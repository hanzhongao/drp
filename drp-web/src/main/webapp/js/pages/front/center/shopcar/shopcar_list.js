$(function() {
	$("#selectAll").on("click",function(){
		checkboxSelectAll('gid',this.checked) ;
	}) ;
	try {
		calcSumPrice();
	}catch (e) {
	}

	$(rmBtn).on("click",function () {
		data = "";
		gitArray = new Array();
		foot =0;
		$(":checkbox[id='gid']").each(function () {
			if($(this).prop("checked")){
				data +=$(this).val() +";";
				gitArray[foot++] =$(this).val();
			}
		});
		if(data ==""){
			operateAlert(false,"","请先选择要删除的小商品！") ;
		}else{
			$.get("pages/front/center/shopcar/shopcar_delete.action",{"data":data},function (data) {
				operateAlert(data.trim()=="true","购物车信息删除成功！","购物车信息删除失败！") ;
				if(data.trim()=="true"){
					for(x = 0;x < gitArray.length;x++){
						$("#shopcar-" +gitArray).fadeOut(1000,function () {
							$("#shopcar-" + gitArray).remove();
						});
					}
				}
			},"text");
		}
	});

	$(editBtn).on("click",function () {
		//发送修改数据
		data ="";
		$("input[id^='amount']").each(function () {
			gid = $(this).attr("id").split("-")[1];
			amount = $(this).val();
			data +=gid + ":"+amount;
		});
		$.get("pages/front/center/shopcar/shopcar_edit.action",{"data":data},function (data) {
			operateAlert(data.trim()=="true","购物车信息修改成功！","购物车信息修改失败！") ;
		},"text");
	});

	$("button[id^='updateBtn']").each(function () {
		$(this).on("click",function () {
			gid =$(this).attr("id").split("-")[1];
			amount = $("#amount-" +gid).val();
			data = gid +":"+amount;
			$.get("pages/front/center/shopcar/shopcar_edit.action",{"data":data},function (data) {
				operateAlert(data.trim()=="true","购物车信息修改成功！","购物车信息修改失败！") ;
			},"text");
		})
	})

	$("button[id^='add-']").each(function () {
		$(this).on("click",function () {
			gid = $(this).attr("id").split("-")[1];
			amount = parseInt($("#amount-" +gid).val());
			if(amount <0){
				amount =1;
			}
			$("#amount-" + gid).val(amount +1);
			calcSumPrice();
		});
	});
	$("button[id^='sub-']").each(function () {
		$(this).on("click",function () {
			gid = $(this).attr("id").split("-")[1];
			amount = parseInt($("#amount-" +gid).val());
			if(amount -1 !=0){
				$("#amount-" + gid).val(amount -1);
				calcSumPrice();
			}
		});
	})
})
function calcSumPrice() {
	//获得所有商品价格数据
	$("span[id^='price']").each(function () {
		//获取id
		gid = $(this).attr("id").split("-")[1];
		// console.log($(this).text());
		//价格变小数
		price = parseFloat($(this).text());
		//获取数量
		amount = parseInt($("#amount-" +gid).val());
		sum = price * amount;
	});
	$(allPrice).text(round(sum,2));
}