import com.alibaba.fastjson.JSON;
import com.zxy.ssm.pojo.User;
import com.zxy.ssm.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestService {
    private static Logger logger = Logger.getLogger(TestService.class);

    @Autowired
    private IUserService userService;

    @Test
    public void test(){
        List<User> list = userService.getUsers();
        logger.info(JSON.toJSONString(list));
    }
}
