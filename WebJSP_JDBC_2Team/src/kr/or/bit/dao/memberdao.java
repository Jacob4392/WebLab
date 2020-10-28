package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.koreamember;
import kr.or.bit.utils.Singleton_Helper;

public class memberdao {
	Connection conn = null;

	public memberdao() {
		conn = Singleton_Helper.getConnection("oracle");
	}

	// 회원 정보 전체 검색
	// select id, pwd, name, age, gender, email, ip from koreamember;
	public List<koreamember> getDAOAllList() {
		List<koreamember> memberlist = new ArrayList<koreamember>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// System.out.println(conn.isClosed()); // 연결 상태 확인

			String query = "select id, pwd, name, age, gender, email, ip from koreamember";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				koreamember km = new koreamember();
				km.setId(rs.getString(1));
				km.setPwd(rs.getString(2));
				km.setName(rs.getString(3));
				km.setAge(rs.getInt(4));
				km.setGender(rs.getString(5));
				km.setEmail(rs.getString(6));
				km.setIp(rs.getString(7));
				memberlist.add(km);
			}
		} catch (Exception e) {
			System.out.println("데이터 전체 조회 중 문제 발생 : " + e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return memberlist;
	}

	// 회원 정보 부분 검색 : id, ip
	// select id, ip from koreaMember
	public List<koreamember> getDAOPartList() {
		List<koreamember> memberlist = new ArrayList<koreamember>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// System.out.println(conn.isClosed()); // 연결 상태 확인

			String query = "select id, ip from koreaMember";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				koreamember km = new koreamember();
				km.setId(rs.getString(1));
				km.setIp(rs.getString(2));
				memberlist.add(km);
			}
		} catch (Exception e) {
			System.out.println("데이터 전체 조회 중 문제 발생 : " + e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return memberlist;
	}

	// 회원 정보 부분 검색 : 아이디로 검색해 단일 객체 or null 객체를 반환하는 함수 findById
	// select id from koreaMember where id=?
	public koreamember findById(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select id from koreaMember where id=?";

		koreamember km = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				km = new koreamember();
				km.setId(rs.getString("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("findById 에러 발생");
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return km;
	}

	// 회원 정보 부분 검색
	// select id, pwd, name, age, gender, email, ip from koreamember where id=?
	public koreamember selectAccount(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select id, pwd, name, age, gender, email, ip from koreamember where id=?";

		koreamember km = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				km = new koreamember();
				km.setId(rs.getString(1));
				km.setPwd(rs.getString(2));
				km.setName(rs.getString(3));
				km.setAge(rs.getInt(4));
				km.setGender(rs.getString(5));
				km.setEmail(rs.getString(6));
				km.setIp(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("selectAccount 에러 발생");
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return km;
	}

	// 회원 정보 삽입
	// insert into koreaMember(id,pwd,name,age,gender,email,ip)
	public int insertAccount(koreamember km) {
		// insert into department(deptno,dname) values(?,?)
		PreparedStatement pstmt = null;

		int row = 0;

		String query = "insert into koreaMember(id,pwd,name,age,gender,email," + "ip) values(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, km.getId());
			pstmt.setString(2, km.getPwd());
			pstmt.setString(3, km.getName());
			pstmt.setInt(4, km.getAge());
			pstmt.setString(5, km.getGender());
			pstmt.setString(6, km.getEmail());
			pstmt.setString(7, km.getIp());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("INSERT 작업 도중 SQLException 발생 : " + e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return row;
	}

	// update koreamember set name=?, age=? where id=?
	public int updateMember(koreamember member) {
		// member.getId()
		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {
			String sql = "update koreamember set name=?, age=?, gender=?, email=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getAge());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("update: " + e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return rowcount;
	}

	// 회원 정보 삭제 : 해당 아이디가 DB에 존재하면 rowcount ? 1 : 0
	// delete from koreamember where id=?
	public int deleteMember(String id) {

		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {
			String sql = "delete from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("delete: " + e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return rowcount;
	}

	// 회원 정보 부분 검색 : DB에 id와 같은 row가 존재하면 return DTO or null
	// select id, pwd from koreaMember where id=?
	public koreamember isExist(String id) {
		koreamember km = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println(conn.isClosed()); // 연결 상태 확인

			String query = "select id, pwd from koreaMember where id=?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				km = new koreamember();
				km.setId(rs.getString(1));
				km.setPwd(rs.getString(2));
			}

		} catch (Exception e) {
			System.out.println("데이터 전체 조회 중 문제 발생 : " + e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return km;
	}

	// select id, name, email from koreamember where name like ?
	public List<koreamember> searchMember(String name) {

		List<koreamember> memberlist = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select id, name, email from koreamember where name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			rs = pstmt.executeQuery();

			if(rs.next()) {
				memberlist = new ArrayList<koreamember>();
				do {
					koreamember member = new koreamember();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setEmail(rs.getString("email"));
					memberlist.add(member);
				}while(rs.next());
			} else {
				System.out.println("like 검색 결과가 없습니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(rs);
		}
		return memberlist;
	}

	// select count(*) from koreamember where name like ?
	public int countMember(String name) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rowcount = 0;

		try {
			String sql = "select count(*) from koreamember where name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			rs = pstmt.executeQuery();
			rowcount = 0;

			if (rs.next()) {
				rowcount = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(rs);
		}
		return rowcount;
	}
}
