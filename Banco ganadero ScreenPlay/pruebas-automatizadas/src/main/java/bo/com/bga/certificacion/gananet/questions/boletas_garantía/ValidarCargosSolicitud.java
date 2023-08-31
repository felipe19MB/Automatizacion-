package bo.com.bga.certificacion.gananet.questions.boletas_garantía;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarCargosSolicitud implements Question<Boolean> {

    private String monto;
    private String comision;

    public ValidarCargosSolicitud(String monto, String comision){
        this.monto=monto;
        this.comision=comision;
    }

    @Override
    public Boolean answeredBy(Actor actor){
       return monto.contains(comision);
    }
    public static ValidarCargosSolicitud sonConrrectos(String monto, String comision){return new ValidarCargosSolicitud(monto, comision);}
}