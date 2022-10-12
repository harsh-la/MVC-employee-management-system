
<%
String username = (String)session.getAttribute("username");
if (username == null){
	request.setAttribute("msg", "Please Login First");
	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	dispatcher.forward(request, response);
}
else{
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
%>
<script type="text/javascript">
		alert("${msg}")
</script>
<% 
	}
%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" href="#">ERP</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp">HOME<span
					class="sr-only">(current)</span></a></li>
			<%
			String type=(String)session.getAttribute("type");
			if(type.equals("ADMIN")){				
				%>
					<li class="nav-item"><a class="nav-link" href="addEmployeePage">Add
					EMPLOYEE</a></li>
				<%
			}
			%>
						
			<li class="nav-item"><a class="nav-link" href="listofEmployee">LIST
					EMPLOYEE</a></li>
			<li class="nav-item"><a class="nav-link"
				href="profileEmployee?eid=<%=session.getAttribute("eid")%>"><%=session.getAttribute("username")%></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="importExportEmployee">Import/Export Employee</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">LOGOUT</a></li>
		</ul>
	</div>
</nav>
<%
}
%>