package org.mario.vo.error;

import lombok.Data;

/**
 * @author CYX
 * @create 2019-02-23-14:00
 */
@Data
public class ErrorInfo {

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    public ErrorInfo(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ErrorInfo() {
    }
}
