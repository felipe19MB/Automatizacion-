@Consultas
Feature: Consultas
  Verificar saldo en cuenta

  @TEST-T1392 @SmokeTest @ConsultaSaldo
  Scenario Outline: Como usuario quiero ver el saldo de mi cuenta.
    Given Cliente abre aplicacion
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Ingreso a la opcion
      |Cuentas|
    When Consulto la cuenta
      |<nroCuenta>|<saldo>|
    Then Obtengo el saldo y el estado de la cuenta
      |<nroCuenta>|<estado>|<saldo>|<tipoCuenta>|


    Examples:
      |ID|usuario|password|nroCuenta|saldo|estado|tipoCuenta|
      ##@externaldata@./src/test/resources/data/Cuentas/DatosExtractos.xlsx@HappyPath@1
      |1   |12062765   |1234   |CA 1310471927   |98.06   |SIN BLOQUEO  |EMPLEADOS - GANAMAS  Bs|
