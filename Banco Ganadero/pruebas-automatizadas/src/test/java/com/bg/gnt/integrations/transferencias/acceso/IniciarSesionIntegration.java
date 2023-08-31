package com.bg.gnt.integrations.transferencias.acceso;

import com.bg.gnt.util.database.UtilsDB;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class IniciarSesionIntegration {
    UtilsDB UtilsDB = new UtilsDB();



    public String getField(String query) {
        String result="";
        result = UtilsDB.getField(query);

        if(result=="") {result="0";}

        return result;
    }


    public int updateQuery(String query,String schemaDB) {
        int result=0;
        result = UtilsDB.update(query,schemaDB);

        return result;
    }
}
