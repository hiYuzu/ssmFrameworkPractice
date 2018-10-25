import com.alibaba.fastjson.JSON;
import com.zxy.crud.pojo.Students;
import com.zxy.crud.service.IStudentsService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestService {
    private static Logger logger = Logger.getLogger(TestService.class);

    @Autowired
    private IStudentsService studentsService;

    @Test
    public void test(){
        Students students = studentsService.getStuById(1);
        logger.info(JSON.toJSONString(students));
    }
}
