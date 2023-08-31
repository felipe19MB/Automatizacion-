@SeguroMultiHogar
Feature: Solicitud de Seguro MultiHogar
  Como cliente quiero adquirir un seguro multihogar para estar protegido

  Background:
    Given Cliente abre aplicacion


  @TEST-T1381 @SmokeTest @SeguroMultiHogar
  Scenario Outline: Como cliente quiero solicitar mi seguro multihogar
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Ingreso a la opcion
      |Seguros Masivos|MULTIHOGAR|
    And selecciona su plan multihogar
    And selecciona su cuenta y tipo de pago
      |<numeroCuenta>|
    And llena los datos del tomador del seguro
      |<CorreoPoliza>|<ConfirmarCorreoPoliza>|<TelefonoDomicilio>|<Celular>|
    And llena direccion del domicilio
      |<Departamento>|<Ciudad>|<Barrio>|<Calle>|<Numero>|<ReferenciaLugar>|
    When confirma declaracion jurada y resumen de la informacion para el seguro Multihogar
    Then cliente cuenta con seguro Multihogar



    Examples:
      |ID|usuario|password|numeroCuenta|CorreoPoliza|ConfirmarCorreoPoliza|TelefonoDomicilio|Celular|Departamento|Ciudad|Barrio|Calle|Numero|ReferenciaLugar|
      |1 |802901|1234 |CA 1310084428 Bs|asvaldivia12@gmail.com|asvaldivia12@gmail.com|75330974  |75330974|SANTA CRUZ |SANTA CRUZ|Barrio Test|Calle Test|123|Porton negro de pruebas|
