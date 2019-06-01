$(function(){
	$(selall).on("click",function(){
		checkboxSelectAll("nid",this.checked) ;
	}) ;
	$(removeBtn).on("click",function(){
		operateChecked("nid","/pages/back/emp") ;
	}) ;
	$("span[id^=pub-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#memberInfo").modal("toggle") ;
		}) ;
	}) ;


	$(addBtn).on("click",function(){
		data = "" ; // 保存要发布的nid
		gidArray = new Array() ; // 保存
		foot = 0 ;
		$(":checkbox[id='nid']").each(function(){
			if ($(this).prop("checked")) {
				data += $(this).val() + ";";
				gidArray[foot ++] = $(this).val() ;
			}
		}) ;
		console.log(data)

		if (data == "") {   // 此时没有选中任何的内容
			operateAlert(false,"","请先选择要发布的公告！") ;
		} else {
			$.get("pages/back/admin/news/news_updataStatus.action",{"data":data},function(data){
				operateAlert(data.trim() == "true","公告发布成功！","公告发布失败！") ;
				if (data.trim()=="true"){
					$("tr[id^='news-']>td:eq(4)").text("已发布");
				}
			},"text");
			// $.get("pages/back/admin/news/news_flush.action",{"gidArry":gidArray},function (data) {
			// 	console.log(data);
			// 	for(x=0; x< data.length;x++){
			// 		$("tr[id^='news-']>td:eq(4)").text("已发布");
			// 	}
			// },"text")
		}
	}) ;

	$(removeBtn).on("click",function(){
		data = "";
		gidArray = new Array();
		foot = 0;
		$(":checkbox[id='nid']").each(function(){
			if ($(this).prop("checked")) {
				data += $(this).val() + ";";
				gidArray[foot ++] = $(this).val() ;
			}
		}) ;
		if (data == "") {   // 此时没有选中任何的内容
			operateAlert(false,"","请先选择要删除的公告！") ;
		}else {
			$.get("pages/back/admin/news/news_remove.action",{"data":data},function(data) {
				operateAlert(data.trim()=="true","公告删除成功","公告删除失败");
				if (data.trim() == "true") {    // 删除对应的表格行的信息
					for (x = 0 ; x < gidArray.length ; x ++) {
						$("#news-" + gidArray).fadeOut(1000,function() {
							$("#news-" + gidArray).remove() ;
						}) ;
					}
				}
			})
		}
	});

})