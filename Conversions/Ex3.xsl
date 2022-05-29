<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>llistallibres</h2>
                <ol>
                    <xsl:for-each select="llistallibres/llibre">
                        <li><xsl:value-of select="titol"/><br>
                         <xsl:value-of select="autor"/>
                        </li>
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>