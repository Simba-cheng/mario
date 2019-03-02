package org.mario.vo.response;

import lombok.Data;
import org.mario.vo.error.ErrorInfo;

/**
 * @author CYX
 * @date: 2019/2/27 10:39
 */
@Data
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
}
