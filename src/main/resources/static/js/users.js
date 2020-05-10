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

    $('#users-delete-form').submit(function (event) {
        enableDeleteUserButton(false);
        event.preventDefault();
        deleteUserAjax();
    });

    $('#users-update-form').submit(function (event) {
        enableUpdateUsernameButton(false);
        event.preventDefault();
        updateUsernameAjax();
    });

});

function enableSearchAllUsersButton(flag) {
    $('#getAllUsers').prop("disabled", flag);
}

function enableAddNewUserButton(flag) {
    $('#users-add-btn').prop("disabled", flag);
}

function enableDeleteUserButton(flag) {
    $('#users-delete-btn').prop("disabled", flag);
}

function enableUpdateUsernameButton(flag) {
    $('#users-update-btn').prop("disabled", flag);
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
            window.location = "http://localhost:9090/users.html";
        },
        error: function () {
            $('#users-add-btn').parent().append('<p>Username has been already exists!</p>');
            console.log("ERROR: ", e);
            event.preventDefault();

        },
        done: function (e) {
            console.log("DONE");
            enableAddNewUserButton(true);
        }
    });
}


function deleteUserAjax() {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:9090/users/" + document.getElementById('user-delete-id').value,
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            window.location = "http://localhost:9090/users.html";
        },
        error: function (e) {
            $('#users-delete-btn').parent().append('<p>User ID was not found!</p>');
            console.log("ERROR: ", e);
            event.preventDefault();
        },
        done: function (e) {
            console.log("DONE");
            enableDeleteUserButton(true);
        }
    });
}


function updateUsernameAjax() {
    var newUsername = {username: document.getElementById('user-update-newusername').value}
    $.ajax({
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        type: "PATCH",
        url: "http://localhost:9090/users/" + document.getElementById('user-update-recentusername').value,
        data: JSON.stringify(newUsername),
        timeout: 100000,

        success: function (newUsername) {
            console.log("SUCCESS: ", newUsername);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        done: function (e) {
            console.log("DONE");
            enableUpdateUsernameButton(true);
        }
    });
}