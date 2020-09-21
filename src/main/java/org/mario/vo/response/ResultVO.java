package org.mario.vo.response;

/**
 * @author CYX
 * @create 2019-02-23-13:56
 */
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

    public String getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(String successFlag) {
        this.successFlag = successFlag;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultVO{");
        sb.append("successFlag='").append(successFlag).append('\'');
        sb.append(", resultData=").append(resultData);
        sb.append('}');
        return sb.toString();
    }
}
