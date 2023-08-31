#Autor: Daniel Amaya Marín

@afiliarServicioBásico
Feature: Flujo afiliar servicio básico

  Como tester del Banco
  Deseo afiliar un servicio
  Para verificar el registro y pagar


  @smokeTest @auto-704 @afiliarServicio @smokeTestAfiliarServicioTelefonia/Internet/TvCable @TestCaseKey=TEST-T2165
  Scenario Outline: Usuario afilia un servicio básico de telefonia/internet/tv cable
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    When navega hasta el módulo
      | Pagos de servicios |
    And selecciona el tipo de servicio
      |<servicio>	|<tipodeservicio>|
    And diligencia los datos del servicio
      |tipo|codigo|cuenta|referencia|
      |<tipo>|<codigo>|<cuenta>|<referencia>|
    Then válida el registro del servicio <response>

    Examples: Tabla
      | usuario | contrasena |servicio	|tipodeservicio|tipo|codigo|cuenta|referencia|response|
##@externaldata@./src/test/resources/datadriven/pagodeservicio/servicio_basico_data.xlsx@TelefoniaInternetTv@1
   |152843   |1234   |Básico   |TELEFONIA/INTERNET/TV CABLE   |ENTEL   |CUENTA   |43657397   |Afiliación Automatizada   |El registro de la afiliación fue exitosa|


