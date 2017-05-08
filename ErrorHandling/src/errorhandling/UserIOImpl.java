/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

import java.util.Scanner;

/**
 *
 * @author Tobias
 */
public class UserIOImpl extends AUserIO
{
    private Scanner scanner;

    public UserIOImpl()
    {
        scanner = new Scanner(System.in);
    }
    
    
    
    @Override
    public String getLine()
    {
        return scanner.nextLine();
    }

    @Override
    public void print(String s)
    {
        System.out.print(s);
    }
    
}
