package bo.com.bga.certificacion.gananet.userinterfaces.administracion;

import net.serenitybdd.screenplay.targets.Target;

public class ListadoPerfilesPage {

    public static final Target BOTON_AGREGAR_PERFIL = Target.the("Boton Agregar nuevo perfil")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-perfil-listado[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/control-box[1]/div[1]/div[1]/button[1]");
    public static final Target TXT_NOMBRE_PERFIL = Target.the("Ingreso Nombre del perfil")
            .locatedBy("//body/app-root[1]/app-paginas[1]/div[1]/div[1]/app-perfil-crear[1]/control-contenedor-paginas[1]/section[1]/div[1]/div[1]/control-wizard-step[1]/control-wizard-container[1]/control-box[1]/div[1]/div[2]/perfil-crear-paso1[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/control-input-text[1]/div[1]/input[1]");

    public static final Target SELECT_PERFIL_BASE = Target.the("Selecciono Perfil base")
            .locatedBy("//label[contains(text(),'Perfil base ')]/following-sibling::select");

    public static final Target BOTON_SIGUIENTE = Target.the("Boton Siguiente")
            .locatedBy("//button[contains(text(),'Siguiente')]");

    public static final Target SELECT_SELECCIONAR_TODOS = Target.the("Selecciono Todos")
            .locatedBy("//label[contains(text(),'Seleccionar Todos')]");

    public static final Target SELECT_PUEDE_VER_SALDOS = Target.the("Selecciono Puede ver saldos")
            .locatedBy("//label[contains(text(),'Puede ver saldos')]");

    public static final Target SELECT_PUEDE_VER_PLANILLAS = Target.the("Selecciono Puede ver planillas")
            .locatedBy("//label[contains(text(),'Puede ver planillas')]");

    public static final Target BOTON_CONFIRMAR = Target.the("Boton Confirmar")
            .locatedBy("//button[contains(text(),'Confirmar')]");

    public static final Target BOTON_ELIMINAR = Target.the("Boton Eliminar")
            .locatedBy("//h4[contains(text(),'PRUEBAS PERFIL')]/parent::div/following-sibling::div[2]//a[@title='Eliminar']/i");




}
