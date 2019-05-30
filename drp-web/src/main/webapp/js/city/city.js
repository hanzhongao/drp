$(function () {
    $(pid).on("change",function () {
        val =  $(this).val();
        $.get("/city_list.action",{"pid":val},function (data) {
            console.log(data);
            $("#cid option:gt(0)").remove();
            for(x =0 ;x<data.length;x++){
                $(cid).append("<option value='" + data[x].cid +"'>" + data[x].title +"</option>");
            }
        },"json")
    });
})