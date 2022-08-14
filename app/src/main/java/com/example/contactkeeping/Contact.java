package com.example.contactkeeping;

public class Contact {


    public Contact(String name, String number) {
        Name = name;
        Number = number;
    }

    private String Name;
    private String Number;





    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        Number = Number;
    }
}


