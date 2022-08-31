package top.ky.website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ky.website.core.RespResult;
import top.ky.website.domain.PageData;
import top.ky.website.service.PageService;

/**
 * page
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private PageService pageService;

    @PostMapping("/page/save")
    public RespResult save(@RequestBody PageData pageData) {
        log.info("===接收到请求：{}", pageData);
        pageService.sendSimple(pageData);
        return RespResult.ok();
    }

}
