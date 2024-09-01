package LLD.RailwayBookingApp;

public class Passenger {
    static int id_Provider = 0;
    private  int id;
    private String name;
    private int age;
    private char seat_preference;
    private int seat_number;
    private String ticket_type;

    public Passenger(String name, int age,char seat_preference){
        this.id = ++id_Provider;
        this.age = age;
        this.name = name;
        this.seat_preference = seat_preference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSeat_preference() {
        return seat_preference;
    }

    public void setSeat_preference(char seat_preference) {
        this.seat_preference = seat_preference;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", seat_preference=" + seat_preference +
                ", seat_number=" + seat_number +
                ", ticket_type='" + ticket_type + '\'' +
                '}';
    }
}
