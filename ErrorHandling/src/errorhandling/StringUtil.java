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
public class StringUtil
{
    public static String setLength(String str, int length)
    {
        //Preconditions:
        if(Debug.on)
        {
            if(str == null) throw new NullPointerException("str may not be null!");
            if(length < 5) throw new IllegalArgumentException("length must be at least 5!");  
        }
        
        String res;
        //Method implementation
        if(str.length() < length)
        {
            StringBuilder builder = new StringBuilder(str);
            for(int i = str.length(); i < length; ++i)
            {
                builder.append(' ');
            }
            res = builder.toString();
        }
        else if(str.length() > length)
        {
            res = str.substring(0, length-3) + "...";
        }
        else
        {
            res = str;
        }
        
        //Postcondition
        if(Debug.on)
        {
            if(res.length() != length)
            {
                throw new RuntimeException("There is an error in the implementation of this method!");
            }
        }
        
        return res;
    }
}
