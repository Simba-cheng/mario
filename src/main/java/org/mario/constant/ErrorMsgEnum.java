package org.mario.constant;

/**
 * @author CYX
 * @create 2019-02-20-22:44
 */
public enum ErrorMsgEnum {

    ERR_00("MARIO_API_ERROR_00", "项目名称为空，请检查"),
    ERR_01("MARIO_API_ERROR_01", "项目名称已存在！");

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
