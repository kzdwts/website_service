package top.ky.website.service;

import top.ky.website.domain.PageData;

/**
 * page
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
public interface PageService {
    /**
     * 发送邮件
     *
     * @param pageData {@link PageData}
     * @author Kang Yong
     * @date 2022/8/30
     */
    void sendSimple(PageData pageData);
}
