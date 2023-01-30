/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import Classes.BooleanObserver;
import Classes.Circle;
import Classes.Line;
import Classes.Rectangle;
import Classes.Square;
import Classes.Shape;
import Classes.Triangle;
import Classes.FilledCircle;
import Classes.FilledRectangle;
import Classes.FilledSquare;
import Classes.FilledTriangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author asala
 */
public class Board extends JPanel implements MouseListener, MouseMotionListener {

    private Shape selectedShape = null;
    public static Board Board1 = null;
    public static ArrayList<Shape> shapes;
    int x1, y1, x2, y2, x3, y3;
    int point1, point2;
    public int mode = -1;
    boolean before = false;
    boolean first;
    Color currentColor = Color.BLACK;
    Stack<ArrayList<Shape>> undo = new Stack<ArrayList<Shape>>();
    Stack<ArrayList<Shape>> redo = new Stack<ArrayList<Shape>>();

    private Board() {
        shapes = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void undo(){
        if(undo.size()>1){
            redo.push(undo.pop());
            shapes=undo.peek();
            repaint();
        }
    }
    public void redo(){
        if(redo.size()>0){
            undo.push(redo.pop());
            shapes=undo.peek();
            repaint();
        }
    }
    private ArrayList<Shape> copy(ArrayList<Shape> shapes) throws CloneNotSupportedException{
        ArrayList<Shape> co = new ArrayList<>();
        for(int i=0;i<shapes.size();i++){
            co.add((Shape)shapes.get(i).clone());
        }
        return co;
    }
    public static Board getInstance() {
        if (Board1 == null) {
            Board1 = new Board();
        }
        return Board1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Iterator<Shape> it = shapes.iterator();
        while (it.hasNext()) {

            Shape s = it.next();
            BooleanObserver o= new BooleanObserver(s);
            s.attach(o);
            s.draw(g);
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        before = false;
        x1 = me.getX();
        y1 = me.getY();
        switch (mode) {
            case 0:
                Line l = (Line) Classes.Shapefactory.createshape("line",currentColor, x1, y1, x1, y1);
                shapes.add(l);
                repaint();
                
                break;
            case 1:
                if (!shapes.isEmpty()) {
                    Shape tri = shapes.get(shapes.size() - 1);
                    if (tri instanceof Triangle) {
                        Triangle temp = (Triangle) tri;
                        if (temp.getX1() == temp.getX2()) {
                            temp.setX2(x1);
                            temp.setY2(y1);
                            before = true;
                            
                        }
                    }
                }
                if (!before) { 
                    Triangle t =  (Triangle) Classes.triangleShapeFactory.createshape("triangle",currentColor,x1, y1, x1, y1, x1, y1);
                    shapes.add(t);
                    
                }
                repaint();

                break;
            case 2:
                Circle c = (Circle) Classes.Shapefactory.createshape("circle",currentColor, x1, y1, x1, y1);
                shapes.add(c);
                repaint();
                
                break;
            case 3:
                Rectangle r = (Rectangle) Classes.Shapefactory.createshape("rectangle",currentColor, x1, y1, x1, y1);
                shapes.add(r);
                repaint();
                
                break;
            case 4:
                Square s = (Square) Classes.Shapefactory.createshape("square",currentColor, x1, y1, x2, y2);
                shapes.add(s);
                repaint();
                
                break;
            case 5:
                if (!shapes.isEmpty()) {
                    Shape tri = shapes.get(shapes.size() - 1);
                    if (tri instanceof FilledTriangle) {
                        FilledTriangle temp = (FilledTriangle) tri;
                        if (temp.getX1() == temp.getX2()) {
                            temp.setX2(x1);
                            temp.setY2(y1);
                            before = true;
                            
                        }
                    }
                }
                if (!before) {
                    FilledTriangle t = (FilledTriangle) Classes.triangleShapeFactory.createshape("filledtriangle",currentColor,x1, y1, x1, y1, x1, y1);
                    shapes.add(t);
                    
                }
                repaint();
                break;
            case 6:
                FilledCircle fc = (FilledCircle) Classes.Shapefactory.createshape("filledcircle",currentColor, x1, y1, x1, y1);
                shapes.add(fc);
                repaint();
                
                break;
            case 7:
                FilledSquare fs = (FilledSquare) Classes.Shapefactory.createshape("filledsquare",currentColor, x1, y1, x2, y2);
                shapes.add(fs);
                repaint();
                
                break;
            case 8:
                FilledRectangle fr = (FilledRectangle) Classes.Shapefactory.createshape("filledRectangle",currentColor, x1, y1, x1, y1);
                shapes.add(fr);
                repaint();
                
                break;

            case 9:

                for (int i = shapes.size() - 1; i >= 0; i--) {
                    if (shapes.get(i).contains(x1, y1)) {
                        selectedShape = shapes.get(i);
                        System.out.println("selected");
                        
                        break;
                    }
                }
                break;

            case 11:
                if (selectedShape != null) {
                    try {
                        Shape sh = (Shape) selectedShape.clone();
                        sh.setX1(sh.getX1() - 40);
                        sh.setX2(sh.getX2() - 40);
                        sh.setY1(sh.getY1() - 40);
                        sh.setY2(sh.getY2() - 40);
                        System.out.println("copied");
                        shapes.add(sh);
                        repaint();
                        
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case 12:
                if (selectedShape != null) {
                   
                    System.out.println("click");
                }
                break;

            case 13:
                undo();
                System.out.println("undo");                
                break;

            case 14:
                redo();
                System.out.println("redo");
                break;
            case 15:
                if (selectedShape != null) {
                    shapes.remove(selectedShape);
                    repaint();
                    break;
                }
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        try {   
            undo.push(copy(shapes));
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (shapes.size() > 0) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = shapes.get(shapes.size() - 1);
            switch (mode) {
                case 0:
                    if (s instanceof Line) {
                        Line l = (Line) s;
                        l.setX2(x2);
                        l.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                case 1:
                    x3 = me.getX();
                    y3 = me.getY();
                    if (s instanceof Triangle) {
                        Triangle t = (Triangle) s;
                        t.setX3(x2);
                        t.setY3(y2);
                        repaint();
                    }
                    first = false;
                    break;
                case 2:
                    if (s instanceof Circle) {
                        Circle c = (Circle) s;
                        c.setX2(x2);
                        c.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                case 3:
                    if (s instanceof Rectangle) {
                        Rectangle r = (Rectangle) s;
                        r.setX2(x2);
                        r.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                case 4:
                    if (s instanceof Square) {
                        Square sq = (Square) s;
                        sq.setX2(x2);
                        sq.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                case 5:
                    x3 = me.getX();
                    y3 = me.getY();
                    if (s instanceof FilledTriangle) {
                        FilledTriangle t = (FilledTriangle) s;
                        t.setX3(x2);
                        t.setY3(y2);
                        repaint();
                    }
                    first = false;
                    break;
                case 6:
                    if (s instanceof FilledCircle) {
                        FilledCircle fc = (FilledCircle) s;
                        fc.setX2(x2);
                        fc.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                case 7:
                    if (s instanceof FilledSquare) {
                        FilledSquare fsq = (FilledSquare) s;
                        fsq.setX2(x2);
                        fsq.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                case 8:
                    if (s instanceof FilledRectangle) {
                        FilledRectangle fr = (FilledRectangle) s;
                        fr.setX2(x2);
                        fr.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                case 10:
                    x3 = me.getX();
                    y3 = me.getY();
                    if (selectedShape != null) {
                        s = (Shape) selectedShape;
                        s.setX2(x3);
                        s.setY2(y3);
                        x2 = x3;
                        y2 = y3;
                        repaint();
                    }
                    break;

                case 12:
                    if (selectedShape != null) {
                        Shape s1 = selectedShape;
                        if (s1 instanceof Triangle ) {
                            Triangle t =(Triangle) s1;
                            s1.setX1(s1.getX1() + x2 - x1);
                            s1.setY1(s1.getY1() + y2 - y1);
                            s1.setX2(s1.getX2() + x2 - x1);
                            s1.setY2(s1.getY2() + y2 - y1);
                            t.setX3(t.getX3() + x2 - x1);
                            t.setY3(t.getY3() + y2 - y1);
                            x1 = x2;
                            y1 = y2;
                            repaint();
                            break;
                        }else if(s1 instanceof FilledTriangle){
                            FilledTriangle t =(FilledTriangle) s1;
                            s1.setX1(s1.getX1() + x2 - x1);
                            s1.setY1(s1.getY1() + y2 - y1);
                            s1.setX2(s1.getX2() + x2 - x1);
                            s1.setY2(s1.getY2() + y2 - y1);
                            t.setX3(t.getX3() + x2 - x1);
                            t.setY3(t.getY3() + y2 - y1);
                            x1 = x2;
                            y1 = y2;
                            repaint();
                            break;                                                
                        } else {
                            s1.setX1(s1.getX1() + x2 - x1);
                            s1.setY1(s1.getY1() + y2 - y1);
                            s1.setX2(s1.getX2() + x2 - x1);
                            s1.setY2(s1.getY2() + y2 - y1);
                            x1 = x2;
                            y1 = y2;
                            repaint();
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Must Select a Shape!");
        }

    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    private class ClickListener extends MouseAdapter {

    }

    private class DragListener extends MouseMotionAdapter {

    }
}
