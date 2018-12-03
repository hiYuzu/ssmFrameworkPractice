/**
 *<p>
 *@description
 *</p>
 *@author hiYuzu
 *@date 2018/11/7 8:47
 */

function getMessage() {
    $.ajax({
        url: "/SenderController/querySenders",
        type: "get",
        dataType: "json",
        success: function (json) {
            var length = json.total;
            console.log("共有" + length + "条留言");
            for (var i = 0; i < length; i++) {
                console.log("第" + (i+1) + "条留言");
                console.log("留言人:\n" + json.rows[i].senderName + "\n电话:\n" + json.rows[i].senderTel);
                console.log("留言信息:\n" + json.rows[i].senderMsg);
                console.log("留言时间\n" + json.rows[i].optTime);
                console.log("---------------------------------");
            }
        }
    });
}