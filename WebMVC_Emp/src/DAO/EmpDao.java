package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Emp;
import UTILS.ConnectionHelper;
import UTILS.SingletonHelper;

public class EmpDao {

	//1.전체조회 select * from emp
	public List<Emp> getEmpAllList(){
		
		List<Emp> emplist = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emplist.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);

		}
		return emplist;
	}
	
	//2. 조건조회 select * from emp where empno=?
	public Emp getEmpListByEmpno(int empno) {
		
		Emp emp = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select * from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rs.getInt("empno"));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(rs);
		}
		return emp;
	}
	
	
	//3.데이터 삽입 insert into emp( , , ,...) values(?,?,? ...)
	public int insertEmp(Emp emp) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "insert into emp"
					+ "(empno,ename,job,mgr,hiredate,sal,comm,deptno) "
					+ "values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			rowcount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
		}
		return rowcount;
	}
	
	//4.데이터 수정 update emp set ename=?, job=? where empno=?
	public int updateEmp(Emp emp) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "update emp set ename=?, job=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getEmpno());
			rowcount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
		}
		return rowcount;
		
	}
	
	//5.데이터 삭제 delete from emp where empno=?
	public int deleteEmp(int empno) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "delete from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rowcount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
		}
		return rowcount;
	}
	
}
