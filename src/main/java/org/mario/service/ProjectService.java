package org.mario.service;

import org.mario.vo.response.RespHandlerProjectVo;
import org.mario.vo.response.SearchAllProjectVO;

/**
 * 项目/应用 service接口
 *
 * @author CYX
 * @create 2019-02-20-22:36
 */
public interface ProjectService {

    /**
     * 查询所有项目
     */
    SearchAllProjectVO searchAllProject();

    /**
     * 新增 项目/应用
     *
     * @param projectName 项目名称
     */
    RespHandlerProjectVo addProject(String projectName);

    /**
     * 删除 项目/应用
     *
     * @param projectName 项目名称
     */
    RespHandlerProjectVo deleteProject(String projectName);
}
