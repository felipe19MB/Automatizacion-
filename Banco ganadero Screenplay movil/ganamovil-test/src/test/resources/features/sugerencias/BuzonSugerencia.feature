Feature: Solicitud de sugerencia por Ganamovil
  Como cliente quiero realizar una sugerencia por la aplicacion de Ganamovil

  Background:
    Given Cliente abre aplicacion
    And Elimina internamente dispositivo de la persona
      |7121984|
    And Inicio sesion
      |7121984|1234|
    And Se enrola al usuario
      |7121984|
    And Inicio sesion
      |7121984|1234|


  @Sugerencia @SmokeTest
  Scenario Outline: Como usuario quiero realizar una sugerencia medianta la aplicacion.
    And Ingreso a la opcion
      | Consultas y Sugerencias |
    And Ingreso a la opcion
      | Buzón de Sugerencias |
    And Selecciono la opcion "<opcion>"
    And lleno la descripcion de la sugerencia que voy a enviar "sugerencia que se enviara testing"
    When realizo un click en el boton enviar
    Then muestra un mensaje de confirmacion que dice Sugerencias y comentarios
    Then realizo click en el boton aceptar buzon de sugerencia
    Examples:
      | opcion                             |
      | Atencion al Cliente/Usuario        |
      ##| Banca por Internet                 |
      ##| Boleta de Garantia                 |
      ##| Buros de Informacion               |
      ##| Caja de ahorro                     |
      ##| Central de Informacion Crediticia  |
      ##| Credito de Vivienda Interes Social |
      ##| Credito Productivo                 |
      ##| Creditos                           |
      ##| Cuenta Corriente                   |
      ##| Depositos a Plazo Fijo             |
      ##| Diferimiento de pago de creditos   |
      ##| Giros y Remesas                    |
