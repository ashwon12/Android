package com.example.mylistview;

public class SigerItem {

    String name;
    String number;

    //생성자
    public SigerItem(String name, String number) {
        this.name = name;
        this.number = number;
    }

    //get set 메소드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //객체 안에 들어있는 것 문자열로 출력
    @Override
    public String toString() {
        return "SigerItem{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
