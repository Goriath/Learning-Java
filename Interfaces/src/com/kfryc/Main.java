package com.kfryc;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ITelephone timsPhone;       //interface cannot be created like classes: = new ITelephone(123456)

        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        timsPhone = new MobilePhone(24565); //can be defined as different class when they are of same interface!
        timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();;


    }
}
