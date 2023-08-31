package com.bg.gmv.integrations.transferencia;

import com.bg.gmv.util.Database.UtilsDB;

public class TransferenciaIntegration {

    UtilsDB UtilsDB = new UtilsDB();
    public int updateQuery(String query,String schemaDB) {
        int result=0;
        result = UtilsDB.update(query,schemaDB);

        return result;
    }
}
