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
public class OrderLine
{
    private String description;
    private int amount;
    private int price;

    public OrderLine(String description, int amount, int price)
    {
        this.description = description;
        this.amount = amount;
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public int getAmount()
    {
        return amount;
    }

    public int getPrice()
    {
        return price;
    }
    
    
}
