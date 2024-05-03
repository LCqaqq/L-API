package com.lc.lapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.lapi.common.ErrorCode;
import com.lc.lapi.exception.BusinessException;
import com.lc.lapi.mapper.InterfaceInfoMapper;
import com.lc.lapi.model.entity.InterfaceInfo;
import com.lc.lapi.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @description 针对表【interface_info】的数据库操作Service实现
 * @createDate 2024-05-01 14:40:22
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo> implements InterfaceInfoService {
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null)
            throw new BusinessException(ErrorCode.PARAMS_ERROR);

        String name = interfaceInfo.getName();
        if (add) {
            if (!StringUtils.isNotBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (!StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
    }
}




