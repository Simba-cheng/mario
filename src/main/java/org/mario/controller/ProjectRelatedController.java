package org.mario.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mario.constant.NumberEnum;
import org.mario.service.BasicService;
import org.mario.service.ProjectService;
import org.mario.vo.response.RespHandlerProjectVo;
import org.mario.vo.response.ResultVO;
import org.mario.vo.response.SearchAllProjectVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目相关操作
 *
 * @author CYX
 * @date: 2019/2/27 10:19
 */
@Controller
@RequestMapping(value = "/")
public class ProjectRelatedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRelatedController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private BasicService basicService;

    public static Gson gson = (new GsonBuilder()).enableComplexMapKeySerialization().create();

    /**
     * 查询所有项目名称
     *
     * @param request
     * @param response
     */
    @GetMapping(value = "/searchAllProject.do")
    public void searchAllProject(HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ProjectRelatedController#searchAllProject";
        LOGGER.info("methodName : {}", new Object[]{methodName});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        SearchAllProjectVO allProjectVO = projectService.searchAllProject();
        resultVO.setResultData(allProjectVO);

        String resultJson = gson.toJson(resultVO);
        LOGGER.info("methodName :{},result info : {}", new Object[]{methodName, resultJson});

        basicService.flushResultToPage(response, resultJson);
    }

    /**
     * @param projectName 项目名称
     * @param request
     * @param response
     */
    @PostMapping(value = "addProject.do")
    public void addProject(String projectName, HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ProjectRelatedController#addProject";
        LOGGER.info("methodName : {} , projectName : {}", new Object[]{methodName, projectName});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        RespHandlerProjectVo handlerProjectVo = projectService.addProject(projectName);
        resultVO.setResultData(handlerProjectVo);

        String resultJson = gson.toJson(resultVO);
        LOGGER.info("methodName :{},result info : {}", new Object[]{methodName, resultJson});

        basicService.flushResultToPage(response, resultJson);
    }

    /**
     * 删除项目
     *
     * @param projectName 项目名称
     * @param request
     * @param response
     */
    @PostMapping(value = "deletePorject.do")
    public void deleteProject(String projectName, HttpServletRequest request, HttpServletResponse response) {

        String methodName = "ProjectRelatedController#deleteProject";
        LOGGER.info("methodName : {} , projectName : {}", new Object[]{methodName, projectName});

        ResultVO resultVO = new ResultVO();
        resultVO.setSuccessFlag(NumberEnum.ONE_STR.getNumStr());

        RespHandlerProjectVo handlerProjectVo = projectService.deleteProject(projectName);
        resultVO.setResultData(handlerProjectVo);

        String resultJson = gson.toJson(resultVO);
        LOGGER.info("methodName :{},result info : {}", new Object[]{methodName, resultJson});

        basicService.flushResultToPage(response, resultJson);
    }

}
