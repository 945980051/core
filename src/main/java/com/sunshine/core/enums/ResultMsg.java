/**
 * 
 */
package com.health.core.enums;

/**
 * @author 张梓枫
 * @Description
 * @date:   2019年1月11日 上午9:14:35
 */
public enum ResultMsg {
    
    insert("新增成功"),
    update("修改成功"),
    delete("删除成功");
    
    private String msg;
    
    private ResultMsg(String msg) {
        this.msg = msg;
    }
    
    public String msg() {
        return msg;
    }
}
