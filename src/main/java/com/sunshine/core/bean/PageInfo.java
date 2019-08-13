/**
 * 
 */
package com.sunshine.core.bean;

import java.io.Serializable;

import com.sunshine.common.utils.ObjectUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @Description 分页参数类
 * @date:   2019年1月3日 上午9:46:00
 */
@ApiModel
@Data
public class PageInfo implements Serializable{

    private static final long serialVersionUID = 524366622970361020L;

    @ApiModelProperty("当前页码")
    private Integer pageNum;
    @ApiModelProperty("每页显示的条数")
    private Integer pageSize;
    @ApiModelProperty("排序字段")
    private String orderBy;
    
    public PageInfo(Integer pageNum, Integer pageSize) {
        this(pageNum,pageSize,null);
    }
    
    public PageInfo(Integer pageNum, Integer pageSize, String orderBy) {
        if (ObjectUtils.equals(pageNum, 0)) {
            pageNum = 1;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }
    
    
}
