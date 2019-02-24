package org.mario.service;

import org.mario.vo.response.RespHandlerProjectVo;

/**
 * 项目/应用 service接口
 *
 * @author CYX
 * @create 2019-02-20-22:36
 */
public interface ProjectService {

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

    /**
     * 更新/修改 项目/应用 名称
     *
     * @param projectName 项目名称
     */
    void updateProject(String projectName);
}
