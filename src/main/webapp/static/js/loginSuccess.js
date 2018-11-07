/**
 *<p>
 *@description
 *</p>
 *@author hiYuzu
 *@date 2018/11/7 8:47
 */

$(function () {
    $.ajax({
        url: "/UserController/validLogin",
        type: "get",
        dataType: "json",
        success: function (json) {
            if (json) {
                alert("登录成功");
            } else {
                alert("请先登录");
                window.location.href = "login.html";
            }
        },
        error: function () {
            alert("错误");
            window.location.href = "http://localhost:8080";
        }
    });
});

function getMessage() {
    $.ajax({
        url: "/SenderController/querySenders",
        type: "get",
        dataType: "json",
        success: function (json) {
            var length = json.rows.length;
            console.log("共有" + json.total + "条留言");
            for (var i = 0; i < length; i++) {
                console.log("第" + json.rows[i].senderId + "条留言");
                console.log("留言人:" + json.rows[i].senderName + "\n电话:" + json.rows[i].senderTel);
                console.log("留言信息:" + json.rows[i].senderMsg);
                console.log("留言时间" + json.rows[i].optTime);
                console.log("---------------------------------");
            }
        }
    });
}