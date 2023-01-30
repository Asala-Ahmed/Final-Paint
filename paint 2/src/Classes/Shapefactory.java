/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;


public class Shapefactory   {

    public static Shape createshape(String name, Color color, int x1, int y1, int x2, int y2) {
        if(name.equals("line"))
            return new Line(color,  x1, y1, x1, y1);
        else if(name.equals("circle"))
            return new Circle(color,  x1, y1, x1, y1);
        else if(name.equals("filledcircle"))
            return new FilledCircle(color, x1,  y1,  x1,  y1);
        else if(name.equals("square"))
            return new Square(color, x1,  y1,  x2,  y2);
        else if(name.equals("filledsquare"))
            return new FilledSquare(color, x1,  y1,  x2,  y2);
        else if(name.equals("rectangle"))
            return new Rectangle(color,  x1, y1, x1, y1);
        else if(name.equals("filledRectangle"))
            return new FilledRectangle(color,  x1, y1, x1, y1);
        else
        return null;
    }
    
}
