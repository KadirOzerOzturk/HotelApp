import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class DbConnection extends Abstract1 implements Interface1 {
    Scanner scanner = new Scanner(System.in);
    // belirli bir tipte nesne oluşturmak için her arraylist için bir class oluşturduk
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Stuff> stuffs = new ArrayList<>();
    ArrayList<Management> managers = new ArrayList<>();
    ArrayList<Food> foods = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<TechnicalSupports> technicalSupportMessages = new ArrayList<>();
    ArrayList<Housekeeping> housekeepingRequest = new ArrayList<>();

    Connection connection = null, connection1 = null, connection2 = null; // connection veri tabanına bağlanmak için gerekli
    DbHelper dbHelper = new DbHelper();
    ResultSet resultSet, resultSet1;  // veri tabanından gelen bilgiler tutmak için kullanıyoruz
    static String order_name;

    public void getManagers() {

        Statement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM managers");  // veritabanındaki managers tablosundaki tüm bilgileri çekmemizi sağlayan sql kodu

            while (resultSet.next()) {
                managers.add(new Management(
                        resultSet.getString("manager_name"),
                        resultSet.getString("manager_surname"),
                        resultSet.getString("manager_gender"),
                        resultSet.getString("manager_username"),
                        resultSet.getString("manager_password"),
                        resultSet.getInt("manager_age"),
                        resultSet.getInt("manager_id")

                ));

            }


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getCustomers() {

        Statement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM customers");  // veritabanındaki customers tablosundaki tüm bilgileri çekmemizi sağlayan sql kodu

            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getString("customer_name"),
                        resultSet.getString("customer_surname"),
                        resultSet.getString("customer_gender"),
                        resultSet.getString("customer_country"),
                        resultSet.getInt("customer_roomnumber"),
                        resultSet.getInt("customer_age"),
                        resultSet.getString("customer_uniqueID"),
                        resultSet.getInt("customer_plan"),
                        resultSet.getInt("customer_spendamount")
                ));

            }


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getStuff() {

        Statement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM stuff");  // veritabanındaki stuff tablosundaki tüm bilgileri çekmemizi sağlayan sql kodu

            while (resultSet.next()) {

                stuffs.add(new Stuff(
                        resultSet.getString("stuff_name"),
                        resultSet.getString("stuff_surname"),
                        resultSet.getString("stuff_gender"),
                        resultSet.getString("stuff_username"),
                        resultSet.getString("stuff_password"),
                        resultSet.getString("stuff_entrytime"),
                        resultSet.getString("stuff_checkout"),
                        resultSet.getString("stuff_department"),
                        resultSet.getInt("stuff_age"),
                        resultSet.getInt("stuff_id"),
                        resultSet.getInt("stuff_workedhour"),
                        resultSet.getDouble("stuff_dailysalary")

                ));

            }

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getFoods() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM hotelsdb.foods");  // veritabanındaki foods tablosundaki tüm bilgileri çekmemizi sağlayan sql kodu

            while (resultSet.next()) {
                foods.add(new Food(
                        resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),
                        resultSet.getInt("food_calorie"),
                        resultSet.getInt("food_price"),
                        resultSet.getString("food_category")
                ));
            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getRequest() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM technicalsupport ");   // veritabanındaki technicalsupport tablosundaki tüm bilgileri çekmemizi sağlayan sql kodu

            while (resultSet.next()) {
                technicalSupportMessages.add(new TechnicalSupports(resultSet.getString("technical_message"),
                        resultSet.getString("technical_time"),
                        resultSet.getInt("id"),
                        resultSet.getInt("technical_roomnumber"),
                        resultSet.getInt("technical_status")
                ));

            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getHousekeepingRequest() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();// resultSeti nesneye aktarmak için kullanıyoruz
            resultSet = statement.executeQuery("SELECT * FROM housekeeping");   // veritabanındaki housekeeping tablosundaki tüm bilgileri çekmemizi sağlayan sql kodu

            while (resultSet.next()) {
                housekeepingRequest.add(new Housekeeping(resultSet.getString("housekeeping_time"),
                        resultSet.getInt("housekeeping_status"),
                        resultSet.getInt("id"),

                        resultSet.getInt("housekeeping_roomnumber")

                ));

            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setCustomer(String customer_name, String customer_surname, int customer_age, String customer_gender, String customer_country, String customer_uniqueID, int customer_roomnumber, int customer_plan) {

        PreparedStatement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("insert into customers (customer_name,customer_surname,customer_age,customer_gender,customer_country,customer_uniqueID,customer_roomnumber,customer_plan) values('" + customer_name + "','" + customer_surname + "'," + customer_age + ",'" + customer_gender + "','" + customer_country + "','" + customer_uniqueID + "'," + customer_roomnumber + "," + customer_plan + ")");// resultSeti nesneye aktarmak için kullanıyoruz
                                                    // customers tablosuna veri göndermek için kullandığımız sql kodu
            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Müşteri Kaydedildi .");
    }


    public void orderAdding(int order_foodID, int order_roomnumber, int order_count) {
        PreparedStatement statement = null, statement1 = null;
        Statement statement2 = null, statement3 = null;

        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getFood_id() == order_foodID) {
                order_name = foods.get(i).getFood_name();
            }
        }
        try {
            connection1 = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection1.prepareStatement("insert into orders (order_foodID,order_roomnumber,order_count,order_name) values(" + order_foodID + "," + order_roomnumber + "," + order_count + ",'" + order_name + "')");// resultSeti nesneye aktarmak için kullanıyoruz
                                                         // orders tablosuna veri göndermek için kullandığımız sql kodu
            statement.executeUpdate();

            statement3 = connection1.createStatement();
            resultSet1 = statement3.executeQuery("SELECT * FROM customers WHERE customer_uniqueID='" + Login.customer_uniqueId + "'");
            int beforeamount = 0;
            if (resultSet1.next()) {
                beforeamount = resultSet1.getInt("customer_spendamount");
            }
            getFoods();
            beforeamount += order_count * (foods.get(order_foodID - 1).getFood_price());

            statement1 = connection1.prepareStatement("UPDATE customers SET customer_spendamount=" + beforeamount + " WHERE customer_uniqueID='" + Login.customer_uniqueId + "'");
            statement1.executeUpdate();
            System.out.println("Sipariş alındı.\n");


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);

        } finally {
            try {
                statement.close();
                connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void orderAddingForWaiters(int order_foodID, int order_tablenumber, int order_count, String customerID) {
        PreparedStatement statement = null, statement1 = null;
        Statement statement2 = null, statement3 = null;
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getFood_id() == order_foodID) {
                order_name = foods.get(i).getFood_name();
            }
        }
        try {
            connection1 = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection1.prepareStatement("insert into orders (order_foodID,order_tablenumber,order_count,order_name) values(" + order_foodID + "," + order_tablenumber + "," + order_count + ",'" + order_name + "')");// resultSeti nesneye aktarmak için kullanıyoruz
            statement.executeUpdate();

            statement3 = connection1.createStatement();
            resultSet1 = statement3.executeQuery("SELECT * FROM customers WHERE customer_uniqueID='" + customerID + "'");
            int beforeamount = 0;
            if (resultSet1.next()) {
                beforeamount = resultSet1.getInt("customer_spendamount");
            }
            getFoods();
            beforeamount += order_count * (foods.get(order_foodID - 1).getFood_price());

            statement1 = connection1.prepareStatement("UPDATE customers SET customer_spendamount=" + beforeamount + " WHERE customer_uniqueID='" + customerID + "'");
            statement1.executeUpdate();
            System.out.println("Sipariş alındı.\n");


        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);

        } finally {
            try {
                statement.close();
                connection1.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // overloading
    public void getOrders(int roomnumber) {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hotelsdb.orders WHERE order_roomnumber=" + roomnumber);


            while (resultSet.next()) {

                if (resultSet.getInt("order_status") == 0) {
                    System.out.print(resultSet.getInt("order_count") + " porsiyon ");
                    System.out.print(resultSet.getString("order_name"));
                    System.out.println(" - Sipariş onayı bekleniyor.\n");

                } else if (resultSet.getInt("order_status") == 1) {
                    System.out.print(resultSet.getInt("order_count") + " porsiyon ");
                    System.out.print(resultSet.getString("order_name"));
                    System.out.println(" - Siparişiniz hazırlanıyor...\n");


                } else if (resultSet.getInt("order_status") == 2) {
                    System.out.print(resultSet.getInt("order_count") + " porsiyon ");
                    System.out.print(resultSet.getString("order_name"));
                    System.out.println(" - Sipariş tamamlandı.\n");

                }

            }

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getOrders() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT order_name,order_roomnumber,order_status,id FROM hotelsdb.orders ");
            int i = 0;
            while (resultSet.next()) {
                orders.add(new Order(resultSet.getString("order_name"),
                        resultSet.getInt("order_roomnumber"),
                        resultSet.getInt("order_status"),
                        resultSet.getInt("id")));


            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateOrderOrSupport(String table_name, String category, int id, int status) {
        super.updateOrderOrSupport(table_name, category, id, status);
    }

    public void updateRoomStatus(int room_status, int room_number,int room_spendamount) {
        PreparedStatement statement = null;


        try {

            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE rooms SET room_status=" + room_status + ",room_spendamount="+room_spendamount+" WHERE room_number=" + room_number);
            statement.executeUpdate();
            System.out.println("Güncellendi.");

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void updateHousekeepingStatus(int housekeeping_status, int id) {
        PreparedStatement statement = null;


        try {

            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE housekeeping SET housekeeping_status=" + housekeeping_status + " WHERE id=" + id);
            statement.executeUpdate();
            System.out.println("Güncellendi.");

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void updateCustomer(String  customerID) {
        PreparedStatement statement = null;


        try {

            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE customers SET customer_roomnumber=" + 0 +",customer_uniqueID='0' WHERE customer_uniqueID='" + customerID+"'");
            statement.executeUpdate();
            System.out.println("Güncellendi.");

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addProduct(String food_name, int food_calorie, int food_price, String food_category) {
        PreparedStatement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("insert into foods (food_name,food_calorie,food_price,food_category) values('" + food_name + "'," + food_calorie + "," + food_price + ",'" + food_category + "')");
            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ürün Kaydedildi .");
    }

    public void getRooms() {
        Statement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hotelsdb.rooms ");
            int i = 0;
            while (resultSet.next()) {
                rooms.add(new Room(resultSet.getString("room_option"),
                        resultSet.getString("room_view"),
                        resultSet.getInt("room_number"),
                        resultSet.getInt("room_status"),
                        resultSet.getInt("room_price"),
                        resultSet.getInt("room_spendamount")
                ));


            }
        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void setStuff(String stuff_name, String stuff_surname, int stuff_age, String stuff_gender, String stuff_username, String stuff_password, String stuff_department) {

        PreparedStatement statement = null;


        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("insert into stuff (stuff_name,stuff_surname,stuff_age,stuff_gender,stuff_username,stuff_password,stuff_department) values('" + stuff_name + "','" + stuff_surname + "'," + stuff_age + ",'" + stuff_gender + "','" + stuff_username + "','" + stuff_password + "','" + stuff_department + "')");
            statement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
            dbHelper.showErrorMassage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Müşteri Kaydedildi .");
    }


    // bu fonksiyon ile personelin kaç saat çalıştığını veritabanına aktarıyoruz
    public void stuffWorkHour(String stuffUsername) {

        PreparedStatement statement = null;
        Statement statement1 = null;
        int stuffWorkedHourData = 0;
        String stuffEntryTime = null, stuffCheckOutTime = null;
        double stuffDailySalary = 0;
        String[] timevalues1 = new String[2];
        Integer[] timevalues2 = new Integer[6];
        String[] timevalues3 = new String[2];
        Integer[] timevalues4 = new Integer[6];
        String[] timevalues5 = new String[3];
        String[] timevalues6 = new String[3];
        String[] timevalues7 = new String[3];
        String[] timevalues8 = new String[3];
        try {
            getStuff();

            for (int i = 0; i < stuffs.size(); i++) {
                if (stuffs.get(i).getStuff_username().equalsIgnoreCase(stuffUsername)) {
                    stuffEntryTime = stuffs.get(i).getStuff_entrytime();
                    stuffCheckOutTime = stuffs.get(i).getStuff_checkout();
                    stuffWorkedHourData = stuffs.get(i).getStuff_workedHourData();
                    stuffDailySalary = stuffs.get(i).getStuff_dailysalary();
                }
            }
            timevalues1 = stuffEntryTime.split("T");

            timevalues5 = timevalues1[0].split("-");
            timevalues6 = timevalues1[1].split(":");

            timevalues2[0] = Integer.parseInt(timevalues5[0]);
            timevalues2[1] = Integer.parseInt(timevalues5[1]);
            timevalues2[2] = Integer.parseInt(timevalues5[2]);
            timevalues2[3] = Integer.parseInt(timevalues6[0]);
            timevalues2[4] = Integer.parseInt(timevalues6[1]);
            timevalues2[5] = Integer.parseInt(timevalues6[2]);

            timevalues3 = stuffCheckOutTime.split("T");
            timevalues7 = timevalues3[0].split("-");
            timevalues8 = timevalues3[1].split(":");

            timevalues4[0] = Integer.parseInt(timevalues7[0]);
            timevalues4[1] = Integer.parseInt(timevalues7[1]);
            timevalues4[2] = Integer.parseInt(timevalues7[2]);
            timevalues4[3] = Integer.parseInt(timevalues8[0]);
            timevalues4[4] = Integer.parseInt(timevalues8[1]);
            timevalues4[5] = Integer.parseInt(timevalues8[2]);
            long timeHours = Duration.between(LocalDateTime.of(timevalues2[0], timevalues2[1], timevalues2[2], timevalues2[3], timevalues2[4], timevalues2[5]), LocalDateTime.of(timevalues4[0], timevalues4[1], timevalues4[2], timevalues4[3], timevalues4[4], timevalues4[5])).toHours();
            stuffWorkedHourData += timeHours;
            double stuff_salary = stuffWorkedHourData * stuffDailySalary;
            connection = DbHelper.getConnection();
            statement = connection.prepareStatement("UPDATE stuff SET stuff_workedhour=" + stuffWorkedHourData + ",stuff_salary=" + stuff_salary + " WHERE stuff_username='" + stuffUsername + "'");
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void technicalSupportAdding(String message, String time) {
        PreparedStatement statement = null;
        try {
            connection2 = DbHelper.getConnection();
            getCustomers();
            statement = connection2.prepareStatement("insert into technicalsupport (technical_roomnumber,technical_message,technical_time,technical_status) values(" + customers.get(Login.customer_id).getCustomer_roomnumber() + ",'" + message + "','" + time + "',0)");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection2.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void housekeepingAdding(String time) {
        PreparedStatement statement = null;
        try {
            getCustomers();
            connection2 = DbHelper.getConnection();
            statement = connection2.prepareStatement("insert into housekeeping (housekeeping_roomnumber,housekeeping_time,housekeeping_status) values(" + customers.get(Login.customer_id).getCustomer_roomnumber() + ",'" + time + "',0)");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            connection2.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
