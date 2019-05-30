$(function(){
    $(cid).on("change",function() {
        handleAddress() ;	// 处理地址
    }) ;
    $(pid).on("change",function(){
        if (this.value != "") {	// 有内容，需要进行ajax异步加载
            handleAddress() ;	// 处理地址
        } else {
            $("#cid option:gt(0)").remove() ;
        }
    }) ;
}
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