/**
 *<p>
 *@Description: 发送信息
 *</p>
 *@author ゆず
 *@date 2018/10/22 15:32
 */
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