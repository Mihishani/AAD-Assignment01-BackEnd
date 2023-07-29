package lk.ijse.gdse63.aadassignment01.DB;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    public static Connection getConnection(){
        try{
            InitialContext context = new InitialContext();
            DataSource pool = (DataSource) context.lookup("");
            connection = pool.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
