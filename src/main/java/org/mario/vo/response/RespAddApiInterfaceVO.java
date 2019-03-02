package org.mario.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @author CYX
 * @date: 2019/2/28 14:50
 */
@Data
public class RespAddApiInterfaceVO extends ResponseVO {

    private List<RespApiInfoVO> apiInfos;

}
