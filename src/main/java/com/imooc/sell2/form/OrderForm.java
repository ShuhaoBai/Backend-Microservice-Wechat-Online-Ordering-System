package com.imooc.sell2.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Shuhao Bai on 9/19/19
 */
@Data
public class OrderForm {

    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Phone number is required")
    private String phone;
    @NotEmpty(message = "Address is required")
    private String address;
    @NotEmpty(message = "openin is required")
    private String openid;
    @NotEmpty(message = "Shop cart cannot be empty")
    private String items;
}
