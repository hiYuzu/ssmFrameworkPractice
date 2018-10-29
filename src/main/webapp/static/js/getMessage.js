/**
 *<p>
 *@Description: 获取信息
 *</p>
 *@author ゆず
 *@date 2018/10/22 15:32
 */
function getMessage() {
    console.log("你的名字：" + document.getElementById("nameInput").value);
    console.log("你的联系方式：" + document.getElementById("contactInput").value);
    console.log("留言：" + document.getElementById("message").value);
    document.getElementById("messageForm").reset();
}
function downTest(mobileCode) {
    if (mobileCode != null) {
        var file = new File([mobileCode], "手机号.txt", { type: "text/plain;charset=utf-8" });
        saveAs(file);
        alert("!");
    }
}

console.log("大鹏一日同风起,扶摇直上九万里");