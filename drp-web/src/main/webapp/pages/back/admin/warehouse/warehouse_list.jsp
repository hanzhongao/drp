<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
	<jsp:include page="/pages/plugins/basepath.jsp"/>
	<script type="text/javascript" src="js/pages/back/admin/warehouse/warehouse_list.js"></script>
	<script type="text/javascript" src="js/split_page.js"></script>
</head>
<%!
	public static final String WAREHOUSE_EDIT_URL = "pages/back/admin/warehouse/house_editPre.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="12"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;仓库信息列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/pages/plugins/split_page_search_plugin.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
						<tr>${houseList}
							<th class="text-left" style="width:15%;">仓库名称</th> 
							<th class="text-left" style="width:25%;">仓库地址</th>
							<th class="text-left" style="width:10%;">当前仓库图片</th>
							<th class="text-center" style="width:10%;">存储分类</th>
							<th class="text-center" style="width:10%;">存储上限</th>
							<th class="text-center" style="width:10%;">当前存储量</th>
							<th class="text-center" style="width:10%;">管理员姓名</th>
							<th class="text-left" style="width:20%;">操作</th>
						</tr>
					</thead>
					<tbody>

					<c:forEach items="${findSplit}" var="findList">
						<tr>
							<td class="text-left">${findList.name}</td>
							<td class="text-left">${findList.address}</td>
							<td class="text-left"><img src="http://upload-server/upload/${findList.photo}" style="width:100px;"></td>
							<td class="text-center">${houseTitle.title}</td>
							<td class="text-center">${findList.maximum}</td>
							<td class="text-center">商品现存数量</td>
							<td class="text-center" id="admin-1"><span id="mid-admin" style="cursor:pointer;">${findList.admin}</span></td>
							<td class="text-left">
								<button id="editadmin-${findList.wid}" class="btn btn-primary btn-xs">
									<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;编辑库管</button>
								<a href="<%=WAREHOUSE_EDIT_URL%>?wid=${findList.wid}" id="editinfo-${findList.wid}" class="btn btn-warning btn-xs">
									<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑信息</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/pages/plugins/split_page_bar_plugin.jsp"/>
				</div>
			</div>
			<div class="panel-footer" style="height:100px;">
				<jsp:include page="/pages/plugins/alert.jsp"/>
			</div>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/modal/member_info_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/modal/member_dept_list_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/footer.jsp"/>
