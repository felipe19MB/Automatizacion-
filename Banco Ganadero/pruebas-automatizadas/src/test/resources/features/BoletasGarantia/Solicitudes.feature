@Solicitudes
Feature: Solicitudes de boletas de garantia

	@Caso001 @Boletas @SolicitudBoleta @SmokeTest @SmokeTestSolicitudBoleta
	Scenario Outline: Como usuario logueado,
	quiero realizar una solicitud de boleta de garantia prepagada
	para autorizar y verificar el comprobante.
	Given Me autentique con un usario habilitado
	|<tipoUsuario>|<usuario>|<password>|
	And El saldo disponible en mi cuenta es positivo
	|<ctaOrigen>|<monto>|
	When Selecciono el menu
	|Boletas de Garant�a|Solicitudes|
	And Realizo la solicitud de boleta de garantia
	|<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|<ganapin>|
	Examples:
	|ID|tipoUsuario|usuario|password|ctaOrigen|ctaDestino|monto|moneda|glosaOrigen|glosaDestino|ganapin|
	|1   |CODIGO_PERSONA   |39073   |1234   |1051229049   |1051959195   |5   |BOLIVIANOS   |TRABAJO HONESTO   |PARA TORTA DE CUMPLE   |1234|
