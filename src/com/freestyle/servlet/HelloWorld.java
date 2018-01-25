package com.freestyle.servlet;

public class HelloWorld {
    private String name;

    public static void main(String[] args) {
        int temp1 = 100;
        int temp2 = 50;
        int temp3 = addNum(temp1,temp2);
        System.out.println("------YouMeek.com----temp3值＝"+temp3);

    }

    public static Integer addNum(Integer temp1, Integer temp2) {
        int temp3 = temp1 + temp2;
        return temp3;
    }

}
