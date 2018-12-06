package com.kfryc.awtSample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {

    public MyWindow(String title) throws HeadlessException {
        super(title);
        setSize(500,140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {  //windowClosing is process of closing window. windowClosed is when the frame has been closed
                System.exit(0);

            }
        });
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD,18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD,12);

        g.setFont(sansSerifLarge);
        g.drawString("This is a example title for Java Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("Created by Krzysztof Fryc", 60, 100);

    }
}
