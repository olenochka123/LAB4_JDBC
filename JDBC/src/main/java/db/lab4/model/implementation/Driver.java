package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class Driver implements GeneralModelInterface {
    private Integer id;
    private String name;
    private String surname;
    private String last_name;
    private Integer age;
    private String telephone_number;
    private String email;

    public Driver(Integer id, String name, String surname, String last_name, Integer age, String telephone_number, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.last_name = last_name;
        this.age = age;
        this.telephone_number = telephone_number;
        this.email = email;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephoneNumber() {
        return telephone_number;
    }

    public void setTelephoneNumber(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age='" + age + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
