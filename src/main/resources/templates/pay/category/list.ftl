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
                                <th>Category ID</th>
                                <th>Name</th>
                                <th>Type</th>
                                <th>Creation Time</th>
                                <th>Modified Time</th>
                                <th>Operation</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list categoryList as category>
                                <tr>
                                    <td>${category.categoryId}</td>
                                    <td>${category.categoryName}</td>
                                    <td>${category.categoryType}</td>
                                    <td>${category.createTime}</td>
                                    <td>${category.updateTime}</td>
                                    <td><a href="sell2/seller/category/index?categoryId=${category.categoryId}">Modify</a></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </body>
</html>