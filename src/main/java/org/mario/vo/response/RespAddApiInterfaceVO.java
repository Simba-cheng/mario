package org.mario.vo.response;

import java.util.List;

/**
 * @author CYX
 * @date: 2019/2/28 14:50
 */

public class RespAddApiInterfaceVO extends ResponseVO {

    private List<RespApiInfoVO> apiInfos;

    public List<RespApiInfoVO> getApiInfos() {
        return apiInfos;
    }

    public void setApiInfos(List<RespApiInfoVO> apiInfos) {
        this.apiInfos = apiInfos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RespAddApiInterfaceVO{");
        sb.append("apiInfos=").append(apiInfos);
        sb.append('}');
        return sb.toString();
    }
}
