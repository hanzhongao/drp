$(function () {
    /*
    此类为city城市类的异步公共调用JS，有的页面的js中带有这部分的代码，有的部分不带有
    这部分的代码，如果您的js突然发生了不好使的情况，请先检查您的js里面是否有冲突的代码
    同时检查页面之中是否引入了这个js。如果都做了，还是有冲突问题。追你好运
   */
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
    $(cid).on("change",function() {
        handleAddress() ;	// 处理地址
    }) ;
    $(pid).on("change",function(){
        if (this.value != "") {	// 有内容，需要进行ajax异步加载
            $("#cid option:gt(0)").remove() ;
            handleAddress() ;	// 处理地址
        } else {
            $("#cid option:gt(0)").remove() ;

        }
    }) ;
})
function handleAddress() {	// 实现地址处理过程
    address = $("#address").val() ;	// 获得address原始内容
    ptitle = $("#pid option:selected").text() + " " ;
    ctitle = " " ;
    if ($("#cid option:selected").val() != "") {
        ctitle = $("#cid option:selected").text() + " " ;
    }
    adr = address.split(" ") ;
    if (adr.length >= 3) {	// 都填写完了，现在要修改了
        str = ptitle + ctitle + adr[2] ;
        for (x = 2 ; x < adr.length ; x ++) {
            str += adr[x] + " " ;
        }
        $("#address").val(str) ;
    } else {
        $("#address").val(ptitle + ctitle) ;
    }
}