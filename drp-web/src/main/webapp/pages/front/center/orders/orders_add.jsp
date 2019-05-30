<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/front/center/orders/orders_add.js"></script>
</head>

<%!
	public static final String ORDERS_ADD_URL = "pages/front/center/orders/orders_add.action" ;
%>
<body class="back">
	<div class="container contentback">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_navbar.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div> 
		<div id="contentDiv" class="row">
			<div class="col-md-2 col-xs-2">
				<jsp:include page="/pages/plugins/front/center/include_center_item.jsp">
					<jsp:param value="1" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-file"></span>&nbsp;创建订单</strong>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" action="<%=ORDERS_ADD_URL%>" id="myform" method="post">
							<div class="form-group" id="aidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="aid">收件地址：</label>
								<div class="col-md-5">
									<div class="radio">
										<c:forEach items="${allAddresses}" var="addresses">
											<input type="radio" id="aid" name="aid" class="radio" checked value="1">${addresses.receiver},${addresses.phone},${addresses.addr}	<br /><%--李先生，13934720223，北京市朝阳区来广营马泉营--%>
										</c:forEach>
									</div>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="aidMsg"></div>
							</div>
							<div id="noteDiv" class="form-group">
								<label class="col-md-3 control-label" for="note" >订单备注：</label>
								<div class="col-md-5"> 
									<textarea id="note" name="text" class="form-control"></textarea>
								</div>
								<div class="col-md-4" id="noteMsg"></div>
							</div>

                            <%--部分数据隐藏显示--%>
                            <div id="sumDiv" class="form-group" hidden>
                                <label class="col-md-3 control-label" for="note" >订单总价：</label>
                                <div class="col-md-5"><span id="allPrice" class="text-danger" >78.9</span></div>
                                <div class="col-md-4" id="sumMsg"></div>
                            </div>
                            <div hidden>
                                <table>
                                    <tbody>
                                    <c:forEach items="${allGoods}" var="goods">
                                        <tr>
                                            <td class="text-center">
                                                <input type="hidden" name="gid" value="${goods.gid}">${goods.name}
                                            </td>
                                            <td class="text-center">￥<span id="price-${goods.gid}">${goods.price}</span></td><br />
                                            <td class="text-center"><span id="amount-${goods.gid}">${shopcar[goods.gid]}</span></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <%--隐藏显示部分--%>
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary btn-lg">下单</button>
									<a href="pages/front/center/shopcar/shopcar_list.jsp" class="btn btn-link">再想想还有什么没卖的？</a>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-footer">
						<jsp:include page="/pages/plugins/alert.jsp"/>
					</div>
				</div>
			</div>
		</div>
		<div id="footDiv" class="row navbar-fixed-bottom">
			<jsp:include page="/pages/plugins/front/include_title_foot.jsp" />
		</div>
	</div>
</body>
</html>