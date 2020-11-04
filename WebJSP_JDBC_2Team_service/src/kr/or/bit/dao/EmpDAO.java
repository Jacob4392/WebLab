package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.dto.EmpDTO;

//DAO란
//Data Access Object의 줄임말로,
//현재 클래스로 DB와 연결하여 DB에서 작동하는 CRUD를 직접 자바언어로 작성하는 클래스이다.

//EmpDTO는 실제 DB에 있는 Memo table의 정보를 담는 클래스인데,
//EmpDTO = 정보가 담겨있는 클래스를 DAO로 가져와
//실 DB에서 작성하는 쿼리문에 대한 로직을 작성한다.
//대표적인 쿼리문들을 함수로 작성한다.

public class EmpDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private static DataSource ds = null;

	public EmpDAO() {
		
	}
	
	static {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			Context envctx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) envctx.lookup("/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EmpDAO JNDI 오류 : " + e.getMessage());
		}
	}

	//-------------------- EmpDAO Functions start --------------------
	
	// Emp 전체 사원 select
	// SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP;
	public List<EmpDTO> getEmpAllList() { // select * from emp;
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		
		String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmpDTO emp = new EmpDTO(); 
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
				emplist.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("<EmpDAO> getEmpAllList() 중 :" + e.getMessage());
		} finally {
			closeDB(rs, pstmt, conn);
		}
		return emplist;
	}

	// Emp 회원의 총 사원 숫자를 반환
	// SELECT COUNT(*) FROM EMP;
	public int getEmpAllCount() { 
		String sql = "SELECT COUNT(*) FROM EMP";

		int count = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			conn.close(); 
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("<EmpDAO> getEmpAllCount() 중 :" + e.getMessage());
		} finally {
			closeDB(rs, pstmt, conn);
		}
		return count;
	}
	
	/*	select no, empno, ename, job, mgr, hiredate, sal, comm, deptno
		from (
			 select rownum as no, empno, ename, job, mgr, hiredate, sal, comm, deptno
			 from emp
			 where rownum <= ?
		) where no >= ? */
	// ShowEmpList.member 시 Emp리스트를 페이징하여 출력
	public List<EmpDTO> getPagedEmpList(int currpage, int pagesize){
		List<EmpDTO> emplist = null;
		
		String sql = "SELECT NO, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO"
				   + " FROM"
				   + 	" (SELECT ROWNUM AS NO, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO"
				   + 	" FROM EMP"
				   + 	" WHERE ROWNUM <= ?"
				   + ") WHERE NO >= ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			int from_N = currpage * pagesize - (pagesize - 1);
			int to_N = currpage * pagesize;
			
			pstmt.setInt(1, to_N);		// N까지
			pstmt.setInt(2, from_N);	// N부터
			
			rs = pstmt.executeQuery();
			emplist = new ArrayList<EmpDTO>();
			
			while(rs.next()) {
				EmpDTO emp = new EmpDTO();
				
				emp.setEmpno(rs.getInt(2));	// 1 : RN..
				emp.setEname(rs.getString(3));
				emp.setJob(rs.getString(4));
				emp.setMgr(rs.getInt(5));
				emp.setHiredate(rs.getString(6));
				emp.setSal(rs.getInt(7));
				emp.setComm(rs.getInt(8));
				emp.setDeptno(rs.getInt(9));
				
				emplist.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("<EmpDAO> getPagedEmpList 중 : " + e.getMessage());
		} finally {
			closeDB(rs, pstmt, conn);
		}
		
		return emplist;
	}
	
	public int insertAccount(EmpDTO dto) {
		// insert into department(deptno,dname) values(?,?)
		int row = 0;

		try {
			conn = ds.getConnection();
			
			String query = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno,filename) values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setInt(4, dto.getMgr());
			pstmt.setString(5, dto.getHiredate());
			pstmt.setInt(6, dto.getSal());
			pstmt.setInt(7, dto.getComm());
			pstmt.setInt(8, dto.getDeptno());
			pstmt.setString(9, dto.getFilename());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println("INSERT 작업 도중 SQLException 발생 : " + e.getMessage());
		} finally {
			closeDB(pstmt, conn);
		}
		return row;
	}
	
	public String IdIsExist(String id) {
		String idCheck="";
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			System.out.println(conn.isClosed()); // 연결 상태 확인

			String query = "select empno from emp where empno=?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) idCheck = "true";
			else idCheck = "false";
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert : " + e.getMessage());
		} finally {
			closeDB(rs, pstmt, conn);
		}
		return idCheck;
	}
	
	// SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP WHERE EMPNO=?;
	// EditEmp.member요청 시 EmpDetail 표시를 위해 검색한 결과를 EmpDTO객체로 반환
	public EmpDTO getDetailEmp(int empno) {
		EmpDTO emp = new EmpDTO();
		
		String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO"
				   + "	FROM EMP"
				   + "	WHERE EMPNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
			}
			
		} catch (Exception e) {
			
		} finally {
			closeDB(rs, pstmt, conn);
		}
		return emp;
	}
	
	// EmpDetail에서 Emp 1명 update 후 성공 결과를 int로 반환
	/* 
	update emp
	set ename = 'AAA',
    job = 'BBB',
    mgr = ?,
    hiredate = ?
    sal = ?,
    comm = ?,
    deptno = ?
	where empno = 7788;
	*/
	public int updateEmp(EmpDTO e) {
		EmpDTO emp = new EmpDTO();
		
		String sql = "UPDATE EMP"
				   + "	SET ENAME=?,"
				   + "		JOB=?,"
				   + "		MGR=?,"
				   + "		HIREDATE=?,"
				   + "		SAL=?,"
				   + "		COMM=?,"
				   + "		DEPTNO=?"
				   + "WHERE EMPNO=?";
		
		int result = 0;
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, e.getEname());
			pstmt.setString(2, e.getJob());
			pstmt.setInt(3, e.getMgr());
			pstmt.setString(4, e.getHiredate());
			pstmt.setInt(5, e.getSal());
			pstmt.setInt(6, e.getComm());
			pstmt.setInt(7, e.getDeptno());
			pstmt.setInt(8, e.getEmpno());
			
			result = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("<EmpDAO> updateEmp 결과 : " + ex.getMessage());
			ex.printStackTrace();
		} catch(Exception ex) {
			System.out.println("<EmpDAO> updateEmp 결과 : " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			closeDB(pstmt, conn);
		}
		return result;
	}
	
	public int deleteEmp(int empno) {
		int row = 0;
		String sql = "DELETE FROM EMP WHERE EMPNO = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			closeDB(pstmt, conn);
		}
		return row;
	}
	
	public EmpDTO getEmpByEmpno(int empno) {
		EmpDTO emp = new EmpDTO();
		String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO"
				   + " FROM EMP WHERE EMPNO = ?";
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("<EmpDTO> getEmpByEmpno : " + e.getMessage());
		} finally {
			closeDB(rs, pstmt, conn);
		}
		return emp;
	}
	
	// ------------------------- Connection 및 자원 반환 시 closeDB() -------------------------
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
