package com.imooc.sell2.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Seller Info Entity
 *
 * @author Shuhao Bai on 10/21/19
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
}
