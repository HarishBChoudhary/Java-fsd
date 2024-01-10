<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Citizens</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <%@ include file="header.jsp" %>
        <input type="hidden" id="citizenId" value="${id}">
            <div id="citizenView">
                <h2> View Citizen</h2>
                <div id="oneCitizen"></div>
            </div>
    </div>

    <script>
        window.onload = function(event)
        {
            let id = document.getElementById("citizenId").value;
            console.log(id);
            citizenApi.edit(id, _layoutOneCitizenView)
        }
    </script>
</body>
</html>