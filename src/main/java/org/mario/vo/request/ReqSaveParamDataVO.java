package org.mario.vo.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author CYX
 * @date: 2019/2/28 22:30
 */
@Data
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

}
