package com.kfryc;

public interface ITelephone {       //no need to put public nor private
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();




}
