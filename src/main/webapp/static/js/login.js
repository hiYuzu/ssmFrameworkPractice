/**
 *<p>
 *@description 登录
 *</p>
 *@author hiYuzu
 *@date 2018/11/5 9:57
 */
function login() {
    var mark;
    var data = {};
    var userCode = document.getElementById("userCode").value;
    var userPwd = document.getElementById("userPwd").value;
    document.getElementById("loginForm").reset();
    var emailPattern = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
    var phonePattern = /0?(13|14|15|18|17)[0-9]{9}/;
    if (emailPattern.test(userCode)) {
        data = {"userEmail": userCode, "userPwd": userPwd};
        mark = "邮箱";
    } else if (phonePattern.test(userCode)) {
        data = {"userTel": userCode, "userPwd": userPwd};
        mark = "电话";
    } else {
        data = {"userName": userCode, "userPwd": userPwd};
        mark = "用户名";
    }
    $.ajax({
        url: "/UserController/loginUser",
        type: "post",
        data: data,
        dataType: "json",
        success: function (json) {
            if (json.result){
                window.location.href = "loginSuccess.html";
            }else {
                alert(mark + "或密码错误");
            }
        }
    });
}