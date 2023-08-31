package com.bg.gmv.integrations.cuentas;

import com.bg.gmv.util.Database.UtilsDB;

public class ConsultasIntegration {

    com.bg.gmv.util.Database.UtilsDB UtilsDB = new UtilsDB();
    public int updateQuery(String query,String schemaDB) {
        int result=0;
        result = UtilsDB.update(query,schemaDB);

        return result;
    }
}
