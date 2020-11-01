package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.EmpDTO;
import kr.or.bit.utils.Singleton_Helper;

//DAO란
//Data Access Object의 줄임말로,
//현재 클래스로 DB와 연결하여 DB에서 작동하는 CRUD를 직접 자바언어로 작성하는 클래스이다.

//EmpDTO는 실제 DB에 있는 Memo table의 정보를 담는 클래스인데,
//EmpDTO = 정보가 담겨있는 클래스를 DAO로 가져와
//실 DB에서 작성하는 쿼리문에 대한 로직을 작성한다.
//대표적인 쿼리문들을 함수로 작성한다.

public class EmpDAO {
	
	public List<EmpDTO> getEmpDAOAllList(){				// select * from emp;
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "select empno, ename, job, mgr,"
					+ "hiredate, sal, comm, deptno from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDTO emp = new EmpDTO();				// emp객체를 생성하고
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getString(5));
				emp.setSal(rs.getInt(6));
				emp.setComm(rs.getInt(7));
				emp.setDeptno(rs.getInt(8));		// db select 정보를 객체에 담고
				emplist.add(emp);						// add to List
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return emplist;
	}
	
}
