<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>List</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<thead>
		<table class="table table-striped table-dark">
			<thead>
				<%
				String type = (String) session.getAttribute("type");
				if (type.equals("ADMIN")) {
				%>
				<tr>
					<th scope="col">EID</th>
					<th scope="col">USERNAME</th>
					<th scope="col">PASSWORD</th>
					<th scope="col">DEPARTMENT</th>
					<th scope="col">SALARY</th>
					<th scope="col">TYPE</th>
					<th scope="col">QUESTION</th>
					<th scope="col">ANSWER</th>
					<th scope="col">Action</th>
				</tr>
				<%
				}
				%>

				<%
				String type1 = (String) session.getAttribute("type");
				if (type.equals("EMPLOYEE")) {
				%>
				<tr>
					<th scope="col">EID</th>
					<th scope="col">USERNAME</th>
					<th scope="col">DEPARTMENT</th>
					<th scope="col">TYPE</th>
				</tr>
				<%
				}
				%>

			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp">
					<%
					String type2 = (String) session.getAttribute("type");
					if (type.equals("ADMIN")) {
					%>
					<tr>
						<td><c:out value="${emp.eid}"></c:out></td>
						<td><c:out value="${emp.username}"></c:out></td>
						<td><c:out value="${emp.password}"></c:out></td>
						<td><c:out value="${emp.department}"></c:out></td>
						<td><c:out value="${emp.salary}"></c:out></td>
						<td><c:out value="${emp.type}"></c:out></td>
						<td><c:out value="${emp.question}"></c:out></td>
						<td><c:out value="${emp.answer}"></c:out></td>
						<td>
						<a href="profileEmployee?eid=${emp.eid}" class="link-success">UPDATE</a> 
						<a href="deleteEmployee?eid=${emp.eid}" class="link-danger">DELETE</a>
						</td>
					<tr>
						<%
						}
						%>
						
						<%
						String type3 = (String) session.getAttribute("type");
						if (type.equals("EMPLOYEE")) {
						%>
					
					<tr>
						<td><c:out value="${emp.eid}"></c:out></td>
						<td><c:out value="${emp.username}"></c:out></td>
						<td><c:out value="${emp.department}"></c:out></td>
						<td><c:out value="${emp.type}"></c:out></td>
					<tr>
						<%
						}
						%>
					
				</c:forEach>
			</tbody>
		</table>
	</thead>
</body>
</html>
