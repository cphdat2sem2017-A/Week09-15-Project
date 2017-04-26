package order;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tm
 */
public class OrderStateTester {

    private static String TALISKER = "Talisker";

    @Test
    public void testOrderSendsMailIfUnfilled() {
        Order order = new Order(TALISKER, 51);
        MailServiceStub mailer = new MailServiceStub();
        WarehouseStub warehouse = new WarehouseStub();
        order.setMailer(mailer);
        order.fill(warehouse);
        assertEquals(1, mailer.numberSent());
    }
}
