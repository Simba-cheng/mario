package org.mario.vo.response;

import lombok.Data;

/**
 * @author CYX
 * @date: 2019/2/28 16:06
 */
@Data
public class RespApiInfoVO {

    /**
     * api接口内部编号，根据数据库id自增长
     */
    private Integer apiId;

    /**
     * 项目/应用名称
     */
    private String projectName;

    /**
     * API编号
     */
    private String apiNum;

    /**
     * API接口名称
     */
    private String apiName;

    /**
     * API路径(包.类.方法名)
     */
    private String apiPath;

    /**
     * API URL(https://localhost:8888/test.do)
     */
    private String apiURL;

    /**
     * API请求方式
     */
    private String requestMethod;

    /**
     * 使用终端
     */
    private String terminal;

    /**
     * 开发人员
     */
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
