package top.ky.website.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.ky.website.controller.PageController;
import top.ky.website.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * 邮件发送
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
@Service
public class MailServiceImpl implements MailService {

    private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;

    @Value("${website.to_email}")
    private String toEmail;

    /**
     * 发送简单的邮件
     *
     * @param type {@link Integer}
     * @param data {@link String}
     * @return {@link null}
     * @author Kang Yong
     * @date 2022/8/30
     */
    @Async
    @Override
    public void sendMail(Integer type, String data) {
        //邮件设置
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("新消息提醒");
        message.setText(data);
        message.setTo(toEmail);
        message.setFrom(mailProperties.getUsername());
        javaMailSender.send(message);
        log.info("===发送短信：END===");
    }

    /**
     * 复杂的邮件
     *
     * @author Kang Yong
     * @date 2022/8/30
     */
    @Override
    public void complexMail(Integer type, String data) throws MessagingException {
        //1、创建一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        //邮件主题
        helper.setSubject("这是一个邮件啊");
        //文本中添加图片
//        helper.addInline("image1",new FileSystemResource("D:\\images\\spring\\1.jpg"));
        //邮件内容
        helper.setText(this.structHtml(data), true);
        helper.setTo(toEmail);
        helper.setFrom(mailProperties.getUsername());
        //附件添加图片
//        helper.addAttachment("1.jpg",new File("D:\\images\\spring\\1.jpg"));
        //附件添加word文档
//        helper.addAttachment("哈哈哈.docx",new File("D:\\images\\spring\\哈哈哈.docx"));

        javaMailSender.send(mimeMessage);
    }

    private String structHtml(String data) {
        // 数据
        JSONObject json = JSONObject.parseObject(data);

        // 拼接
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\" style=\"border-collapse: collapse;\">");
        // 遍历拼接
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            log.info("{}->{}", entry.getKey(), entry.getValue());
            sb.append("<tr>");
            sb.append("<th>" + entry.getKey() + "</th>");
            sb.append("<td>" + entry.getValue() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");

        return sb.toString();
    }
}
