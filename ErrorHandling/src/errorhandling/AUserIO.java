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
public abstract class AUserIO implements UserIO
{

    /**
     *
     * @return
     */
    @Override
    public abstract String getLine();
    @Override
    public abstract void print(String s);
    
    @Override
    public void printLine(String s)
    {
        print(s + "\n");
    }
    
    @Override
    public int getInt(int min, int max)
    {
        //Precondition
        if(Debug.on)
        {
            if(min > max)
            {
                throw new RuntimeException("min must be less than or equal to max. min is " + min + ", max is " + max + ".");
            }
        }
        while(true)
        {
            String s = getLine();
            try
            {
                int i = Integer.parseInt(s);
                if(i < min || i > max)
                {
                    printLine("You must enter an integer between " + min + " and " + max + ".");
                }
                else
                {
                    return i;
                }
            }
            catch(NumberFormatException e)
            {
                printLine("You must enter an integer.");
            }
        }
    }
}
