package bo.com.bga.certificacion.gananet.interactions.shared;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ActualizarFecha implements Interaction {

    private final String nombreArchivo;
    private final String nombreHoja;

    public ActualizarFecha(String nombreArchivo, String nombreHoja) {
        this.nombreArchivo = nombreArchivo;
        this.nombreHoja = nombreHoja;
    }

    public static ActualizarFecha enExcel(String nombreArchivo, String nombreHoja) {
        return new ActualizarFecha(nombreArchivo, nombreHoja);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActualFormateada = fechaActual.format(formatter);
        int numeroColumna = 6;

        try (XSSFWorkbook libro = new XSSFWorkbook(new FileInputStream(new File(nombreArchivo)))) {
            Sheet hoja = libro.getSheet(nombreHoja);

            CellStyle estiloCelda = libro.createCellStyle();
            estiloCelda.setDataFormat(libro.getCreationHelper().createDataFormat().getFormat("d/MM/yyyy"));

            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                Row fila = hoja.getRow(i);
                if (fila == null) {
                    fila = hoja.createRow(i);
                }
                Cell celda = fila.getCell(numeroColumna, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                celda.setCellStyle(estiloCelda);
                celda.setCellValue(fechaActualFormateada);
            }
            try (FileOutputStream salida = new FileOutputStream(new File(nombreArchivo))) {
                libro.write(salida);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}