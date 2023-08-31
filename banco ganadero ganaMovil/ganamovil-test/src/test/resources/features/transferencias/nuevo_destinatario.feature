#Autor: Daniel Amaya Marin

@transferenciasNuevoDestinatario
Feature: Flujo Transferencia

  Como tester del Banco
  Deseo registrar un nuevo destinatario (billetera yolo - mismo banco - banco externo)
  Para verificar el registro y completar la transacción a las cuentas registradas

  @smokeTest @auto-672 @transferencias @smokeTestTransferenciasNuevoDestinatarioBilletera @TestCaseKey=TEST-T2125
  Scenario Outline: Usuario realiza el registro de una cuenta de la billetera yolo
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | Transferencias | Nuevo destinatario |
    When agrega al nuevo destinatario banco yolo
      | institucion   | telefono   | guardarcomo   |
      | <institucion> | <telefono> | <guardarcomo> |
    And selecciona los datos de transferencia del banco yolo
      | cuentaorigen   | descripcion   | saldo   |
      | <cuentaorigen> | <descripcion> | <saldo> |
    Then deberia ver un comprobante de la transferencia del nuevo destinatario <response>

    Examples: Tabla
      | usuario | contrasena | institucion | telefono | guardarcomo | cuentaorigen | descripcion | saldo | response |
    ##@externaldata@./src/test/resources/datadriven/transferencia/transferencia_data.xlsx@NuevoDestinatarioYolo@1
   |4020   |1234   |BILLETERA YOLO   |71044936   |PERSONA NATURAL   |1041159747   |Transferencia prueba automatizada   |10   |¡Transferencia Exitosa!|


  @smokeTest @auto-670 @transferencias @smokeTestTransferenciasNuevoDestinatarioMismoBanco @TestCaseKey=TEST-T2124
  Scenario Outline: Usuario realiza el registro de una cuenta del mismo banco
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | Transferencias | Nuevo destinatario |
    When agrega al nuevo destinatario del mismo banco
      | institucion   | cuentadestino   | nombretitular   | guardarcomo   |
      | <institucion> | <cuentadestino> | <nombretitular> | <guardarcomo> |
    And selecciona los datos de transferencia del mismo banco
      | cuentaorigen   | descripcion   | saldo   |
      | <cuentaorigen> | <descripcion> | <saldo> |
    Then deberia ver un comprobante de la transferencia del nuevo destinatario <response>

    Examples: Tabla
      | usuario | contrasena | institucion | cuentadestino | nombretitular | guardarcomo | cuentaorigen | descripcion | saldo | response |
 ##@externaldata@./src/test/resources/datadriven/transferencia/transferencia_data.xlsx@NuevoDestinatarioMismoBanco@1
   |4020   |1234   |BANCO GANADERO   |1051358509   |Empleado banco   |Prueba Automatizada   |1041159747   |Transferencia prueba automatizada   |10   |¡Transferencia Exitosa!|


  @smokeTest @auto-671 @transferencias @smokeTestTransferenciasNuevoDestinatarioBancoExterno @TestCaseKey=TEST-T2123
  Scenario Outline: Usuario realiza el registro de una cuenta de un banco externo
    Given el usuario inicia Sesión en GanaMovil
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And navega hasta el módulo
      | Transferencias | Nuevo destinatario |
    When agrega al nuevo destinatario del banco externo
      | institucion   | nombresucursal   | tipocuenta   | cuentadestino   | nombretitular   |
      | <institucion> | <nombresucursal> | <tipocuenta> | <cuentadestino> | <nombretitular> |
    And selecciona los datos de transferencia del banco externo
      | cuentaorigen   | descripcion   | saldo   |
      | <cuentaorigen> | <descripcion> | <saldo> |
    Then deberia ver un comprobante de la transferencia ach del nuevo destinatario <response>

    Examples: Tabla
      | usuario | contrasena | institucion | nombresucursal | tipocuenta | cuentadestino | nombretitular | cuentaorigen | descripcion | saldo | response |
##@externaldata@./src/test/resources/datadriven/transferencia/transferencia_data.xlsx@NuevoDestinatarioBancoExterno@1
   |4020   |1234   |BANCO ECONOMICO   |SUCURSAL LA PAZ   |Ahorro   |123400456   |Prueba Automatizada   |1041159747   |Prueba   |10   |¡Transferencia Exitosa!|
