@AfiOtrosBancos
Feature: Afiliacion de cuentas de otros bancos

  
  Scenario Outline: Como usuario habilitado, quiero eliminar un afiliado para que no aparezca en mi lista.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliación|Cuentas de otros bancos|
    And Busco el afiliado ACH y hago clic en eliminar
      |<ctaDestino>|
    And Ingreso segundo factor para eliminar	<ganapin>
    Then Verifico el mensaje
      |<mensaje>|

    Examples: 
      |ID|tipoUsuario|usuario|password|ctaDestino|titularCuenta|moneda|favorito|ganapin|mensaje|
   |1   |CODIGO_PERSONA   |521   |1234   |123456789   |RAMIREZ ALI   |BOLIVIANOS   |SI   |1234   |La cuenta fue desafiliada satisfactoriamente|

   
	
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

      
      