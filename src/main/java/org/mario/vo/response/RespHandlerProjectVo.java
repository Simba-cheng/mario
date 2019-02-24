package org.mario.vo.response;

import lombok.Data;
import org.mario.vo.error.ErrorInfo;

/**
 * @author CYX
 * @create 2019-02-20-22:46
 */
@Data
public class RespHandlerProjectVo {

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

    public RespHandlerProjectVo(String successFlag, ErrorInfo errorInfo, String copyWriting) {
        this.successFlag = successFlag;
        this.errorInfo = errorInfo;
        this.copyWriting = copyWriting;
    }

    public RespHandlerProjectVo() {
    }
}
