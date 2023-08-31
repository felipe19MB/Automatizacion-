@registrarReclamo
Feature: Como usuario deseo realizar el registro de un reclamo

  @smokeTest @atencionAlCliente @smokeTestRegistrarReclamo @auto-581 @TestCaseKey=TEST-T2110
  Scenario Outline: realizar el registro de un reclamo de cargos no Reconocidos
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When registra un reclamo
      | celular   | telefonoTrabajo   | barrio   | calle   | numeroCasa   | correoElectronico   | tipoReclamo   | reclamo   | monto   | moneda   | descripcion   |
      | <celular> | <telefonoTrabajo> | <barrio> | <calle> | <numeroCasa> | <correoElectronico> | <tipoReclamo> | <reclamo> | <monto> | <moneda> | <descripcion> |
    And visualiza el estado del reclamo por el tipo "<tipo>"
      | perfil   | modulo         | funcionalidad         |
      | <perfil> | <moduloEstado> | <funcionalidadEstado> |
    Then deberia ver el reclamo listado en estado de reclamos
      | mensaje   | tipoReclamo   | descripcion   | monto   | moneda   |
      | <mensaje> | <tipoReclamo> | <descripcion> | <monto> | <moneda> |

    Examples:
      | usuario | contrasena | perfil          | modulo              | funcionalidad | celular | telefonoTrabajo | barrio     | calle                 | numeroCasa | correoElectronico | tipoReclamo        | reclamo               | monto | moneda | descripcion                     | moduloEstado        | funcionalidadEstado | tipo     | mensaje                                                              |
      ##@externaldata@src/test/resources/data/atencion_al_cliente/registrar_reclamo_data.xlsx@happyPath
   |456   |1234   | Persona Natural   |Atención al Cliente   |Reclamos   |5434278   |5432647   |monteverde    |santacruz calle 54#34   |3   |prueba@gmail.com   |Banca por Internet    |Cargos no Reconocidos    |3.00   |Bs   |Esto es una prueba automatizada   |Atención al Cliente   |Estado de reclamos   |Reclamos   |Gracias por su reclamo, el reclamo fue realizado satisfactoriamente.|

