function showMap() {
    var map = new BMap.Map("allmap");
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
    //添加地图类型控件
    map.addControl(new BMap.MapTypeControl({
        mapTypes:[
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]}));
    map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
}

function showUser() {
    var url = "static/map.json";
    var url1 = "/UserController/queryUsers";
    $.ajax({
        url: url1,
        type: "get",
        dataType: "json",
        success: function (json) {
            alert("1");
            alert(JSON.stringify(json));
        },
        error: function () {
            alert("no!");
        }
    });
}