import com.trade.ace.entity.TradeUser;
import com.trade.ace.mapper.TradeUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: cks
 * @Date: Created by 19:33 2018/8/12
 * @Package: PACKAGE_NAME
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDao {

    @Autowired
    private TradeUserMapper tradeUserMapper;

    @Test
    public void test(){
        TradeUser user = new TradeUser();
        user.setUserName("张三");
        user.setUserPassword("123456");
        int i = tradeUserMapper.insert(user);
        System.out.println("i ="+ i);
    }
}
