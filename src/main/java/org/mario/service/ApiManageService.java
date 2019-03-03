package org.mario.service;

import org.mario.vo.response.*;

/**
 * API service 接口
 *
 * @author CYX
 * @create 2019-02-14-22:38
 */
public interface ApiManageService {

    /**
     * 新增API接口
     *
     * @param data 入参数据
     */
    RespAddApiInterfaceVO addNewApi(String data);

    /**
     * 根据项目名称 查询所有api接口
     *
     * @param projectName 项目名称
     */
    RespQueryApiByProtNameVO queryApiByProjectName(String projectName);

    /**
     * 根据API名称查询API信息
     *
     * @param apiName
     */
    RespQueryInfoByApiNameVO queryApiInfoByApiName(String apiName);

    /**
     * 更新api接口中入参、出参 数据结构
     *
     * @param data
     * @param
     */
    RespSaveParamDataVO updateParamDataWithApiName(String data);

    /**
     * 更新API接口
     */
    void updateApiInterface();

    /**
     * 删除API接口
     *
     * @param apiName API名称
     */
    RespDeleteApiVO deleteApiInterface(String apiName);

}
