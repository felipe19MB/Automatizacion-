package com.bg.gnt.util.database;

import java.sql.ResultSet;

public class UtilsDB {

	ConnectionDB ConnectionDB = new ConnectionDB();
	
	
	
	public int insert(String query, String schemaDB) {
		ResultSet	resultSet	=	null;

		int result	=	0;
		ConnectionDB.setParameters(schemaDB);
		ConnectionDB.setConnection();
		ConnectionDB.setStatement();
		ConnectionDB.setResultUpdate(query);
		result	=	ConnectionDB.getResultUpdate();


		return	result;
	}
	
	public int update(String query,String schemaDB) {
		ResultSet	resultSet	=	null;
		
		int result	=	0;
			ConnectionDB.setParameters(schemaDB);
			ConnectionDB.setConnection();
			ConnectionDB.setStatement();
			ConnectionDB.setResultUpdate(query);
			result	=	ConnectionDB.getResultUpdate();

			
		return	result;
	}
	
	public ResultSet select(String query) {
		ResultSet result	=null;
			ConnectionDB.setConnection();
			ConnectionDB.setStatement();
			ConnectionDB.setResultSet(query);
			result = ConnectionDB.getResultSet();
		return result;
	}
	
	public String getField(String query) {
		String	result	=	"";
			ConnectionDB.setConnection();
			ConnectionDB.setStatement();
			ConnectionDB.setResultField(query);
			result	=	ConnectionDB.getResultField();
		return	result;
	}
	
	public int delete(String query,String schemaDB) {
		ResultSet	resultSet	=	null;

		int result	=	0;
		ConnectionDB.setParameters(schemaDB);
		ConnectionDB.setConnection();
		ConnectionDB.setStatement();
		ConnectionDB.setResultUpdate(query);
		result	=	ConnectionDB.getResultUpdate();
		return	result;
		
	}
	
}
