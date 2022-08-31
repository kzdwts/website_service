package top.ky.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ky.website.domain.PageData;
import top.ky.website.service.MailService;
import top.ky.website.service.PageService;

/**
 * page
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private MailService mailService;

    @Override
    public void sendSimple(PageData pageData) {
        mailService.sendMail(pageData.getType(), pageData.getData());
    }
}
