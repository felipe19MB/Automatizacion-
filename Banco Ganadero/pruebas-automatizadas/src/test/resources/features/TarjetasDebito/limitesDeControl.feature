@limitesDeControlTD
Feature: Limites de control de tarjetas de debito

	#Tiempo de creacion: 30
  @test-001 @tarjetasDebito @smokeTest @smokeTestLimitesControl
  Scenario Outline: Como usuario logueado, Quiero realizar el cambio del limite de control de mi tarjeta de debito.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Tarjetas de Débito|Límites de Control|
    And Cambio el limite de control
      |<importe>|<cantidad>|<fechaVencimiento>|
    And Finalizo el Cambio Limite Control ingresando GanaPin <ganapin>
    Then Verifico si el cambio Limite Control fue exitoso fue exitoso
      |<mensaje>|

			#Tiempo de recoleccion de datos:
    Examples:
      |ID|tipoUsuario|usuario|password|nroTarjeta|importe|cantidad|fechaVencimiento|ganapin|mensaje|
      |1   |CODIGO_PERSONA   |9951821   |1234   |4218-28XX-XXXX-6670|1234   |8   |30   |1234|Los parametros se registraron correctamente|
