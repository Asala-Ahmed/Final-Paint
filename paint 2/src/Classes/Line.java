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
public class Line extends Shape {
    
    public Line(Color color, int x1, int y1, int x2, int y2) {
        super(color, x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

 
    @Override
    public boolean contains(int x, int y) {
         java.awt.Rectangle r ;
        if(getX1() < getX2() && getY1() < getY2()){
        r= new java.awt.Rectangle(getX1(),getY1(),getX2()-getX1(),getY2()-getY1());
             return r.contains(new Point(x,y));
        }
        else if(getX1() > getX2() && getY1()> getY2()){
            r= new java.awt.Rectangle(getX2(),getY2(),getX1()-getX2(),getY1()-getY2());
             return r.contains(new Point(x,y));
        }
         else if(getX1() < getX2() && getY2() < getY1()){
             r= new java.awt.Rectangle(getX1(),getY2(),getX2()-getX1(),getY1()-getY2());
             return r.contains(new Point(x,y));
         }
        else if(getX1() > getX2() && getY2()> getY1()){
            r= new java.awt.Rectangle(getX2(),getY1(),getX1()-getX2(),getY2()-getY1());
             return r.contains(new Point(x,y));
    }
        return false;
    }

    @Override
    public void move(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
  
    

    
    
}
