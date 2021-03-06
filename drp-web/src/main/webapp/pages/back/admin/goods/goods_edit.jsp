<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="/pages/plugins/basepath.jsp"/>
    <script type="text/javascript" src="js/pages/back/admin/goods/goods_edit.js"></script>
    <script type="text/javascript" src="js/split_page.js"></script>
    <script type="text/javascript" src="bootstrap/tinymce/tinymce.min.js"></script>
    <script type="text/javascript" src="js/subtype/subtype.js"></script>
</head>
    <%!
	public static final String GOODS_EDIT_URL = "pages/back/admin/goods/goods_edit.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!-- 导入头部标题栏内容 -->
    <jsp:include page="/pages/plugins/back/include_title_head.jsp"/>
    <!-- 导入左边菜单项 -->
    <jsp:include page="/pages/plugins/back/include_menu_item.jsp">
        <jsp:param name="mi" value="5"/>
        <jsp:param name="msi" value="52"/>
    </jsp:include>
    <div class="content-wrapper text-left">
        <div class="panel panel-info">
            <div class="panel-heading">
                <strong><span class="glyphicon glyphicon-user"></span>&nbsp;编辑商品信息</strong>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="<%=GOODS_EDIT_URL%>?photo=${goods.photo}" id="myform" method="post"
                      enctype="multipart/form-data">

                    <fieldset>
                        <!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
                        <div class="form-group" id="nameDiv">
                            <!-- 定义表单提示文字 -->
                            <label class="col-md-3 control-label" for="name">商品名称：</label>
                            <div class="col-md-5">
                                <!-- 定义表单输入组件 -->
                                <input type="text" id="name" name="name" class="form-control"
                                       placeholder="请输入仓库标记名称" value="${goods.name}">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class=" col-md-4" id="nameMsg">
                            </div>
                        </div>
                        <div class="form-group" id="tidDiv">
                            <!-- 定义表单提示文字 -->
                            <label class="col-md-3 control-label" for="wiid">商品分类：</label>
                            <div class="col-md-5">
                                <select id="wiid" name="wiid" class="form-control">
                                    <option value="">====== 请选择商品所属分类 ======</option>
                                    <c:forEach items="${allWitems}" var="witem">
                                        <option value="${witem.wiid}" ${witem.wiid==goods.wiid?"selected":""}>${witem.title}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- 定义表单错误提示显示元素 -->
                            <div class="col-md-4" id="tidMsg"></div>
                        </div>
                        <div class="form-group" id="stidDiv">
                            <!-- 定义表单提示文字 -->
                            <label class="col-md-3 control-label" for="stid">商品子分类：</label>
                            <div class="col-md-5">
                                <select id="stid" name="stid" class="form-control">
                                    <option value="">====== 请选择商品所属子分类 ======</option>
                                    <c:forEach items="${allSubtypes}" var="subtype">
                                    <option value="${subtype.stid}" ${subtype.stid==goods.stid?"selected":""}>${subtype.title}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- 定义表单错误提示显示元素 -->
                            <div class="col-md-4" id="stidMsg"></div>
                        </div>
                        <div class="form-group" id="priceDiv">
                            <!-- 定义表单提示文字 -->
                            <label class="col-md-3 control-label" for="price">商品单价（￥）：</label>
                            <div class="col-md-5">
                                <input type="text" id="price" name="price" class="form-control"
                                       placeholder="请输入商品单价" value="${goods.price}">
                            </div>
                            <!-- 定义表单错误提示显示元素 -->
                            <div class="col-md-4" id="priceMsg"></div>
                        </div>
                        <div class="form-group" id="weightDiv">
                            <!-- 定义表单提示文字 -->
                            <label class="col-md-3 control-label" for="weight">商品重量（g）：</label>
                            <div class="col-md-5">
                                <!-- 定义表单输入组件 -->
                                <input type="text" id="weight" name="weight" class="form-control"
                                       placeholder="请输入商品重量." value="${goods.weight}">
                            </div>
                            <!-- 定义表单错误提示显示元素 -->
                            <div class="col-md-4" id="weightMsg"></div>
                        </div>
                        <div class="form-group" id="picDiv">
                            <!-- 定义表单提示文字 -->
                            <label class="col-md-3 control-label" for="photo">商品图片：</label>
                            <div class="col-md-5">
                                <!-- 定义表单输入组件 -->
                                <input type="file" id="photo" name="photo" class="form-control"
                                       placeholder="请上传商品照片" value="${goods.photo}">
                            </div>
                            <div class="col-md-3">
                                <img src="http://upload-server/upload/${goods.photo==""?"nophoto.jpg":goods.photo}">
                            </div>
                            <!-- 定义表单错误提示显示元素 -->
                            <div class="col-md-4" id="picMsg"></div>
                        </div>
                        <!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
                        <div class="form-group" id="noteDiv">
                            <!-- 定义表单提示文字 -->
                            <label class="col-md-3 control-label" for="note">备注信息：</label>
                            <div class="col-md-5">
                                <!-- 定义表单输入组件 -->
                                <textarea id="note" name="note"
                                          class="form-control" placeholder="请输入商品的详细信息" rows="10">${goods.note}</textarea>
                            </div>
                            <!-- 定义表单错误提示显示元素 -->
                            <div class="col-md-4" id="noteMsg"></div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-5 col-md-offset-3">
                                <input type="hidden" name="gid" id="gid" value="${goods.gid}">
                                <input type="hidden" name="pic" id="pic" value="${goods.photo}">
                                <button type="submit" class="btn btn-primary">修改</button>
                                <button type="reset" class="btn btn-warning">重置</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="panel-footer" style="height:100px;">
                <jsp:include page="/pages/plugins/alert.jsp"/>
            </div>
        </div>
    </div>
    <!-- 导入公司尾部认证信息 -->
    <jsp:include page="/pages/plugins/back/include_title_foot.jsp"/>
    <!-- 导入右边工具设置栏 -->
    <jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp"/>
    <div class="control-sidebar-bg"></div>
</div>
<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp"/>
<jsp:include page="/pages/plugins/footer.jsp"/>
