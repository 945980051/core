/**
 * 
 */
package com.sunshine.core.utils;

import java.util.List;

import com.github.pagehelper.Page;
import com.health.core.bean.ResponseBean;
import com.health.core.enums.ResultCode;
import com.health.core.enums.ResultMsg;

/**
 * @author 张梓枫
 * @Description 接口返回类型工具类
 * @date:   2019年1月3日 下午2:25:16
 */
public class ResponseUtils {

    public static <T> ResponseBean<List<T>> createRet(ResultCode status,List<T> list) {
        ResponseBean<List<T>> bean = new ResponseBean<>(status.value());
        if (list == null) {
            return bean;
        }
        if (list instanceof Page) {
            return getPageDatas(list, bean);
        }
        bean.setDatas(list);
        return bean;
    }
    
    private static <T> ResponseBean<List<T>> getPageDatas(List<T> list,ResponseBean<List<T>> bean) {
        Page<T> page = (Page<T>)list;
        bean.setDatas(page.getResult());
        bean.setPageNum(page.getPageNum());
        bean.setPageSize(page.getPageSize());
        bean.setTotal(page.getTotal());
        bean.setPageTotals(page.getPages());
        return bean;
    }
    
    public static <T> ResponseBean<List<T>> createRet(ResultCode status,List<T> list,Long total,Integer pageNum,Integer pageSize) {
        ResponseBean<List<T>> bean = new ResponseBean<>(status.value());
        if (total == 0) {
            return bean;
        }
        bean.setDatas(list);
        bean.setPageNum(pageNum);
        bean.setPageSize(pageSize);
        bean.setTotal(total);
        return bean;
    }
    
    public static <T> ResponseBean<T> createRet(ResultCode status, T data) {
        ResponseBean<T> bean = new ResponseBean<T>(status.value(), data);
        return bean;
    }
    
    public static <T> ResponseBean<T> createRet(ResultCode status, String meeeage) {
        ResponseBean<T> bean = new ResponseBean<T>(status.value());
        bean.setMsg(meeeage);;
        return bean;
    }
    
    public static <T> ResponseBean<T> createRet(ResultCode status, ResultMsg msg) {
        ResponseBean<T> bean = new ResponseBean<T>(status.value());
        bean.setMsg(msg.msg());;
        return bean;
    }
    
    public static <T> ResponseBean<T> createRet(ResultCode status) {
        ResponseBean<T> bean = new ResponseBean<T>(status.value());
        bean.setMsg(status.msg());
        return bean;
    }
}
