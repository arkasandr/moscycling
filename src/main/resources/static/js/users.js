jQuery(document).ready(function ($) {

    $('#users-all-search-form').submit(function (event) {
        enableSearchAllUsersButton(false);
        event.preventDefault();
        searchAllUsersAjax()
    });


    $("#users-add-form").submit(function (event) {
        enableAddNewUserButton(false);
        var username = $("#user-add-username").val();
        var password = $("#user-add-password").val();
        var role = $("#user-add-role").val();
        var userDTO = {
            username: username,
            password: password,
            userRole: [role]
        };
        var resultJson = JSON.stringify(userDTO);
        if (username !== "" && password !== "" && role !== "") {
            addNewUserAjax(resultJson);
            event.preventDefault();
        } else {
            alert("All fields must be required");
            event.preventDefault();
        }
    });

});

function enableSearchAllUsersButton(flag) {
    $('#getAllUsers').prop("disabled", flag);
}

function enableAddNewUserButton(flag) {
    $('#users-add-btn').prop("disabled", flag);
}

function displayToTableAllUsers(data) {
    $('tr:has(td)').remove();
    $.each(data, function (i, item) {
        $('<tr>').html("<td>" + data[i].id + "</td><td>" + data[i].username + "</td><td>" + data[i].password + "</td>")
            .appendTo('#users-all');
    });
}


function searchAllUsersAjax() {
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/users/all",
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayToTableAllUsers(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
            enableSearchAllUsersButton(true);
        }
    });
}


function addNewUserAjax(json) {
    $.ajax({
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        type: "POST",
        url: "http://localhost:9090/users/addnewuser",
        data: json,
        timeout: 100000,
        success: function () {
            console.log("SUCCESS: ", "ok222");
        },
        error: function () {
            // $('#users-add-btn').parent().append('<h1>ERROR!!</h1>');
            alert("Username has been already exists!");
            window.location = "http://localhost:9090/users.html";
            event.preventDefault();

        },
        done: function (e) {
            console.log("DONE");
            enableAddNewUserButton(true);
        }
    });
}
