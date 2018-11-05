/**
 *<p>
 *@description 登录
 *</p>
 *@author hiYuzu
 *@date 2018/11/5 9:57
 */
function login() {
    var userEmail = document.getElementById("userEmail").value;
    var userPwd = document.getElementById("userPwd").value;
    document.getElementById("loginForm").reset();
    var data = {"userEmail": userEmail, "userPwd": userPwd};
    $.ajax({
        url: "/UserController/loginUser",
        type: "post",
        data: data,
        dataType: "json",
        success: function (json) {
            if (json.result){
                window.location.href = "loginSuccess.html";
            }else {
                alert("邮箱或密码错误");
            }
        }
    });
}