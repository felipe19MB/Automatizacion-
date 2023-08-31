@afiliacionCuentasExterior
Feature: Yo como usuario quiero realizar la afiliacion de cuentas nuevas para que pueda realizar transferencias

  @smokeTest @transferencias @smokeTestAfiliacionCuentasExterior @auto-475 @TestCaseKey=TEST-T2114
  Scenario Outline: Afiliar cuentas del Exterior
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Registra la nueva cuenta del exterior
      | subFuncionalidad| alias   | cuentaIBAN   | nombreAfiliado   | numeroDocumento   | tipoPersona   | direccion| pais | ciudad | tipoCodigo   | codigoBanco   | nombreBanco   | paisBanco   | ciudadBanco   | usuario   |
      | <subFuncionalidad>| <alias> | <cuentaIBAN> | <nombreAfiliado> | <numeroDocumento> | <tipoPersona> | <direccion> | <pais> | <ciudad> | <tipoCodigo>    | <codigoBanco> | <nombreBanco> | <paisBanco> | <ciudadBanco> | <usuario> |
    Then Deberia ver un mensaje de guardado satisfactoriamente de cuenta del exterior
      | mensaje   | nombreAfiliado   |  subFuncionalidad   |
      | <mensaje> | <nombreAfiliado> | <subFuncionalidad>  |

    Examples:
      | usuario | contrasena | perfil | modulo | funcionalidad |subFuncionalidad| alias | cuentaIBAN | nombreAfiliado | numeroDocumento | tipoPersona | direccion | pais | ciudad |tipoCodigo|codigoBanco| nombreBanco|paisBanco|ciudadBanco|mensaje |
      ##@externaldata@src/test/resources/data/transferencias/afiliaciones/afiliacion_cuentas_exterior_data.xlsx@happy_path
   |803105   |1234   |Persona Natural   |Transferencias   |Afiliación   |Cuentas del exterior   |GREENFIELD   |8026557129   |GREENFIELD   |701008841   |EMPRESA   |3355 ENTREPRISE AVE SUITE 160   |EEUU   |FORT LAUDERDALE   |ABBA/ROUTE   |031207607   |PNC BANK NA   |EEUU   |BRUNSWICK   |La cuenta se ha guardado satisfactoriamente.|
