package com.lc.lapi.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.lc.lapi.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询请求
 *
 * @author yupi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoQueryRequest extends PageRequest implements Serializable {

    /**
     * 序号
     */
    @TableId
    private Integer id;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 请求头
     */
    private String requestheade;

    /**
     * 响应头
     */
    private String responseheade;

    /**
     * 接口状态 0-关闭  1-开启
     */
    private Integer status;

    /**
     * 创建人
     */
    private Long userid;

}