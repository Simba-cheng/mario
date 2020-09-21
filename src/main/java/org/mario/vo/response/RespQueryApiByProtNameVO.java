package org.mario.vo.response;

import java.util.List;

/**
 * @author CYX
 * @date: 2019/2/28 17:45
 */
public class RespQueryApiByProtNameVO extends ResponseVO {

    private List<RespApiInfoVO> apiInfos;

    public List<RespApiInfoVO> getApiInfos() {
        return apiInfos;
    }

    public void setApiInfos(List<RespApiInfoVO> apiInfos) {
        this.apiInfos = apiInfos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RespQueryApiByProtNameVO{");
        sb.append("apiInfos=").append(apiInfos);
        sb.append('}');
        return sb.toString();
    }
}
