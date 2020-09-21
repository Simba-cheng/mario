package org.mario.vo.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author CYX
 * @date: 2019/2/28 14:17
 */
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApiNum() {
        return apiNum;
    }

    public void setApiNum(String apiNum) {
        this.apiNum = apiNum;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReqApiInterInfoVO{");
        sb.append("projectName='").append(projectName).append('\'');
        sb.append(", apiNum='").append(apiNum).append('\'');
        sb.append(", apiName='").append(apiName).append('\'');
        sb.append(", apiPath='").append(apiPath).append('\'');
        sb.append(", apiURL='").append(apiURL).append('\'');
        sb.append(", requestMethod='").append(requestMethod).append('\'');
        sb.append(", terminal='").append(terminal).append('\'');
        sb.append(", coder='").append(coder).append('\'');
        sb.append(", product='").append(product).append('\'');
        sb.append(", requestParam='").append(requestParam).append('\'');
        sb.append(", responseParam='").append(responseParam).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
