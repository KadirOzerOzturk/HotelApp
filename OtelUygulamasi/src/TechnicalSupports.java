public class TechnicalSupports {
    // bu classın tek görevi oluşturacak nesnenin tipini belirlemek
    private String technical_message,technical_time;
    private int technical_id,technical_roomnumber,technical_status;

    public TechnicalSupports(String technical_message, String technical_time, int technical_id, int technical_roomnumber, int technical_status) {
        this.technical_message = technical_message;
        this.technical_time = technical_time;
        this.technical_id = technical_id;
        this.technical_roomnumber = technical_roomnumber;
        this.technical_status = technical_status;
    }

    public String getTechnical_message() {
        return technical_message;
    }

    public String getTechnical_time() {
        return technical_time;
    }

    public int getTechnical_id() {
        return technical_id;
    }

    public int getTechnical_roomnumber() {
        return technical_roomnumber;
    }

    public int getTechnical_status() {
        return technical_status;
    }
}
