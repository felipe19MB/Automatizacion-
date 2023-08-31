@iniciarSesion
Feature: Yo como usuario Deseo actualizar mi clave de acceso y transaccional para
  poder ingresar a ganaNet y realizar transacciones

  @smokeTest @acceso @smokeTestIniciarSesion @auto-409 @TestCaseKey=TEST-T2096
  Scenario Outline:Actualizacion la clave de acceso y transaccional
    Given El cliente actualiza la DB para que permita hacer el cambio de clave
    And El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    When ingresa los campos de actualizacion de la clave
      | contrasena   | nuevaClave   | nuevaClaveTransaccional   |
      | <contrasena> | <nuevaClave> | <nuevaClaveTransaccional> |
    And ingresa a la pagina de gananet con las nuevas credenciales
      | usuario   | nuevaClave   |
      | <usuario> | <nuevaClave> |
    Then Deberia poder ver el <nombre> del usuario y la <claveTransaccional> actualizada en bd


    Examples:
      | usuario | contrasena | nuevaClave | nuevaClaveTransaccional | nombre | claveTransaccional                                                                                                             |
       ##@externaldata@src/test/resources/data/acceso/accesos_data.xlsx@Hoja1@1
   |521   |1234   |5678   |12345678   |F   |FA585D89C851DD338A70DCF535AA2A92FEE7836DD6AFF1226583E88E996293F16BC09C652826E0FC5C706695A03CDDCE372F139EFF4D13959DA6F1F5D3EABE|







