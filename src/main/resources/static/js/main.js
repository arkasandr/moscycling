jQuery(document).ready(function ($) {

    $("#info__max__form").submit(function(event) {
        enableSearchMaxButton(false);
        event.preventDefault();
        searchMaxLengthAjax()
    });


    $("#info__min__form").submit(function(event) {
        enableSearchMinButton(false);
        event.preventDefault();
        searchMinLengthAjax()
    });


    $("#routes__search__form").submit(function (event) {
        enableAllPathButton(false);
        event.preventDefault();
        ajaxGetTwo()
    });

});

function enableSearchMaxButton(flag) {
    $("#info__max__form__search").prop("disabled", flag);
}

function enableSearchMinButton(flag) {
    $("#info__min__form__search").prop("disabled", flag);
}

function searchMaxLengthAjax() {
    var search = {}
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/maxlength",
        data: JSON.stringify(search),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayMaxLength(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            displayMaxLength(e);
        },
        done: function (e) {
            console.log("DONE");
            enableSearchMaxButton(true);
        }
    });
}

function searchMinLengthAjax() {
    var search = {}
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/minlength",
        data: JSON.stringify(search),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayMinLength(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            displayMinLength(e);
        },
        done: function (e) {
            console.log("DONE");
            enableSearchMinButton(true);
        }
    });
}

function displayMaxLength(data) {
    var json =
        +JSON.stringify(data, null, 4);
    $('#maxlength').val(json);
}

function displayMinLength(data) {
    var json =
        +JSON.stringify(data, null, 4);
    $('#minlength').val(json);
}


function ajaxGetTwo() {
    var search = {}
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/allpath",
        data: JSON.stringify(search),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayToTable(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
            enableSearchButton(true);
        }
    });

}

function enableAllPathButton(flag) {
    $("#getALlRoutes").prop("disabled", flag);
}


function displayToTable(data) {
    $("tr:has(td)").remove();
    $.each(data, function (i, item) {
        $('<tr>').html("<td>" + data[i].id + "</td><td>" + data[i].name + "</td><td>" + data[i].objectPhone + "</td>")
            .appendTo('#routes__all');
    });
}

