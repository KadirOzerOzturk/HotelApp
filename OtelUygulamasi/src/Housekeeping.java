public class Housekeeping {
    // bu classın tek görevi oluşturacak nesnenin tipini belirlemek
    private String housekeeping_time;
    private int housekeeping_status,id,housekeeping_roomnumber;

    public Housekeeping(String housekeeping_time, int housekeeping_status, int id, int housekeeping_roomnumber) {
        this.housekeeping_time = housekeeping_time;
        this.housekeeping_status = housekeeping_status;
        this.id = id;
        this.housekeeping_roomnumber = housekeeping_roomnumber;
    }

    public String getHousekeeping_time() {
        return housekeeping_time;
    }

    public int getHousekeeping_status() {
        return housekeeping_status;
    }

    public int getId() {
        return id;
    }

    public int getHousekeeping_roomnumber() {
        return housekeeping_roomnumber;
    }
}
