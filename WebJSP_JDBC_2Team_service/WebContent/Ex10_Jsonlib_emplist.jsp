<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.bit.dto.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//http://localhost:8090/WebClient_Jquery_Ajax/Ex10_Jsonlib_Ajax_emplist.html
//Error : Access-Control-Allow-Origin  >>다른도메인에서는 접근 불가

//http://192.168.0.25:8090/WebClient_Jquery_Ajax/Ex10_Jsonlib_Ajax_emplist.html

response.addHeader("Access-Control-Allow-Origin ", "*"); //에러 해결법  *모든곳에서 접근 허용

%>
<%
Class.forName("oracle.jdbc.OracleDriver");
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
//out.print(conn.isClosed());

stmt = conn.createStatement();
String sql= "select empno ,ename , sal , job , comm from emp";

rs = stmt.executeQuery(sql);
//POINT
//여러건의 데이터를 객체에 담아놓고 사용 (collection)
//선행 조건: DTO 클래스
//DTO ArrayList Add
List<EmpDTO> list = new ArrayList<>();
while(rs.next()){
	EmpDTO emp = new EmpDTO();
	emp.setEmpno(rs.getInt(1)); //rs.getInt("empno")
	emp.setEname(rs.getString(2));
	emp.setSal(rs.getInt(3));
	emp.setJob(rs.getString(4));
	emp.setComm(rs.getInt(5));
	
	list.add(emp);
}
	//변환작업 1줄코드
	JSONArray jsonlist = JSONArray.fromObject(list);
	
	/* 
	[{"comm":0,"empno":7369,"ename":"SMITH","job":"CLERK","sal":800},
	 {"comm":300,"empno":7499,"ename":"ALLEN","job":"SALESMAN","sal":1600},
	 {"comm":200,"empno":7521,"ename":"WARD","job":"SALESMAN","sal":1250},
	 {"comm":30,"empno":7566,"ename":"JONES","job":"MANAGER","sal":2975},
	 {"comm":300,"empno":7654,"ename":"MARTIN","job":"SALESMAN","sal":1250},
	 {"comm":0,"empno":7698,"ename":"BLAKE","job":"MANAGER","sal":2850},
	 {"comm":0,"empno":7782,"ename":"CLARK","job":"MANAGER","sal":2450},
	 {"comm":0,"empno":7788,"ename":"SCOTT","job":"ANALYST","sal":3000},
	 {"comm":3500,"empno":7839,"ename":"KING","job":"PRESIDENT","sal":5000},
	 {"comm":0,"empno":7844,"ename":"TURNER","job":"SALESMAN","sal":1500},
	 {"comm":0,"empno":7876,"ename":"ADAMS","job":"CLERK","sal":1100},
	 {"comm":0,"empno":7900,"ename":"JAMES","job":"CLERK","sal":950},
	 {"comm":0,"empno":7902,"ename":"FORD","job":"ANALYST","sal":3000},
	 {"comm":0,"empno":7934,"ename":"MILLER","job":"CLERK","sal":1300}]
	*/
%>
<%=jsonlist %>








