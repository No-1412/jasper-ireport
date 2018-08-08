package shiro;

import com.kingdom.model.User;
import com.kingdom.service.UserService;
import com.kingdom.utils.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shiro.proxy.CglibProxy;

import java.io.IOException;

/**
 * @author No.1412
 * @version 2018/5/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-context.xml")
public class UserTest {

    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void generateUser() {
//        SqlSession session = sqlSessionFactory.openSession();
//        UserDao userDao = session.getMapper(UserDao.class);
//        User user = new User();
//        user.setName("No.1412");
//        user.setLoginName("Sora");
//        String password = "123456";
//        byte[] salt = generateRandom();
//        Sha256Hash hash = new Sha256Hash(password, ByteSource.Util.bytes(salt), hashIterations);
//        user.setPassword(Hex.encodeToString(salt) + hash.toHex());
//        userDao.insertSelective(user);
//        UserService userService = CglibProxy.createByAgent(UserService.class);
        User user = new User();
        user.setLoginName("Aqua");
        user.setName("阿库娅");
        user.setLoginFlag(1);
        user.setRemarks("水姐");
        user.setPassword(SecurityUtils.encryptPassword("123456"));

        userService.generateUser(user);
        System.out.println(user.getLoginName());
        logger.info("插入成功 name-> {}", user.getName());
//        session.commit();
//        session.close();
    }

    @Test
    public void updateUser() {
        User user = userService.getById(56);
        user.setPassword(SecurityUtils.encryptPassword("123456"));
        user.setName("怪盜基德");
        user.setLoginFlag(1);
        user.setRemarks("No.1412");
        userService.updateUser(user);
        logger.info("修改成功 name-> {}", user.getName());
    }

    /**
     * 封装代理方法
     */
    public <T> T createByAgent(Class<T> superclass) {
        net.sf.cglib.proxy.Enhancer enhancer = new net.sf.cglib.proxy.Enhancer();
//        Class<UserService> superclass = UserService.class;
        enhancer.setSuperclass(superclass);
        enhancer.setCallback(new CglibProxy());
        return (T) enhancer.create();
    }

    @Test
    public void getUser() throws IOException {
        final UserService userService = new UserService();
//        UserService userService = CglibProxy.createByAgent(UserService.class);

//            new Thread(() -> {
//                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Sora").getName());
//                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Riku").getName());
//                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Sora").getName());
//                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Riku").getName());
//            }).start();
            new Thread(
        new Runnable() {
            @Override
            public void run() {

                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Sora").getName());
                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Riku").getName());
                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Sora").getName());
                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Riku").getName());
            }
        }
            ).start();
//        String name = userService.findByUsername("Sora").getName();
//        System.out.println(name+" 4444444444444444444");
        Thread thread = new Thread() {
            @Override
            public void run() {
                String name = userService.findByUsername("Sora").getName();
                System.out.println(Thread.currentThread().getName() + "-------------- aaaaaaaaaaaaaaaaaaaaaaa ---------->" + name);
                logger.info(Thread.currentThread().getName() + "------->" + name);
                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Riku").getName());
                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Sora").getName());
                logger.info(Thread.currentThread().getName() + "------->" + userService.findByUsername("Riku").getName());
                System.out.println(0x455555);
            }
        };
        thread.start();
        System.out.println("============> > >" + userService);
    }

    public static void main(String[] args) {

//        byte[] salt = generateRandom();
//        Sha256Hash sha256Hash = new Sha256Hash("123456", salt, 512);
//        logger.info("salt-> {}", Hex.encodeToString(salt));
//        logger.info("加密后的密码-> {}", sha256Hash);
//        logger.info("存入数据库的最终密码-> {}", Hex.encodeToString(salt) + sha256Hash);


//        Random random = new Random();
//        System.out.println();
//        for(int i=0;i<8;i++)
//        {
//            int i1 = random.nextInt();
//            System.out.println(i1);
//            System.out.println(Integer.toHexString(i1));
//        }

//        byte[] bytes = {127};
//        System.out.println(Hex.encodeToString(bytes));
//        System.out.println(Integer.toHexString(1));
//        for (;;) {
//            byte[] bytes = new byte[16];
//            SecureRandom secureRandom = new SecureRandom();
//            secureRandom.nextBytes(bytes);
//            System.out.println(Hex.encodeToString(bytes));
//        }

//        raw-> 64339827
//        hex-> 3d5bf73
//        String hex = Integer.toHexString(64339827);
//        int i = Integer.parseInt(hex, 16);
//        System.out.println(i);
//        for (;;) {
//            int i = generateRandom();
//            System.out.println("raw-> "+i);
//            System.out.println("hex-> "+Integer.toHexString(i));
//        }

//        System.out.println("===========================================================================================================================");
//        System.out.println((char) 97);
//        System.out.println("威斯克-> "+ Integer.toHexString(15));
//        TODO: 2018/5/18 生成随机数加在密码前做盐
//        String string = generateRandom().toString();
//        System.out.println("随机数-> "+string);
//        System.out.println(Integer.toHexString(Integer.parseInt(string)));
//        ByteSource salt = ByteSource.Util.bytes(string);
//        Sha256Hash sha256Hash = new Sha256Hash("123456", salt, 512);
//        SystemAuthorizingRealm.password = salt.toBase64() + sha256Hash.toBase64();
//        System.out.println("密码生成-> " + SystemAuthorizingRealm.password);
//        System.out.println("============================================== 开始登陆 ===================================================");
//        String password = "123456";
//        String newSalt = SystemAuthorizingRealm.password.substring(0, 16);
//        byte[] decode = Base64.decode(newSalt);
//        Sha256Hash sha256Hash1 = new Sha256Hash(password, decode, 512);
//        System.out.println(newSalt + sha256Hash1.toBase64());
//        System.out.println(SystemAuthorizingRealm.password);
    }

}
