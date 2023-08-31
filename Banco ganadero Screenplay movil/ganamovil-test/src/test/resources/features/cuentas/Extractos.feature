@Extractos
Feature: Extractos
  Generar extractos por periodos

  @TEST-000 @SmokeTest @ExtractoOtrosMeses
  Scenario Outline: Como usuario quiero generar extracto de otros meses para confirmar el debito o credito de las transacciones.
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
    When Consulto extracto de la cuenta
      |<nroCuenta>|<mes>|
    Then Obtengo un resumen del debito o credito realizado en el mes seleccionado
      |<descripcion>|<importe>|


    Examples:
      |ID|usuario|password|nroCuenta|mes|descripcion|importe|
      ##@externaldata@./src/test/resources/data/Cuentas/DatosExtractos.xlsx@HappyPath@1
   |1   |10535519   |1234   |CA 1310322272   |Enero   |Seguro 1-2022 4218281004179343   |12.00 Bs|
