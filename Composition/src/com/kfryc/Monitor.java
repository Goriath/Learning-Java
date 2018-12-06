package com.kfryc;

public class Monitor {
    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResulution;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResulution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResulution = nativeResulution;
    }

    public void drawPixelAt(int x, int y, String color){
        System.out.println("drawing pixel at "+ x + ", " + y + " in colour " + color);
    }
}
