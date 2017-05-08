/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class Order
{
    private List<OrderLine> lines;
    private int total;

    public Order()
    {
        lines = new ArrayList<>();
        total = 0;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void addLine(String desc, int amount, int price)
    {
        lines.add(new OrderLine(desc, amount, price));
        total += amount*price;
        if(Debug.on)
        {
            classConstraint();
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for(OrderLine line : lines)
        {
            int lineTotal = line.getAmount()*line.getPrice();
            res.append(StringUtil.setLength(line.getDescription(), 25));
            res.append(" ");
            res.append(StringUtil.setLength(""+line.getAmount(), 5));
            res.append(" ");
            res.append(StringUtil.setLength(""+line.getPrice(), 5));
            res.append(" ");
            res.append(lineTotal);
            res.append('\n');
        }
                   
        res.append("\nTotal: ");
        res.append(total);
        return res.toString();
    }
    
    private void classConstraint()
    {
        int sum = 0;
        for(OrderLine line : lines)
        {
            
            sum += line.getAmount()*line.getPrice();
        }
        if(sum != total)
        {
            throw new RuntimeException("The sum does not add up to total!");
        }
    }
    
}
