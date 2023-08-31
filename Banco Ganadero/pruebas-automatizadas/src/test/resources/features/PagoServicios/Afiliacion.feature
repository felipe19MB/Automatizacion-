@AfiliacionServicios
Feature: Afiliacion de Servicios

  @Caso001 @Servicios @AfiServicio @SmokeTest @SmokeTestAfiServicio
  Scenario Outline: Como usuario logueado, Quiero realizar la afiliacion de un servicio.

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Pago de Servicios|Afiliación|
    And Selecciono un servicio a afiliar
      |<tipo>|<subTipo>|<ciudad>|<servicio>|
    And Lleno los datos de busqueda
      |<servicio>|<criterioBusqueda>|<criterioBusqueda1>|<criterioBusqueda2>|<referencia>|
    And Finalizo la afiliacion ingresando GanaPin <ganapin>
    Then Verifico si la afiliacion fue exitoso
      |<mensaje>|<usuario>|

			#Tiempo de recoleccion de datos:
    Examples:
      |ID|tipoUsuario|usuario|password|tipo|subTipo|ciudad|servicio|criterioBusqueda|criterioBusqueda1|criterioBusqueda2|referencia|ganapin|mensaje|
      |1   |CODIGO_PERSONA   |9951821   |1234   |SERVICIOS BASICOS|ELECTRICIDAD   |LA PAZ   |DELAPAZ   |identificador del consumidor|268577|5|MI CASA|1234 |El registro de la afiliación fue exitosa|