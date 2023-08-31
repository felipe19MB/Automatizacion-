package com.bg.gmv.integrations.transferencia.afiliacion;

import com.bg.gmv.util.Database.UtilsDB;

public class AfiliacionIntegration {
    UtilsDB UtilsDB = new UtilsDB();

    public int deleteQuery(String query,String schemaDB) {
        int result=0;
        result = UtilsDB.update(query,schemaDB);

        return result;
    }


}
