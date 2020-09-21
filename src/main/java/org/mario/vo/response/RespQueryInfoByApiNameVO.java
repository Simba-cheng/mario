package org.mario.vo.response;

/**
 * @author CYX
 * @date: 2019/2/28 20:31
 */
public class RespQueryInfoByApiNameVO extends ResponseVO {

    private RespApiInfoVO apiInfo;

    public RespApiInfoVO getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(RespApiInfoVO apiInfo) {
        this.apiInfo = apiInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RespQueryInfoByApiNameVO{");
        sb.append("apiInfo=").append(apiInfo);
        sb.append('}');
        return sb.toString();
    }
}
