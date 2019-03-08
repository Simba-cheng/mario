package org.mario.vo.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author CYX
 * @create 2019-03-08-20:27
 */
@Data
@Valid
public class ReqUpdataApiInfoVO {

    /**
     * api接口内部编号，根据数据库id自增长
     */
    @NotNull(message = "API接口内部编号为空，请联系维护者检查！")
    private Integer apiId;

    /**
     * 项目/应用名称
     */
    @NotNull(message = "项目/应用名称 不能为空")
    private String projectName;

    /**
     * API编号
     */
    @NotNull(message = "API编号不能为空！")
    private String apiNum;

    /**
     * API接口名称
     */
    @NotNull(message = "API接口名称不能为空！")
    private String apiName;

    /**
     * API路径(包.类.方法名)
     */
    @NotNull(message = "包.类.方法名不能为空！")
    private String apiPath;

    /**
     * API URL(https://localhost:8888/test.do)
     */
    @NotNull(message = "API URL 不能为空！")
    private String apiURL;

    /**
     * API请求方式
     */
    @NotNull(message = "API请求方式不能为空！")
    private String requestMethod;

    /**
     * 使用终端
     */
    @NotNull(message = "使用终端不能为空！")
    private String terminal;

    /**
     * 开发人员
     */
    @NotNull(message = "开发人员不能为空！")
    private String coder;

    /**
     * 产品
     */
    private String product;

}
