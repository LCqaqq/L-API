package com.lc.lapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lc.lapi.model.entity.InterfaceInfo;

/**
* @author admin
* @description 针对表【interface_info】的数据库操作Service
* @createDate 2024-05-01 14:40:22
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean b);
}
