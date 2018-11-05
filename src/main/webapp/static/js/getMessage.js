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
        url: "/SenderController/insertSender",
        type: "POST",
        data: data,
        dataType: "json",
        success: function (json) {
            console.log(json.result);
            alert(json.detail);
        }
    })
}

console.log("崽,阿爸对你很失望");