@PortaChequera
Feature: Porta Chequera

  @TST-0001 @Chequeras @PortaChequeras @SmokeTest @SmokeTestPortaChequeras
  Scenario Outline: Solicitar porta chequera

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Chequeras|Solicitud de Porta Chequera|
    And Solicito porta chequera
      |<cuentaOrigen>|<tipoPortaChequera>|<retiraChequera>|<oficinaEntrega>|<comentario>|
    Then Obtengo un comprobante con los datos de porta chequera
      |<cuentaOrigen>|<nombre>|<importeDebitado>|<tipo>|<recogera>|<oficina>|<pie>|

    Examples:
      |ID|tipoUsuario|usuario|password|cuentaOrigen|tipoPortaChequera|retiraChequera|oficinaEntrega|comentario|nombre|importeDebitado|tipo|recogera|oficina|pie|
