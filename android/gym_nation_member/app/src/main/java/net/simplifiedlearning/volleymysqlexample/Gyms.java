package net.simplifiedlearning.volleymysqlexample;

public class Gyms {
    private int id;
    private String gym_name;
    private String gym_logo;
    private String gym_database_url;


    public Gyms(int id, String gym_name, String gym_logo, String gym_database_url) {
        this.id = id;
        this.gym_name = gym_name;
        this.gym_logo = gym_logo;
        this.gym_database_url = gym_database_url;


    }

    public int getId() {
        return id;
    }

    public String getGym_nameg() {
        return gym_name;
    }

    public String getGym_logo() {
        return gym_logo;
    }

    public String getGym_database_url() {
        return gym_database_url;
    }

}




