<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
  <html>
  <body>
  <h2>Órarend</h2>
  <table border="1">
    <tr>
      <th>ID</th>
      <th>Tárgy</th>
      <th>Nap</th>
      <th>Időpont</th>
      <th>Helyszín</th>
      <th>Oktató</th>
      <th>Típus</th>
      <th>Szak</th>
    </tr>
    <xsl:for-each select="XY_orarend/ora">
    <tr>
      <td><xsl:value-of select="@id"/></td>
      <td><xsl:value-of select="targy"/></td>
      <td><xsl:value-of select="idopont/nap"/></td>
      <td><xsl:value-of select="concat(idopont/tol, ' - ', idopont/ig)"/></td>
      <td><xsl:value-of select="helyszin"/></td>
      <td><xsl:value-of select="oktato"/></td>
      <td><xsl:value-of select="@típus"/></td>
      <td><xsl:value-of select="szak"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>