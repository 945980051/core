/**
 * 
 */
package com.health.core.constant;

/**
 * @author 张梓枫
 * @Description 系统静态变量类
 * @date:   2019年1月2日 上午9:44:34
 */
public abstract class ConfigConstant {

    public static final String SCAN_BASE_PACKAGES = "com.health";
    
    public static final String SESSION_USER = "SESSION_USER";
    
    public final static String CONTENT_TYPE = "application/json;UTF-8";
    
    public static final String SESSION_TOKEN = "Authorization";
    
    public final static String PATH = "/**";
    
    public static final String IMAGE_BASE64_DATA = "data:image/";
    
    public static final String IMAGE_BASE64 = ";base64,";
    /**
     * response自定义返回headers
     */
    public static final String EXPOSE_HEADERS = "Access-Control-Expose-Headers";
    
    public static final String SYSTEM_ERROR = "意外错误，请稍后重试!";
    
    public static final String TIMEZONE = "GMT+8";
    
}
