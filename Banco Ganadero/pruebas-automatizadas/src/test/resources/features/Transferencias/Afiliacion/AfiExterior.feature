@AfiExterior
Feature: Afiliacion de cuenta al exterior

  @TST-0001 @Transferencia @AfiExterior @SmokeTest @SmokeTestAfiExterior
  Scenario Outline: Afiliar cuenta del exterior

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Transferencias|Afiliacion|Cuentas del exterior|
    And Afilio una cuenta del exterior
      |<tipoCodigo>|<codigoBanco>|<nombreBancoBeneficiario>|<paisBancoBeneficiario>|<ciudadBancoBeneficiario>|<alias>|<iban>|<nombre>|<nroDocumento>|<tipoPersona>|<direccion>|<pais>|<ciudad>|
    Then Obtengo un mensaje indicando que la cuenta del exterior ha sido afiliada
      |<mensaje>|

    Examples:
      |ID|tipoUsuario|usuario|password|tipoCodigo|codigoBanco|nombreBancoBeneficiario|paisBancoBeneficiario|ciudadBancoBeneficiario|alias|iban|nombre|nroDocumento|tipoPersona|direccion|pais|ciudad|mensaje|
      |2 |CODIGO_PERSONA  |812   |1234|          |           |                       |                     |                       |     |    |      |            |           |         |    |      |La cuenta se ha guardado satisfactoriamente.|
