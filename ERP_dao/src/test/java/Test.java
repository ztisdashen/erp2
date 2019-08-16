import com.dao.IDepDao;
import com.dao.impl.EmpDaoImpl;
import com.entity.Dep;
import com.entity.Emp;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-17 14:39
 **/
public class Test {
    @SuppressWarnings({"unchecked","deprecated"})
    @org.junit.jupiter.api.Test
    void Test() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext_dao.xml");
        EmpDaoImpl empDao = ac.getBean("empDao", EmpDaoImpl.class);
        List<Emp> list = (List<Emp>) empDao.getHibernateTemplate().find("from Emp where username=?1 and pwd=?2", "admin", "admin");
        System.out.println(list.get(0));
    }

    @org.junit.jupiter.api.Test
    void text(){

        Md5Hash md5Hash = new Md5Hash("1234567","sunwukong",2);
        System.out.println(md5Hash.toString());

    }
}
