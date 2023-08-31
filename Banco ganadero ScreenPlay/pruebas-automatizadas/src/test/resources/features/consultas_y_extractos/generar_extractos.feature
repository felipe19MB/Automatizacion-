@generarExtracto
Feature: Yo como usuario deseo realizar la generacion del extracto para mis difentes cuentas

  @smokeTest @consultasYExtractos @smokeTestGenerarExtracto @auto-179 @TestCaseKey=TEST-T2113
  Scenario Outline: consultar la generacion del extracto
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When ingresa los campos para generar el extracto
      | periodoFiltro   | desde   | hasta   | cuenta   |
      | <periodoFiltro> | <desde> | <hasta> | <cuenta> |
    Then Deberia poder ver el extracto generado para el numero de transaccion"<numeroTransaccion>"
      | descripcion   | importeDebitado   | saldoDisponible   |
      | <descripcion> | <importeDebitado> | <saldoDisponible> |

    Examples:
      | usuario | contrasena | perfil          | modulo                | funcionalidad    | cuenta     | periodoFiltro   | desde      | hasta      | numeroTransaccion | descripcion                       | importeDebitado | saldoDisponible |
      ##@externaldata@src/test/resources/data/consultas_y_extractos/generar_extractos_data.xlsx@happyPath
   |521   |1234   | Persona Natural    |Consultas y Extractos   |Generar Extracto   |1051364223   |Rango de Fechas   |01/02/2023   |25/03/2023   |1007228   |POS FIDALGA - URUBO Tarj: 7068 BO   |29.30   |4,656.49|
