package com.cmcc.androidknowledge.desginpattern.factorymode;

public class ComputerFactory {

    public static Computer createComputer(String type){
        Computer computer = null;
        switch (type)
        {
            case "hp":
                computer = new HpComputer();
                break;
            case "lenovo":
                computer = new LenovoComputer();
                break;
         }
         return computer;
    }
}
