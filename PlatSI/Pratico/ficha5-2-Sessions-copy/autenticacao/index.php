<?php
	session_start();
	include_once "login.php";
	include_once "registo.php";
	if ($_SERVER["REQUEST_METHOD"] == "POST") {
		if (isset($_POST['register'])) {
			include_once "register.php";
		}
		if (isset($_POST['login'])) {
			$_SESSION['login'] = $_POST['user'];
			$_SESSION['password'] = $_POST['pass'];
			header("Location: auth.php");
			exit();
		}	
	}
	if($_SERVER['REQUEST_METHOD'] == "GET"){
		session_destroy();
	}
	// ehj749madellt8qj1gp0rjqm1v