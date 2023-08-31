package bo.com.bga.certificacion.gananet.questions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ValidacionDescargaArchivo implements Question<Boolean> {
    private final String rutaArchivoDescargado;

    public ValidacionDescargaArchivo(String rutaArchivoDescargado) {
        this.rutaArchivoDescargado = rutaArchivoDescargado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String downloadDirectory = System.getProperty("user.home") + "/Downloads/";
        File downloadedFile = new File(downloadDirectory,rutaArchivoDescargado);
        boolean p=downloadedFile.exists();
        System.out.println(p);
        return downloadedFile.exists();


    }

    public static ValidacionDescargaArchivo exitosamente(String rutaArchivoDescargado) {
        return new ValidacionDescargaArchivo(rutaArchivoDescargado);
    }
}
