/**
 * 
 */
package com.health.core.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 张梓枫
 * @Description 主键父类
 * @date:   2019年1月8日 上午10:16:31
 */
@Data
public class IdBean<PK> implements Serializable{
  
    private static final long serialVersionUID = -1040146011908687921L;
    /**
     * 主键
     */
    private PK id;
    
}
