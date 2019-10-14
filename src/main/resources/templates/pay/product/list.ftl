<html>
    <#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">
        <#--    sidebar-->
        <#include "../common/nav.ftl">

        <#--    content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Name</th>
                                <th>Product Icon</th>
                                <th>Price</th>
                                <th>Inventory</th>
                                <th>Description</th>
                                <th>Detail Description</th>
                                <th>Category</th>
                                <th>Create Time</th>
                                <th>Modified Time</th>
                                <th colspan="2">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list productInfoPage.content as productInfo>
                                <tr>
                                    <td>${productInfo.productId}</td>
                                    <td>${productInfo.productName}</td>
                                    <td><img height="100" width="100" src="${productInfo.productName}" alt=""></td>
                                    <td>${productInfo.productPrice}</td>
                                    <td>${productInfo.productStock}</td>
                                    <td>${productInfo.productDescription}</td>
                                    <td>${productInfo.categoryType}</td>
                                    <td>${productInfo.createTime}</td>
                                    <td>${productInfo.updateTime}</td>
                                    <td><a href="sell2/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                                    <td>
                                        <#if productInfo.getProductStatusEnum().message == "在架">
                                            <a href="sell2/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                                        <#else>
                                            <a href="sell2/seller/product/on_sale?productId=${productInfo.productId}">上架</a>

                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <#--page bar-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">Prev</a></li>
                            <#else>
                                <li><a href="sell2/seller/order/list?page=${currentPage - 1}&size=${size}">Prev</a></li>
                            </#if>
                            <#list 1..<productInfoPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell2/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#if currentPage gte productInfoPage.getTotalPages()>
                                <li class="disabled"><a href="#">Next</a></li>
                            <#else>
                                <li><a href="sell2/seller/order/list?page=${currentPage + 1}&size=${size}">Next</a></li>
                            </#if>

                            <li><a href="#">Next</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </body>
</html>