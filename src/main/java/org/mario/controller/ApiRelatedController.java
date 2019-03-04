package org.mario.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mario.constant.NumberEnum;
import org.mario.service.ApiManageService;
import org.mario.vo.response.RespAddApiInterfaceVO;
import org.mario.vo.response.RespDeleteApiVO;
import org.mario.vo.response.RespQueryApiByProtNameVO;
import org.mario.vo.response.RespQueryInfoByApiNameVO;
import org.mario.vo.response.RespSaveParamDataVO;
import org.mario.vo.response.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * API相关操作
 *
 * @author CYX
 * @create 2019-02-23-13:21
 */
@Controller
@RequestMapping(value = "/")
public class ApiRelatedController extends BasicController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiRelatedController.class);

    @Autowired
    private ApiManageService apiManageService;

    public static Gson gson = (new GsonBuilder()).enableComplexMapKeySerialization().create();

    /**
     * 新增接口
     *
     * @param data
     * @param request
     * @param response
     */
    @PostMapping(value = "addApi.do")
    public void addApiInterface(String data, HttpServletRequest request, HttpServletResponse response) {
        String methodName = "ApiRelatedController#addApiInterface";
        LOGGER.info("methodName:{} , data:{}", new Object[]{methodName, data});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        RespAddApiInterfaceVO addApiInterfaceVO = apiManageService.addNewApi(data);
        resultVO.setResultData(addApiInterfaceVO);

        String resultJson = gson.toJson(resultVO);

        super.returnAjaxRequestData(methodName,resultJson,response);
    }

    /**
     * 根据projectName，查询所有API
     *
     * @param projectName 项目名称
     * @param request
     * @param response
     */
    @PostMapping(value = "queryAllApiList.do")
    public void queryAllApiInterByProName(String projectName, HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ApiRelatedController#queryAllApiInterByProName";
        LOGGER.info("methodName:{} , projectName:{}", new Object[]{methodName, projectName});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        RespQueryApiByProtNameVO queryApiByProtNameVO = apiManageService.queryApiByProjectName(projectName);
        resultVO.setResultData(queryApiByProtNameVO);

        String resultJson = gson.toJson(resultVO);

        super.returnAjaxRequestData(methodName,resultJson,response);
    }

    /**
     * 根据API名称 查询 API内容
     *
     * @param apiName  API名称
     * @param request
     * @param response
     */
    @PostMapping(value = "queryApiInfoByApiName.do")
    public void queryApiInfoByApiName(String apiName, HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ApiRelatedController#queryApiInfoByApiName";
        LOGGER.info("methodName:{} , apiName:{}", new Object[]{methodName, apiName});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        RespQueryInfoByApiNameVO infoByApiNameVO = apiManageService.queryApiInfoByApiName(apiName);
        resultVO.setResultData(infoByApiNameVO);

        String resultJson = gson.toJson(resultVO);

        super.returnAjaxRequestData(methodName,resultJson,response);
    }

    /**
     * 保存/更新 参数结构数据
     *
     * @param request
     * @param response
     */
    @PostMapping(value = "saveParamData.do")
    public void saveParamData(String data, HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ApiRelatedController#saveParamData";
        LOGGER.info("methodName:{} , data:{}", new Object[]{methodName, data});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        RespSaveParamDataVO saveParamDataVO = apiManageService.updateParamDataWithApiName(data);
        resultVO.setResultData(saveParamDataVO);

        String resultJson = gson.toJson(resultVO);

        super.returnAjaxRequestData(methodName,resultJson,response);
    }

    /**
     * 删除接口信息
     *
     * @param apiName
     * @param request
     * @param response
     */
    @PostMapping(value = "deleteApi.do")
    public void deleteApiInterface(String apiName, HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ApiRelatedController#deleteApiInterface";
        LOGGER.info("methodName:{} , apiName:{}", new Object[]{methodName, apiName});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        RespDeleteApiVO respDeleteApiVO = apiManageService.deleteApiInterface(apiName);
        resultVO.setResultData(respDeleteApiVO);

        String resultJson = gson.toJson(resultVO);

        super.returnAjaxRequestData(methodName,resultJson,response);
    }

    /**
     * 更新接口信息
     *
     * @param data
     * @param request
     * @param response
     */
    @PostMapping(value = "updateApi.do")
    public void updateApiInterface(String data, HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ApiRelatedController#updateApiInterface";
        LOGGER.info("methodName:{} , data:{}", new Object[]{methodName, data});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

    }
}
