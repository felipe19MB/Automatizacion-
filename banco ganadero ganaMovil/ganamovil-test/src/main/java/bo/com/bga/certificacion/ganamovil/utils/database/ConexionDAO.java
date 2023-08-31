package bo.com.bga.certificacion.ganamovil.utils.database;


import bo.com.bga.certificacion.ganamovil.utils.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public class ConexionDAO {
    private static Connection connection;
    private String url = PropertiesReader.getInstance().getProperties("urlDatabase");

    public ConexionDAO(String username, String password) throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);
            Logger.getAnonymousLogger().info("Conexión a base de datos éxitosa.");
        }catch (SQLException e) {
            Logger.getAnonymousLogger().info("Error al conectar a la base de datos: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            Logger.getAnonymousLogger().info("Error al cargar el controlador JDBC." + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() throws SQLException {
        if (connection != null){
            try {
                connection.close();
                Logger.getAnonymousLogger().info("Conexión cerrada");
            } catch (SQLException e) {
                Logger.getAnonymousLogger().info("Error al cerrar la conexión a la base de datos: " + e.getMessage());
            }
        }
    }
}

