package org.mario.vo.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author CYX
 * @date: 2019/2/28 22:30
 */
@Valid
public class ReqSaveParamDataVO {

    /**
     * API 名称
     */
    @NotNull(message = "API名称为空")
    private String apiName;

    /**
     * 参数结构
     */
    @NotNull(message = "参数结构为空")
    private String paramData;

    /**
     * paramFlag 参数标示(1-入参 2-出参)
     */
    @NotNull(message = "参数标示为空")
    private String paramFlag;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getParamFlag() {
        return paramFlag;
    }

    public void setParamFlag(String paramFlag) {
        this.paramFlag = paramFlag;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReqSaveParamDataVO{");
        sb.append("apiName='").append(apiName).append('\'');
        sb.append(", paramData='").append(paramData).append('\'');
        sb.append(", paramFlag='").append(paramFlag).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
