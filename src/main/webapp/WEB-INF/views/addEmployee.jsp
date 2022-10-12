
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="resources/css/reg.css">


<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<jsp:include page="menu.jsp" />

<div class="container register">
	<div class="row">
		<div class="col-md-3 register-left">
			<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
			<h3>Welcome</h3>
			<p>You are 30 seconds away from earning your own money!</p>

		</div>
		<div class="col-md-9 register-right">

			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<h3 class="register-heading">Add Employee</h3>
					
					<form action="addEmployee" method="post">
						<div class="row register-form">
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" name="username" class="form-control"
										placeholder="Enter Username *" value="" />
								</div>
								<div class="form-group">
									<input type="text" name="password" class="form-control"
										placeholder="Password *" value="" />
								</div>
								<div class="form-group">
									<select name="department" class="form-control">
										<option class="hidden" selected disabled>Please Select Your Department</option>
										<option value="IT">IT</option>
										<option value="MECH">MECH</option>
										<option value="CS">CS</option>
									</select>
								</div>
								<div class="form-group">
									<input type="text" name="salary" minlength="5" maxlength="10" name=""
										class="form-control" placeholder="Salary *" value="" />
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">
									<select name="type" class="form-control">
										<option class="hidden" selected disabled>Type</option>
										<option value="ADMIN">ADMIN</option>
										<option value="EMPLOYEE">EMPLOYEE</option>
									</select>
								</div>
								<div class="form-group">
									<select name="question" class="form-control">
										<option class="hidden" selected disabled>Please	select your Sequrity Question</option>
										<option>What is your Birthdate?</option>
										<option>What is Your old Phone Number</option>
										<option>What is your Pet Name?</option>
									</select>
								</div>
								<div class="form-group">
									<input name="answer" type="text" class="form-control"
										placeholder="Enter Your Answer *" value="" />
								</div>

								<input type="submit" class="btnRegister" value="Register" />
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</div>