package com.shahbaz.lenovo.bookstacks;

/**
 * Created by lenovo on 9/26/2017.
 */

public class BeanClass {
    public String name,phone,email,details,address,pin;
    public String stream;



    public static BeanClass create(String name, String phone, String email,String stream, String details, String address, String pin)
    {
        BeanClass bean = new BeanClass();
        bean.name = name;
        bean.phone = phone;
        bean.email = email;
        bean.stream=stream;
        bean.details = details;
        bean.address=address ;
        bean.pin = pin;
        return bean;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
