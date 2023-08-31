package bo.com.bga.certificacion.gananet.stepdefinitions.pago_planillas;

import bo.com.bga.certificacion.gananet.tasks.shared.EjecutaBaseDeDatos;
import bo.com.bga.certificacion.gananet.utils.GeneralConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExamplesDatabaseCall {
    @Given("actualizar registros")
    public void Actualizar() {
            Map<String, Object> valores = new HashMap<>();
            valores.put("ID_DISPOSITIVO", "324342");
            valores.put("USUARIO_CREACION", "TEST");
            Map<String, Object> condiciones = new HashMap<>();
            condiciones.put("IDENTIFICADOR", 7);
            condiciones.put("NRO_PERSONA", 38133);
            OnStage.theActorInTheSpotlight().attemptsTo(
                    EjecutaBaseDeDatos.Actualizar("AUTOSRV.AUT_HIST_BLOQUEO",condiciones,valores,"GANADERO")
            );
        }
    @Given("eliminar registros")
    public void Eliminar() {
        Map<String, Object> condiciones = new HashMap<>();
        condiciones.put("IDENTIFICADOR", 7);
        condiciones.put("NRO_PERSONA", 38133);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.Eliminar("AUTOSRV.AUT_HIST_BLOQUEO",condiciones,"GANADERO")
            );
        }
    @Given("obtener registros por varias condiciones")
    public void ObtenerXId() {
        Map<String, Object> condiciones = new HashMap<>();
        condiciones.put("IDENTIFICADOR", 7);
        condiciones.put("NRO_PERSONA", 38133);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.ObtenerPorId("AUTOSRV.AUT_HIST_BLOQUEO",condiciones,"GANADERO")
        );
     }
    @Given("obtener TODOS los registros de una tabla")
    public void ObtenerTodos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.ObtenerTodos("GANANET.GNT_PERFILES","GANADERO")
        );
    }
    @Given("agregar registros a una tabla")
    public void agregarRegistros() {
        Map<String, Object> valores = new HashMap<>();
        valores.put("IDENTIFICADOR", 1);
        valores.put("NRO_PERSONA", 34564);
        valores.put("ID_DISPOSITIVO", "0000084224");
        valores.put("FECHA_CREACION", "2020-11-26");
        valores.put("USUARIO_CREACION", "TEST DATABASE");
        valores.put("TZ_LOCK", 1234);
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.Agregar("AUTOSRV.AUT_HIST_BLOQUEO",valores,"GANADERO")
        );
    }
    @Given("ejecutar query personalizado")
    public void querypersonalizado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado("update AUTOSRV.AUT_HIST_BLOQUEO set USUARIO_CREACION = 'TEST2' where IDENTIFICADOR=7","resultadosObtenidos","GANADERO")
        );
    }
    @Given("ejecutar query personalizado procedimiento almacenado")
    public void querypersonalizadoProcedimientoAlmacenado() {
        // En el siguiente código definiremos el llamado al procedimiento almacenado que se encuentra a continuación
        String procedimientoBase1 =
                "VARIABLE l_pcursor REFCURSOR;\n" +
                "DECLARE\n" +
                "    l_pintcodmoneda NUMBER := 2225;\n" +
                "BEGIN\n" +
                "    SPR_GNT_OBTENER_MONEDA (l_pintcodmoneda, :l_pcursor);\n" +
                "END;";
        // Debido a que como vemos, el procedimiento tiene valores de entrada los definimos:
        List<Object> datosEntrada = new ArrayList<>();
        datosEntrada.add(2225);
        //Asi mismo definiremos el TIPO de datos de salida que devolverá el procedimiento almacenado
        List<Object> datosSalida = new ArrayList<>();
        datosSalida.add(GeneralConstants.REFCURSOR);
        // Todos los querys deben tener el siguiente formato en donde los ? son los valores TOTALES de entrada o de salida
        String query = "{ CALL SPR_GNT_OBTENER_MONEDA(?, ?) }";
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.ConProcedimientosAlmacenados(query,datosEntrada,datosSalida,"resultadoPA","GANANET")
        );
        // En este caso dado que el procedimiento almacenado devuelve varios campos lo imprimos de esta manera:
        List<Map<String, Object>> recall = (OnStage.theActorInTheSpotlight().recall("resultadoPA"));
        System.out.println(recall);
        System.out.println(recall.get(0).get("PORCENTAJE_TOLERANCIA"));
        // Ejemplo 2: Procedimiento almacenado con solo un campo de salida
        String procedimientoBase2 =
                "VARIABLE l_p_nombre VARCHAR2;\n" +
                "DECLARE\n" +
                "    l_p_numero NUMBER := 2225;   \n" +
                "BEGIN\n" +
                "    SP_NOMBRE_MONEDA (l_p_numero, :l_p_nombre); -- Asegúrate de que SP_NOMBRE_MONEDA tiene un parámetro OUT\n" +
                "END;";
        List<Object> datosEntrada2 = new ArrayList<>();
        datosEntrada2.add(2225);
        List<Object> datosSalida2 = new ArrayList<>();
        datosSalida2.add(GeneralConstants.VARCHAR); // Agrega un valor vacio de tipo string para definir que la respuesta del procedimiento será un string.
        String query2 = "{ CALL SP_NOMBRE_MONEDA(?, ?) }";
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.ConProcedimientosAlmacenados(query2,datosEntrada2,datosSalida2,"resultadoPA","GANANET")
        );
        List<Map<String, Object>> recall2 = (OnStage.theActorInTheSpotlight().recall("resultadoPA"));
        System.out.println(recall2);
        System.out.println(recall2.get(0).get("parametro1"));
    }

    @Given("ejecutar query personalizado funcion")
    public void querypersonalizadoFuncion() {
        //Importante que el query para el llamado a las funciones y demás, no termienen con punto y coma -> ;
        OnStage.theActorInTheSpotlight().attemptsTo(
                EjecutaBaseDeDatos.QueryPersonalizado("SELECT RETORNAR_NOMBRE ('Prueba.txt', '') FROM DUAL","FUNCIONTEST","GANANET")
        );
        System.out.println(OnStage.theActorInTheSpotlight().recall("FUNCIONTEST").toString());
    }
    @When("genera reporte de libro IVA")
    public void generaReporteDeLibroIVA() {
    }
}

