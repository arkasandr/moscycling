$(document).ready(function () {
    $("#login-username-form").submit(function (event) {
        var username = $("#username").val();
        var password = $("#password").val();
        var userDTO = {
            username: username,
            password: password
        };
        var resultJson = JSON.stringify(userDTO);
        if (username !== "" && password !== "") {
            sentUserData(resultJson);
            event.preventDefault();
        } else {
            alert("Both fields must be required");
            event.preventDefault();
        }
    });

    function sentUserData(json) {
        $.ajax({
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            type: "POST",
            url: "http://localhost:9090/login",
            data: json,
            timeout: 100000,

            success: function () {
                window.location = "http://localhost:9090/index.html";
                console.log("SUCCESS: ", "ok222");
            },
            error: function () {
                alert("Registration error");
            }

        });
    }
});
