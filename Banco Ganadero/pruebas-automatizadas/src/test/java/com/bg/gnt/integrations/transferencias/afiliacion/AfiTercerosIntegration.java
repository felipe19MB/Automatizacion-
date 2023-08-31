package com.bg.gnt.integrations.transferencias.afiliacion;

import com.bg.gnt.util.database.UtilsDB;

public class AfiTercerosIntegration {
    com.bg.gnt.util.database.UtilsDB UtilsDB = new UtilsDB();



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
