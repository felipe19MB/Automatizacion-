@AfiTerceros
Feature: Afiliacion de cuentas de terceros

	
  Scenario Outline: Como usuario habilitado, quiero eliminar un afiliado para que no aparezca en mi lista.

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
      
  
  Scenario Outline: Como usuario habilitado, quiero afiliar una cuenta para poder realizar transferencias

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliación|Cuentas de terceros|
    And Selecciono agregar nuevo usuario
		And Registro los datos del beneficiario
			|<ctaDestino>|<titularCuenta>|<favorito>|<referencia>|
    And Ingreso segundo factor para afiliar	<ganapin>
    Then Verifico el mensaje
      |<mensaje>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaDestino|titularCuenta|moneda|favorito|ganapin|mensaje|referencia|
      ##@externaldata@./src/test/resources/data/transferencia/afiliacion/DatosAfiliacionCtaTerceros.xlsx@Naturales@1
   |1   |CODIGO_PERSONA   |39073   |1234   |1310296212   |CARDONA SOSSI MARIANELLA   |BOLIVIANOS   |SI   |1234   |La cuenta se ha adicionado satisfactoriamente   |1310296212|

      
