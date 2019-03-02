package org.mario.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @author CYX
 * @date: 2019/2/28 17:45
 */
@Data
public class RespQueryApiByProtNameVO extends ResponseVO {

    private List<RespApiInfoVO> apiInfos;

}
