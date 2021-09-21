<!DOCTYPE html>
<html>
<head>
	<title>Ficha 5 - Sessions</title>
</head>
<body>
	<br>
	<h5>Tentativas feitas: </h5>
	<?php
		echo "<br>";
		foreach ($_SESSION['tentativas'] as $valor) {
			echo "|" . $valor;
		}
		echo "|<br>";
		if ($resposta == 1) {
			echo "O número introduzido é maior que o número alvo <br> Tente um número mais baixo!";
		}
		if($resposta == 2) {
			echo "O número introduzido é menor que o número alvo <br> Tente um número mais alto!";
		}
		if ($resposta == 3) {
			echo "MESMO EM CHEIO! Acertou no número gerado aleatóriamente!<br>Demorou ". count($_SESSION['tentativas']) ." tentativas";
		}
		echo "<hr>";
		echo $_SESSION['numRandom'];
	?>
</body>
</html>