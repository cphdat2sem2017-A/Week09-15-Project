/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tm
 */
class WarehouseStub implements Warehouse{
    
    @Override
    public boolean hasInventory(String item, int amount) {
        if (amount > 50)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
    

    @Override
    public void remove(String item, int amount) {
     }
    
}
