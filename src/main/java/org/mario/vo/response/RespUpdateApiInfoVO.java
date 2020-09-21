package org.mario.vo.response;

/**
 * @author CYX
 * @create 2019-03-08-20:23
 */
public class RespUpdateApiInfoVO extends ResponseVO {

    private RespApiInfoVO respApiInfoVO;

    public RespApiInfoVO getRespApiInfoVO() {
        return respApiInfoVO;
    }

    public void setRespApiInfoVO(RespApiInfoVO respApiInfoVO) {
        this.respApiInfoVO = respApiInfoVO;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RespUpdateApiInfoVO{");
        sb.append("respApiInfoVO=").append(respApiInfoVO);
        sb.append('}');
        return sb.toString();
    }
}
