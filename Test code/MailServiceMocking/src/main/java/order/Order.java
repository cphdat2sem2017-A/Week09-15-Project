
package order;

/**
 *
 * @author tm
 */
public class Order {

    private MailService mailer;   
    private String item;
    private int amount;
    private boolean isFilled;

    public Order(String i, int a) {
        item = i;
        amount = a;
    }
   void setMailer(MailService mailer) {
        this.mailer = mailer;
   }
    
    
    public void fill(Warehouse wh) {
        if (wh.hasInventory(item, amount)) {
            wh.remove(item, amount);
            isFilled = true;
        }
        else mailer.send("out of stock"); 
    }

    public boolean isFilled() {
        return isFilled;
    }

 
}
