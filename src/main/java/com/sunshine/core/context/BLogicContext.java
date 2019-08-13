/**
 * 
 */
package com.sunshine.core.context;

import java.util.HashMap;
import java.util.Map;

import com.sunshine.common.context.ContextHolder;
import com.sunshine.common.utils.ObjectUtils;

/**
 * @author 张梓枫
 * @Description 系统上下文对象
 * @date:   2019年1月3日 下午5:08:56
 */
public class BLogicContext extends ContextHolder{

    private static ThreadLocal<Map<String, Object>> threadLocalMap = new ThreadLocal<Map<String, Object>>();
    
    public static void setValue(String key, Object value) {
        Map<String, Object> map = threadLocalMap.get();
        if (ObjectUtils.isEmpty(map)) {
            map = new HashMap<String, Object>();
            threadLocalMap.set(map);
        }
        map.put(key, value);
    }
    
    public static Object getValue(String key) {
        Map<String, Object> map = threadLocalMap.get();
        return ObjectUtils.isEmpty(map) ? null : map.get(key);
    }
    
    public static void setMap(Map<String, Object> map) {
        threadLocalMap.set(map);
    }
    
    public static Map<String, Object> getMap() {
        return threadLocalMap.get();
    }
    
    public static void clear() {
        threadLocalMap.remove();
    }
}
