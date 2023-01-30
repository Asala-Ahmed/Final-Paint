/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;


public class triangleShapeFactory {
    public  static Shape createshape(String name,Color color,int x1, int y1, int x2, int y2,int x3, int y3)
    {
     if(name.equals("triangle"))
            return new Triangle(color, x1, y1, x1, y1, x1, y1);
        else if(name.equals("filledtriangle"))
            return new FilledTriangle(color, x1, y1, x1, y1, x1, y1);
        return null;
    
    }
    
}
