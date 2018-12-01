package hello;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class Receiver {

    private static final Logger logger =
            LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] message) {
        System.out.println("Received <" + new String(message) + ">");
        logger.info(new String(message));
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
