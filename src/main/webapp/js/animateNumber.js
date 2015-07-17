function show_num(n){
    var it = $(".t_num i");
    var len = String(n).length;
    for(var i=0;i<len;i++){
        if(it.length<=i){
            $(".t_num").append("<i></i>");
        }
        var num=String(n).charAt(i);
        var y = -parseInt(num)*30; //y轴位置
        var obj = $(".t_num i").eq(i);
        obj.text(num);
        obj.animate({ //滚动动画
            backgroundPosition :'(0 '+String(y)+'px)'
            }, 'slow','swing',function(){
            }
        );
    }
}