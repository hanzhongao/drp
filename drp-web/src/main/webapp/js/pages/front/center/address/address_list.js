$(function() {

	$("#selectAll").on("click",function(){
		checkboxSelectAll('aid',this.checked) ;
	}) ;
	// $("#editBtn-1").on("click",function () {
	// 	$(this).on("click",function() { // 绑定单击事件
	// 		mid = $(this).attr("mid") ; // 获取id的属性内容
	// 		$.get("pages/front/center/address/address_list.action",{"mid":mid},function(){
	// 			console.log("haoren===");
	// 		},"text") ;
	// 	}) ;
	// });        和《a href=""》 写重复了
	$(delBtn).on("click",function(){
		data = "" ; // 保存要删除的商品编号
		gidArray = new Array() ; // 保存要删除 gid编号
		foot = 0 ;
		$(":checkbox[id='aid']").each(function(){
			if ($(this).prop("checked")) {
				data += $(this).val() + ";";
				gidArray[foot ++] = $(this).val() ;
			}
		}) ;
		console.log(data)
		if (data == "") {   // 此时没有选中任何的内容
			operateAlert(false,"","请先选择要删除的地址！") ;
		} else {
			$.get("pages/front/center/address/address_delete.action",{"data":data},function(data){
				operateAlert(data.trim() == "true","地址信息删除成功！","地址信息删除失败！") ;
				if (data.trim() == "true") {    // 删除对应的表格行的信息
					for (x = 0 ; x < gidArray.length ; x ++) {
						$("#address-" + gidArray).fadeOut(1000,function() {
							$("#address-" + gidArray).remove() ;
						}) ;
					}
				}
			},"text") ;
		}
	}) ;
})
