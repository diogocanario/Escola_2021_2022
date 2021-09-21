<?php
	session_start();
	$tentativas = array();
	if ($_SERVER['REQUEST_METHOD'] == 'GET') {
		session_destroy();
		session_start();
		include_once "ficha5-modelo.php";
		iniciarJogo();
		include_once "vistas/ficha5-vista_formulario.php";
	}
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		if( isset($_POST['adivinharNum']) ){
			include_once "ficha5-modelo.php";
			$numeroJogador = lerNumero($tentativas);
			include_once "vistas/ficha5-vista_formulario.php";
			if($numeroJogador > -1){
				$resposta = verificarNumero($numeroJogador);
				include_once "vistas/ficha5-vista.php";
				if($numeroJogador == $_SESSION['numRandom']){
					include_once "vistas/ficha5-vistaJogarDeNovo.php";
				}
			}
		}
	}
