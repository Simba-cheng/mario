package org.mario.service.impl;

import org.apache.commons.lang.StringUtils;
import org.mario.constant.CommConstant;
import org.mario.constant.ErrorMsgEnum;
import org.mario.persistent.ProjectRepository;
import org.mario.persistent.bean.Project;
import org.mario.service.ProjectService;
import org.mario.vo.error.ErrorInfo;
import org.mario.vo.response.RespHandlerProjectVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CYX
 * @create 2019-02-20-22:41
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public RespHandlerProjectVo addProject(String projectName) {

        RespHandlerProjectVo addProjectVo = new RespHandlerProjectVo();

        //check
        if (StringUtils.isEmpty(projectName)) {
            ErrorInfo errorInfo = new ErrorInfo(ErrorMsgEnum.ERR_00.getErrorCode(), ErrorMsgEnum.ERR_00.getErrorMsg());
            addProjectVo.setErrorInfo(errorInfo);
            addProjectVo.setSuccessFlag(CommConstant.STRING_N);
            return addProjectVo;
        }

        //process
        try {

            //不存在则新增
            Project project = projectRepository.findProjectByProjectName(projectName);
            if (null == project) {
                //新增
                Project resultPro = projectRepository.save(new Project(projectName));
                addProjectVo.setSuccessFlag(CommConstant.STRING_Y);
                addProjectVo.setCopyWriting("添加项目：" + resultPro.getProjectName() + "成功！");

            } else {
                ErrorInfo errorInfo = new ErrorInfo(ErrorMsgEnum.ERR_01.getErrorCode(), ErrorMsgEnum.ERR_01.getErrorMsg());
                addProjectVo.setErrorInfo(errorInfo);
                addProjectVo.setSuccessFlag(CommConstant.STRING_N);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            ErrorInfo errorInfo = new ErrorInfo(ErrorMsgEnum.ERR_02.getErrorCode(), ErrorMsgEnum.ERR_02.getErrorMsg());
            addProjectVo.setErrorInfo(errorInfo);
            addProjectVo.setSuccessFlag(CommConstant.STRING_N);
        }

        return addProjectVo;
    }

    @Override
    public RespHandlerProjectVo deleteProject(String projectName) {

        RespHandlerProjectVo deleteProjectVo = new RespHandlerProjectVo();

        if (StringUtils.isEmpty(projectName)) {
            ErrorInfo errorInfo = new ErrorInfo(ErrorMsgEnum.ERR_00.getErrorCode(), ErrorMsgEnum.ERR_00.getErrorMsg());
            deleteProjectVo.setErrorInfo(errorInfo);
            deleteProjectVo.setSuccessFlag(CommConstant.STRING_N);
            return deleteProjectVo;
        }

        try {
            Project project = projectRepository.deleteProjectByProjectName(projectName);

            if (null != project) {
                deleteProjectVo.setSuccessFlag(CommConstant.STRING_Y);
                deleteProjectVo.setCopyWriting("删除项目：" + project.getProjectName() + "成功！");
            } else {

            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            deleteProjectVo.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_04.getErrorCode(), ErrorMsgEnum.ERR_04.getErrorMsg()));
            deleteProjectVo.setSuccessFlag(CommConstant.STRING_N);
        }

        return deleteProjectVo;
    }

}
