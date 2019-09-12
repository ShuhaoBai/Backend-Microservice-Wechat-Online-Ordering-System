package com.imooc.sell2.controller;

import com.imooc.sell2.VO.ProductInfoVO;
import com.imooc.sell2.VO.ProductVO;
import com.imooc.sell2.VO.ResultVO;
import com.imooc.sell2.dataobject.ProductCategory;
import com.imooc.sell2.dataobject.ProductInfo;
import com.imooc.sell2.service.CategoryService;
import com.imooc.sell2.service.ProductService;
import com.imooc.sell2.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author Shuhao Bai on 9/11/19
 */

@RestController //返回的是Json格式
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //从数据库里查询出来，并且展示 ：
        //第一步和第二步都是对数据库的查询
        //1. 查询所有的上架商品 - 上面需要@Autowire ProductService
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目（一次性查询） - 上面需要@Autowire CategoryService
        //List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for(ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法Java8
        List<Integer> categoryTypeList = productInfoList.stream().
                map(e -> e.getCategoryType()).
                collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO =new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }




//        ResultVO resultVO = new ResultVO();
//
//        resultVO.setData(productVOList);
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");


        return ResultVOUtil.success(productVOList)  ;
    }
}
