@consulta
Feature: Yo como usuario quiero consultar un movimiento de tipo credito

  @smokeTest @comprobantes @smokeTestConsulta @auto-396 @TestCaseKey=TEST-T2769
  Scenario Outline: Consultar un comprobante de credito
    Given El cliente ingresa a la pagina de gananet
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And Ingresa al perfil,modulo y funcionalidad correspondiente
      | perfil   | modulo   | funcionalidad   |
      | <perfil> | <modulo> | <funcionalidad> |
    When Consulta un comprobante de credito
      | tipoDeMovimiento   | cuenta   | desde   | hasta   | nroAsiento   | nroCuenta   |
      | <tipoDeMovimiento> | <cuenta> | <desde> | <hasta> | <nroAsiento> | <nroCuenta> |
    Then Deberia ver un comprobante con los datos del credito realizado
      | nroAsiento   | fecha   | tipoMovimiento   | importe   | moneda   | nroCuenta   | glosa   |
      | <nroAsiento> | <fecha> | <tipoMovimiento> | <importe> | <moneda> | <nroCuenta> | <glosa> |

    Examples:
      | usuario | contrasena | perfil          | modulo       | funcionalidad | tipoDeMovimiento | cuenta | desde      | hasta      | nroAsiento | fecha      | tipoMovimiento | importe | moneda | nroCuenta  | glosa                                                                                |
      | 78802   | 1234       | Persona Natural | Comprobantes | Consulta      | CREDITO          | TODOS  | 08/02/2023 | 08/02/2023 | 704008473  | 08/02/2023 | CRÉDITO        | 4000    | Bs     | 1310240699 | ACH QR Nro. 51662841. BANCO FASSIL S.A. DEP: TELCHI ABUAWAD NASRI CI/NIT: 04567806SC |
