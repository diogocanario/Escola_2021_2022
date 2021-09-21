<!DOCTYPE html>
<html>
<head>
	<title>Ficha 5 - Sessions</title>
</head>
<body>
	<h3>Jogo para Adivinhar números</h3>
	<h5>Introduza um número entre 0 e 100</h5>
	<form action="ficha5-controlador.php" method="POST" class="blocked">
		<input type="number" name="numero" placeholder="Número para tentar adivinhar" width="100%" required="required" id="blocked">
		<input type="submit" name="adivinharNum" value="Adivinhar Número" id="blocked2">
	</form>
	<style type="text/css">
		* {
			font-family: Calibri;
		}
	</style>
</body>
</html>
