package kr.or.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import UTILS.SingletonHelper;
import kr.or.dto.MemoDto;

public class MemoDao {

	
	
	public List<MemoDto> getMemoAllList(){
		
		List<MemoDto> memolist = new ArrayList<MemoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select id,email,content from memo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemoDto memo = new MemoDto();
				memo.setId(rs.getString("id"));
				memo.setEmail(rs.getString("email"));
				memo.setContent(rs.getString("content"));
				memolist.add(memo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		return memolist;
	}
	
	
	public MemoDto getMemoListbyId(String id) {
		
		MemoDto memo = new MemoDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select email, content from memo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memo = new MemoDto();
				memo.setId(rs.getString("id"));
				memo.setEmail(rs.getString("email"));
				memo.setContent(rs.getString("content"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		
		return memo;
	}
	
	public int insertMemo(MemoDto memo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into memo(id,email,content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memo.getId());
			pstmt.setString(2,memo.getEmail());
			pstmt.setString(3,memo.getContent());
			
			rowcount = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return rowcount;
	}
	
	public int updateMemo(MemoDto memo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update memo set email=?, content=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memo.getEmail());
			pstmt.setString(2, memo.getContent());
			pstmt.setString(3, memo.getId());
			rowcount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return rowcount;
	}
	
	public int deleteMemo(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "delete from memo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rowcount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return rowcount;
	}
	
	
	
	
	
	
	
	
	
}
