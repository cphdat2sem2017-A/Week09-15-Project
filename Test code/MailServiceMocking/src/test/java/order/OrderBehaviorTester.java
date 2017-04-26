package order;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author tm
 */
public class OrderBehaviorTester {

    private static String TALISKER = "Talisker";

    @Test
    public void testOrderSendsMailIfUnfilled() {
        Order order = new Order(TALISKER, 51);
        Warehouse warehouseMock = mock(Warehouse.class);
        MailService mailMock = mock(MailService.class);
        order.setMailer(mailMock);

        when(warehouseMock.hasInventory(TALISKER, 51))
         .thenReturn(false);

        order.fill(warehouseMock);

        verify(warehouseMock).hasInventory(TALISKER, 51);
        verify(mailMock).send("out of stock");
    }
    
    @Test
    public void testOrderNotSendsMailIfFilled() {
        Order order = new Order(TALISKER, 50);
        Warehouse warehouseMock = mock(Warehouse.class);
        MailService mailMock = mock(MailService.class);
        order.setMailer(mailMock);
        
        when(warehouseMock.hasInventory(TALISKER, 50))
            .thenReturn(true);

        order.fill(warehouseMock);

        verify(warehouseMock).hasInventory(TALISKER, 50);
        verify(warehouseMock).remove(TALISKER, 50);
    }
}
