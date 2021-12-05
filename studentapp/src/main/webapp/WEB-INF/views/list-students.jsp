<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
			integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
			crossorigin="anonymous">
	</head>
	<body>
	    <div class="container">
	    <h1>Student Debate Registration App</h1>
	    <hr/>	
	    <h2>Registered Students
	    <a href="/studentapp/students/add" class="btn btn-primary btn-sm float-end" style="float: right;"> Add Student</a>
	    </h2>
		<table class="table table-bordered table-striped">
				<tr>		
			<th style="background-color:#008080">Student Id</th>		
			<th style="background-color:#008080">Name</th>
			<th style="background-color:#008080">Department</th>
			<th style="background-color:#008080">Country</th>
			<th style="background-color:#008080">Action</th>
				</tr>
			<tbody>
				<c:forEach items="${Student}" var="student">
					<tr>
					    <td><c:out value="${student.id}" /></td>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.department}" /></td>
						<td><c:out value="${student.country}" /></td>
						<td>
							<a href="/studentapp/students/update?id=${student.id}" class="btn btn-secondary btn-sm">Update</a>
							<a href="/studentapp/students/delete?id=${student.id}" class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student ?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</body>
</html>