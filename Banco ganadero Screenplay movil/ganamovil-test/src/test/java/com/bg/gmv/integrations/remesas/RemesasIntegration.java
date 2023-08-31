package com.bg.gmv.integrations.remesas;

import com.bg.gmv.util.Database.UtilsDB;

public class RemesasIntegration {

    UtilsDB UtilsDB = new UtilsDB();
    public int updateQuery(String query,String schemaDB) {
        int result=0;
        result = UtilsDB.update(query,schemaDB);
        return result;
    }
}
