package org.mario.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CYX
 * @create 2018-10-15-23:08
 */
public class JsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * JSON字符串转换为Java Bean对象
     *
     * @param json  JSON字符串
     * @param clazz
     * @param <T>
     * @return
     */
    public static final <T> T toJavaObject(String json, Class<T> clazz) {
        try {
            JSONObject jObject = JSONObject.parseObject(json);
            return JSONObject.toJavaObject(jObject, clazz);
        } catch (Exception e) {
            LOGGER.error("json : {} , e : {} , message : {}", new Object[]{json, e, e.getMessage()});
            return null;
        }
    }

    /**
     * Java Bean对象转换为JSON字符串
     *
     * @param object Java Bean对象
     * @return
     */
    public static final String toJSONStr(Object object) {
        String jsonStr = null;
        try {
            jsonStr = JSONObject.toJSONString(object);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return jsonStr;
    }

}
