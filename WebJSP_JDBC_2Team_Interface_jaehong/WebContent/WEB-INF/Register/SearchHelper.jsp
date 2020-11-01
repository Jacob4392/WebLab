<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String check = (String)request.getAttribute("check");
 
  
  if(check.equals("true")){
%>
	<script>
		alert('있는 ID');		
	    location.href='Ex02_JDBC_Main.jsp';
	</script>
	
<%	  
  }else if(check.equals("false")){
%>
	  <script>
		alert('없는 ID');		
		location.href='Ex02_JDBC_Main.jsp';
	</script>
<% }%>