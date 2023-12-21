<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.RailwayCrossing1"%>
<%@ page import="com.RailwayCrossingDAOImpl"%>
<%@ page import="java.util.List"%>

<%
// Create an instance of RailwayCrossingDAO
RailwayCrossingDAOImpl crossingDAO = new RailwayCrossingDAOImpl();

// Retrieve all crossings from the DAO
List<RailwayCrossing1> crossings = crossingDAO.getAllCrossings();

// Get the ID from the search request parameter
String searchId = request.getParameter("searchId");

// Check if the searchId parameter is provided
if (searchId != null && !searchId.isEmpty()) {
	// Parse the searchId as an int
	int crossingId = Integer.parseInt(searchId);

	// Retrieve the crossing by ID from the DAO
	RailwayCrossing1 searchedCrossing = crossingDAO.getCrossingById(crossingId);

	// Set the crossing as an attribute to be displayed in the table
	request.setAttribute("crossing", searchedCrossing);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* Button Styles */
.button-container {
	display: flex;
	justify-content: flex-start;
	margin-bottom: 10px;
	margin-left: 5px;
}

.button-container form {
	margin-right: 100px;
}

.button-container input[type="text"] {
	margin-right: 5px;
	padding: 5px;
	border-radius: 4px;
	border: 1px solid #ccc;
}

.button-container button[type="submit"] {
	padding: 10px 20px;
	border-radius: 4px;
	border: none;
	background-color: #B6B6B6;
	font-weight: bold;
	color: black;
	cursor: pointer;
}

.button-container button[type="submit"]:hover {
	background-color: #45a049;
}

.update-button, .delete-button {
	display: inline-block;
	vertical-align: middle;
	margin-right: 10px;
	padding: 7px;
	width: 80px;
	height: 30px;
}

/* Table Styles */
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

/* Responsive Styles */
@media only screen and (max-width: 768px) {
	.button-container form {
		margin-right: 5px;
	}
	.update-button, .delete-button {
		float: none;
		margin-right: 5px;
		margin-bottom: 5px;
	}
}
</style>
</head>

<body>
<h1>Admin Home Page</h1>
	<h3>
		Railway Crossing[<%=crossings.size()%>]
	</h3>

	<!-- Buttons -->
	<div class="button-container">
		<form action="HomePage.jsp" method="post">
			<button type="submit">Home</button>
		</form>
		<form action="addRailCrossingForm.jsp" method="post">
			<button type="submit">Add Railway Crossing</button>
		</form>
		<form action="searchCrossing" method="post">
			<input type="text" name="searchId" placeholder="Enter ID">
			<button type="submit">Search Crossing</button>
		</form>
		<form action="adminHome.jsp" method="post">
			<button type="submit">Display All Railway Crossings</button>
		</form>
		<!-- Logout Button -->
		<form action="adminRegister.jsp" method="post">
			<button type="submit">Logout</button>
		</form>
	</div>

	<!-- Table -->
	<table>
		<thead>
			<tr>
				<th>Sr.No</th>
				<th>Name</th>
				<th>Address</th>
				<th>Landmark</th>
				<th>Train Schedule</th>
				<th>Person In-Charge</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (request.getAttribute("crossing") != null) { // Check if a specific crossing is found
				RailwayCrossing1 crossing = (RailwayCrossing1) request.getAttribute("crossing");
			%>
			<tr>
				<td><%=crossing.getId()%></td>
				<td><%=crossing.getName()%></td>
				<td><%=crossing.getAddress()%></td>
				<td><%=crossing.getLandmark()%></td>
				<td><%=crossing.getSchedule()%></td>
				<td><%=crossing.getPerson()%></td>
				<td><%=crossing.getStatus()%></td>
				<td></td>
			</tr>
			<%
			} else { // Display all crossings
			for (RailwayCrossing1 anotherCrossing : crossings) {
			%>
			<tr>
				<td><%=anotherCrossing.getId()%></td>
				<td><%=anotherCrossing.getName()%></td>
				<td><%=anotherCrossing.getAddress()%></td>
				<td><%=anotherCrossing.getLandmark()%></td>
				<td><%=anotherCrossing.getSchedule()%></td>
				<td><%=anotherCrossing.getPerson()%></td>
				<td><%=anotherCrossing.getStatus()%></td>
				<td>
					<form action="updateRailCrossingForm.jsp" method="post">
						<input type="hidden" name="id"
							value="<%=anotherCrossing.getId()%>">
						<button type="submit" class="update-button">Update</button>
					</form>
					<form action="deleteCrossing" method="post">
						<input type="hidden" name="id"
							value="<%=anotherCrossing.getId()%>">
						<button type="submit" class="delete-button">Delete</button>
					</form>
				</td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>

</body>
</html>