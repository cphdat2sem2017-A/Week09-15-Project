package order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tm
 */
public class MailServiceStub implements MailService {

    private List<String> messages = new ArrayList<String>();

    public void send(String msg) {
        messages.add(msg);
    }

    public int numberSent() {
        return messages.size();
    }
}
