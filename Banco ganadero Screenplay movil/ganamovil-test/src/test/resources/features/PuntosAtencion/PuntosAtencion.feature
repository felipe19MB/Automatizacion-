@PuntosAtencion
Feature: Puntos de Atencion
  Como cliente quiero conocer los Puntos de Atencion donde me tengo que apersonar

  Background:
    Given Cliente abre aplicacion
    And Ingreso a la opcion puntos de atencion

  ##ubicación debe estar mockeado en -17.7837, -63.1821

  @TEST-T1141 @BVT @PuntosAtencion
  Scenario: Como cliente quiero ingresar a la opcion Puntos de Atencion
    Then Cliente puede visualizar el mapa con las opciones disponibles

  @TEST-T1142  @PuntosAtencion
  Scenario: Como cliente quiero poder localizar varias agencias
    And Cliente selecciona la opcion Agencias
    Then Cliente puede filtrar agencias mas cercanas disponibles

  @TEST-T1143  @PuntosAtencion
  Scenario: Como cliente quiero poder localizar varios puntos de autoservicio
    And Cliente selecciona la opcion Autoservicio
    Then Cliente puede filtrar puntos autoservicio disponibles