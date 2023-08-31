@historicoPagoPlanillas
Feature: Yo como cliente quiero conocer el historico de pago de planillas en distintas fechas
  para que tenga un registro para su control de los pagos realizados

  @smokeTest @planillas @smokeTestHistoricoPagoPlanillas @auto-412 @TestCaseKey=TEST-T2095
  Scenario Outline:  Buscar pagos de planillas en un rango de fechas y verificar datos de la planilla
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil           | modulo            | funcionalidad               |
      | Persona Juridica | Pago de Planillas | Historico pago de planillas |
    When Ingreso los campos para buscar una planilla
      | convenio   | periodoDel   | periodoAl   |
      | <convenio> | <periodoDel> | <periodoAl> |
    And Selecciono una Planilla
      | nroPlanilla   |
      | <nroPlanilla> |
    Then Deberia ver los datos de la Planilla
      | nroPlanilla   | codigoServicio   | cliente   | cuentaDebito   | importe   | fechaCarga   | fechaVigencia   | nombrePlanilla   | EstadoPlanilla   |
      | <nroPlanilla> | <codigoServicio> | <cliente> | <cuentaDebito> | <importe> | <fechaCarga> | <fechaVigencia> | <nombrePlanilla> | <EstadoPlanilla> |

    Examples:
      | id | usuario | contrasena | convenio                                                   | periodoDel | periodoAl  | nroPlanilla | importe       | codigoServicio                              | cliente                  | cuentaDebito | fechaCarga | fechaVigencia | nombrePlanilla | EstadoPlanilla |
       ##@externaldata@src/test/resources/data/pago_planillas/pago_planilla_data.xlsx@planillaHistorico@1
      | 1  | 20025   | 1234       | 92562 - 1310068705 - GANASUELDOS FERROVIARIA ORIENTAL S.A. | 01/12/2022 | 31/12/2022 | 3201943     | 442,204.98 Bs | 92562-GANASUELDOS FERROVIARIA ORIENTAL S.A. | 3033562-PERSONA JURIDICA | 1310068705   | 27/12/2022 | 29/12/2022    | Ganadero 2 Dic | PROCESADO      |


  @Regresion  @Planillas  @Historico_Pagos_Empleados
  Scenario Outline:  Buscar pagos de planillas en un rango de fechas y verificar datos de los empleados
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil           | modulo            | funcionalidad               |
      | Persona Juridica | Pago de Planillas | Historico pago de planillas |
    When Ingreso los campos para buscar una planilla
      | convenio   | periodoDel   | periodoAl   |
      | <convenio> | <periodoDel> | <periodoAl> |
    And Selecciono una Planilla
      | nroPlanilla   |
      | <nroPlanilla> |
    Then Deberia ver los datos de los empleados en la planilla
      | orden | codigo     | nombre                        | formaPago        | fechaPago  | nroCuenta  | montoPago | estado    |
      | 1     | 1813027 TJ | AGUIAR CABALLERO JHONN MARCOS | TRANSFERENCIA BG | 29/12/2022 | 1310460356 | 6,940.35  | PROCESADO |
      | 2     | 5858959 SC | AGUILERA MELGAR JOSE LUIS     | TRANSFERENCIA BG | 29/12/2022 | 1310460380 | 4,850.58  | PROCESADO |
      | 3     | 1987052 SC | ANTELO CORTEZ EVALDO          | TRANSFERENCIA BG | 29/12/2022 | 1310460423 | 6,599.83  | PROCESADO |
      | 4     | 3853795 SC | ANTELO MERUVIA JOSE           | TRANSFERENCIA BG | 29/12/2022 | 1310460357 | 4,284.04  | PROCESADO |
      | 5     | 3176929 SC | AÑEZ VEIZAGA EDDY             | TRANSFERENCIA BG | 29/12/2022 | 1310460381 | 4,751.71  | PROCESADO |

    Examples:
      | id | usuario | contrasena | convenio                                                   | periodoDel | periodoAl  | nroPlanilla |
       ##@externaldata@src/test/resources/data/pago_planillas/pago_planilla_data.xlsx@planillaEmpleados
      | 1  | 20025   | 1234       | 92562 - 1310068705 - GANASUELDOS FERROVIARIA ORIENTAL S.A. | 01/12/2022 | 31/12/2022 | 3201943     |
