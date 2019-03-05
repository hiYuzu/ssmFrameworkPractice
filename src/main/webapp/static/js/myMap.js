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

/**
 * 添加点
 */
function addMarker() {
    var url = "/MapController/getMapData";
    $.ajax({
        url: url,
        dataType: "json",
        type: "post",
        success: function (json) {
            if (json.total > 0) {
                var length = json.rows.length;
                var pointView = [];
                for (var i = 0; i < length; i++) {
                    var data = json.rows[i];
                    var point = new BMap.Point(data.lng, data.lat);
                    var marker = new BMap.Marker(point);
                    map.addOverlay(marker);
                    var label = new BMap.Label(setLabelFuc(data), {offset: new BMap.Size(20, -10)});
                    marker.setLabel(label); //添加标签
                    label.setStyle({
                        display: "none",
                        maxWidth: "none",
                        border: "0",
                        zIndex: 1000000000
                    });
                    marker.addEventListener("mouseover", function () {
                        label.setStyle({
                            display: ""
                        });
                    });
                    marker.addEventListener("mouseout", function() {
                        label.setStyle({
                            display: "none"
                        });
                    });
                    pointView.push(point);
                }
                map.setViewPoint(pointView);
            }
        }
    })
}

/**
 * 设置标签
 * @param data
 */
function setLabelFuc(data) {
    var optTime = longToDate(data.optTime);
    var str =  "<div style='background:#fbd023;padding:10px 15px;border:1px solid #fbd023;min-width: 200px;font-weight:bold;'>" +
        data.deviceName +
        "</div>" +
        "<div style='min-height: 60px;min-width: 200px;'>" +
        "<div style='padding:6px 15px;'>温度：" +
        data.temp +
        "</div>" +
        "<div  style='padding:6px 15px;'>湿度：" +
        data.hum +
        "</div>" +
        "<div  style='padding:6px 15px;'>信息上传时间：" +
        optTime +
        "</div>" +
        "</div>";
    return str;
}

function longToDate(optTime) {
    var d = new Date();
    d.setTime(optTime);
    var year = d.getFullYear();
    var month = (d.getMonth() + 1);
    if (d.getMonth() + 1 < 10) {
        month = "0" + month;
    }
    var day = d.getDate();
    if (d.getDate() < 10) {
        day = "0" + day;
    }
    var hour = d.getHours();
    var minute = d.getMinutes();
    var second = d.getSeconds();
    return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
}