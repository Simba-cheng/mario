package org.mario.vo.response;

import org.mario.vo.error.ErrorInfo;

/**
 * @author CYX
 * @date: 2019/2/27 10:39
 */
public class ResponseVO {

    /**
     * 标识符
     */
    private String successFlag;

    /**
     * 错误信息
     */
    private ErrorInfo errorInfo;

    /**
     * 文案
     */
    private String copyWriting;

    public ResponseVO(String successFlag, ErrorInfo errorInfo, String copyWriting) {
        this.successFlag = successFlag;
        this.errorInfo = errorInfo;
        this.copyWriting = copyWriting;
    }

    public ResponseVO() {
    }

    public String getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(String successFlag) {
        this.successFlag = successFlag;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getCopyWriting() {
        return copyWriting;
    }

    public void setCopyWriting(String copyWriting) {
        this.copyWriting = copyWriting;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseVO{");
        sb.append("successFlag='").append(successFlag).append('\'');
        sb.append(", errorInfo=").append(errorInfo);
        sb.append(", copyWriting='").append(copyWriting).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
