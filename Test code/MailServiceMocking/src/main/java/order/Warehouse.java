package order;

/**
 *
 * @author tm
 */
public interface Warehouse {

    public boolean hasInventory(String item, int amount);

    public void remove(String item, int amount);
}
