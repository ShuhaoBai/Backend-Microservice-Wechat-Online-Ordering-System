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
                                <th>Order ID</th>
                                <th>Name</th>
                                <th>Submit Time</th>
                                <th>Address</th>
                                <th>Money Amount</th>
                                <th>Order Status</th>
                                <th>Payment Status</th>
                                <th>Create Time</th>
                                <th colspan="2">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTOPage.content as orderDTO>
                                <tr>
                                    <td>${orderDTO.orderId}</td>
                                    <td>${orderDTO.buyerName}</td>
                                    <td>${orderDTO.buyerPhone}</td>
                                    <td>${orderDTO.buyerAddress}</td>
                                    <td>${orderDTO.orderAmount}</td>
                                    <td>${orderDTO.orderStatus}</td>
                                    <td>${orderDTO.payStatus}</td>
                                    <td>${orderDTO.createTime}</td>
                                    <td><a href="sell2/seller/order/detail?orderId=${orderDTO.orderId}">Details</a></td>
                                    <td>
                                        <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                            <a href="sell2/seller/order/cancel?orderId=${orderDTO.orderId}">Cancel</a>
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
                            <#list 1..<orderDTOPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell2/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#if currentPage gte orderDTOPage.getTotalPages()>
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