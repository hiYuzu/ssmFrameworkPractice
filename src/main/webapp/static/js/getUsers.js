/**
 *<p>
 *@description json获取后台信息测试
 *</p>
 *@author hiYuzu
 *@date 2018/10/26 15:58
 */

function getUsers() {
    $.ajax({
        url: "/UserController/queryUsers",
        type: "get",
        dataType: "json",
        success: function (json) {
            console.log(JSON.stringify(json));
            alert("获取信息成功!");
        }
    })
}