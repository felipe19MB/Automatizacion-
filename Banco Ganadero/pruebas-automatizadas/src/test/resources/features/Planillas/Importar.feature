@Importar
Feature: Importar y pagar planilla

  @PIM001 @Planillas @ImportarPlanilla @SmokeTest @SmokeTestImportarPlanilla
  Scenario Outline: Como usuario logueado, quiero verificar si la lista de convenios no muestra el convenio SFTP.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Pago de Planillas|Importar y pagar planilla|
    And Selecciono forma de pago
      |<formaPago>|<btnSiguiente>|
    And Verifico que el convenio SFTP no se muestre en la lista
    	|<nombreConvenio>|<convenio>|

    Examples: 
      |ID|tipoUsuario|usuario|password|nombre|nombrePerfil|formaPago|convenio|btnSiguiente|
      |2 |CODIGO_PERSONA  |10944652   |1234   |MARIO   |TELEFONICA CELULAR DE BOLIVIA|Automática|823|Siguiente|
