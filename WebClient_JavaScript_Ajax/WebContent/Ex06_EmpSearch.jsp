<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Class.forName("oracle.jdbc.OracleDriver"); //드라이브 로딩
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null; //데이터베이스를 연결하고 연결한 데이터베이스에서 작업할 수 있도록 해줌
	
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
	String sql="select empno , ename , sal , job from emp where empno=?"; // ?는 parameter값
	pstmt= conn.prepareStatement(sql);
	//.jsp?empno=7788 추가 입력
	
	pstmt.setInt(1, Integer.parseInt(request.getParameter("empno")));
	
	rs = pstmt.executeQuery();
	/*  
	<table>
		<tr><td></td></tr>
	</table>
	
	*/
	//out.print(""); //print()
	out.print("<table border='1'>");//위의 값을 받아서 테이블을 만들고 테이블에 데이터를 배치함
	while(rs.next()){
		out.print("<tr><th>empno</th><td>"+ rs.getInt("empno") + "</td></tr>");
		out.print("<tr><th>ename</th><td>"+ rs.getString("ename") + "</td></tr>");
		out.print("<tr><th>sal</th><td>"+ rs.getInt("sal") + "</td></tr>");
		out.print("<tr><th>job</th><td>"+ rs.getString("job") + "</td></tr>");
	}
	out.print("</table>");
	if(pstmt !=null){try{ pstmt.close();}catch(Exception e){}}
	if(rs !=null){try{ rs.close();}catch(Exception e){}}
	if(conn !=null){try{ conn.close();}catch(Exception e){}}
%>    
