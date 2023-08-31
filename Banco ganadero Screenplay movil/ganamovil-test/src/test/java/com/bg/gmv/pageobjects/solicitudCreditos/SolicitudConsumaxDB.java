package com.bg.gmv.pageobjects.solicitudCreditos;

import com.bg.gmv.util.Database.UtilsDB;

public class SolicitudConsumaxDB {

    UtilsDB util = new UtilsDB();

    public int updateParametriaDocsPermitir(){
        return util.update("UPDATE GANADERO.CAS_PAR_DOCUMENTACION SET CANTIDAD_MINIMA=2 WHERE IDENTIFICADOR IN (3,17)", "GANADERO");
    }

    public int updateParametriaDocsRestringir(){
        return 0;
    }

    public int updateQuery(String query){
        int result = 0;
        result = util.update(query,"GANADERO");
        return  result;
    }
}
