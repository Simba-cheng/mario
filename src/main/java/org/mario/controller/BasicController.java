package org.mario.controller;

import org.mario.service.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

/**
 * @author CYX
 * @create 2019-03-03-21:51
 */
public class BasicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private BasicService basicService;

    /**
     * 返回ajax请求的数据
     *
     * @param methodName
     * @param resultJson
     */
    public void returnAjaxRequestData(String methodName, String resultJson, HttpServletResponse response) {
        LOGGER.info("methodName :{},result info : {}", new Object[]{methodName, resultJson});
        try {
            basicService.flushResultToPage(response, resultJson);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
