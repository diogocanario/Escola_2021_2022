<?php
	function iniciarJogo(){
		$numero_random = rand(0,100);
		if( !isset( $_SESSION['numRandom'] ) ){
			$_SESSION['numRandom'] = $numero_random;	
		}
	}
	function lerNumero($tentativas){
		$numeroJogador = $_POST['numero'];
		if($numeroJogador < 0 || $numeroJogador > 100){
			$numeroJogador = -1;
		}
		else{
			if (isset($_SESSION['tentativas'])) {
				$tentativas = $_SESSION['tentativas'];
			}
			array_push($tentativas, $numeroJogador);
			$_SESSION['tentativas'] = $tentativas;
		}
		return $numeroJogador;
	}
	function verificarNumero($numeroJogador){
		$resposta = 0;

		if($numeroJogador > $_SESSION['numRandom']){
			$resposta = 1;
		}
		if ($numeroJogador < $_SESSION['numRandom']) {
			$resposta = 2;
		}
		if ($numeroJogador == $_SESSION['numRandom']) {
			$resposta = 3;
		}
		return $resposta;
	}