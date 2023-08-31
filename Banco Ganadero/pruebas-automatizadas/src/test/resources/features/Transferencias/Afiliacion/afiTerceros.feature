@AfiliacionTerceros
Feature: Afiliacion de cuentas de terceros


  Scenario Outline: Eliminar afiliado.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliación|Cuentas de terceros|
    And Busco el afiliado y hago clic en eliminar
      |<ctaDestino>|
    And Ingreso segundo factor para eliminar	<ganapin>
    Then Verifico el mensaje
      |<mensaje>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaDestino|titularCuenta|moneda|favorito|ganapin|mensaje|
      ##@externaldata@./src/test/resources/data/transferencia/afiliacion/DatosBajaCtaTerceros.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |39073   |1234   |1310296212   |CARDONA SOSSI MARIANELLA   |BOLIVIANOS   |SI   |1234   |La cuenta fue desafiliada satisfactoriamente|
      
  @test-T1385 @transferencias @smokeTest @smokeTestAfiliacionTerceros
  Scenario Outline: Afiliar cuenta de tercero.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliación|Cuentas de terceros|
    And Registro los datos de la cuenta de terceros y finalizo la afiliacion
      |<ctaDestino>|<titularCuenta>|<favorito>|<alias>|<ganapin>|<usuario>|
    Then Obtengo un mensaje de afiliacion exitosa y la cuenta aparece en la lista
      |<mensaje>|<alias>|<ctaDestino>|<titularCuenta>|


    Examples: 
      |ID|tipoUsuario|usuario|password|ctaDestino|titularCuenta|favorito|ganapin|mensaje|alias|
      ##@externaldata@./src/test/resources/data/transferencia/afiliacion/datosAfiliacionCtaTerceros.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |39073   |1234   |1310296212   |PERSONA NATURAL   |SI   |1234   |La cuenta se ha guardado satisfactoriamente   |1310296212|


      
