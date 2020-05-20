<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    sidebar-->
    <#include "../common/nav.ftl">
    <#--    content-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>OrderID</th>
                            <th>Order Amount Sum</th>
                        </tr>
                        </thead>
                        <tbody>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.orderAmount}</td>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>ProductID</th>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTO.orderDetailList as orderDetail>
                            <tr>
                                <td>${orderDetail.productId}</td>
                                <td>${orderDetail.productName}</td>
                                <td>${orderDetail.productPrice}</td>
                                <td>${orderDetail.productQuantity * orderDetail.productPrice}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="col-md-12 column">
                <#if orderDTO.getOrderStatusEnum().message == "New Order">
                    <a href="/sell2/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">Order Complete</a>
                    <a href="/sell2/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">Order Cancel</a>
                </#if>

            </div>
        </div>
    </div>
</div>

</body>
</html>