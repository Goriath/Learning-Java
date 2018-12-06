package com.kfryc;

public class ExtendedPassword extends Password{
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

//    @Override
//    public void storePassword() { //cannot be exteded as the Password class has final keyword
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
