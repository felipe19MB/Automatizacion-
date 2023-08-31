
@RemesaCobroGiroSinSesion
Feature: Remesas Cobro de Giros sin sesion en GanaMovil
  Quiero realizar un cobro de giro sin Sesion en GanaMovil y abonarlo a una cuenta de cliente

  @TEST-T1389 @SmokeTest @Remesas
  Scenario Outline: Como cliente quiero realizar un cobro de giro FTP en remesas sin Sesion en GanaMovil y abonarlo a mi cuenta.
    Given Abri la aplicacion
    And Ingreso a la opcion
      |Cobro de Giros y Remesas|
    And Ingreso Documento de Identificacion
      |<nroCarnetIdentidad>|<extensionCI>|
    And Confirmo datos de identificacion
    When Ingreso datos de cobro remesa
      |<claveReferencia>|<montoEnvio>|<moneda>|<nombreApellidoRemitente>|<nroCuenta>|
    And Confirmar datos de cobro remesa
    And Confirmar Resumen de Giro Remesa
      |<montoEnvio>|<nroCuenta>|<moneda>|
    Then Finalizamos Comprobante Giro Remesa
      |<montoEnvio>|<moneda>|
    Examples:
      |ID|nroCarnetIdentidad|extensionCI|claveReferencia|montoEnvio|moneda|nombreApellidoRemitente|nroCuenta|
      |1 |6198548   |LP  |ZR20179429  |1116.00|DOLARES AMERICANOS |LIDIA FUENZALIDA|1310126649|
      |2 |6231546   |SC  |ITE00014867273  |2000.00|BOLIVIANOS |SERGIO PAINA HINOJOSA|1051075307|
      |3 |6198548   |LP  |YF20090381  |172.50|BOLIVIANOS |NELLY LUJAN ROJAS|1310504173|