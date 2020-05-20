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
                                        <#if orderDTO.getOrderStatusEnum().message == "New Order">
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

<#--pop-up window-->
    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        Reminder
                    </h4>
                </div>
                <div class="modal-body">
                    You got a new order.
                </div>
                <div class="modal-footer">
                    <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button onclick="location.reload()" type="button" class="btn btn-primary">Check New Order</button>
                </div>
            </div>

        </div>

    </div>

<#--    play a song-->
    <audio id="notice" loop="loop">
        <source src="/sell2/mp3/song.mp3" type="audio/mpeg" />
    </audio>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script>
        var webscoket = null;
        if('WebSocket' in window){
            webscoket = new WebSocket('ws://baishuhao.natapp4.cc/sell2/webSocket');
        } else {
            alert('current browser does not support websocket!');
        }

        webscoket.onopen = function(event){
            console.log('Connection is made')
        }
        webscoket.onclose = function(event){
            console.log('connection is closed')
        }
        webscoket.onmessage = function(event){
            console.log('Received a message:' + event.data)
            //you can do play a song, or pop a message in front-end
            ${'#myModal'}.modal('show');
            document.getElementById('notice').play();

        }
        webscoket.onerror = function() {
            alert('error occurred')
        }
        window.onbeforeunload = function () {
            webscoket.close();
        }
    </script>
    </body>
</html>