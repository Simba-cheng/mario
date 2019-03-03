package org.mario.constant;

/**
 * @author CYX
 * @create 2019-02-20-22:44
 */
public enum ErrorMsgEnum {

    ERR_00("MARIO_API_ERROR_00", "项目名称为空，请检查"),
    ERR_01("MARIO_API_ERROR_01", "项目名称已存在！"),
    ERR_02("MARIO_API_ERROR_02", "保存项目名称失败，请稍后再试"),
    ERR_03("MARIO_API_ERROR_03", "删除项目失败"),
    ERR_04("MARIO_API_ERROR_04", "删除项目异常"),
    ERR_05("MARIO_API_ERROR_05", "项目名称不存在"),
    ERR_06("MARIO_API_ERROR_06", "查询所有项目名称失败"),
    ERR_07("MARIO_API_ERROR_07", "保存API接口信息失败，参数为空，请检查！"),
    ERR_08("MARIO_API_ERROR_08", "保存API接口信息接口异常！"),
    ERR_09("MARIO_API_ERROR_09", "查询API列表异常！"),
    ERR_10("MARIO_API_ERROR_10", "查询API接口信息异常！"),
    ERR_11("MARIO_API_ERROR_11", "API名称为空，请检查！"),
    ERR_12("MARIO_API_ERROR_12", "保存参数结构数据异常！"),
    ERR_13("MARIO_API_ERROR_13", "删除API接口异常！"),
    ERR_14("MARIO_API_ERROR_13", "删除API接口失败！");

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    ErrorMsgEnum() {
    }

    ErrorMsgEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "ErrorMsgEnum{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
