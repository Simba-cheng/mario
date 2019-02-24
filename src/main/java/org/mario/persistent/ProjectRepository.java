package org.mario.persistent;

import org.mario.persistent.bean.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 项目/应用 - JPA接口
 *
 * @author CYX
 * @create 2019-02-20-22:31
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    /**
     * 根据pId查询项目/应用
     *
     * @param pId
     * @return
     */
    Project findProjectByPId(Integer pId);

    /**
     * 根据项目名称查询
     *
     * @param projectName
     * @return
     */
    Project findProjectByProjectName(String projectName);

    /**
     * 根据项目名称删除
     *
     * @param projectName
     * @return
     */
    Project deleteProjectByProjectName(String projectName);

}
