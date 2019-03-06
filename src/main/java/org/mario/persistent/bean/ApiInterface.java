package org.mario.persistent.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * API接口 - 映射数据库表
 *
 * @author CYX
 * @create 2019-02-20-22:19
 */
@Data
@Entity
@Table(name = "apiInterface")
public class ApiInterface {

    /**
     * api接口内部编号，根据数据库id自增长
     */
    @Id
    @GeneratedValue
    @Column(name = "apiId", nullable = false)
    private Integer apiId;

    /**
     * 项目/应用名称
     */
    @Column(name = "projectName", nullable = false)
    private String projectName;

    /**
     * API编号
     */
    @Column(name = "apiNum", nullable = false)
    private String apiNum;

    /**
     * API接口名称
     */
    @Column(name = "apiName", nullable = false)
    private String apiName;

    /**
     * API路径(包.类.方法名)
     */
    @Column(name = "apiPath", nullable = false)
    private String apiPath;

    /**
     * API URL(https://localhost:8888/test.do)
     */
    @Column(name = "apiURL", nullable = false)
    private String apiURL;

    /**
     * API请求方式
     */
    @Column(name = "requestMethod", nullable = false)
    private String requestMethod;

    /**
     * 使用终端
     */
    @Column(name = "terminal", nullable = false)
    private String terminal;

    /**
     * 开发人员
     */
    @Column(name = "coder", nullable = false)
    private String coder;

    /**
     * 产品
     */
    @Column(name = "product")
    private String product;

    /**
     * 请求入参结构
     */
    @Column(name = "requestParam", nullable = false, length = 90000)
    private String requestParam;

    /**
     * 请求出参结构
     */
    @Column(name = "responseParam", nullable = false, length = 90000)
    private String responseParam;

    public ApiInterface(String projectName, String apiNum, String apiPath, String apiURL, String requestMethod, String terminal, String coder, String product, String requestParam, String responseParam) {
        this.projectName = projectName;
        this.apiNum = apiNum;
        this.apiPath = apiPath;
        this.apiURL = apiURL;
        this.requestMethod = requestMethod;
        this.terminal = terminal;
        this.coder = coder;
        this.product = product;
        this.requestParam = requestParam;
        this.responseParam = responseParam;
    }

    public ApiInterface() {
    }
}
