package com.imooc.sell2.service;

import com.imooc.sell2.dataobject.SellerInfo;

/**
 * @author Shuhao Bai on 10/21/19
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
