import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public interface Interface1 {
    // bir otelde kesinlikle olması gerekenler müşteri,personel,yönetici,sipariş ve ürün bilgisi
    void getCustomers();
    void getStuff();
    void getManagers();
    void getOrders();
    void getOrders(int room_number);
    void getFoods();


}
