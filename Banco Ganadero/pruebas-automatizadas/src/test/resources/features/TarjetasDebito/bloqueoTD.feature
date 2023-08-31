@bloqueoTD
Feature: Bloqueo y desbloqueo de tarjetas de debito

	#Tiempo de creacion: 30
  @test-0001 @tarjetasDebito @bloqueoTD @smokeTest @smokeTestBloqueoTD
  Scenario Outline: Bloquear tarjeta de debito

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Tarjetas de Débito|Bloqueo|
    And Ingreso el motivo para el bloqueo
    And Finalizo el bloqueo ingreso GanaPin <ganapin>
    Then Verifico si el bloqueo de tarjeta fue exitoso
      |<nroTarjeta>|<usuario>|

			#Tiempo de recoleccion de datos:
    Examples:
      |ID|tipoUsuario|usuario|password|nroTarjeta|nroPlastico|tipoBloqueo|ganapin|mensaje|
      |1   |CODIGO_PERSONA   |9951821   |1234   |4218-28XX-XXXX-6670|4218-28XX-XXXX-6670   |2   |1234   |Bloqueada|
