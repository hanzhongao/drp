$(function(){
	//实现全选与反选
	$("#selall").click(function() {
		if (this.checked){
			$("input[name^=eid-]:checkbox").each(function(){
				$(this).attr("checked", true);
			});
		} else {
			$("input[name^=eid-]:checkbox").each(function() {
				$(this).attr("checked", false);
			});
		}
	});
});
