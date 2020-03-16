<%--
  Created by IntelliJ IDEA.
  User: fanqiaolian
  Date: 2020/2/26
  Time: 10:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>订单详情</title>

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
    <style>

        .my_title > div {
            height: 40px;
            line-height: 40px;
            border-right: 1px solid #cacaca;
            border-bottom: 1px solid #cacaca;
        }

        .my_title > div > input {
            height: 20px;
            width: 80%;
            margin: 10px auto;
        }

        .my_title2 > div {
            background-color: #fafafa;
        }
    </style>
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <jsp:include page="head.jsp"/>
    <jsp:include page="sidebar.jsp"/>


    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                订单管理
                <small>订单详情</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/order/orderList.do">订单管理</a></li>
                <li class="active">订单详情</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="box-body">

                <%-- 订单信息 --%>
                <!--tab页-->
                <div class="nav-tabs-custom">

                    <!--tab头-->
                    <div class="box-header with-border" style="background-color: #fafafa;
">
                        <h3 class="box-title">订单信息</h3>
                    </div>
                    <!--tab头/-->

                    <!--tab内容-->
                    <div class="tab-content">

                        <!--label显示的内容-->
                        <div class="tab-pane active" id="tab-label">
                            <div class="row data-type">

                                <div class="col-md-2 title">订单编号</div>
                                <div class="col-md-4 data text">
                                    <input disabled type="text" class="form-control" name="productNum"
                                           value="${order.orderNum}">
                                </div>

                                <div class="col-md-2 title">下单时间</div>
                                <div class="col-md-4 data text">
                                    <div class="form-group">
                                        <div class="input-group date">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input disabled type="text" class="form-control pull-right"
                                                   name="departureTime" value="${order.orderTimeStr}">
                                        </div>

                                    </div>
                                </div>

                                <div class="col-md-2 title">路线名称</div>
                                <div class="col-md-4 data text">
                                    <input disabled type="text" class="form-control" name="productNum"
                                           value="${order.product.productName}">
                                </div>

                                <div class="col-md-2 title">出发城市</div>
                                <div class="col-md-4 data text">
                                    <input disabled type="text" class="form-control" name="productNum"
                                           value="${order.product.cityName}">
                                </div>

                                <div class="col-md-2 title">出发时间</div>
                                <div class="col-md-4 data text">
                                    <div class="form-group">
                                        <div class="input-group date">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" class="form-control pull-right"
                                                   name="departureTime" disabled
                                                   value="${order.product.departureTimeStr}">
                                        </div>

                                    </div>
                                </div>

                                <div class="col-md-2 title">出游人数</div>
                                <div class="col-md-4 data text">
                                    <input disabled type="text" class="form-control" name="productNum"
                                           value="${order.peopleCount}">
                                </div>


                                <div class="col-md-2 title rowHeight2x">产品描述</div>
                                <div class="col-md-10 data rowHeight2x">
                                    <textarea class="form-control" name="productDesc"
                                              rows="3">${order.orderDesc}</textarea>
                                </div>

                            </div>

                        </div>

                    </div>
                    <!--label显示的内容/-->


                </div>
                <!--tab内容/-->

                <%-- 练习人信息 --%>
                <!--tab页-->
                <div class="nav-tabs-custom">

                    <!--tab头-->
                    <div class="box-header with-border" style="background-color: #fafafa;
">
                        <h3 class="box-title">游客信息</h3>
                    </div>
                    <!--tab头/-->

                    <!--tab内容-->
                    <div class="tab-content">

                        <!--label显示的内容-->
                        <div class="tab-pane active">
                            <div class="row data-type">

                                <div class="my_title">
                                    <div class="col-md-1">人群</div>
                                    <div class="col-md-2 ">姓名</div>
                                    <div class="col-md-2 ">性别</div>

                                    <div class="col-md-2 ">手机号码</div>
                                    <div class="col-md-2 ">证件类型</div>
                                    <div class="col-md-3 ">证件号码</div>
                                </div>

                                <c:if test="${not empty order.travellers}">
                                    <c:forEach items="${order.travellers}" var="traveller">
                                        <div class="my_title my_title2">

                                            <div class="col-md-1">
                                                <span>${traveller.travellerTypeStr}</span>
                                            </div>
                                            <div class="col-md-2 ">
                                                <input type="text" value="${traveller.name}">
                                            </div>
                                            <div class="col-md-2 ">
                                                <input type="text" value="${traveller.sex}"></div>
                                            <div class="col-md-2 ">
                                                <input type="text" value="${traveller.phoneNum}">
                                            </div>
                                            <div class="col-md-2 ">
                                                <input type="text" value="${traveller.credentialsTypeStr}">
                                            </div>
                                            <div class="col-md-3 "><input type="text"
                                                                          value="${traveller.credentialsNum}"></div>

                                        </div>
                                    </c:forEach>

                                </c:if>

                            </div>

                        </div>


                    </div>
                    <!--label显示的内容/-->

                </div>
                <!--tab页/-->

                <%-- 订单信息 --%>
                <!--tab页-->
                <div class="nav-tabs-custom">

                    <!--tab头-->
                    <div class="box-header with-border" style="background-color: #fafafa;
">
                        <h3 class="box-title">联系人信息</h3>
                    </div>
                    <!--tab头/-->

                    <!--tab内容-->
                    <div class="tab-content">

                        <!--label显示的内容-->
                        <div class="tab-pane active">
                            <div class="row data-type">

                                <div class="col-md-2 title">会员</div>
                                <div class="col-md-4 data text">${order.member.nickName}
                                </div>

                                <div class="col-md-2 title">联系人</div>
                                <div class="col-md-4 data text">
                                    ${order.member.name}
                                </div>

                                <div class="col-md-2 title">手机号</div>
                                <div class="col-md-4 data text">
                                    ${order.member.phoneNum}
                                </div>

                                <div class="col-md-2 title">邮箱</div>
                                <div class="col-md-4 data text">
                                    ${order.member.email}
                                </div>

                            </div>

                        </div>

                    </div>
                    <!--label显示的内容/-->


                </div>
                <!--tab内容/-->

                <%-- 费用信息 --%>
                <!--tab页-->
                <div class="nav-tabs-custom">

                    <!--tab头-->
                    <div class="box-header with-border" style="background-color: #fafafa;
">
                        <h3 class="box-title">费用信息</h3>
                    </div>
                    <!--tab头/-->

                    <!--tab内容-->
                    <div class="tab-content">

                        <!--label显示的内容-->
                        <div class="tab-pane active">
                            <div class="row data-type">

                                <div class="col-md-2 title">支付方式</div>
                                <div class="col-md-4 data text">${order.payTypeStr}
                                </div>

                                <div class="col-md-2 title">金额</div>
                                <div class="col-md-4 data text">
                                    ${order.product.productPrice}
                                </div>


                            </div>

                        </div>

                    </div>
                    <!--label显示的内容/-->

                </div>
                <!--tab内容/-->
                <div class="nav-tabs-custom">
                    <button style="width: 100%; background-color: #fbfbfb;" type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>

                </div>

            </div>
        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

</div>


<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function () {

        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {
        $('#datepicker-a3').datetimepicker({
            format: "yyyy-mm-dd hh:ii",
            autoclose: true,
            todayBtn: true,
            language: "zh-CN"
        });
    });


    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("order-manage");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>
</html>
