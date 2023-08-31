@Bloqueo
Feature: Bloqueo y desbloqueo de tarjetas de crédito
	
	#Tiempo de creacion: 30 
  @Caso001 @TarjetasCredito @BloqueoTC @SmokeTest @SmokeBloqueoTC
  	Scenario Outline: Como usario logueado, Quiero realizar el bloqueo de mi tarjeta de credito para que no se pueda utilizar la tarjeta de credito.
  		
	    Given Me autentique con un usuario habilitado
	    |<tipoUsuario>|<usuario>|<password>|
	    When Selecciono el menu
	    |Tarjetas de Crédito|Bloqueo/Desbloqueo|
	    And Ingreso los datos para el bloqueo
	    |<nroTarjeta>|<nroPlastico>|<tipoBloqueo>|
	    And Finalizo el bloqueo <ganapin>
			Then Verifico si el bloqueo fue exitoso
			|<nroTarjeta>|<mensaje>|
			
			#Tiempo de recoleccion de datos:
			Examples:
			|ID|tipoUsuario|usuario|password|nroTarjeta|nroPlastico|tipoBloqueo|ganapin|mensaje|
			##@externaldata@./src/test/resources/data/DatosTarjetasCredito.xlsx@BloqueoNaturales
   |1   |CODIGO_PERSONA   |115254   |1234   |4421-19XX-XXXX-4012   |4421-91XX-XXXX-4012   |2   |1234   |Bloqueada|
   |2   |CODIGO_PERSONA   |38133   |1234   |4099-91XX-XXXX-8071   |4099-12XX-XXXX-8071   |2   |1234   |Bloqueada|
   |3   |CODIGO_PERSONA   |19483   |1234   |4263-36XX-XXXX-7065   |4263-69XX-XXXX-7065   |2   |1234   |Bloqueada|



  @Caso002
  	Scenario Outline: Como usario logueado, Quiero realizar el desbloqueo de mi tarjeta de credito para utilizar la tarjeta de credito.
  		
	    Given Me autentique con un usuario habilitado
	    |<tipoUsuario>|<usuario>|<password>|
	    When Selecciono el menu
	    |Tarjetas de Crédito|Bloqueo/Desbloqueo|
	    And Ingreso los datos para el bloqueo
	    |<nroTarjeta>|<nroPlastico>|<tipoBloqueo>|
	    And Finalizo el bloqueo <ganapin>
			Then Verifico si el bloqueo fue exitoso
			|<nroTarjeta>|<mensaje>|
			
			#Tiempo de recoleccion de datos:
			Examples:
			|ID|tipoUsuario|usuario|password|nroTarjeta|nroPlastico|tipoBloqueo|ganapin|mensaje|
			##@externaldata@./src/test/resources/data/DatosTarjetasCredito.xlsx@DesbloqueoNaturales
   |2   |CODIGO_PERSONA   |115254   |1234   |4421-19XX-XXXX-4012   |4421-91XX-XXXX-4012   |0   |1234   |habilitada|
   |4   |CODIGO_PERSONA   |38133   |1234   |4099-91XX-XXXX-8071   |4099-12XX-XXXX-8071   |0   |1234   |habilitada|
   |3   |CODIGO_PERSONA   |19483   |1234   |4263-36XX-XXXX-7065   |4263-69XX-XXXX-7065   |0   |1234   |habilitada|
	
			
			
			
			
			
			
