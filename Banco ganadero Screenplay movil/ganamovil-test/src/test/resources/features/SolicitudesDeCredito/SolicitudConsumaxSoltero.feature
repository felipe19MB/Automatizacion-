@SolicitudConsumax
Feature: Solicitud de Credito Consumax Soltero
  Como cliente quiero ingresar mi solicitud de credito de consumo para acceder
  al credito que necesito

  Background:
    Given Cliente abre aplicacion
    And Elimina internamente dispositivo de la persona
      |802300|
    And Inicio sesion
      |802300|1234|
    And Se enrola al usuario
      |802300|
    And Inicio sesion
      |802300|1234|
    And Ingreso a la opcion
      |Solicitudes de Crédito|Solicitud de Crédito de Consumo|



  @TEST-T1305 @BVT @SolicitudConsumax
  Scenario Outline: Como cliente quiero ingresar una solicitud pero no soy asalariado
    When Cliente indica que No es Asalariado
    Then mensaje informativo indicando que no puede solicitar el credito
      |<mensaje>|

    Examples:
      |ID|usuario|password|mensaje|
      |1 |802300|1234|Estimado cliente por el momento no contamos con el servicio para “No asalariados”, estamos trabajando para próximamente poder atenderlo, por favor pase por nuestras oficinas.|

  @TEST-T1304 @SmokeTest @SolicitudConsumax
  Scenario Outline: Como cliente quiero poder desestimar mi solicitud antes de terminar el registro
    And Indica iniciar la solicitud
    And Indica iniciar la solicitud porque es asalariado
    And Confirma Terminos y Condiciones
    And selecciona y llena Estado civil, Residencia y Sueldo Liquido USD
      |<SueldoLiquidoTitular>|
    And llena confirmacion de correo electronico del titular
      |escribe tu correo electrónico nuevamente|
    And llena correo electronico del titular
    And llena telefono celular y confirma los datos
      |<telefono>|
    And Selecciona cancelar la solicitud consumax soltero
    And Selecciona Si para ser redirigido a la pantalla principal de la solicitud consumax soltero
    And Selecciona Cancelar Solicitud consumax soltero
    When Indica que esta seguro de cancelar la solicitud consumax soltero
    Then Visualiza que la solicitud se desestimo correctamente
      |<MensajeDesestimado>|

    Examples:
      |ID|usuario|password|SueldoLiquidoTitular|telefono|MensajeDesestimado|
      |1 |802300|1234|1500|75330974|Estimado Cliente, se desestimo la solicitud.|

  @TEST-T1299 @SmokeTest @SolicitudConsumax
  Scenario Outline: Como cliente quiero ingresar una solicitud de credito consumax
    And Indica iniciar la solicitud
    And Se desactiva antispoofing
      |<usuario>|<tipologia>|
    And Indica iniciar la solicitud porque es asalariado
    And Confirma Terminos y Condiciones
    And selecciona y llena Estado civil, Residencia y Sueldo Liquido USD
      |<SueldoLiquidoTitular>|
    And llena confirmacion de correo electronico del titular
      |escribe tu correo electrónico nuevamente|
    And llena correo electronico del titular
    And llena telefono celular y confirma los datos
      |<telefono>|
    And indica el monto a solicitar
      |<montoASolicitar>|
    And selecciona el dia que desea pagar
    And confirma datos del monto a solicitar
    And selecciona nivel de educacion, profesion, cargo, nivel ingreso
      |<profesion>|
    And selecciona tipo vivienda y cantidad de hijos y nombre empresa
      |<empresa>|
    And llena fecha de ingreso al trabajo
      |Día|
    And confirma datos de actividad economica
    And acepta mensaje informativo acerca de la direccion de domicilio
    And indica usar mapas mientras la app este en uso
    And llena barrio, calle, numero, manzana y referencia y selecciona zona
      |<barrio>|<calle>|<numeroDomicilio>|<manzana>|<referencia>|
    And confirma datos de direccion de domicilio
    And selecciona ciudad y zona, llena barrio, calle, numero y manzana
      |<barrioLaboral>|<calleLaboral>|<numeroLaboral>|<manzanaLaboral>|
    And confirma datos de direccion laboral
    And confirma vinculacion economica
    And confirma declaracion jurada de bienes
      |<mueblesEnseres>|
    And adjunta documentacion requerida
    And confirma documentacion requerida adjuntada
    And llena ddjj de salud
      |<peso>|<altura>|
    And confirma ddjj de salud
    Then solicitud ingresa correctamente al flujo
      |<usuario>|

    Examples:
      |ID|usuario|tipologia|password|SueldoLiquidoTitular|telefono|montoASolicitar|profesion|empresa|barrio|calle|numeroDomicilio|manzana|referencia|barrioLaboral|calleLaboral|numeroLaboral|manzanaLaboral|mueblesEnseres|peso|altura|
      |1 |802300|C |1234|1500|75330974|9512|Ing. Sistemas|Empresa SA|Barrio ABC|Calle DEF|1124|11|Porton negro con rojo|Barrio del centro|Calle Laboral|1122|12|25000|85|1.75|

  @TEST-T1306 @BVT @SolicitudConsumax
  Scenario Outline: Como cliente quiero poder ingresar a la pantalla de inicio de solicitud
    Then Puedo ver la pantalla de inicio de la solicitud
    And Puedo ingresar la solicitud a traves del boton de Inicio de Solicitud
    Examples:
      |ID|usuario|password|
      |1 |802300|1234|