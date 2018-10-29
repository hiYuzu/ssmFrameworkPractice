/**
 *<p>
 *@Description: 获取信息
 *</p>
 *@author ゆず
 *@date 2018/10/22 15:32
 */
function downTest(mobileCode) {
    if (mobileCode != null) {
        var file = new File([mobileCode], "手机号.txt", {type: "text/plain;charset=utf-8"});
        saveAs(file);
        alert("!");
    }
}

function sendMessage() {
    var senderName = document.getElementById("nameInput").value;
    var senderTel = document.getElementById("contactInput").value;
    var senderMsg = document.getElementById("message").value;
    document.getElementById("messageForm").reset();
    var data = {"senderName": senderName, "senderTel": senderTel, "senderMsg": senderMsg};
    $.ajax({
        url: "/SenderController/insertSenders",
        type: "POST",
        data: data,
        dataType: "json",
        success: function (json) {
            console.log("名字：" + senderName + "\n联系方式：" + senderTel + "\n留言内容：" + senderMsg);
            alert("已收到您的信息，感谢！");
        }
    })
}

console.log("大鹏一日同风起,扶摇直上九万里");