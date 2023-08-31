@Solicitudes
Feature: Solicitudes de boletas de garantia

	@Caso001
	Scenario Outline: Como usuario logueado,
	quiero realizar una solicitud de boleta de garantia prepagada
	para autorizar y verificar el comprobante.
	Given Me autentique con un usario habilitado
	|<tipoUsuario>|<usuario>|<password>|
	And El saldo disponible en mi cuenta es positivo
	|<ctaOrigen>|<monto>|
	When Selecciono el menu
	|Boletas de Garantía|Solicitudes|
	And Realizo la solicitud de boleta de garantia
	|<ctaOrigen>|<ctaDestino>|<monto>|<moneda>|<glosaOrigen>|<glosaDestino>|<ganapin>|