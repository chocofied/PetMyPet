<?php
	$con=mysqli_connect("localhost","my_user","my_password","my_db");

	$name = $_POST['name'];
	$phone = $_POST['phone'];
	$username = $_POST['username'];
	$password = $_POST['password'];

	$statement = mysqli_prepare($con, "INSERT INTO User (name, phone, username, password) VALUE (?, ?, ?, ?) ");	
	mysqli_stmt_bind_param($statement, "ssss", $name, $phone, $username, $password):
	mysqli_stmt_execute($statement);

	mysqli_stmt_close($statement);

	mysqli_close($con);
?>