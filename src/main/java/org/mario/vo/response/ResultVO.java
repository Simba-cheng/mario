package org.mario.vo.response;

import lombok.Data;

/**
 * @author CYX
 * @create 2019-02-23-13:56
 */
@Data
public class ResultVO {

    /**
     * 接口级别-成功失败标识
     * <p>
     * 1-成功
     */
    private String successFlag;

    /**
     * 数据节点
     */
    private Object resultData;

    public ResultVO(String successFlag, Object resultData) {
        this.successFlag = successFlag;
        this.resultData = resultData;
    }

    public ResultVO() {
    }

}
