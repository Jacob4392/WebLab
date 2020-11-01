<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  int check = (int)request.getAttribute("check");
 
  
  if(check == 0){
%>
	<script>
		alert('정상로그인');		
	    location.href='Ex02_JDBC_Main.jsp';
	</script>
	
<%	  
  }else if(check == -1){
%>
	  <script>
		alert('비밀번호 틀림');		
		location.href='Ex02_JDBC_Main.jsp';
	</script>
<% 
	}else if(check == -2){
%>

	  <script>
		alert('존재하지 않는 ID');	
		location.href='Ex02_JDBC_Main.jsp';
	</script>
 <% }%> 
