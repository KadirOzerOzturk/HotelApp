import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    // veritabanı bağlantısını yaptığımız class
    public static Connection getConnection() throws SQLException {
        String password = "K6g4aSfTKjZKmHQBfiAB";
        String dbUrl = "jdbc:mysql://projeotel.ceaeispo2d3k.eu-central-1.rds.amazonaws.com:3306/hotelsdb?user=admin&password=K6g4aSfTKjZKmHQBfiAB";
        String userName = "admin";
        return DriverManager.getConnection(dbUrl, userName, password);
    }
    public  void showErrorMassage(SQLException exception){
        System.out.println("Error : " + exception.getMessage() );
        System.out.println("Error Kodu : "+exception.getErrorCode());
    }
}
