package Design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private List<Connection> availableConnections = new ArrayList<Connection>();
    private List<Connection> usedConnections = new ArrayList<Connection>();

    private int MAX_CONS = 5;

    private String URL;
    private String USER;
    private String PASSWORD;

    public ConnectionPool(String Url, String UserId, String password) throws SQLException {

        this.URL = Url;
        this.USER = UserId;
        this.PASSWORD = password;

        for (int i = 0; i < MAX_CONS; i++){
            availableConnections.add(this.createConnection());
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager
                .getConnection(this.URL, this.USER, this.PASSWORD);
    }

    public Connection getConnection() {
        if (availableConnections.size() == 0) {
            System.out.println("All connections are Used !!");
            return null;
        } else {
            Connection con =
                    availableConnections.remove(
                            availableConnections.size() - 1);
            usedConnections.add(con);
            return con;
        }
    }

    public Boolean releaseConnection(Connection con){

        if(null != con){
            usedConnections.remove(con);
            availableConnections.add(con);
            return true;
        }

        return false;
    }

}
