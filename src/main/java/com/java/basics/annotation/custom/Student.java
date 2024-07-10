package com.java.basics.annotation.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonSerializable
public class Student {

    @JsonElement
    private Integer rno;

    @JsonElement(value = "studentName")
    private String name;

    private String address;

    public Student() {

    }

    @Init
    private void capitalize() {
        this.name = this.name.substring(0,1).toUpperCase() + this.name.substring(1);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRno() {
        return  this.rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
