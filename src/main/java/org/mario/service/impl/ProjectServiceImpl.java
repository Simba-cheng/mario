package org.mario.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mario.constant.CommConstant;
import org.mario.constant.ErrorMsgEnum;
import org.mario.persistent.ProjectRepository;
import org.mario.persistent.bean.Project;
import org.mario.service.ProjectService;
import org.mario.vo.error.ErrorInfo;
import org.mario.vo.response.RespHandlerProjectVo;
import org.mario.vo.response.SearchAllProjectVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CYX
 * @create 2019-02-20-22:41
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public SearchAllProjectVO searchAllProject() {

        SearchAllProjectVO allProjectVO = new SearchAllProjectVO();
        List<String> projectNames = new ArrayList<String>();

        try {
            List<Project> projects = projectRepository.findAll();

            if (CollectionUtils.isNotEmpty(projects)) {
                for (Project project : projects) {
                    projectNames.add(project.getProjectName());
                }
            }

            allProjectVO.setProjectNames(projectNames);
            allProjectVO.setSuccessFlag(CommConstant.STRING_Y);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            ErrorInfo errorInfo = new ErrorInfo(ErrorMsgEnum.ERR_06.getErrorCode(), ErrorMsgEnum.ERR_06.getErrorMsg());
            allProjectVO.setErrorInfo(errorInfo);
            allProjectVO.setSuccessFlag(CommConstant.STRING_N);
        }

        return allProjectVO;
    }


    @Override
    public RespHandlerProjectVo addProject(String projectName) {

        RespHandlerProjectVo addProjectVo = new RespHandlerProjectVo();

        //check
        checkProjectName(projectName, addProjectVo);
        if (StringUtils.isNotEmpty(addProjectVo.getSuccessFlag())) {
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

        try {
            //check
            checkProjectName(projectName, deleteProjectVo);
            projectNameisContains(projectName, deleteProjectVo);
            if (StringUtils.isNotEmpty(deleteProjectVo.getSuccessFlag())) {
                return deleteProjectVo;
            }

            projectRepository.deleteProjectByProjectName(projectName);

            deleteProjectVo.setSuccessFlag(CommConstant.STRING_Y);
            deleteProjectVo.setCopyWriting("删除项目：" + projectName + "成功！");

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            deleteProjectVo.setErrorInfo(new ErrorInfo(ErrorMsgEnum.ERR_04.getErrorCode(), ErrorMsgEnum.ERR_04.getErrorMsg()));
            deleteProjectVo.setSuccessFlag(CommConstant.STRING_N);
        }

        return deleteProjectVo;
    }

    /**
     * 判断projectName是否存在
     *
     * @param projectName      项目名称
     * @param handlerProjectVo
     * @return true-不存在 false-存在
     * @throws Exception
     */
    private void projectNameisContains(String projectName, RespHandlerProjectVo handlerProjectVo) {

        boolean result = Boolean.FALSE;

        //check
        Project project = projectRepository.findProjectByProjectName(projectName);
        if (null == project || StringUtils.isEmpty(project.getProjectName())) {
            result = Boolean.TRUE;
        }

        //项目不存在
        if (result) {
            ErrorInfo errorInfo = new ErrorInfo(ErrorMsgEnum.ERR_05.getErrorCode(), ErrorMsgEnum.ERR_05.getErrorMsg());
            handlerProjectVo.setErrorInfo(errorInfo);
            handlerProjectVo.setSuccessFlag(CommConstant.STRING_N);
        }
    }

    /**
     * 校验projectName 并返回错误信息
     *
     * @param projectName
     */
    private void checkProjectName(String projectName, RespHandlerProjectVo handlerProjectVo) {
        if (StringUtils.isEmpty(projectName)) {
            ErrorInfo errorInfo = new ErrorInfo(ErrorMsgEnum.ERR_00.getErrorCode(), ErrorMsgEnum.ERR_00.getErrorMsg());
            handlerProjectVo.setErrorInfo(errorInfo);
            handlerProjectVo.setSuccessFlag(CommConstant.STRING_N);
        }
    }

}
