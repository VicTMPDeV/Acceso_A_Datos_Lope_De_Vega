<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>POK�DEX</title>
<!-- 				<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/> -->
			</head>
			<body>
			<!-- TITULO -->
				<div class="titulo" style="text-align: center; padding: 2%;">
					<h1>POK�DEX</h1>
				</div>
				<!-- TABLA DE DATOS -->
				<div style="padding-left: 5%;padding-right: 5%;">
					<table class="table">
						<thead style="text-align: center">
							<tr>
								<th>ID</th>
								<th>NOMBRE</th>
								<th>TIPO</th>
								<th>EVOLUCI�N</th>
								<th>IMAGEN</th>
							</tr>
						</thead>
						<tbody style="text-align: center">
							<xsl:for-each select="/Pokedex/Pokemon">
								<tr>
									<td><xsl:value-of select="./@id"/></td>
									<td><xsl:value-of select="nombre"/></td>
									<td><xsl:value-of select="tipos"/></td>
									<td><xsl:value-of select="evoluciones"/></td>
									<td align="center"><img width="100"><xsl:attribute name="src"><xsl:value-of select="imagen"/></xsl:attribute></img></td>
								</tr>
							</xsl:for-each>
						</tbody>
					</table>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>