
/**
 * @author zyq
 * 
 * */
$(function(){

	 //初始化加载的方法
	 (function init(){
         var sceneryImgs = document.getElementsByName("sceneryImg");
         for (var i = 0;i < sceneryImgs.length; i++){
             console.log(sceneryImgs[i]);
             //hotelImgs[i].attr("src", getImgPath()+"/images/"+hotelImgs[i].id);
             sceneryImgs[i].src=getImgPath()+"/images/"+sceneryImgs[i].id;
         }
	 })();

});

function showModal(id) {
    debugger;
    $.ajax({
        type: 'post',
        url: "../base/addPupNo",
        dataType: "json",
        async: false,
        data : {
            id : id,
        },
        error: function () {
            console.log("error!");
        }
    });
    console.log("open"+id);
    $("#"+id).modal();
}

function closeModal(id) {
    //console.log("close"+id);
    $("#"+id).modal('hide');
}

function getImgPath()
{
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    var urlpath= window.location.protocol + '//' + window.location.host + '/'+ webName;
    return urlpath.substring(0,urlpath.lastIndexOf("/"));
}