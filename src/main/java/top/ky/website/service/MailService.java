package top.ky.website.service;

import javax.mail.MessagingException;

/**
 * 邮件发送业务
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
public interface MailService {
    void sendMail(Integer type, String data);

    void complexMail() throws MessagingException;
}
