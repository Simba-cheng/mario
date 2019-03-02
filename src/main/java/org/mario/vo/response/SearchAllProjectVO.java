package org.mario.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @author CYX
 * @date: 2019/2/27 11:11
 */
@Data
public class SearchAllProjectVO extends ResponseVO {

    /**
     * 项目名称
     */
    private List<String> projectNames;

}
