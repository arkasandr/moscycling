jQuery(document).ready(function ($) {

    $("#info__max__form").submit(function (event) {
        enableSearchMaxButton(false);
        event.preventDefault();
        searchMaxLengthAjax()
    });


    $("#info__min__form").submit(function (event) {
        enableSearchMinButton(false);
        event.preventDefault();
        searchMinLengthAjax()
    });


    $("#routes__search__form").submit(function (event) {
        enableAllPathButton(false);
        event.preventDefault();
        ajaxGetTwo()
    });

    $("#route__one__search__form").submit(function (event) {
        enableOnePathButton(false);
        event.preventDefault();
        ajaxGetPathById();
        ajaxGetPathLength()
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

function enableAllPathButton(flag) {
    $("#getALlRoutes").prop("disabled", flag);
}

function enableOnePathButton(flag) {
    $("#getOneRoute").prop("disabled", flag);
}


function displayToTableAll(data) {
    $("tr:has(td)").remove();
    $.each(data, function (i, item) {
        $('<tr>').html("<td>" + data[i].id + "</td><td>" + data[i].name + "</td><td>" + data[i].objectPhone + "</td>")
            .appendTo('#routes__all');
    });
}

function displayToTableOne(data) {
    $("#route__one").find("tr:gt(0)").remove();
    $('<tr>').html("<td>" + data.id + "</td><td>" + data.width + "</td><td>" + data.location + "</td><td id='length'>" + "</td>")
        .appendTo('#route__one');
}


function ajaxGetPathLength() {
    var search = {}
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById("route__one__searching").value + "/length",
        data: JSON.stringify(search),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            document.getElementById('length').innerHTML = data
        },

        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
            enableOnePathButton(true);
        }
    });
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
            displayToTableAll(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
            enableAllPathButton(true);
        }
    });
}

function ajaxGetPathById() {
    var search = {}
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById("route__one__searching").value,
        data: JSON.stringify(search),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayToTableOne(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
            enableOnePathButton(true);
        }
    });
}






