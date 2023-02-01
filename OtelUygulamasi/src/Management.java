import java.util.Scanner;
import java.util.UUID;

public class Management {
    private  String manager_name, manager_surname, manager_gender,manager_username,manager_password;
    private  int manager_age,manager_id;

    public Management(String manager_name, String manager_surname, String manager_gender, String manager_username, String manager_password, int manager_age, int manager_id) {
        this.manager_name = manager_name;
        this.manager_surname = manager_surname;
        this.manager_gender = manager_gender;
        this.manager_username = manager_username;
        this.manager_password = manager_password;
        this.manager_age = manager_age;
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_surname() {
        return manager_surname;
    }

    public void setManager_surname(String manager_surname) {
        this.manager_surname = manager_surname;
    }

    public String getManager_gender() {
        return manager_gender;
    }

    public void setManager_gender(String manager_gender) {
        this.manager_gender = manager_gender;
    }

    public String getManager_username() {
        return manager_username;
    }

    public void setManager_username(String manager_username) {
        this.manager_username = manager_username;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public int getManager_age() {
        return manager_age;
    }

    public void setManager_age(int manager_age) {
        this.manager_age = manager_age;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }
}
