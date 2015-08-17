<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="r1"/>
	<xsl:param name="r2"/>
	<xsl:param name="r3"/>
	<xsl:param name="r4"/>
	<xsl:param name="r5"/>
	<xsl:template match="/">
		<svg xml:space="preserve" width="5.0in" height="5.0in" viewBox="0 0 200 200">
			<text style="fill:red;" x="80" y="30"><xsl:value-of select="/title/text()"/></text>
			<path style="stroke:black;" d="M 50 50 L 50 190 z"/>
			<path style="stroke:black;" d="M 50 190 L 250 190 z"/>
			<rect x="50" y="{190 - $r1}" style="fill:blue;" width="15" height="{$r1}"/>
			<rect x="65" y="{190 - $r2}" style="fill:red;" width="15" height="{$r2}"/>
			<rect x="80" y="{190 - $r3}" style="fill:black;" width="15" height="{$r3}"/>
			<rect x="95" y="{190 - $r4}" style="fill:green;" width="15" height="{$r4}"/>
			<rect x="110" y="{190 - $r5}" style="fill:grey;" width="15" height="{$r5}"/>
		</svg>
	</xsl:template>
</xsl:stylesheet>
