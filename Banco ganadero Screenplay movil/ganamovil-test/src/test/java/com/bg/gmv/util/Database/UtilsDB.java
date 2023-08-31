package com.bg.gmv.util.Database;

import java.sql.ResultSet;

public class UtilsDB {
    ConnectionDB ConnectionDB = new ConnectionDB();

    public void insert(String query) {

    }

    public int update(String query,String schemaDB) {
        ResultSet resultSet	=	null;
        int result	=	0;
        ConnectionDB.setParameters(schemaDB);
        ConnectionDB.setConnection();
        ConnectionDB.setStatement();
        ConnectionDB.setResultUpdate(query);
        result	=	ConnectionDB.getResultUpdate();

        return	result;
    }

    public void select(String query) {

    }

    public String getField(String query) {
        String	result	=	"";
        ConnectionDB.setConnection();
        ConnectionDB.setStatement();
        ConnectionDB.setResultField(query);
        result	=	ConnectionDB.getResultField();
        return	result;
    }

    public void delete(String query) {


    }

}
