/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

/**
 *
 * @author Tobias
 */
public class ErrorHandling
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        Order order = new Order();
        
        order.addLine("Tomater", 6, 1200);
        order.addLine("Trillebør", 1, 65000);
        order.addLine("Bolte 6mmx120mm", 80, 300);
        
        System.out.println(order);
    }
    
}
