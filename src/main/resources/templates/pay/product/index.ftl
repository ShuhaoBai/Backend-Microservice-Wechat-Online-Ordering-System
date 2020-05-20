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
                    <form role="form" method="post" action="/sell2/seller/product/save">
                        <div class="form-group">
                            <label >Name</label>
                            <input name="productName" type="text" class="form-control" value="${(productInfo.productName)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <div class="form-group">
                            <label >Price</label>
                            <input name="productPrice" type="text" class="form-control" value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <div class="form-group">
                            <label >Stock</label>
                            <input name="productStock" type="number" class="form-control" value="${(productInfo.productStock)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <div class="form-group">
                            <label >Description</label>
                            <input name="productDescription" type="text" class="form-control" value="${(productInfo.productDescription)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <div class="form-group">
                            <label >Image</label>
                            <img height="100" width="100" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" type="text" class="form-control" value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <div class="form-group">
                            <label >Category</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                        >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>