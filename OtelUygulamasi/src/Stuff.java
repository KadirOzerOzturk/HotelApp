public class Stuff {

    // bu classın tek görevi oluşturacak nesnenin tipini belirlemek
    private String stuff_name, stuff_surname, stuff_gender, stuff_username, stuff_password, stuff_entrytime, stuff_checkout,stuff_department;
    private int stuff_age, stuff_id,stuff_workedHourData;
    private double stuff_dailysalary;

    public Stuff(String stuff_name, String stuff_surname, String stuff_gender, String stuff_username, String stuff_password, String stuff_entrytime, String stuff_checkout, String stuff_department, int stuff_age, int stuff_id,int stuff_workedHourData,double stuff_dailysalary) {
        this.stuff_name = stuff_name;
        this.stuff_surname = stuff_surname;
        this.stuff_gender = stuff_gender;
        this.stuff_username = stuff_username;
        this.stuff_password = stuff_password;
        this.stuff_entrytime = stuff_entrytime;
        this.stuff_checkout = stuff_checkout;
        this.stuff_department = stuff_department;
        this.stuff_age = stuff_age;
        this.stuff_id = stuff_id;
        this.stuff_workedHourData=stuff_workedHourData;
        this.stuff_dailysalary=stuff_dailysalary;
    }

    public String getStuff_name() {
        return stuff_name;
    }

    public String getStuff_surname() {
        return stuff_surname;
    }

    public String getStuff_gender() {
        return stuff_gender;
    }

    public String getStuff_username() {
        return stuff_username;
    }

    public String getStuff_password() {
        return stuff_password;
    }

    public String getStuff_entrytime() {
        return stuff_entrytime;
    }

    public String getStuff_checkout() {
        return stuff_checkout;
    }

    public String getStuff_department() {
        return stuff_department;
    }

    public int getStuff_age() {
        return stuff_age;
    }

    public int getStuff_id() {
        return stuff_id;
    }

    public int getStuff_workedHourData() {return stuff_workedHourData;}

    public double getStuff_dailysalary() {return stuff_dailysalary;}


}
