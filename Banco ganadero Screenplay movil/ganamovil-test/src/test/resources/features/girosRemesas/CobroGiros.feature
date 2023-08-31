@RemesaCobro
Feature: Remesas Cobro de Giros
  Quiero iniciar un cobro de giro y abonarlo a una cuenta de cliente

  @TEST-T1360 @SmokeTest @Remesas
  Scenario Outline: Como usuario que solo tengo una cuenta quiero realizar un cobro de giro FTP en remesas y abonarlo a mi cuenta de cliente.
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
      |Giros y Remesas|Cobro de giros|
    When Ingreso el numero de referencia del giro abonado
      |<nroReferencia>|
    And Busca el giro a abonar
    And Confirmar el monto a Cobrar
      |<importe>|
    And Confirmar resumen de giro
      |<importe>|
    Then Finalizamos comprobante de deposito de giro
      |<importe>|

    Examples:
      |ID|usuario|password|nroReferencia|importe|
      |1   |8166479   |1234   |9616494 |1,568.00 Bs.|