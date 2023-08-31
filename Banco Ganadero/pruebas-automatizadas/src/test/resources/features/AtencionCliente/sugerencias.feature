@sugerencias
Feature: Envio de sugerencias


  @test-T1723 @atencionCliente @sugerencias @smokeTest @smokeTestSugerencias
  Scenario Outline: Enviar sugerencia

    Given Me autentique con un usuario habilitado
    |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
    |Atención al Cliente|Sugerencias|
    And Envio la sugerencia con los datos requeridos
    |<correoElectronico>|<descripcion>|
    Then Obtengo un mensaje de confirmacion de registro
    |<mensajeExito>|

    Examples:
      |ID|tipoUsuario|usuario|password|correoElectronico|descripcion|mensajeExito|
      ##@externaldata@./src/test/resources/data/datosSugerencia.xlsx@Naturales
      |1   |CODIGO_PERSONA   |42823   |1234   |rriberat@bg.com.bo|Envio de sugerencias Test  |Gracias por su sugerencia, la sugerencia fue enviada satisfactoriamente.|
