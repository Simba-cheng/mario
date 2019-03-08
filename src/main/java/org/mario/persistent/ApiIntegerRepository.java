package org.mario.persistent;

import org.mario.persistent.bean.ApiInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * API接口 - JPA接口
 *
 * @author CYX
 * @create 2019-02-20-22:19
 */
@Repository
public interface ApiIntegerRepository extends JpaRepository<ApiInterface, Integer> {

    /**
     * 根据 项目/应用编号 查询所有API接口
     *
     * @param projectName 项目/应用编号
     * @return
     */
    List<ApiInterface> findAllByProjectName(String projectName);

    /**
     * 根据api名称查找API信息
     *
     * @param apiName
     * @return
     */
    ApiInterface findByApiName(String apiName);

    /**
     * API 入参更新
     * <p>
     * 使用原生SQL更新
     *
     * @param apiName   api名称
     * @param paramData 数据结构
     * @return
     */
    @Query(value = "update api_interface set request_param = ?2 where api_name = ?1", nativeQuery = true)
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    Integer updateInputParamDataWithApiName(String apiName, String paramData);

    /**
     * API 出参更新
     * <p>
     * 使用原生SQL更新
     *
     * @param apiName
     * @param paramData
     * @return
     */
    @Query(value = "update api_interface set response_param = ?2 where api_name = ?1", nativeQuery = true)
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    Integer updateOutParamDataWithApiName(String apiName, String paramData);

    /**
     * 根据apiName删除api接口
     *
     * @param apiName api名称
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    Integer deleteApiInterfaceByApiName(String apiName);

    /**
     *
     * @param apiId
     * @return
     */
    ApiInterface findApiInterfaceByApiId(Integer apiId);

}
