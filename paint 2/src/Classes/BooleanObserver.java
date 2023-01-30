/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author asala
 */
public class BooleanObserver extends Observer{

    private Shape s;

    public BooleanObserver(Shape s) {
        this.s = s;
    }
    
    @Override
    public void update() {
        System.out.println("Observer"+ s.getColor());
    }
    
}
