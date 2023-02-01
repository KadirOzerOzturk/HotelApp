import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public abstract class Abstract1 {

    // personelin giriş çıkış zamanını veritabanına yazıyoruz
    public void updateTime(String timeTerm,String stuffUsername){
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE stuff SET stuff_"+timeTerm+"='" + LocalDateTime.now().toString().substring(0,19) + "' WHERE stuff_username='" + stuffUsername+"'");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // burada müşteriden gelen sipraiş ve teknik destek isteklerinin durumları güncelleniyor
    public void updateOrderOrSupport(String table_name,String category,int id,int status ){
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE "+table_name+" SET "+category+"='" + status + "' WHERE id=" + id+"");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
