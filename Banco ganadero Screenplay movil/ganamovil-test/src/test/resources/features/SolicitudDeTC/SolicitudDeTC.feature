@SolicitudTC
Feature: Solicitud de Tarjeta de Credito
  Como cliente quiero ingresar mi solicitud de Tarjeta de Credito para que sea analizada para su aprobacion

  Background:
    Given Cliente abre aplicacion


  @TEST-T1303 @SmokeTest @SolicitudTC
  Scenario Outline: Como cliente quiero ingresar una solicitud de TC
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Ingreso a la opcion
      |Solicitud de Tarjeta de Crédito|
    And Indica iniciar la solicitud
    And Se desactiva antispoofing
      |<usuario>|<tipologia>|
    And Indica iniciar la solicitud porque es asalariado
    And Indica su situacion laboral como asalariado y con AFP
    And Confirma Terminos y Condiciones
    And Llena la calculadora financiera
      |<ingresos>|<gastosFamiliares>|
    And Llena sus datos solicitados
      |<estadoCivil>|<residencia>|Teléfono (Titular)|<agenciaPreferencia>|<sueldoLiquidoTitular>|escribe tu correo electrónico nuevamente|<telefono>|<correoElectronico>|<confirmacionCorreoElectronico>|
    And Llena datos del monto a solicitar
      |<montoASolicitar>|<direccionCorrespondencia>|
    And Llena actividad economica
      |<nivelEducacion>|<profesion>|<cargo>|<nivelIngreso>|<tipovivienda>|<cantidadHijos>|<empresa>|Día|Mes|Año|<dia>|<mes>|<anho>|
    And Llena declaracion jurada de solicitud de TC
      |<mueblesEnseres>|
    And indica usar mapas mientras la app este en uso
    And Ingresa direccion de su domicilio para solicitud de TC
      |<barrio>|<calle>|<zona>|<numeroDomicilio>|<manzana>|<referencia>|
    And Ingresa direccion laboral para solicitud de TC
      |<departamentoLaboral>|<barrioLaboral>|<calleLaboral>|<zona>|<numeroLaboral>|<manzanaLaboral>|
    And Selecciona vinculacion economica para solciitud de TC
    And Llena declaracion jurada de salud para solicitud de TC
      |<peso>|<altura>|
    And Adjunta documentos necesarios y firma para la solicitud TC
    When Confirma los documentos y la firma
    Then Solicitud ingresa correctamente al workflow
      |<usuario>|



    Examples:
      |ID|usuario|password|tipologia|sueldoLiquidoTitular|telefono|correoElectronico|confirmacionCorreoElectronico|montoASolicitar|direccionCorrespondencia|nivelEducacion|profesion|cargo|nivelIngreso|tipovivienda|cantidadHijos|empresa|dia|mes|anho|barrio|calle|zona|numeroDomicilio|manzana|referencia|departamentoLaboral|barrioLaboral|calleLaboral|numeroLaboral|manzanaLaboral|mueblesEnseres|peso|altura|ingresos|gastosFamiliares|estadoCivil|residencia|agenciaPreferencia|
      |1 |802901|1234 |T          |1500|75330974|asvaldivia12@gmail.com|asvaldivia12@gmail.com|9512|Dirección Laboral|PROFESIONAL|Ing. Sistemas|JEFE|$1201 - $2000|VIVIENDA FAMILIAR|0|Empresa SA|2|8|2010|Barrio ABC|Calle DEF|CENTRO|1124|11|Porton negro con rojo|BENI-TRINIDAD|Barrio del centro|Calle Laboral|1122|12|25000|85|1.75|15000|2100|SOLTERO/A|BENI-TRINIDAD|TRINIDAD (BE)|

  @TEST-T1301 @BVT @SolicitudTC
  Scenario Outline: Como cliente quiero ingresar una solicitud pero no soy asalariado
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Ingreso a la opcion
      |Solicitud de Tarjeta de Crédito|
    When Cliente indica que No es Asalariado
    Then mensaje informativo indicando que no puede solicitar el credito
      |<mensaje>|

    Examples:
      |ID|usuario|password|mensaje|
      |1 |802901|1234|Estimado cliente por el momento no contamos con el servicio para “No asalariados”, estamos trabajando para próximamente poder atenderlo, por favor pase por nuestras oficinas.|

  @TEST-T1371 @BVT @SolicitudTC
  Scenario Outline: Como cliente quiero poder desestimar mi solicitud antes de terminar el registro
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Ingreso a la opcion
      |Solicitud de Tarjeta de Crédito|
    And Indica iniciar la solicitud
    And Se desactiva antispoofing
      |<usuario>|<tipologia>|
    And Indica iniciar la solicitud porque es asalariado
    And Indica su situacion laboral como asalariado y con AFP
    And Confirma Terminos y Condiciones
    And Llena la calculadora financiera
      |<ingresos>|<gastosFamiliares>|
    And Llena sus datos solicitados
      |<estadoCivil>|<residencia>|Teléfono (Titular)|<agenciaPreferencia>|<sueldoLiquidoTitular>|escribe tu correo electrónico nuevamente|<telefono>|<correoElectronico>|<confirmacionCorreoElectronico>|
    And Selecciona cancelar solicitud tc y vuelve a la pantalla principal de la solicitud
    When Selecciona Cancelar Solicitud y confirma que esta seguro de cancelarla
    Then Visualiza que la solicitud se desestimo correctamente
      |<MensajeDesestimado>|

    Examples:
      |ID|usuario|password|tipologia|sueldoLiquidoTitular|telefono|MensajeDesestimado|ingresos|gastosFamiliares|estadoCivil|residencia|agenciaPreferencia|correoElectronico|confirmacionCorreoElectronico|
      |1 |802901|1234|T|1500|75330974|Estimado Cliente, se desestimo la solicitud.|15000|2100|SOLTERO/A|BENI-TRINIDAD|TRINIDAD (BE)|asvaldivia12@gmail.com|asvaldivia12@gmail.com|

  @TEST-T1372 @BVT @SolicitudTC
  Scenario Outline: Como cliente quiero poder ingresar a la pantalla de inicio de solicitud
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Ingreso a la opcion
      |Solicitud de Tarjeta de Crédito|
    Then Puedo ver la pantalla de inicio de la solicitud de TC
    And Puedo ingresar la solicitud a traves del boton de Inicio de Solicitud TC
    Examples:
      |ID|usuario|password|
      |1 |802901|1234|
