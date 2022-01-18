package model;

public class Member {
    private String firstName;
    private String lastName;
    private int available = 0;
    public Member(String firstName,String lastName,int available){
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
    }

    public int isAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
