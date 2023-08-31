@afiOtrosBancos
Feature: Afiliacion de cuentas de otros bancos

  @TST-0001 @transferencia @afiOtrosBancos @smokeTest @smokeTestAfiOtrosBancos
  Scenario Outline: Afiliar cuenta de otro banco

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliación|Cuentas de otros bancos|
    And Afilio una cuenta de otro banco
      |<alias>|<banco>|<sucursal>|<titular>|<documento>|<tipoCuenta>|<nroCuenta>|<mail>|<favorito>|
    Then Obtengo un mensaje de confirmacion
      |<mensaje>|

    Examples: 
      |ID|tipoUsuario|usuario|password|alias|banco|sucursal|titular|documento|tipoCuenta|nroCuenta|mail|favorito|
      ##@externaldata@./src/test/resources/data/transferencia/datosAfiCtaOtrosBancos.xlsx@HappyPath

   
	
  Scenario Outline: Como usuario habilitado, quiero afiliar una cuenta para poder realizar transferencias

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliación|Cuentas de otros bancos|
    And Selecciono agregar nuevo usuario
		And Registro los datos del beneficiario ACH
			|<alias>|<banco>|<sucursal>|<titularCuenta>|<nit>|<tipoCta>|<ctaDestino>|<email>|<favorito>|
    And Ingreso segundo factor para afiliar	<ganapin>
    Then Verifico el mensaje
      |<mensaje>|

    Examples: 
      |ID|tipoUsuario|usuario|password|alias|banco|sucursal|titularCuenta|nit|tipoCta|ctaDestino|email|moneda|favorito|ganapin|mensaje|
   |1   |CODIGO_PERSONA   |521   |1234   |HELMUT|1009|SCZ|RAMIREZ ALI|8999519|CCAD|123456789|hhodin@bg.com.bo    |BOLIVIANOS   |SI   |1234   |El registro de la afiliacion fue exitosa|

      
      