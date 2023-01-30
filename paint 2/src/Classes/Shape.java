/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author asala
 */
public abstract class Shape extends Points implements Cloneable{
    private Color color;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    public Shape(Color color, int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        notifyall();
    }
    public abstract void draw(Graphics g);

    public abstract boolean contains(int x, int y);
    @Override
    public Object clone() throws CloneNotSupportedException{
        Shape s= (Shape)super.clone();
        s.setColor(this.color);
        return s;
    }
     public void attach(Observer o)
    {
        observers.add(o);
    }
    public void notifyall()
    {
        for(int i=0;i<observers.size();i++)
        {
            observers.get(i).update();
        }
    }
    public abstract void move(Graphics g);
}
