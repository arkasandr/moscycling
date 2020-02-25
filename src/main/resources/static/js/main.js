jQuery(document).ready(function ($) {

    $('#info-max-form').submit(function (event) {
        enableSearchMaxButton(false);
        event.preventDefault();
        searchMaxLengthAjax()
    });


    $('#info-min-form').submit(function (event) {
        enableSearchMinButton(false);
        event.preventDefault();
        searchMinLengthAjax()
    });


    $('#routes-search-form').submit(function (event) {
        enableAllPathButton(false);
        event.preventDefault();
        ajaxGetTwo()
    });

    $('#route-one-search-form').submit(function (event) {
        enableOnePathButton(false);
        event.preventDefault();
        ajaxGetPathById();
        ajaxGetPathLength()
    });

    $('#editor-one-search-form').submit(function (event) {
        enableOnePathButton(false);
        event.preventDefault();
        ajaxGetPathByIdEditor();
    });

    $('#editor-patch-form').submit(function (event) {
        enableChangeNumberButton(false);
        event.preventDefault();
        ajaxChangeNumberEditor();
    });

    $('#editor-delete-form').submit(function (event) {
        enableDeleteButton(false);
        event.preventDefault();
        ajaxDeleteEditor();
    });

    $('#editor-coors-search-form').submit(function (event) {
        enableFindCoorsButton(false);
        event.preventDefault();
        ajaxGetCoorsById();
    });
});

function enableSearchMaxButton(flag) {
    $('#info-max-form-search').prop("disabled", flag);
}

function enableSearchMinButton(flag) {
    $('#info-min-form-search').prop("disabled", flag);
}


function searchMaxLengthAjax() {
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/maxlength",
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
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/minlength",
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
    $('#getALlRoutes').prop("disabled", flag);
}

function enableOnePathButton(flag) {
    $('#getOneRoute').prop("disabled", flag);
}

function enableChangeNumberButton(flag) {
    $('#editor-patch-number-btn').prop("disabled", flag);
}

function enableDeleteButton(flag) {
    $('#editor-delete-btn').prop("disabled", flag);
}

function enableFindCoorsButton(flag) {
    $('#editor-getRouteCoors').prop("disabled", flag);
}

function displayToTableAll(data) {
    $('tr:has(td)').remove();
    $.each(data, function (i, item) {
        $('<tr>').html("<td>" + data[i].id + "</td><td>" + data[i].name + "</td><td>" + data[i].objectPhone + "</td>")
            .appendTo('#routes-all');
    });
}

function displayToTableOne(data) {
    $('#route-one').find("tr:gt(0)").remove();
    $('<tr>').html("<td>" + data.id + "</td><td>" + data.width + "</td><td>" + data.location + "</td><td id='length'>" + "</td>")
        .appendTo('#route-one');
}

function displayToTableOneEditor(data) {
    $('#editor-one').find("tr:gt(0)").remove();
    $('<tr>').html("<td>" + data.id + "</td><td>" + data.number + "</td><td>" + data.name + "</td><td>" + data.objectPhone + "</td>")
        .appendTo('#editor-one');
}

function displayToTableCoors(data) {
    $('#editor-coors').find("tr:gt(0)").remove();
    $.each(data, function (i, item) {
        $('<tr>').html("<td>" + data[i].coorX + "</td><td>" + data[i].coorY + "</td>")
            .appendTo('#editor-coors');
    });
}

function ajaxGetPathLength() {
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById('route-one-searching').value + "/length",
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
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/allpath",
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
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById('route-one-searching').value,
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


function ajaxGetPathByIdEditor() {
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById('editor-one-searching').value,
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayToTableOneEditor(data);
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


function ajaxChangeNumberEditor() {
    var newNumber = {number: document.getElementById('editor-patch-change-number').value}
    $.ajax({
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        type: "PATCH",
        url: "http://localhost:9090/cyclepath/" + document.getElementById('editor-one-searching').value,
        data: JSON.stringify(newNumber),
        timeout: 100000,

        success: function (newNumber) {
            console.log("SUCCESS: ", newNumber);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        done: function (e) {
            console.log("DONE");
            enableOnePathButton(true);
        }
    });
}

function ajaxDeleteEditor() {
    var deletedId = {}
    $.ajax({
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        type: "DELETE",
        url: "http://localhost:9090/cyclepath/" + document.getElementById('editor-delete-route').value,
        data: JSON.stringify(deletedId),
        timeout: 100000,

        success: function (deletedId) {
            console.log("SUCCESS: ", deletedId);
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

function ajaxGetCoorsById() {
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById('editor-coors-searching').value + "/coordinates",
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayToTableCoors(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
            enableFindCoorsButton(true);
        }
    });
}





