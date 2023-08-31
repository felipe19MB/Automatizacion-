@LibroIva
Feature: Libro IVA

  @TST-0001 @Instituciones @LibroIva @SmokeTest @SmokeTestLibroIva
  Scenario Outline: Generar reporte libro iva

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Instituciones|Reporte de Instituciones|Libro IVA|
    And Genero reporte libro iva
      |<institucion>|<fechaInicial>|<fechaFinal>|
    Then Obtengo un reporte con los datos del libro iva
      |<convenio>|<razonSocial>|<nit>|

    Examples:
      |ID|tipoUsuario|usuario|password|institucion|fechaInicial|fechaFinal|convenio|razonSocial|nit|
      ##@externaldata@./src/test/resources/data/instituciones/DatosReporteLibroIva.xlsx@Naturales@1
      |2 |CODIGO_PERSONA  |157466   |1234|EDUCRUZ SRL. COLEGIO.SAINT GEORGE|05/05/2022|05/05/2022|EDUCRUZ SRL. COLEGIO.SAINT GEORGE|EDUCRUZ SRL. COLEGIO.SAINT GEORGE|1023169027|
