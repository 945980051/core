/**
 * 
 */
package com.health.core.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 张梓枫
 * @Description
 * @date:   2019年1月3日 下午2:18:29
 */
@Data
@ApiModel(description = "返回参数")
public class ResponseBean<T> {

    @ApiModelProperty(value = "返回状态", dataType = "Integer", example = "100", required = true)
    private Integer responseCode;

    @ApiModelProperty(value = "消息提示", dataType = "String", example = "成功", required = true)
    private String msg;

    @ApiModelProperty(value = "返回数据", dataType = "Object", example = "", required = true)
    private T datas;

    @ApiModelProperty(value = "分页数据总条数", dataType = "long", example = "1000", required = true)
    private Long total;

    @ApiModelProperty(value = "分页当前页数", dataType = "int", example = "1", required = true)
    private Integer pageNum;

    @ApiModelProperty(value = "分页显示条数", dataType = "int", example = "10", required = true)
    private Integer pageSize;
    
    @ApiModelProperty(value = "分页总页数", dataType = "int", example = "10", required = true)
    private Integer pageTotals;

    public ResponseBean() {
        super();
    }
    
    public ResponseBean(Integer responseCode) {
        this(responseCode,null);
    }

    public ResponseBean(Integer responseCode, T datas) {
        super();
        this.responseCode = responseCode;
        this.datas = datas;
    }
    
}
