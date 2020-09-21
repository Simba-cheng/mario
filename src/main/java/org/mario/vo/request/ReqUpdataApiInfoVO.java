package org.mario.vo.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author CYX
 * @create 2019-03-08-20:27
 */
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

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReqUpdataApiInfoVO{");
        sb.append("apiId=").append(apiId);
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append(", apiNum='").append(apiNum).append('\'');
        sb.append(", apiName='").append(apiName).append('\'');
        sb.append(", apiPath='").append(apiPath).append('\'');
        sb.append(", apiURL='").append(apiURL).append('\'');
        sb.append(", requestMethod='").append(requestMethod).append('\'');
        sb.append(", terminal='").append(terminal).append('\'');
        sb.append(", coder='").append(coder).append('\'');
        sb.append(", product='").append(product).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
