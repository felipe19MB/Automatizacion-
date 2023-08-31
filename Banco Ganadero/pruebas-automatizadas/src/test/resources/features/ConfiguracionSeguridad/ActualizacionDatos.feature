@ConfiguracionSeguridad
Feature: Actualizacion de datos del cliente

  @TEST-T1387 @ConfiguracionSeguridad @ActualizacionDatos @SmokeTest @SmokeTestActualizacionDatos
  Scenario Outline: Como usuario y cliente del bga quiero actualizar mis datos personales para que reflejen mi informacion actualizada

    Given Me autentique con un usuario habilitado
      |<tipoUsuario>|<usuario>|<password>|
    When Selecciono el menu
      |Configuración y Seguridad|Actualización de datos|
    And Ingresa datos personales
      |<uv>|<manzana>|<barrio>|<calle>|<nroPuerta>|<piso>|<apartamento>|<email>|<telefonoCelular>|
    And Selecciona direccion preferida de correspondencia
      |<direccionPreferida>|
    And Ingresa datos de referencias personales
      |<primeraReferenciaNombres>|<primeraReferenciaTelefono>|<primeraReferenciaRelacion>|<segundaReferenciaNombres>|<segundaReferenciaTelefono>|<segundaReferenciaRelacion>|
    When Verifica y confirma el resumen de los datos actualizados
      |<uv>|<manzana>|<barrio>|<calle>|<nroPuerta>|<piso>|<apartamento>|<email>|<telefonoCelular>|<direccionPreferida>|<primeraReferenciaNombres>|<primeraReferenciaTelefono>|<primeraReferenciaRelacion>|<segundaReferenciaNombres>|<segundaReferenciaTelefono>|<segundaReferenciaRelacion>|<ganapin>|
    Then Sus datos se actualizan correctamente
      |<mensajeExito>|
      
    Examples: 
      |ID|tipoUsuario|usuario|password|ganapin|uv|manzana|barrio|calle|nroPuerta|piso|apartamento|email|telefonoCelular|direccionPreferida|primeraReferenciaNombres|primeraReferenciaTelefono|primeraReferenciaRelacion|segundaReferenciaNombres|segundaReferenciaTelefono|segundaReferenciaRelacion|mensajeExito|
      |1   |CODIGO_PERSONA   |521   |1234   |1234|12|12  |DE PRUEBAS|DE TEST|4512|2  |13|ASVALDIVIA12@GMAIL.COM|75330974|Domicilio|ALVARO VALDIVIA|75330974|COLEGA|SALVADOR VALDIVIA|71667598|FAMILIAR|Estimado cliente: Sus datos fueron actualizados|
