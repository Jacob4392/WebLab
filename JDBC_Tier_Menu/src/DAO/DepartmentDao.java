package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Department;
import UTILS.SingletonHelper;

public class DepartmentDao {
	Connection conn = null;
	
	public DepartmentDao() { //throws Exception
		conn = SingletonHelper.getConnection("oracle");
	}
	
	//CRUD
	//SingleRow , MultiRow , insert , update , delete 기본 5개
	//검색 함수 (select .... like '')
	public ArrayList<Department> GetDepartmentList(){
		//select deptno , dname from department
		ArrayList<Department> departments = new ArrayList<Department>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select deptno , dname from department";
		try {
			   pstmt = conn.prepareStatement(sql);
			   rs = pstmt.executeQuery();
			   
			   while(rs.next()){
				   Department department = new Department();
				   department.setDeptno(rs.getInt(1));
				   department.setDname(rs.getString(2));
				   departments.add(department);
			   }
			   
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally{
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}
		return departments;
	}
	
	//Like 검색
	//select deptno , dname from department where dname like '%AC%'
	public ArrayList<Department> GetDepartmentListByDname(String dname){
		ArrayList<Department> departments = new ArrayList<Department>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1. 방법 -1
		//String sql = "select deptno , dname from department where dname like '%" + dname +"'%";
		String sql = "select deptno , dname from department where dname like ?"; //
		try {
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, "%"+dname+"%"); //
			   rs = pstmt.executeQuery();
			   
			   while(rs.next()){
				   Department department = new Department();
				   department.setDeptno(rs.getInt(1));
				   department.setDname(rs.getString(2));
				   departments.add(department);
			   }
			   
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally{
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}
		return departments;
	}


    //Insert
	public int InsertDepartment(Department department){
		//insert into department(deptno,dname) values(?,?)
		PreparedStatement pstmt = null;
		int row=0;
		String sql = "insert into department(deptno,dname) values(?,?)";
		//System.out.println(department.getDeptno() +"/"+department.getDname());
		try {
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setInt(1, department.getDeptno());
			   pstmt.setString(2, department.getDname());
			   
			   row = pstmt.executeUpdate();
			   
			   			   
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally{
			SingletonHelper.close(pstmt);
			
		}
		return row;
	}
	//Update
	public int UpdateDepartment(Department department){
		//update department set dname=? where deptno=?
		PreparedStatement pstmt = null;
		int row=0;
		String sql = "update department set dname=? where deptno=?";
		try {
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, department.getDname());
			   pstmt.setInt(2, department.getDeptno());
			   row = pstmt.executeUpdate();
	   			   
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally{
			SingletonHelper.close(pstmt);
			
		}
		return row;
	}
	//Delete
   public int DeleteDepartment(int deptno){
	   //delete from department where deptno=?
		PreparedStatement pstmt = null;
		int row=0;
		String sql = "delete from department where deptno=?";
		try {
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setInt(1, deptno);
			   row = pstmt.executeUpdate();
	   			   
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally{
			SingletonHelper.close(pstmt);
		}
		return row;
   } 
}
