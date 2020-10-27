package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.or.bit.dto.koreamember;
import kr.or.bit.utils.Singleton_Helper;

public class memberdao {
	Connection conn = null;
	public memberdao() {
		conn = Singleton_Helper.getConnection("oracle");
	}
	
	// select * from koreamember
	public List<koreamember> getMemberList(){
		
		List<koreamember> memberlist = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from koreamember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				koreamember member = new koreamember();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				member.setIp(rs.getString("ip"));
				memberlist.add(member);				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(rs);
		}
		return memberlist;
	}
	
	//select * from koreamember where id=?
	public koreamember getMemberListById(String id) {
		
		koreamember member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new koreamember();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				member.setIp(rs.getString("ip"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(rs);
		}
		return member;
	}
	
	//select id,pwd from koreamember where id=?
	public koreamember getListById(String id) {
		
		koreamember member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id,pwd from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new koreamember();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(rs);
		}
		return member;
	}
	
	//"insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
	public int insertMember(koreamember member) {
		
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			String sql = "insert into koreamember"
					+ "(id,pwd,name,age,gender,email,ip)"
					+ " values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getIp());
			rowcount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insert: " + e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return rowcount;
	}
	
	//update koreamember set name=?, age=? where id=?
	public int updateMember(koreamember member) {
		
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
	
	//delete from koreamember where id=?
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
}
