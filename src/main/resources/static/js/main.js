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

    $("#editor__one__search__form").submit(function (event) {
        enableOnePathButton(false);
        event.preventDefault();
        ajaxGetPathByIdEditor();
    });

    $("#editor__patch__form").submit(function (event) {
        enableChangeNumberButton(false);
        event.preventDefault();
        ajaxChangeNumberEditor();
    });

    $("#editor__delete__form").submit(function (event) {
        enableDeleteButton(false);
        event.preventDefault();
        ajaxDeleteEditor();
    });

    $("#editor__coors__search__form").submit(function (event) {
        enableFindCoorsButton(false);
        event.preventDefault();
        ajaxGetCoorsById();
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

function enableChangeNumberButton(flag) {
    $("#editor__patch__number__btn").prop("disabled", flag);
}

function enableDeleteButton(flag) {
    $("#editor__delete__btn").prop("disabled", flag);
}

function enableFindCoorsButton(flag) {
    $("#editor__getRouteCoors").prop("disabled", flag);
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


function displayToTableCoors(data) {
    $("#editor__coors").find("tr:gt(0)").remove();
    $.each(data, function (i, item) {
        $('<tr>').html("<td>" + data[i].coorX + "</td><td>" + data[i].coorY + "</td>")
            .appendTo('#editor__coors');
    });
}

function displayToTableOneEditor(data) {
    $("#editor__one").find("tr:gt(0)").remove();
    $('<tr>').html("<td>" + data.id + "</td><td>" + data.number + "</td><td>" + data.name + "</td><td>" + data.objectPhone + "</td>")
        .appendTo('#editor__one');
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


function ajaxGetPathByIdEditor() {
    var search = {}
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById("editor__one__searching").value,
        data: JSON.stringify(search),
        dataType: 'json',
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
    var newNumber = {number : document.getElementById("editor__patch__change__number").value}
    $.ajax({
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        type: "PATCH",
        url: "http://localhost:9090/cyclepath/" + document.getElementById("editor__one__searching").value,
        data: JSON.stringify(newNumber),
        timeout: 100000,

        success: function (newNumber) {
            console.log("SUCCESS: ", newNumber);
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

function ajaxDeleteEditor() {
     var deletedId = {}
    $.ajax({
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        type: "DELETE",
        url: "http://localhost:9090/cyclepath/" + document.getElementById("editor__delete__route").value,
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
    var search = {}
    $.ajax({
        type: "GET",
        url: "http://localhost:9090/cyclepath/" + document.getElementById("editor__coors__searching").value + "/coordinates",
        data: JSON.stringify(search),
        dataType: 'json',
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






