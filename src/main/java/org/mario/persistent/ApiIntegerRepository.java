package org.mario.persistent;

import org.mario.persistent.bean.ApiInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * API接口 - JPA接口
 *
 * @author CYX
 * @create 2019-02-20-22:19
 */
public interface ApiIntegerRepository extends JpaRepository<ApiInterface, Integer> {

    /**
     * 根据 项目/应用编号 查询所有API接口
     *
     * @param pId 项目/应用编号
     * @return
     */
    List<ApiInterface> findAllByPId(Integer pId);

}
