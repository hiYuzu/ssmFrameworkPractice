/**
 * <p>
 * @author hiYuzu
 * @description
 * @version V1.0
 * </p>
 * @date 2019/3/5 8:42
 */
var map;
loadMap();
addMarker();
function loadMap() {
    map = new BMap.Map("map", {enableMapClick: true});
    map.centerAndZoom(new BMap.Point(117.210, 39.094), 11);  // 初始化地图,设置中心点坐标和地图级别
    //添加地图类型控件
    map.addControl(new BMap.MapTypeControl({
        mapTypes: [
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]
    }));
    map.setCurrentCity("天津");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
}

function addMarker() {
    var url = "/MapController/getMapData";
    $.ajax({
        url : url,
        dataType: "json",
        type: "post",
        success: function (json) {
            if (json.total > 0) {
                var length = json.rows.length;
                for (var i = 0; i < length; i++) {
                    console.log(JSON.stringify(json.rows[0]));
                }
                console.log(json.rows);
            }
        }
    })
}