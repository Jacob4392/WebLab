package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.memo;
import kr.or.bit.utils.SingletonHelper;

/*
 	1.db 연결작업
 	2.CRUD 함수를 생성
 	2.1 전체조회 : select id,email,content from memo
 	2.2 조건조회 : select id,email,content from memo where id=?
 	2.3 삽입 : insert into memo(id,email,content) values(?,?,?)
 	2.4 수정 : update memo set email=?, content=? where id=?
 	2.5 삭제 : delete from memo where id=?
 	+ 알파 :
 	Like 문자열 검색(이름 검색, 컨텐츠 내용검색)
 	
 	
*/

public class memodao {
	Connection conn = null;
	public memodao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	//전체조회
	public List<memo> getMemoList() throws SQLException{
		
		List<memo> memolist = new ArrayList<memo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id,email,content from memo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memo m = new memo();
				m.setId(rs.getString("id"));
				m.setEmail(rs.getString("email"));
				m.setContent(rs.getString("content"));
				memolist.add(m);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}
		return memolist;
	}
	
	//조건조회(where id=? 값이 unique, primary key 이어야 한다는 점 확인!)
	public memo getMemoListById(String id) {
		
		return null;
	}
	
	//INSERT
	public int insertMemo(memo m) {
		
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			String sql = "insert into memo(id,email,content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getContent());
			rowcount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insert: " + e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowcount;
	}
	
	//UPDATE
	public int updateMemo(memo m) {
		
		return 0;
	}
	
	//DELETE
	public int deleteMemo(String id) {
		
		return 0;
	}
	
	//추가함수
	public String idCheckById(String id) {
		
		memo m = new memo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from memo where id like '%?%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				m.setId(rs.getString("id"));
				m.setEmail(rs.getString("email"));
				m.setContent(rs.getString("content"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		return m.getId();
	}
}
