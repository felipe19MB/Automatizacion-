@actualizancionDeDatos
Feature: Como usuario deseo la actualizacion de mis datos personales

  @smokeTest @configuracionYSeguridad @smokeTestActualizancionDeDatos @auto-139 @TestCaseKey=TEST-T2112
  Scenario Outline: actualizar los datos para la persona natural
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When actualiza sus datos personales
      | departamento   | ciudad   | zona   | uv   | mza   | barrio   | calle   | nroPuerta   | piso   | apartamento   | email   | telefono   | celular   | domicilio   | nombreRef1   | nombreRef2   | telefonoRef1   | telefonoRef2   | relacionRef1   | relacionRef2   |
      | <departamento> | <ciudad> | <zona> | <uv> | <mza> | <barrio> | <calle> | <nroPuerta> | <piso> | <apartamento> | <email> | <telefono> | <celular> | <domicilio> | <nombreRef1> | <nombreRef2> | <telefonoRef1> | <telefonoRef2> | <relacionRef1> | <relacionRef2> |
    Then Deberia poder ver "<mensaje>" de cambio exitoso y los datos actualizados en base de datos
      | departamento   | ciudad   | uv   | mza   | barrio   | calle   | nroPuerta   | piso   | apartamento   | email   | telefono   | celular   | nombreRef1   | nombreRef2   | telefonoRef1   | telefonoRef2   | relacionRef1   |
      | <departamento> | <ciudad> | <uv> | <mza> | <barrio> | <calle> | <nroPuerta> | <piso> | <apartamento> | <email> | <telefono> | <celular> | <nombreRef1> | <nombreRef2> | <telefonoRef1> | <telefonoRef2> | <relacionRef1> |


    Examples:
      | usuario | contrasena | perfil          | modulo                    | funcionalidad          | departamento | ciudad    | zona  | uv | mza | barrio     | calle             | nroPuerta | piso | apartamento | email            | telefono | celular  | domicilio | nombreRef1 | nombreRef2 | telefonoRef1 | telefonoRef2 | relacionRef1 | relacionRef2 | mensaje                                         |
      ##@externaldata@src/test/resources/data/configuracion_y_seguridad/actualizacion_de_datos_data.xlsx@happyPath
   |521   |1234   | Persona Natural   |Configuración y Seguridad   |Actualización de datos   |LA PAZ   |LA ASUNTA   |NORTE   |5   |10   |EL ROSARIO   |CALLE 18 DE MARZO   |3   |2   |101   |PRUEBA@GMAIL.COM   |73463521   |54343432   |Domicilio   |CARLOS   |ISABELA   |2324353   |3435435   |FAMILIAR   |COLEGA   |Estimado cliente: Sus datos fueron actualizados|

