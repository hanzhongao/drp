$(function () {
    $(wiid).on("change",function () {
        val =  $(this).val();
        $.get("/subtype_list.action",{"wiid":val},function (data) {
            console.log(data);
            $("#stid option:gt(0)").remove();
            for(x =0 ;x<data.length;x++){
                $(stid).append("<option value='" + data[x].stid +"'>" + data[x].title +"</option>");
            }
        },"json")
    });

})