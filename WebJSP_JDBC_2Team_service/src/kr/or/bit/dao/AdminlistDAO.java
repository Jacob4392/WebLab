package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.AdminlistDTO;

public class AdminlistDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private static DataSource ds = null;

	public AdminlistDAO() {
	}
	
	static {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			Context envctx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) envctx.lookup("/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("AdminDAO JNDI 오류 : " + e.getMessage());
		}
	}

	public AdminlistDTO isExist(String id) {
		AdminlistDTO dto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();

			String query = "select userid, pwd from Adminlist where userid=?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new AdminlistDTO();
				dto.setUserid(rs.getString(1));
				dto.setPwd(rs.getString(2));
			}

		} catch (Exception e) {
			System.out.println("데이터 전체 조회 중 문제 발생 : " + e.getMessage());
		} finally {
			closeDB(rs, pstmt, conn);
		}
		return dto;
	}

	

	// Connection 및 자원 반환 시
	private void closeDB(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("resultSet close error : " + e.getMessage());
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println("preparedStatement close error : " + e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
				System.out.println(conn.isClosed() ? "Connection 반환 됨" : "Connection 반환 안 됨");
			} catch (Exception e) {
				System.out.println("Connection close error : " + e.getMessage());
			}
		}
	}

	private void closeDB(PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println("preparedStatement close error : " + e.getMessage());
			}
		}

		if (conn != null) {
			try {
				conn.close();
				System.out.println(conn.isClosed() ? "Connection 반환 됨" : "Connection 반환 안 됨");
			} catch (Exception e) {
				System.out.println("Connection close error : " + e.getMessage());
			}
		}
	}

}
