package com.bg.gnt.integrations.transferencias.ganaMovil;

import com.bg.gnt.util.database.UtilsDB;

public class GanaMovilIntegration {
    UtilsDB UtilsDB = new UtilsDB();

    public int deleteQuery(String query, String schemaDB) {
        int result = 0;
        result = UtilsDB.delete(query, schemaDB);

        return result;
    }
    public int insertQuery(String query,String schemaDB) {
        int result=0;
        result = UtilsDB.insert(query,schemaDB);

        return result;
    }
}
