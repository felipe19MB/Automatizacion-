@IniciarSesion
Feature: Iniciar sesion
  Quiero iniciar sesion en Ganamovil usando mi usuario y contraseña

  @SmokeTest @Acceso @TEST-T1298
  Scenario Outline: Como usuario quiero iniciar sesion en Ganamovil para poder ver si tengo acceso.
    Given Cliente abre aplicacion
    And Elimina internamente dispositivo de la persona
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    And Se enrola al usuario
      |<usuario>|
    And Inicio sesion
      |<usuario>|<password>|
    Then Deberia mostrarse el nombre del usuario
    |<nombreUsuario>|
    And Cierro sesion
    |¿Deseas cerrar sesión?|
    Examples: 
    |ID|usuario|password|nombreUsuario|
    ##@externaldata@./src/test/resources/data/Acceso/DatosUsuarios.xlsx@Habilitados@1
   |1   |15919   |1234   |VELIZ URZAGASTE MARIA ELIZABETH|


  Scenario Outline: Como usuario quiero iniciar sesion para poder enviar solicitud de habilitacion.
    Given Cliente abre aplicacion
    And Ingreso mi usuario
      |<usuario>|
    And Ingreso mi password
      |<password>|
    And Envio solicitud de habilitacion

    Examples:
      |ID|usuario|password|nombreUsuario|
    ##@externaldata@./src/test/resources/data/Acceso/DatosUsuarios.xlsx@Habilitados@1
   |1   |15919   |1234   |VELIZ URZAGASTE MARIA ELIZABETH|



