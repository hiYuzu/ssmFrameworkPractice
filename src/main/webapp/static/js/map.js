showMap();
function showMap() {
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(117.1786889372559, 39.10762965106183);  // 初始化地图,设置中心点坐标和地图级别
    map.centerAndZoom(point, 12)
    //添加地图类型控件
    map.addControl(new BMap.MapTypeControl({
        mapTypes:[
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]}));
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    map.enableInertialDragging();
    map.enableContinuousZoom();
    map.setDefaultCursor("Default");
}