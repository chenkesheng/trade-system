package trade.system;


import com.ace.trade.common.exception.AceMQException;
import com.ace.trade.common.rocketmq.AceMQproducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: cks
 * @Date: Created by 10:27 2018/8/12
 * @Package: trade.system
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ProducerTest {

    @Autowired
    private AceMQproducer producer;

    @Test
    public void testProducer() throws AceMQException {
       SendResult result = producer.senMessage("TestTopic","order","12345678","this is order message");
        System.out.println(result);
    }
}
