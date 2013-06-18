<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Used Vehicles</title>
			</head>
			<body >
				<h1>Create html with xsl</h1>
				<table align="center" border="2">
					<tr>
					<xsl:template match="/">
					 	<xsl:apply-templates select="*/*[1]/@*"/>
						 <xsl:apply-templates select="*/*[1]/*"/>
					</xsl:template>
					</tr>
					<!--This template has had so far only presentation elements, -->
					<!-- without any reference to the target xml document -->
					<!-- We now refer to the the target xml document -->
					<xsl:for-each select="*/*">
						<tr>
							<xsl:for-each select="@*">

								<td>
									<xsl:value-of select="." />
								</td>

							</xsl:for-each>
							<xsl:for-each select="*">

								<td>
									<xsl:value-of select="." />
								</td>

							</xsl:for-each>

						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="*/*[1]/@*">
		<th> 
		<xsl:value-of select="name()"/>
		(a)
		</th>
	</xsl:template>
	
	<xsl:template match="*/*[1]/*">
		<th> 
		<xsl:value-of select="name()"/>
		(c)
		</th>
	</xsl:template>
	
</xsl:stylesheet>