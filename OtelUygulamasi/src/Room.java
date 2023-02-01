public class Room {
    // bu classın tek görevi oluşturacak nesnenin tipini belirlemek

    private String room_option,room_view;
    private int room_number,room_status,room_price,room_spendamount;

    public Room(String room_option, String room_view, int room_number, int room_status, int room_price, int room_spendamount) {
        this.room_option = room_option;
        this.room_view = room_view;
        this.room_number = room_number;
        this.room_status = room_status;
        this.room_price = room_price;
        this.room_spendamount = room_spendamount;
    }

    public String getRoom_option() {
        return room_option;
    }

    public String getRoom_view() {
        return room_view;
    }

    public int getRoom_number() {
        return room_number;
    }

    public int getRoom_status() {
        return room_status;
    }

    public int getRoom_price() {
        return room_price;
    }

    public int getRoom_spendamount() {
        return room_spendamount;
    }
}
