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
            "type" : {
                required : true,
            },
            "pid" : {
                required : true,
            },
            "cid" : {
                required : true,
            },
            "address" : {
                required : true,
            },
            "phone" : {
                required : true,
            },
            "note" : {
                required : true ,
                digits : true
            }
        }
    });
})