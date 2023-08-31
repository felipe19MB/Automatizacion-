@Test001
Feature: Ingresar a Gananet
  Quiero verificar si puedo ingresar correctamente a Gananet

  @Caso001
  Scenario Outline: Iniciar sesion en Gananet
    Given Ingreso a la pagina principal
    And Ingreso mi usuario

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

      	
  @AAUS02	
  Scenario Outline: Como usuario nuevo, quiero iniciar sesion para poder saber si me pide cambio de imagen y contrato.
    Given Me autentique con un usuario habilitado 
    |<tipoUsuario>|<usuario>|<password>|
		When Acepto el contrato
		And Selecciono la imagen de seguridad
		Then Se muestra un mensaje de actualizacion de datos
		And Se muestra un mensaje de personalizacion de usuario
		And El sistema debe mostrarme mis datos
		|<nombre>|
		And Finalizo la sesion
		
    Examples: 
    |ID|tipoUsuario|usuario|password|nombre|nombrePerfil|
    ##@externaldata@./src/test/resources/data/acceso/DatosUsuarios.xlsx@Nuevos@1
   |1   |CODIGO_PERSONA   |80868   |1234   |PERSONA   |Persona Juridica|

   
   
	@AAUS03
	Scenario Outline: Como usuario migrado con clave vencida, quiero iniciar sesion para poder saber si me pide cambio de clave.
    Given Me autentique con un usuario habilitado 
    |<tipoUsuario>|<usuario>|<password>|
		When Acepto el contrato
		And Ingreso mi clave actual y la nueva
		|<passActual>|<passNueva>|
		And Verifico si se muestra el mensaje correcto
		|<msjCambioClave>|
		And Selecciono la imagen de seguridad
		Then Se muestra un mensaje de actualizacion de datos
		And Se muestra un mensaje de personalizacion de usuario
		And El sistema debe mostrarme mis datos
		|<nombre>|
		And Finalizo la sesion
   
    Examples: 
    |ID|tipoUsuario|usuario|password|nombre|nombrePerfil|passActual|passNueva|msjCambioClave|
    ##@externaldata@./src/test/resources/data/acceso/DatosUsuarios.xlsx@CambioClave@1
   |1   |CODIGO_PERSONA   |53370   |1234   |F   |Persona Natural   |1234   |4321   |La contraseña se cambio exitosamente|

	@AAUS04
	Scenario Outline: Como usuario existente y habilitado con 3 deudas pendientes de ganapin, quiero iniciar sesion para poder saber si no me permite ingresar.
    Given Me autentique con un usuario habilitado 
    |<tipoUsuario>|<usuario>|<password>|
		Then Se muestra un mensaje de alerta
		|<mensaje>|

   
    Examples: 
    |ID|tipoUsuario|usuario|password|mensaje|
    ##@externaldata@./src/test/resources/data/acceso/DatosUsuarios.xlsx@CuotasPendientesPago@1
   |1   |CODIGO_PERSONA   |443476   |1234   |Estimado cliente: Su acceso ha sido bloqueado debido a que tiene coutas pendientes de pago. por concepto de Mantenimiento de su dispositivo Ganapin|

   
	@AAUS05
	Scenario Outline: Como usuario existente y habilitado y con segundo factor, quiero iniciar sesion ingresando el password incorrecto 3 veces para saber si me pide ganapin.
    Given Ingrese un usuario valido
    |<tipoUsuario>|<usuario>|
    When Ingreso el password
    |<password>|
    And Verifico si se muestra el mensaje correcto
    |<mensaje>|
    And Ingreso el password
    |<password>|
    And Verifico si se muestra el mensaje correcto
    |<mensaje>|
		And Ingreso el password
    |<password>|
		And Ingreso ganapin
		|<ganapin>|
		Then El sistema debe mostrarme mis datos
		|<nombre>|
		And Finalizo la sesion

   
    Examples: 
    |ID|tipoUsuario|usuario|password|ganapin|mensaje|
    ##@externaldata@./src/test/resources/data/acceso/DatosUsuarios.xlsx@Bloqueo3Intentos@1