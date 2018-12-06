package com.kfryc;

public class ScopeCheck {
    public int publicVar = 0;
    private int varOne =1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar +" : varOne = "+ varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo(){
        int varTwo =2;
        for(int i=0;i<10;i++){
            System.out.println(i + " times two is "+ i * varTwo);
            //to use the class variable: this.varOne
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
        //visibility extends to outer class when variable is private
    }


    public class InnerClass {
        private int varThree = 3;

        public InnerClass(){
            System.out.println("InnerClass created, varOne " + varOne + " and varThree is " + varThree);
        }

        public void timesTwo(){
            System.out.println("varOne is still available here " + varOne);
            for(int i=0;i<10;i++){
                System.out.println(i + " times two is "+ i * varThree);
                //to use the class variable: ScopeCheck.this.varOne
            }
        }


    }
}
