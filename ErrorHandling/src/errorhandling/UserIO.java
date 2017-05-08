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
public interface UserIO
{
    public void printLine(String s);
    public void print(String s);
    public String getLine();
    public int getInt(int min, int max);
}
