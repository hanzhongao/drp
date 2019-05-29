$(function() {
    $("#myform").validate({
        debug : true, // 取消表单的提交操作
        submitHandler : function(form) {
            form.submit(); // 提交表单
        },
        errorPlacement : function(error, element) {
            $("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
        },
        highlight : function(element, errorClass) {
            $(element).fadeOut(1,function() {
                $(element).fadeIn(1, function() {
                    $("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
                });

            })
        },
        unhighlight : function(element, errorClass) {
            $(element).fadeOut(1,function() {
                $(element).fadeIn(1,function() {
                    $("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
                });
            })
        },
        errorClass : "text-danger",
        rules : {
            "name" : {
                required : true,
            },
            "phone" : {
                required : true ,
                digits : true
            } ,
            "pid" : {
                required : true
            },
            "cid" : {
                required : true
            },
            "address" : {
                required : true
            }
        }
    });
    calcSumPrice() ;
})

function calcSumPrice() {	// 进行购买总价的计算
    sum = 0.0 ; // 保存商品的计算总价
    $("span[id^='price-']").each(function() {	// 获取全部的商品价格元素的内容
        gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
        console.log(gid);
        price = parseFloat($(this).text()) ; // 将字符串的内容变为小数
        console.log(price);
        amount = parseInt($("#amount-" + gid).text()); // 获取数量
        console.log(amount);
        sum += price * amount ; // 商品总价计算
    }) ;
    $(allPrice).text(round(sum,2)) ;
}