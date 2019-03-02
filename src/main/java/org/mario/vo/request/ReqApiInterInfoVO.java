package org.mario.vo.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author CYX
 * @date: 2019/2/28 14:17
 */
@Data
@Valid
public class ReqApiInterInfoVO {

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

    /**
     * 请求入参结构
     */
    private String requestParam;

    /**
     * 请求出参结构
     */
    private String responseParam;
}
