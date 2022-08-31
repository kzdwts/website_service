package top.ky.website.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendMail1() {
        mailService.sendMail(1, "测试发送邮件");
    }

}