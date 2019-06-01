$(function(){
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[1] ;
			operateAlert(true,"待出库商品添加成功！","待出库商品添加失败！") ;
		}) ;
	}) ;
	$("span[id^=storage-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#goodsRecordInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			console.log("雇员编号：" +mid);
			$("#memberInfo").modal("toggle") ;
			$("#name td span:gt(0)").remove();
			$("#level_title td:gt(0)").remove();
			$("#dept_dname td:gt(0)").remove();
			$("#phone td:gt(0)").remove();

			$.getJSON("/pages/plugins/back/modal/member_info.action",{"mid":mid},function (data) {
				$("#name").text(data.member.name);
				$("#level_title").text(data.level.title);
				$("#dept_dname").text(data.dept.dname);
				$("#phone").text(data.member.phone);
				$("#note").text(data.member.note);
				$("#photo img").attr("src", "http://upload-server/upload/" + data.member.photo);

			});
		}) ;
	}) ;
})