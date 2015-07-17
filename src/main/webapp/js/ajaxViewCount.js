function getdata(){
    $.ajax({
        url: 'getViewCount',
        type: 'GET',
        dataType: "json",
        cache: false,
        timeout: 10000,
        error: function(){},
        success: function(data){
            show_num(data);
        }
       });
}
$(function(){
   // getdata();
    //setInterval('getdata()', 3000);//每隔3秒执行一次
});