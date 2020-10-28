<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.or.bit.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = new Member();
	//JSON 객체로 변환하고 싶다면?
	//String jsondata = "{"+"username:"+member.get .... >> 이방법은 권장하지 않습니다

	//JSON으로 한 건의 데이터 변환하기
	JSONObject obj = JSONObject.fromObject(member);
	//{"address":"서울시 강남구","admin":"1","password":"1004","username":"bit"}
	

%>
<%=obj %>
<hr>
<%
	//JSON으로 여러건 데이터 변환하기
	List<Member> memberlist = new ArrayList<>();
	memberlist.add(new Member("hong","1004","서울시 강남구","0"));
	memberlist.add(new Member("kim","1004","서울시 강남구","1"));
	memberlist.add(new Member("park","1004","서울시 강남구","0"));
	
	//[{},{},{}]
	JSONArray objarray = JSONArray.fromObject(memberlist);
	
%>
<%= objarray%>