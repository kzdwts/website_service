package top.ky.website.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ky.website.domain.PageData;
import top.ky.website.service.MailService;
import top.ky.website.service.PageService;

import javax.mail.MessagingException;

/**
 * page
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
@Slf4j
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private MailService mailService;

    @Override
    public void sendSimple(PageData pageData) {
        try {
            log.info("===START===");
            mailService.complexMail(pageData.getType(), pageData.getData());
            log.info("===END===");
        } catch (MessagingException e) {
            log.error("===短信发送失败");
            e.printStackTrace();
        }
    }
}
