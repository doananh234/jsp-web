var _data;
var selectedData = {};
var imgData;
var indexPaging = 1;
var limit = 10;
var count;
var maxPage = 0;
$(document).ready(function() {
    getProduct();
    $.get("GetCountProduct", function(data, status) {
        console.log(data);
        count = parseInt(data);
        console.log(count);
        $('#count').text(count);
        reloadPagingSize();
    });
    // 	maxPage = count/limit;
    // 	var components = [];
    // for (var i = 1; i <=maxPage; i++) {
    // 	components.push(
    // 		'<button class="pageButton btn '+(i==1? 'btn-success':'')+'"  onclick="changePage(this,'+i+')">'+i+'</button>'
    // 		);
    // }

    // 	$('#paging').html(components.join(""));


    $('#listProduct tbody').on('click', 'tr', function() {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        } else {
            $('tr .selected').removeClass('selected');
            $(this).addClass('selected');
        }

        var i = e.rowIndex - 2;
        enableEdit(i, true);
    });

    $('#img').change(selectImage);

    $('#deleteButton').click(function() {
        onDelete();
    });

    $('#addButton').click(function() {
        onAdd();
    });

    $('#updateButton').click(function() {
        onClickUpdate();
    });

    $('#openAdd').click(function() {
        setEnable('updateButton', false);
        setEnable('deleteButton', false);
        setEnable('addButton', true);
        togglePopup();
        selectedData = {};
    });

    $('#close').click(function() {
        togglePopup('close');
    });
});


function enableEdit(index, isEdit) {
    // $(".selected .")
}

function renderDatatable(data) {
    var components = data.map(function(data, index) {
        return (
            '<tr>' +
            '<td >' + renderId(data) + '</td>' +
            '<td>' + renderImg(data) + '</td>' +
            '<td>' + renderName(data) + '</td>' +
            '<td>' + renderPrice(data) + '</td>' +
            '<td>' + renderQuatity(data) + '</td>' +
            '<td>' + renderInfo(data) + '</td>' +
            '<td>' + renderActionButton(data, index) + '</td>' +
            '</tr>'
        );
    });
    $('#renderlist').html(components.join(''));
}

function reloadPagingSize(type) {
    switch (type) {
        case 'add':
            count += 1;
            // statements_1
            break;
        case 'remove':
            count -= 1;
            // statements_1
            break;
        default:
            // statements_def
            break;
    }
    var afterMaxPage = maxPage;
    maxPage = Math.ceil(count / limit);
    $('#count').text(count);
    indexPaging = maxPage < indexPaging ? 1 : indexPaging;
    if (maxPage != afterMaxPage) {
        var components = [];
        for (var i = 1; i <= maxPage; i++) {
            components.push(
                '<button class="pageButton btn ' + (i == indexPaging ? 'btn-success pageActive' : 'btn-default') + '" style="margin: 5px;"  onclick="changePage(this,' + i + ')">' + i + '</button>'
            );
        }
        $('#paging').html(components.join(""));
        getProduct();
    }
}

function changePage(e, index) {
    indexPaging = index;
    $('.pageActive').removeClass('btn-success');
    $('.pageActive').removeClass('pageActive');
    $(e).addClass('btn-success');
    $(e).addClass('pageActive');
    getProduct();
}

function getProduct() {
    $('#popup').hide();
    $.post("GetProduct", { pageIndex: indexPaging, limit: limit }, function(data, status) {
        console.log(data);
        _data = data;
        renderDatatable(data);
        // var table = $('#listProduct');
    });

}


function deleteRow(e) {
    console.log('on delete');
    var i = e.parentNode.parentNode.parentNode.rowIndex;
    console.log(i);
    console.log(_data[i - 2].idproduct);
    var objRequest = { id: _data[i - 2].idproduct, newRow: limit * indexPaging - 1 };
    $.post("deleteProduct", objRequest)
        .done(function(resData) {
            document.getElementById("listProduct").deleteRow(i);
            _data.splice(i, 1);
            _data.push(resData);
            console.log(_data);
            insertNewRow(resData);
            reloadPagingSize('remove');
        });
}


function insertNewRow(data, index) {
    if (!data) return;
    if (data.idproduct) {
        var row = document.getElementById("listProduct").insertRow(index ? index : limit - 2);
        for (var i = 0; i < 7; i++) {
            var cell = row.insertCell(i);
            cell.innerHTML = innerHTMLData(data, i);
        }
    }
}

function innerHTMLData(data, index) {
    switch (index) {
        case 0:
            return renderId(data);
        case 1:
            return renderImg(data);
        case 2:
            return renderName(data);
        case 3:
            return renderPrice(data);
        case 4:
            return renderQuatity(data);
        case 5:
            return renderInfo(data);
        default:
            // statements_def
            return renderActionButton(data, index);
    }
}

function selectImage(event) {
    event.stopPropagation();
    event.preventDefault();
    var files = event.target.files;
    var data = new FormData();
    console.log(files)
    $.each(files, function(key, value) {
        data.append(key, value);
    });
    imgData = data;

    var getImagePath = URL.createObjectURL(event.target.files[0]);
    $("#subImgTag").attr('src', getImagePath);
}

function onAdd() {
    var objRequest = getObjRequest();
    console.log(objRequest);
    uploadImg(function(PathImg) {
        objRequest.img = PathImg != 'fail' ? PathImg : 'assets/default.png';
        console.log(objRequest);
        $.post("addProduct", objRequest)
            .done(function(resData) {
                console.log('Add success');
                console.log(resData);
                document.getElementById("listProduct").deleteRow(limit + 1);
                _data.pop();
                _data.splice(0, 0, objRequest);
                console.log(_data);
                insertNewRow(resData, 2);
                reloadPagingSize('add');
            });
    });
}

function getObjRequest() {
    var objRequest = {
        name: $('#name').val() || '',
        price: $('#price').val() || '',
        quatity: $('#quatity').val() || 0,
        info: $('#info').val() || '',
    };
    return objRequest;
}

function edit(e) {
    console.log('on update');
    var tableRowIndex = e.parentNode.parentNode.parentNode.rowIndex;
    console.log(e.parentNode.parentNode.parentNode)
    console.log(e.parentNode.parentNode)
    console.log(e.parentNode)
    var objRequest = getObjRequest();
    uploadImg(function(PathImg) {
        objRequest.img = PathImg != 'fail' ? PathImg : _data[tableRowIndex - 2].img;
        objRequest.idproduct = _data[tableRowIndex - 2].idproduct;
        _data[tableRowIndex] = objRequest;
        console.log(tableRow);
        $.post("updateProduct", objRequest)
            .done(function(data) {
                console.log(data);
            });
    });
}

// objRequest.idproduct = selectedData.idproduct;
// 	$("#uploadServlet").submit(function( event ) {
// 		console.log(event);
// 		console.log (objRequest);
// 			$.post( "addProduct", objRequest)
// 			  .done(function( data ) {
// 		  	console.log(data);
// 		    togglePopup('close');
// 	  });
// 	});
// console.log ($('#img').attr('value'));
// console.log (objRequest);
// $.post("updateProduct", objRequest)
//   .done(function( data ) {
//   	console.log(data);
//     togglePopup('close');
//  });

function uploadImg(callback) {
    $.ajax({
        url: 'uploadServlet',
        type: "POST",
        data: new FormData(document.getElementById("uploadServlet")),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false
    }).done(function(data) {
        callback && callback(data);
    }).fail(function(jqXHR, textStatus) {
        //alert(jqXHR.responseText);
        alert('File upload failed ...');
    });
}

function setSelectedData(data) {
    $('#name').attr('value', data.name || '');
    $('#price').attr('value', data.price || '');
    $('#quatity').attr('value', data.quatity || '');
    $('#info').attr('value', data.info || '');
    $('#subImgTag').attr('src', data.img || "assets/default.png");
}

function setEnable(id, key) {
    var _id = '#' + id;
    if ($(_id.toString()).hasClass(key ? 'disabled' : 'active')) {
        $(_id.toString()).removeClass(key ? 'disabled' : 'active');
    }
    $(_id.toString()).addClass(key ? 'active' : 'disabled');
}

function togglePopup(key) {
    if ($('#popup').hasClass(key == 'close' ? 'bounceInDown' : 'bounceOutUp')) {
        $('#popup').removeClass(key == 'close' ? 'bounceInDown' : 'bounceOutUp');
    }
    $('#popup').addClass(key == 'close' ? 'bounceOutUp' : 'bounceInDown');
    key == 'close' ? $('#popup').hide() : $('#popup').css('display', 'flex');;
}

function renderId(data) {
    return '<div class="center colId" style="width:10%">' +
        '<p style="color: #FF1240; width: 100%">' + data.idproduct + '</p>' +
        '</div>';
}

function renderImg(data) {
    return '<div class="center colImg"><img src="' + data.img + '" alt="' + data.img + '" style="width:100px;"></div>';
}

function renderName(data) {
    return '<div class="center colName" style="width:10%">' +
        '<p style="color: #FF1240; width: 100%"> ' + data.name + '</p>' +
        '</div>';
}


function renderPrice(data) {
    return '<div class="center colPrice" style="width:10%">' +
        '<p style="color: #FF1240; width: 100%">' + data.price + '</p>' +
        '</div>';
}

function renderInfo(data) {
    return '<div class="center colInfo" style="width:10%">' +
        '<p style="color: #FF1240; width: 100%">' + data.info + '</p>' +
        '</div>';
}

function renderQuatity(data) {
    return '<div class="center colQuatity" style="width:10%">' +
        '<p style="color: #FF1240; width: 100%">' + data.info + '</p>' +
        '</div>';
}


function renderActionButton(data, index) {
    return '<div class="center colButton">' +
        '<button class="btn btn-success edit" onclick="edit(this)"><span class="glyphicon glyphicon-edit editIcon" /></button>' +
        '<button class="btn btn-danger delete" onclick="deleteRow(this)"><span class="glyphicon glyphicon-remove deleteIcon" /></button>' +
        '</div>';
}
