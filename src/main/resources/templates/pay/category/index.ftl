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
                    <form role="form" method="post" action="/sell2/seller/category/save">
                        <div class="form-group">
                            <label >名称</label>
                            <input name="categoryName" type="text" class="form-control" value="${(category.categoryName)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" type="number" class="form-control" value="${(category.categoryType)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>


                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>