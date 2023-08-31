@instituciones
Feature: Yo como usuario deseo realizar las consultasde las transacciones de las instituciones agrupadas
  por fecha para tener un registro mas entendible

  @smokeTest @instituciones @smokeTestTransaccionesPorFecha @auto-625 @TestCaseKey=TEST-T2767
  Scenario Outline: Genrar las transacciones de las instituciones agrupadas por fecha
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Genera las transacciones agrupadas por fecha
      | subFuncionalidad   | institucion   | gestion   | fechaInicial   | fechaFinal   | agrupacion   |
      | <subFuncionalidad> | <institucion> | <gestion> | <fechaInicial> | <fechaFinal> | <agrupacion> |
    Then Deberia ver el registro generado para la fecha seleccionada
      | numeroTransaccion   | usr   | curso   | concepto   | codigo   | nombre   | cuota   | monto   |
      | <numeroTransaccion> | <usr> | <curso> | <concepto> | <codigo> | <nombre> | <cuota> | <monto> |
    Examples:
      | usuario | contrasena | perfil           | modulo        | funcionalidad            | subFuncionalidad    | institucion                       | gestion | fechaInicial | fechaFinal | agrupacion | numeroTransaccion | usr | curso | concepto                                  | codigo | nombre                   | cuota | monto    |
      ##@externaldata@src/test/resources/data/instituciones/transacciones_por_fecha_data.xlsx@happyPath
   |157466   |1234   | Persona Juridica    |Instituciones   |Reporte de Instituciones   |Transacciones fecha   |EDUCRUZ SRL. COLEGIO.SAINT GEORGE    |2023   |22-02   |22-02   |Fecha   |84000021   |RTH   |S2B   |SERVICIOS DE EDUCACION SECUNDARIA GENERAL   |45864   |PARADA BALDIVIESO SAMUEL   |1   |	2,303.00|


