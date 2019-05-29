$(function() {
	$("#selectAll").on("click",function(){
		checkboxSelectAll('aid',this.checked) ;
	}) ;
	$("#delBtn").on("click",function(){	// 绑定用户锁定操作
		operateChecked("确定要删除这些地址吗？","address.aid",'pages/jsp/admin/UserActionBack!lock.action?p=p') ;
	}) ;
	$("#editBtn-1").on("click",function () {
		$(this).on("click",function() { // 绑定单击事件
			mid = $(this).attr("mid") ; // 获取id的属性内容
			$.get("pages/front/center/address/address_list.action",{"mid":mid},function(){

			},"text") ;
		}) ;
	})

})
