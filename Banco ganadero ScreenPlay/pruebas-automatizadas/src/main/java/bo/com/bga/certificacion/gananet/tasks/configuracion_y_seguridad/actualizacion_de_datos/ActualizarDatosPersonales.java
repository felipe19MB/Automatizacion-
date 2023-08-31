package bo.com.bga.certificacion.gananet.tasks.configuracion_y_seguridad.actualizacion_de_datos;

import bo.com.bga.certificacion.gananet.interactions.shared.Espera;
import bo.com.bga.certificacion.gananet.interactions.shared.IngresaGanaPin;
import bo.com.bga.certificacion.gananet.interactions.shared.LimpiaCampos;
import bo.com.bga.certificacion.gananet.models.configuracion_y_seguridad.ActualizacionDeDatosModel;
import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;

import static bo.com.bga.certificacion.gananet.userinterfaces.configuracion_y_seguridad.ActualizacionDeDatosPage.*;
import static bo.com.bga.certificacion.gananet.utils.ConstantesBD.*;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText;

public class ActualizarDatosPersonales implements Task {
    ActualizacionDeDatosModel actualizacionDeDatosModel;
    String scenario;

    public ActualizarDatosPersonales(ActualizacionDeDatosModel actualizacionDeDatosModel, String scenario) {
        this.actualizacionDeDatosModel = actualizacionDeDatosModel;
        this.scenario = scenario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenario) {
            case ("HappyPath"):
                actor.attemptsTo(
                        byVisibleText(actualizacionDeDatosModel.getDepartamento()).from(LABEL_DEPARTAMENTO),
                        byVisibleText(actualizacionDeDatosModel.getCiudad()).from(LABEL_CIUDAD),
                        byVisibleText(actualizacionDeDatosModel.getZona()).from(LABEL_ZONA),
                        Enter.theValue(actualizacionDeDatosModel.getUv()).into(LABEL_UV),
                        Enter.theValue(actualizacionDeDatosModel.getMza()).into(LABEL_MZA),
                        Enter.theValue(actualizacionDeDatosModel.getBarrio()).into(LABEL_BARRIO),
                        Enter.theValue(actualizacionDeDatosModel.getCalle()).into(LABEL_CALLE),
                        Scroll.to(LABEL_NRO_PUERTA),
                        Enter.theValue(actualizacionDeDatosModel.getNroPuerta()).into(LABEL_NRO_PUERTA),
                        Enter.theValue(actualizacionDeDatosModel.getPiso()).into(LABEL_PISO),
                        Enter.theValue(actualizacionDeDatosModel.getApartamento()).into(LABEL_APARTAMENTO),
                        LimpiaCampos.paraEscribir(LABEL_EMAIL),
                        Enter.theValue(actualizacionDeDatosModel.getEmail()).into(LABEL_EMAIL),
                        Enter.theValue(actualizacionDeDatosModel.getTelefono()).into(LABEL_TELEFONO),
                        Enter.theValue(actualizacionDeDatosModel.getCelular()).into(LABEL_CELULAR),
                        JavaScriptClick.on(BOTON_CONTINUAR),
                        byVisibleText(actualizacionDeDatosModel.getDomicilio()).from(LABEL_DOMICILIO),
                        JavaScriptClick.on(BOTON_CONTINUAR),
                        Enter.theValue(actualizacionDeDatosModel.getNombreRef1()).into(LABEL_REFERENCIA_1),
                        Enter.theValue(actualizacionDeDatosModel.getNombreRef2()).into(LABEL_REFERENCIA_2),
                        Enter.theValue(actualizacionDeDatosModel.getTelefonoRef1()).into(LABEL_TELEFONO_REFERENCIA_1),
                        Enter.theValue(actualizacionDeDatosModel.getTelefonoRef2()).into(LABEL_TELEFONO_REFERENCIA_2),
                        byVisibleText(actualizacionDeDatosModel.getRelacionRef1()).from(LABEL_RELACION_1),
                        byVisibleText(actualizacionDeDatosModel.getRelacionRef2()).from(LABEL_RELACION_2),
                        JavaScriptClick.on(BOTON_CONTINUAR),
                        JavaScriptClick.on(BOTON_CONFIRMAR),
                        IngresaGanaPin.paraConfirmarProceso(),
                        Espera.aTime(2000)
                );
                String mensaje = actor.asksFor(Text.of(MENSAJE_CAMBIO_DE_DATOS));
                actor.remember("mensajeActualizacion",mensaje);
                actor.attemptsTo(
                        EjecutaBaseDeDatos.QueryPersonalizado(QUERY_DATOS_PERSONALES,"resultadoDatosPersonales","GANADERO").Comentario("Se ejecuta el query para obtener la consulta de los datos personales"),
                        EjecutaBaseDeDatos.QueryPersonalizado(QUERY_DATOS_PREFERIDOS1,"resultadoDatosReferidos1","GANADERO").Comentario("Se ejecuta el query para obtener la consulta del referido 1"),
                        EjecutaBaseDeDatos.QueryPersonalizado(QUERY_DATOS_PREFERIDOS2,"resultadoDatosReferidos2","GANADERO").Comentario("Se ejecuta el query para obtener la consulta del referido 2"),
                        JavaScriptClick.on(BOTON_OK)
                );

                break;
        }

    }
    public static ActualizarDatosPersonales go(ActualizacionDeDatosModel actualizacionDeDatosModel, String scenario){
        return Tasks.instrumented(ActualizarDatosPersonales.class,actualizacionDeDatosModel,scenario);

    }

}
