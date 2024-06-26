<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
FootBallStart.jsp<br>

<%
	String viewPage = request.getContextPath() + "/list.fb";
	response.sendRedirect(viewPage);
%>