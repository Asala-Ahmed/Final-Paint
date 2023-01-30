/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author asala
 */
public class Circle extends Shape {
    
    public Circle(Color color, int x1, int y1, int x2, int y2) {
        super(color, x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
                     
        g.setColor(getColor());
               if(getX1() < getX2() && getY1() < getY2())
                   g.drawOval(getX1(),getY1(),getX2()-getX1(),getY2()-getY1());
               else if(getX1() > getX2() && getY1()> getY2())
                   g.drawOval(getX2(),getY2(),getX1()-getX2(),getY1()-getY2());
               else if(getX1() < getX2() && getY2() < getY1())
                   g.drawOval(getX1(),getY2(),getX2()-getX1(),getY1()-getY2());
               else if(getX1() > getX2() && getY2()> getY1())
                   g.drawOval(getX2(),getY1(),getX1()-getX2(),getY2()-getY1());
                   
               
    }

    @Override
    public boolean contains(int x, int y) {
        if(getX1() < getX2() && getY1() < getY2()){
        Ellipse2D e = new Ellipse2D.Float(getX1(), getY1(),getX2()-getX1(),getY2()-getY1());
        return e.contains(x,y);}
        else if(getX1() > getX2() && getY1()> getY2()){
            Ellipse2D e = new Ellipse2D.Float(getX2(),getY2(),getX1()-getX2(),getY1()-getY2());
        return e.contains(x,y);}
         else if(getX1() < getX2() && getY2() < getY1()){
             Ellipse2D e = new Ellipse2D.Float(getX1(),getY2(),getX2()-getX1(),getY1()-getY2());
        return e.contains(x,y);}
        else if(getX1() > getX2() && getY2()> getY1()){
        Ellipse2D e = new Ellipse2D.Float(getX2(),getY1(),getX1()-getX2(),getY2()-getY1());
        return e.contains(x,y);}
        else{
            return false;
            
        }
        
    }

    @Override
    public void move(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
