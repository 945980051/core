/**
 * 
 */
package com.sunshine.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import com.github.pagehelper.Page;
import com.sunshine.common.exception.BLogicException;
import com.sunshine.common.utils.ObjectUtils;

/**
 * @author 张梓枫
 * @Description bean操作类
 * @date:   2019年1月3日 下午4:57:14
 */
public class BeanUtils {
    
    private static Converter converter = new HealthConverter();

    public static <S,T> void copy(S s, T t) {
        BeanCopier copier = BeanCopier.create(s.getClass(), t.getClass(), true);
        copier.copy(s, t, converter);
    }
    
    public static <S,T> Page<T> copyPage(List<S> sList, Class<T> clazz) throws InstantiationException, IllegalAccessException{
        if (!(sList instanceof Page)) {
            throw new BLogicException("传入的数据格式不正确!");
        }
        Page<S> page = (Page<S>)sList;
        Page<T> tPage = new Page<T>(page.getPageNum(),page.getPageSize());
        tPage.setTotal(page.getTotal());
        tPage.setPages(page.getPages());
        List<T> tList = copy(sList, clazz);
        tPage.addAll(tList);
        return tPage;
    }
    
    public static <S,T> List<T> copy(List<S> sList, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        if (ObjectUtils.isEmpty(sList)) {
            return new ArrayList<>();
        }
        BeanCopier copier = BeanCopier.create(sList.get(0).getClass(), clazz, true);
        List<T> tList = new ArrayList<T>();
        for (S s : sList) {
            T t = clazz.newInstance();
            copier.copy(s, t, converter);
            tList.add(t);
        }
        return tList;
    }
}
