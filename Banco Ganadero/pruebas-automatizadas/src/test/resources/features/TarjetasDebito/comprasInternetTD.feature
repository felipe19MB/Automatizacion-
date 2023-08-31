@comprasInternetTD
Feature: Habilitar Compras por Internet

	#Tiempo de creacion: 30
  @test-001 @tarjetasDebito @smokeTest @smokeTestComprasInternet
  Scenario Outline: Habilitar compras por internet

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Tarjetas de Débito|Compras por Internet|
    And Selecciono rango hoy con un importe <importe>
    And Finalizo el Cambio Compra Hoy ingresando GanaPin <ganapin>
    Then Verifico si el cambio fue exitoso fue exitoso
      |<mensaje>|<usuario>|

			#Tiempo de recoleccion de datos:
    Examples:
      |ID|tipoUsuario|usuario|password|nroTarjeta|importe|fechaDesde|fechaHasta|ganapin|mensaje|
      |1   |CODIGO_PERSONA   |9951821   |1234   |4218-28XX-XXXX-6670|1000|06102022|30102022|1234|exitosa|

  @Caso002 @SmokeTest1
  Scenario Outline: Como usuario logueado, Quiero realizar la habilitacion de mi tarjeta de debito para compras por Internet con un rango de fechas.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Tarjetas de Débito|Compras por Internet|
    And Selecciono rango temporal con un importe
      |<importe>|<fechaDesde>|<fechaHasta>|
    And Finalizo el Cambio Compra Hoy ingresando GanaPin <ganapin>
    Then Verifico si el cambio fue exitoso fue exitoso
      |<mensaje>|<usuario>|

			#Tiempo de recoleccion de datos:
    Examples:
      |ID|tipoUsuario|usuario|password|nroTarjeta|importe|fechaDesde|fechaHasta|ganapin|mensaje|
      |1   |CODIGO_PERSONA   |9951821   |1234   |4218-28XX-XXXX-6670|1000|0|10|1234|exitosa|
