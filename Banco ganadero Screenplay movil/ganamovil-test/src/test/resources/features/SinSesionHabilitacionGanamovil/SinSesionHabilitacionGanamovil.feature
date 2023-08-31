@SinSesionHabilitacionGanamovil
Feature: Sin Sesion Habilitacion Ganamovil
  Como cliente quiero registrar mi dispositivo para ingresar a ganamovil

  Background:
    Given Cliente abre aplicacion

  @TEST-T1261 @SinSesionHabilitacionGanamovil @SmokeTest
  Scenario Outline: Como cliente quiero registrar mi dispositivo para ingresar a ganamovil
    And Ingresa sus datos personales para registar su dispositivo
      |<ci>|<extension>|<diaNacimiento>|<mesNacimiento>|<anoNacimiento>|<celular>|<nroTarjeta>|<mesExpiracion>|<anoExpiracion>|
    And Sistema verifica el dispositivo en poder del cliente
    #And Autentica su identidad
    #Then Se registra el dispositivo para ingresar a ganamovil
    Examples:
      |ID|ci|extension|diaNacimiento|mesNacimiento|anoNacimiento|celular|nroTarjeta|mesExpiracion|anoExpiracion|
      |1   |7676570   |SC|17   |09|1992|60927948|4218280007896406|10|26|
