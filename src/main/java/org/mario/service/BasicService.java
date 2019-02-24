package org.mario.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author CYX
 * @create 2019-02-23-14:04
 */
public interface BasicService {

    /**
     * 向页面输出结果
     *
     * @param response
     * @param jsonStr  string型json字符串
     */
    void flushResultToPage(HttpServletResponse response, String jsonStr);

}
