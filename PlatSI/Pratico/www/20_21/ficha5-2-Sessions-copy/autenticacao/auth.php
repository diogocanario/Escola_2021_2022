<?php
	session_start();
	if($_SESSION['login'] != $_SESSION['userRegistado'] || $_SESSION['password'] != $_SESSION['passRegistado']){
		header("Location: index.php");
		exit();
	}
	if($_SESSION['login'] == $_SESSION['userRegistado'] && $_SESSION['password'] == $_SESSION['passRegistado']){
		include_once "private.php";
	}