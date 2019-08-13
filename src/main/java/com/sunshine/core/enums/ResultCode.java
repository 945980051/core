/**
 * 
 */
package com.health.core.enums;

/**
 * @author 张梓枫
 * @Description
 * @date:   2019年1月3日 下午4:24:08
 */
public enum ResultCode {

    OK(200,"成功"), 
    FAIL(201,"失败"), 
    INVALID(9999,"登陆失效"), 
    USER_NO_ACCESS(202,"无权访问"),
    ANNULLED(204,"无效的token"),
    USER_NO_LOGIN(203,"用户未登录");

    private int value;
    
    private String msg;

    private ResultCode(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int value() {
        return value;
    }
    
    public String msg() {
        return msg;
    }
}
