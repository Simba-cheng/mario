package org.mario.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mario.constant.CommConstant;
import org.mario.constant.ErrorMsgEnum;
import org.mario.constant.NumberEnum;
import org.mario.persistent.ApiIntegerRepository;
import org.mario.persistent.bean.ApiInterface;
import org.mario.service.ApiManageService;
import org.mario.util.JsonUtils;
import org.mario.util.PubUtils;
import org.mario.vo.error.ErrorInfo;
import org.mario.vo.request.ReqApiInterInfoVO;
import org.mario.vo.request.ReqSaveParamDataVO;
import org.mario.vo.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CYX
 * @create 2019-02-20-22:40
 */
@Service
public class ApiManageServiceImpl implements ApiManageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiManageServiceImpl.class);

    @Autowired
    private ApiIntegerRepository apiIntegerRepository;

    @Override
    public RespAddApiInterfaceVO addNewApi(String data) {

        RespAddApiInterfaceVO addApiInterfaceVO = new RespAddApiInterfaceVO();
        List<RespApiInfoVO> respApiInfoVOS = new ArrayList<RespApiInfoVO>();

        if (null == data) {
            addApiInterfaceVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_07.getErrorCode(), ErrorMsgEnum.ERR_07.getErrorMsg()));
            addApiInterfaceVO.setSuccessFlag(CommConstant.STRING_N);
            return addApiInterfaceVO;
        }

        try {

            //check
            ReqApiInterInfoVO apiInterInfoVO = JsonUtils.toJavaObject(data, ReqApiInterInfoVO.class);
            List<String> errorInfo = PubUtils.validateObjectField(apiInterInfoVO);
            if (CollectionUtils.isNotEmpty(errorInfo)) {
                //默认选择第一个报错
                addApiInterfaceVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_08.getErrorCode(), errorInfo.get(0)));
                addApiInterfaceVO.setSuccessFlag(CommConstant.STRING_N);
                return addApiInterfaceVO;
            }

            //入参copy
            ApiInterface apiInterfaceBo = new ApiInterface();
            BeanUtils.copyProperties(apiInterInfoVO, apiInterfaceBo);

            //process
            ApiInterface apiInterface = apiIntegerRepository.save(apiInterfaceBo);

            //出参copy
            RespApiInfoVO respApiInfoVO = new RespApiInfoVO();
            BeanUtils.copyProperties(apiInterface, respApiInfoVO);

            //特殊处理
            respApiInfoVO.setRequestMethod(respApiInfoVO.getRequestMethod().toUpperCase());
            respApiInfoVOS.add(respApiInfoVO);

            addApiInterfaceVO.setSuccessFlag(CommConstant.STRING_Y);
            addApiInterfaceVO.setApiInfos(respApiInfoVOS);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            addApiInterfaceVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_08.getErrorCode(), ErrorMsgEnum.ERR_08.getErrorMsg()));
            addApiInterfaceVO.setSuccessFlag(CommConstant.STRING_N);
            return addApiInterfaceVO;
        }

        return addApiInterfaceVO;
    }

    @Override
    public RespQueryApiByProtNameVO queryApiByProjectName(String projectName) {

        RespQueryApiByProtNameVO queryApiByProtNameVO = new RespQueryApiByProtNameVO();

        //check
        if (StringUtils.isEmpty(projectName)) {
            queryApiByProtNameVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_00.getErrorCode(), ErrorMsgEnum.ERR_00.getErrorMsg()));
            queryApiByProtNameVO.setSuccessFlag(CommConstant.STRING_N);
            return queryApiByProtNameVO;
        }

        List<RespApiInfoVO> respApiInfoVOS = new ArrayList<RespApiInfoVO>();
        try {
            List<ApiInterface> apiInterfaces = apiIntegerRepository.findAllByProjectName(projectName);

            if (CollectionUtils.isNotEmpty(apiInterfaces)) {

                for (ApiInterface apiInterface : apiInterfaces) {

                    //copy
                    RespApiInfoVO apiInfoVO = new RespApiInfoVO();
                    BeanUtils.copyProperties(apiInterface, apiInfoVO);

                    //特殊处理
                    apiInfoVO.setRequestMethod(apiInfoVO.getRequestMethod().toUpperCase());

                    respApiInfoVOS.add(apiInfoVO);
                }
            }
            queryApiByProtNameVO.setApiInfos(respApiInfoVOS);
            queryApiByProtNameVO.setSuccessFlag(CommConstant.STRING_Y);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            queryApiByProtNameVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_09.getErrorCode(), ErrorMsgEnum.ERR_09.getErrorMsg()));
            queryApiByProtNameVO.setSuccessFlag(CommConstant.STRING_N);
            return queryApiByProtNameVO;
        }
        return queryApiByProtNameVO;
    }

    @Override
    public RespQueryInfoByApiNameVO queryApiInfoByApiName(String apiName) {

        RespQueryInfoByApiNameVO infoByApiNameVO = new RespQueryInfoByApiNameVO();

        //check
        if (StringUtils.isEmpty(apiName)) {
            infoByApiNameVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_11.getErrorCode(), ErrorMsgEnum.ERR_11.getErrorMsg()));
            infoByApiNameVO.setSuccessFlag(CommConstant.STRING_N);
            return infoByApiNameVO;
        }

        try {
            ApiInterface apiInterface = apiIntegerRepository.findByApiName(apiName);

            if (null != apiInterface) {

                //copy
                RespApiInfoVO apiInfoVO = new RespApiInfoVO();
                BeanUtils.copyProperties(apiInterface, apiInfoVO);

                //特殊处理
                apiInfoVO.setRequestMethod(apiInfoVO.getRequestMethod().toUpperCase());
                infoByApiNameVO.setApiInfo(apiInfoVO);
                infoByApiNameVO.setSuccessFlag(CommConstant.STRING_Y);
            } else {
                infoByApiNameVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_10.getErrorCode(), ErrorMsgEnum.ERR_10.getErrorMsg()));
                infoByApiNameVO.setSuccessFlag(CommConstant.STRING_N);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            infoByApiNameVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_10.getErrorCode(), ErrorMsgEnum.ERR_10.getErrorMsg()));
            infoByApiNameVO.setSuccessFlag(CommConstant.STRING_N);
            return infoByApiNameVO;
        }

        return infoByApiNameVO;
    }

    @Override
    public RespSaveParamDataVO updateParamDataWithApiName(String data) {

        RespSaveParamDataVO saveParamDataVO = new RespSaveParamDataVO();

        //check
        ReqSaveParamDataVO reqSaveParamDataVO = JsonUtils.toJavaObject(data, ReqSaveParamDataVO.class);
        List<String> errorInfos = PubUtils.validateObjectField(reqSaveParamDataVO);
        if (CollectionUtils.isNotEmpty(errorInfos)) {
            saveParamDataVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_12.getErrorCode(), errorInfos.get(0)));
            saveParamDataVO.setSuccessFlag(CommConstant.STRING_N);
            return saveParamDataVO;
        }

        Integer result = null;
        try {
            if (NumberEnum.ONE_STR.getNumStr().equals(reqSaveParamDataVO.getParamFlag())) {
                result = apiIntegerRepository.updateInputParamDataWithApiName(reqSaveParamDataVO.getApiName(), reqSaveParamDataVO.getParamData());
            } else if (NumberEnum.TWO_STR.getNumStr().equals(reqSaveParamDataVO.getParamFlag())) {
                result = apiIntegerRepository.updateOutParamDataWithApiName(reqSaveParamDataVO.getApiName(), reqSaveParamDataVO.getParamData());
            }

            if (null != result && result > 0) {

                RespApiInfoVO apiInfoVO = new RespApiInfoVO();
                BeanUtils.copyProperties(result, apiInfoVO);

                saveParamDataVO.setCopyWriting("保存/更新 参数结构成功！");
                saveParamDataVO.setSuccessFlag(CommConstant.STRING_Y);
            } else {
                saveParamDataVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_12.getErrorCode(), ErrorMsgEnum.ERR_12.getErrorMsg()));
                saveParamDataVO.setSuccessFlag(CommConstant.STRING_N);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            saveParamDataVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_12.getErrorCode(), ErrorMsgEnum.ERR_12.getErrorMsg()));
            saveParamDataVO.setSuccessFlag(CommConstant.STRING_N);
            return saveParamDataVO;
        }

        return saveParamDataVO;
    }

    @Override
    public RespDeleteApiVO deleteApiInterface(String apiName) {

        RespDeleteApiVO respDeleteApiVO = new RespDeleteApiVO();

        if (StringUtils.isEmpty(apiName)) {
            respDeleteApiVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_00.getErrorCode(), ErrorMsgEnum.ERR_00.getErrorMsg()));
            respDeleteApiVO.setSuccessFlag(CommConstant.STRING_N);
            return respDeleteApiVO;
        }

        Integer result;
        try {

            result = apiIntegerRepository.deleteApiInterfaceByApiName(apiName);

            if (null != result && result > 0) {
                respDeleteApiVO.setCopyWriting("删除API接口成功！");
                respDeleteApiVO.setSuccessFlag(CommConstant.STRING_Y);
            } else {
                respDeleteApiVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_14.getErrorCode(), ErrorMsgEnum.ERR_14.getErrorMsg()));
                respDeleteApiVO.setSuccessFlag(CommConstant.STRING_N);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            respDeleteApiVO.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_13.getErrorCode(), ErrorMsgEnum.ERR_13.getErrorMsg()));
            respDeleteApiVO.setSuccessFlag(CommConstant.STRING_N);
            return respDeleteApiVO;
        }

        return respDeleteApiVO;
    }

    @Override
    public void updateApiInterface() {

    }

}
