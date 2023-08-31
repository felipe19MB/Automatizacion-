@afiliacionCuentasOtrosBancos
Feature: Yo como usuario quiero realizar la afiliacion de cuentas nuevas para que pueda realizar transferencias

  @smokeTest @transferencias @smokeTestAfiliacionCuentasOtrosBancos @auto-315 @TestCaseKey=TEST-T2101
  Scenario Outline: Afiliar cuentas de otros Bancos
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Registra la nueva cuenta de otro banco
      | subFuncionalidad   | alias   | banco   | sucursal   | nombreTitular   | ciNit   | tipoCuenta| nroCuenta | email | usuario   |
      | <subFuncionalidad>    | <alias> | <banco> | <sucursal> | <nombreTitular> | <ciNit> | <tipoCuenta> | <nroCuenta> | <email> | <usuario> |
    Then Deberia ver un mensaje de afiliacion exitosa
      | mensaje   | nroCuenta   | banco   | alias   | nombreTitular   |  subFuncionalidad   |
      | <mensaje> | <nroCuenta> | <banco> | <alias> | <nombreTitular> | <subFuncionalidad>  |

    Examples:
      | usuario | contrasena | perfil | modulo | funcionalidad |subFuncionalidad| alias | banco | sucursal | nombreTitular | ciNit | tipoCuenta | nroCuenta | email | mensaje |
      ##@externaldata@src/test/resources/data/transferencias/afiliaciones/afiliacion_cuenta_otros_bancos_data.xlsx@happy_path
   |803105   |1234   |Persona Natural   |Transferencias   |Afiliación   |Cuentas de otros bancos   |AUTOMATION   |BANCO UNION   |SUCURSAL LA PAZ   |MIGUEL CONTRERAS   |6732452   |CTA CTE CAJA AHORRO   |3127514011   |MACONTRERAS@BG.COM.BO   |El registro de la afiliacion fue exitosa|
