@CuentasRelacionadas
Feature: Asignar una cuenta a una Tarjeta de Debito

	#Tiempo de creacion: 30
  @Caso001 @TarjetasDebito @CuentasRelacionadas @SmokeTest @SmokeTestCuentasRelacionadas
  Scenario Outline: Como usuario logueado, Quiero asignar una de mis cuentas a mi tarjeta de debito.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Tarjetas de Débito|Cuentas Relacionadas|
    And Asignar cuenta a TD
      |<cuenta>|
    And Finalizo la asignacion de cuenta ingresando GanaPin <ganapin>
    Then Verifico la asignacion fue exitoso
      |<mensaje>|

			#Tiempo de recoleccion de datos:
    Examples:
      |ID|tipoUsuario|usuario|password|cuenta|importe|cantidad|fechaVencimiento|ganapin|mensaje|
      |1   |CODIGO_PERSONA   |9951821   |1234   |1310572857|1234   |8   |30   |1234|Los datos ser registraron correctamente|