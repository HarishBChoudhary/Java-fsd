<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>

<br>
<script src="<%= baseUrl %>/script.js"></script>

<input type="hidden" id="baseUrl" value="<%= baseUrl %>"/>