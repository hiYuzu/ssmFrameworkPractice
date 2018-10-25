import com.zxy.crud.dao.IStudentsDao;
import com.zxy.crud.pojo.Students;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IStudentsDao studentsDao;

    @Test
    public void testSelectByPrimaryKey(){
        int stuId = 1;
        Students students = studentsDao.selectByPrimaryKey(stuId);
        logger.info("students={}", students);
        System.out.println(students.getStuName());
    }
}
