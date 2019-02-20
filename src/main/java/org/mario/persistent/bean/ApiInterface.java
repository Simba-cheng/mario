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
     * pId-项目/应用编号
     */
    @Id
    @GeneratedValue
    @Column(name = "apiId", nullable = false)
    private Integer apiId;

    /**
     * 项目应用名称
     */
    @Column(name = "pId", nullable = false)
    private String pId;

    /**
     * API编号
     */
    @Column(name = "apiNum", nullable = false)
    private String apiNum;

    /**
     * API路径
     */
    @Column(name = "apiPath", nullable = false)
    private String apiPath;

    /**
     * API
     */
    @Column(name = "apiURL", nullable = false)
    private String apiURL;

    /**
     * API请求方式
     */
    @Column(name = "requestMethod", nullable = false)
    private String requestMethod;

    /**
     * 开发人员
     */
    @Column(name = "coder", nullable = false)
    private String coder;

    /**
     * 产品
     */
    @Column(name = "product", nullable = false)
    private String product;

    /**
     * 请求入参结构
     */
    @Column(name = "requestParam", nullable = false, length = 500)
    private String requestParam;

    /**
     * 请求出参结构
     */
    @Column(name = "responseParam", nullable = false, length = 500)
    private String responseParam;

    public ApiInterface(String pId, String apiNum, String apiPath, String apiURL, String requestMethod, String coder, String product, String requestParam, String responseParam) {
        this.pId = pId;
        this.apiNum = apiNum;
        this.apiPath = apiPath;
        this.apiURL = apiURL;
        this.requestMethod = requestMethod;
        this.coder = coder;
        this.product = product;
        this.requestParam = requestParam;
        this.responseParam = responseParam;
    }

    public ApiInterface() {
    }
}
