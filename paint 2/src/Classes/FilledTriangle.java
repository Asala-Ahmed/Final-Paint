/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author asala
 */
public class FilledTriangle extends Shape{
    
    int x3,y3;

    public FilledTriangle(Color color, int x1, int y1, int x2, int y2, int x3, int y3) {
        super(color, x1, y1, x2, y2);
        this.x3 = x3;
        this.y3 = y3;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    @Override
    public void draw(Graphics g) {
            g.setColor(getColor());
            int xpoints[]= new int[3];
            xpoints[0]=getX1();
            xpoints[1]=getX2();
            xpoints[2]=getX3();
            int ypoints[]= new int[3];
            ypoints[0]=getY1();
            ypoints[1]=getY2();
            ypoints[2]=getY3();
            g.setColor(getColor());
            g.fillPolygon(xpoints, ypoints, 3);
    }

    @Override
    public boolean contains(int x, int y) {
       java.awt.Polygon tri ;
        int xpoints[]= new int[3];
            xpoints[0]=getX1();
            xpoints[1]=getX2();
            xpoints[2]=getX3();
            int ypoints[]= new int[3];
            ypoints[0]=getY1();
            ypoints[1]=getY2();
            ypoints[2]=getY3();
        tri = new java.awt.Polygon(xpoints, ypoints, 3);
        if (tri.contains(new Point(x,y))){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void move(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}