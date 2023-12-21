<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.RailwayCrossing1"%>
<%@ page import="com.RailwayCrossingDAOImpl"%>
<%@ page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Railway Crossings - User Home Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
}

.container {
	border: 1px solid #ccc;
	border-radius: 10px;
	padding: 20px;
	margin-bottom: 20px;
	margin-top: 20px;
}

.container h3 {
	margin-top: 0;
}

.container p {
	margin: 0;
}

.crossing {
	margin-bottom: 10px;
}

.crossing button {
	margin-left: 10px;
}

.status {
	display: inline-block;
	padding: 5px;
	font-weight: bold;
}

.status-open {
	color: white;
	border-radius: 30%;
	background-color: green;
}

.status-closed {
	color: white;
	background-color: red;
}
</style>
</head>
<body>
	<h1 style="font-weight: bold;">User Home Page</h1>

	<!-- Display Search Crossings button -->
	<button onclick="location.href='HomePage.jsp'"
		style="border-radius: 10px; font-weight: bold;">Home</button>

	<!-- Display All button -->
	<button onclick="location.href='userHome.jsp'"
		style="border-radius: 10px; margin-left: 50px; font-weight: bold;">All
		Crossings</button>

	<!-- Display Favorite Crossings button -->
	<button onclick="location.href='userHomeFavoriteCrossing.jsp'"
		style="border-radius: 10px; margin-left: 50px; font-weight: bold;">Favorite
		Crossings</button>

	<!-- Display Search Crossings button -->
	<button onclick="location.href='userSearchCrossing.jsp'"
		style="border-radius: 10px; margin-left: 50px; font-weight: bold;">Search
		Crossings</button>

	<!-- Logout button -->
	<button onclick="location.href='userLogin.jsp'"
		style="border-radius: 10px; margin-left: 800px; font-weight: bold;">Logout</button>

	<%-- Create an instance of RailwayCrossingDAO --%>
	<%
	RailwayCrossingDAOImpl crossingDAO = new RailwayCrossingDAOImpl();
	List<RailwayCrossing1> allCrossings = crossingDAO.getAllCrossings();
	for (RailwayCrossing1 crossing : allCrossings) {
		String status = crossing.getStatus();
		String statusClass = status.equalsIgnoreCase("Open") ? "status-open" : "status-closed";
	%>
	<div class="container">
		<h3><%=crossing.getName()%></h3>
		<p>
			Status: <strong><span class="status <%=statusClass%>"><%=crossing.getStatus()%></span></strong>
		</p>
		<p>
			Person in Charge: <strong><%=crossing.getPerson()%></strong>
		</p>
		<p>
			Train Schedules: <strong><%=crossing.getSchedule()%></strong>
		</p>
		<p>
			Landmark: <strong><%=crossing.getLandmark()%></strong>
		</p>
		<p>
			Address: <strong><%=crossing.getAddress()%></strong>
		</p>
		<form action="addFavServlet" method="post" style="display: inline;">
			<input type="hidden" name="crossingId" value="<%=crossing.getId()%>">
			<button type="submit"
				style="border-radius: 10px; font-weight: bold; margin-top: 10px; margin-left: 0px;">ADD
				TO FAVORITES</button>
		</form>
	</div>
	<%
	}
	%>
</body>
</html>
