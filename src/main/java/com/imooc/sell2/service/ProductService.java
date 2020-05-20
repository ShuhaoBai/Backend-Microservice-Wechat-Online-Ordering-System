package com.imooc.sell2.service;

import com.imooc.sell2.dataobject.ProductInfo;
import com.imooc.sell2.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Shuhao Bai on 9/11/19
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * Check and return all products in the inventory
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);
}
