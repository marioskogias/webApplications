<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Used Vehicles</title>
			</head>
			<body background="Money.jpg">
				<h1
					style="background-color: #446600;
color: #FFFFFF; font-size: 20pt; text-align: center;
letter-spacing: 1.0em">Used Vehicles</h1>
				<table align="center" border="2">
					<tr>
					<xsl:template match="/">
					 	<xsl:apply-templates select="child::*/child::*[1]/attribute::*"/>
						 <xsl:apply-templates select="child::*/child::*[1]/*"/>
					</xsl:template>
					</tr>
					<!--This template has had so far only presentation elements, -->
					<!-- without any reference to the target xml document -->
					<!-- We now refer to the the target xml document -->
					<xsl:for-each select="child::*/child::*">
						<tr>
							<xsl:for-each select="attribute::*">

								<td>
									<xsl:value-of select="current()" />
								</td>

							</xsl:for-each>
							<xsl:for-each select="child::*">

								<td>
									<xsl:value-of select="current()" />
								</td>

							</xsl:for-each>

						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="child::*/child::*[1]/attribute::*">
		<th> 
		<xsl:value-of select="local-name()"/>
		</th>
	</xsl:template>
	
	<xsl:template match="child::*/child::*[1]/*">
		<th> 
		<xsl:value-of select="local-name()"/>
		</th>
	</xsl:template>
	
</xsl:stylesheet>