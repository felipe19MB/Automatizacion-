package com.bg.gnt.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectionDB {

	
	
	private Connection	connection	=	null;
	private	Statement	statement	=	null;
	private	ResultSet	resultSet	=	null;
	private	String		resultField	=	"";
	private int			resultUpdate	=	0;
	// Variables para la conectarse a la DB
	private String		userId	= "GANADERO";
	private String		password= "!7Kcht2!";
	private String protocol = "TCP";
	private String ipHost = "172.16.1.20";
	private String numPort = "1521";
	private String sid = "BGDM";
	private String serviceName = "BGDB";

	
	
	public Connection getConnection() {
		return connection;
	}

	public void setParameters(String schemaDB){
		switch (schemaDB){
			case "GANADERO":
				this.userId = "GANADERO";
				this.password = "!7Kcht2!";
				break;
			case "GANANET":
				this.userId = "GANANET";
				this.password = "123abc";
				break;
			case "AUTOSRV":
				this.userId = "AUTOSRV";
				this.password = "SRV123";
				break;
		}
	}
	public void setConnection() {
		
		Connection link = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
			// Comment	URL normal
			//String dbURL	=	"jdbc:oracle:thin:@172.16.1.208:1521/orcl","AUTOSRV","SRV123";
			// Comment	URL con TNS name
			String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL="+this.protocol+")(HOST="+this.ipHost+")(PORT="+this.numPort+")))(CONNECT_DATA=(SID="+this.sid+")(SERVICE_NAME="+this.serviceName+")))";
			link=DriverManager.getConnection(dbURL,this.userId,this.password);
			System.out.println("Connected to DB");
			
			
		}catch(SQLException ex) {
			
			System.out.println("No connection found!");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
		}catch(ClassNotFoundException ex) {
			
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		this.connection=link;
	}
	
	public Statement getStatement() {
		return this.statement;
	}
	
	public void setStatement() {
		Statement	stm	= null;
		try {
			stm	=	this.connection.createStatement();
		}catch(SQLException ex) {
			
			System.out.println("No connection found!");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

		}

		this.statement=stm;
	}
	
	public ResultSet getResultSet() {
		return this.resultSet;
	}
	
	public void setResultSet(String query) {
		ResultSet	rs	=	null;
		try {
			rs	=	this.statement.executeQuery(query);
		}catch(SQLException ex) {
			
			System.out.println("No connection found!");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

		}
		this.resultSet=rs;
	}
	
	public String getResultField() {
		return this.resultField;
	}

	public void setResultUpdate(String query) {
		int	ru	=	0;
		try {
			ru	=	this.statement.executeUpdate(query);
		}catch(SQLException ex) {
			
			System.out.println("No connection found!");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

		}
		this.resultUpdate=ru;
	}
	
	public int getResultUpdate() {
		return this.resultUpdate;
	}
	
	public void setResultField(String query) {
		String	field	= "";
		ResultSet	rs	=	null;
		try {
			rs	=	this.statement.executeQuery(query);
			while (rs.next()) {
				field = rs.getString(1);
			}
		}catch(SQLException ex) {
			
			System.out.println("No connection found!");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

		}
		
		this.resultField=field;
	}

}
