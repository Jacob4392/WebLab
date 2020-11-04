<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  JSONArray jarray = (JSONArray)request.getAttribute("jsonarray");
  //System.out.println(jarray);  
%>    
    
<%=jarray%>