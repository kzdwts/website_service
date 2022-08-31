package top.ky.website.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 页面数据
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
@Data
@ToString
public class PageData implements Serializable {

    private Integer type;

    private String data;
}
