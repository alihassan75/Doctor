package com.example.doctor;

public class person {
    private String name;
    private String Debartment;
    private String Address;
    private String Phone;

    public void Person(String name, String Debarment, String Address,String Phone) {
        this.Debartment = Debarment;
        this.name = name;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDebarment() {
        return Debartment;
    }

    public void setDebarment(String debartment) {
        Debartment = debartment;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}

