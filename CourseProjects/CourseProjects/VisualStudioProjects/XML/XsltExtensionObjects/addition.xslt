<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:adder="urn:adder">
	<xsl:template match="/">
		<html>
			<head></head>
			<body>
				<h2>Results of Additions</h2>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="valuesList">
		<ul>
		<xsl:for-each select="value">
			<li>
				<xsl:value-of select="adder:addValue(.)"/>
			</li>
		</xsl:for-each>
		</ul>
	</xsl:template>
</xsl:stylesheet>

  