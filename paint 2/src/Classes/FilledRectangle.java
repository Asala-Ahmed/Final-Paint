package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


/**
 *
 * @author asala
 */
public class FilledRectangle extends Shape {
    
    public FilledRectangle(Color color, int x1, int y1, int x2, int y2) {
        super(color, x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
               if(getX1() < getX2() && getY1() < getY2())
                   g.fillRect(getX1(),getY1(),getX2()-getX1(),getY2()-getY1());
               else if(getX1() > getX2() && getY1()> getY2())
                   g.fillRect(getX2(),getY2(),getX1()-getX2(),getY1()-getY2());
               else if(getX1() < getX2() && getY2() < getY1())
                   g.fillRect(getX1(),getY2(),getX2()-getX1(),getY1()-getY2());
               else if(getX1() > getX2() && getY2()> getY1())
                   g.fillRect(getX2(),getY1(),getX1()-getX2(),getY2()-getY1());
    }

   
    @Override
    public boolean contains(int x, int y) {
        java.awt.Rectangle r ;
        if(getX1() < getX2() && getY1() < getY2()){
        r= new java.awt.Rectangle(getX1(),getY1(),getX2()-getX1(),getY2()-getY1());
        if (r.contains(new Point(x,y))){
            return true;
        } else{
            return false;
        }
        }
        else if(getX1() > getX2() && getY1()> getY2()){
            r= new java.awt.Rectangle(getX2(),getY2(),getX1()-getX2(),getY1()-getY2());
            if (r.contains(new Point(x,y))){
            return true;
        } else{
            return false;
        }
        }
         else if(getX1() < getX2() && getY2() < getY1()){
             r= new java.awt.Rectangle(getX1(),getY2(),getX2()-getX1(),getY1()-getY2());
             if (r.contains(new Point(x,y))){
            return true;
        } else{
            return false;
        }
         }
        else if(getX1() > getX2() && getY2()> getY1()){
            r= new java.awt.Rectangle(getX2(),getY1(),getX1()-getX2(),getY2()-getY1());
        if (r.contains(new Point(x,y))){
            return true;
        } else{
            return false;
        }
    }
        return false;
    }

    @Override
    public void move(Graphics g) {
        paintIcon(this,g,getX1(),getY1());
    }

    private void paintIcon(FilledRectangle aThis, Graphics g, int x1, int y1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }

    