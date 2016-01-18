$(function () {
  $("#error,#warning").dialog({
    autoOpen: false,
    resizable: false,
    modal: true,
    buttons: {
      Ok: function () {
        $(this).dialog("close");
      }
    }
  });
});
$(function () {
  $(document).tooltip();
});
$(document).ready(function () {
  //inizio ric-2015-03-26 le tabelle gestite con datatables vengono visualizzate solo alla fine del caricamento della pagina
  $('.showBeforeLoad').each(function () {
    $(this).hide();
  });
  $('.showAfterLoad').each(function () {
    $(this).show();
  });
  //inizio ric-2015-03-26
  $('a,td.head').not('a[href="javascript:void(0)"]').click(function (event) {
    event.preventDefault();
    $('a,td.head').not('a[href="javascript:void(0)"]').off('click');
    var query = $(this).attr('href').split('?')[1];
    if (query != undefined) {
      var vars = query.split('&');
      for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split('=');
        var value = replaceAll('\\+', ' ', pair[1]);
        value=fixDate(pair[0],value);
        $('form#linkMaskForm').append('<input type="text" name="' + pair[0] + '" value="' + value + '" />');
      }
    }
    $('form#linkMaskForm').attr('action', $(this).attr('href').split('?')[0]);
    $('form#linkMaskForm').submit();
  });
  $('[data-popup-target]').click(function () {
    var activePopup = $(this).attr('data-popup-target');
    $(activePopup).addClass('visible');
    $('#loading').css('display', 'fixed');
    $('img.loading').css('display', 'none');
  });
  $(document).keyup(function (e) {
    if (e.keyCode == 27 && $('html').hasClass('overlay')) {
      clearPopup();
    }
  });
  $('.popup-exit').click(function () {
    clearPopup();
  });
  $('.popup-overlay').click(function () {
    clearPopup();
  });

  function clearPopup() {
    $('.popup.visible').removeClass('visible');
    $('#loading').css('display', 'none');
  }
  hideAllMessages();
  $('.message').click(function () {
    $(this).animate({
      top: -$(this).outerHeight()
    }, 500);
  });
  $('table.dataTable thead th').each(function () {
    $(this).width('1%');
  });
  $('table.dataTable tbody td').not('.buttons,.popup-link,.link,.head,.date').each(function () {
    if (!$(this).hasClass('renderingType2')&&!$(this).is("input")) {
      var text = $.trim($(this).text());
      $(this).text(text);
      if (text.length > 20) {
        $(this).width('1%');
        $(this).attr("title", text);
        $(this).attr("alt", text);
        $(this).text(text.substr(0, 20) + "...");
        $(this).css('cursor', 'pointer');
        $(this).toggle(function () {
          var text2 = $(this).attr("alt");
          $(this).text(text2);
          $(this).css("white-space", "normal");
          $("[id^='ui-id']").hide();
        }, function () {
          var text2 = $(this).attr('alt');
          $(this).text(text2.substr(0, 20) + "...");
          $(this).css("white-space", "nowrap");
        });
      }
    }
  });
  $('table.dataTable tbody td.link').each(function () {
    $(this).children('ul').children('li:gt(0)').hide();
    var lis = $(this).children('ul').children('li:gt(0)');
    $(this).children('div.list').toggle(function () {
      $(this).children().addClass('up');
      $(this).css('position', 'relative');
      $(lis).slideDown();
    }, function () {
      $(this).children().removeClass('up');
      $(this).css('position', 'absolute');
      $(lis).slideUp();
    });
  });
  $('td.head').each(function () {
    var href = $(this).children('a').attr('href');
    $(this).children('a').removeAttr('href');
    $(this).text($(this).children('a').text());
    $(this).attr('href', href);
    $.trim($(this).text());
    $(this).css('color', '#00A');
    $(this).css('cursor', 'pointer');
  });
  var i = 0;
  $('table.dataTable').each(function () {
    if (typeof $(this).attr('id') === "undefinend") {
      $(this).attr('id', 'dataTable' + i);
    }
    $(this).DataTable({
      "language": {
        "sEmptyTable": "Nessun dato presente nella tabella",
        "sInfo": "Vista da _START_ a _END_ di _TOTAL_ elementi",
        "sInfoEmpty": "Vista da 0 a 0 di 0 elementi",
        "sInfoFiltered": "(filtrati da _MAX_ elementi totali)",
        "sInfoPostFix": "",
        "sInfoThousands": ",",
        "sLengthMenu": "Visualizza _MENU_ elementi",
        "sLoadingRecords": "Caricamento...",
        "sProcessing": "Elaborazione...",
        "sSearch": "Cerca:",
        "sZeroRecords": "La ricerca non ha portato alcun risultato.",
        "oPaginate": {
          "sFirst": "Inizio",
          "sPrevious": "Precedente",
          "sNext": "Successivo",
          "sLast": "Fine"
        },
        "oAria": {
          "sSortAscending": ": attiva per ordinare la colonna in ordine crescente",
          "sSortDescending": ": attiva per ordinare la colonna in ordine decrescente"
        }
      },
    });
    i++;
  });
  //inizio   mod 2015-03-12
  var i = 0;

    $('#elencoDati').dataTable( {
	    	 paging: false,
	    	 searching: false,
	        "order": [[ 0, "asc" ]]
	    } );

  $('table.dataTableDetails').each(function () {
    if (typeof $(this).attr('id') === "undefinend") {
      $(this).attr('id', 'dataTableDetails' + i);
    }
    $(this).DataTable({
      "language": {
        "sEmptyTable": "Nessun dato presente nella tabella",
        "sInfo": "Vista da _START_ a _END_ di _TOTAL_ elementi",
        "sInfoEmpty": "Vista da 0 a 0 di 0 elementi",
        "sInfoFiltered": "(filtrati da _MAX_ elementi totali)",
        "sInfoPostFix": "",
        "sInfoThousands": ",",
        "sLengthMenu": "Visualizza _MENU_ elementi",
        "sLoadingRecords": "Caricamento...",
        "sProcessing": "Elaborazione...",
        "sSearch": "Cerca:",
        "sZeroRecords": "La ricerca non ha portato alcun risultato.",
        "oPaginate": {
          "sFirst": "Inizio",
          "sPrevious": "Precedente",
          "sNext": "Successivo",
          "sLast": "Fine"
        },
        "oAria": {
          "sSortAscending": ": attiva per ordinare la colonna in ordine crescente",
          "sSortDescending": ": attiva per ordinare la colonna in ordine decrescente"
        }
      },
      "paging": false,
      "ordering": true,
      "info": false,
      "filter": false,
      "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) { //mod 2015-04-02 tabelle figlie con righe di colore diverso
        if (iDisplayIndex % 2 == 0) {
          $('td', nRow).removeClass("child-even");
          $('td', nRow).addClass("child-odd");
        } else {
          $('td', nRow).removeClass("child-odd");
          $('td', nRow).addClass("child-even");
        }
      }
    });
    i++;
  });
  //fine   mod 2015-03-12
  if ($('.export').length) {
    $(".push").before($("#exportForm").html());
    $("#exportForm").remove();
  }
  $('#table').val($('.export').html());
  i = 0;
  $("fieldset.detail div[class*='dataTables_wrapper']").hide();
  i = 1;
  $("fieldset.detail legend").each(function () {
    if ($(this).parent().attr('class') != 'detailEntityItemTabella') {
      $(this).click(function () {
        //serve per rendere fissa la larghezza delle colonne che contengono i pulsantini per espandere/comprimere le tabelle figlie
        $('.espandiComprimiColumn').css('width', '30px');
        $(this).next("div[class*='dataTables_wrapper']").toggle();
        var bgPos = $(this).children("div.arrow").css("background-position");
        bgPos.indexOf("-21") != -1 ? $(this).children("div.arrow").css("background-position", "") : $(this).children("div.arrow").css("background-position", "-21px 0");
      });
    } else {
      $(this).next("div[class*='dataTables_wrapper']").toggle();
    }
  });
});

function onSuccess(data, status) {
  $("div#loading").hide();
  writeEsito(data);
}

function onError(jqXHR, exception) {
  $("div#loading").hide();
  if (jqXHR.status === 0) {
    message = ('Not connect.n Verify Network.');
  } else if (jqXHR.status == 404) {
    message = ('Requested page not found. [404]');
  } else if (jqXHR.status == 500) {
    message = ('Internal Server Error [500].');
  } else if (exception === 'parsererror') {
    message = ('Requested JSON parse failed.');
  } else if (exception === 'timeout') {
    message = ('Time out error.');
  } else if (exception === 'abort') {
    message = ('Ajax request aborted.');
  } else {
    message = ('Uncaught Error.n' + jqXHR.responseText);
  }
  $("div.alert-message.error p").text(message);
  $("div.alert-message.error").show();
}

function writeEsito(data) {
  obj = $.parseJSON(data);
  var esito = "";
  if (obj.esito) {
    esito = obj.esito;
  } else if (obj.codiceEsito) {
    esito = obj.codiceEsito
  }
  if (esito.indexOf("OK") != -1) {
    showMessage('success', esito, obj.descrizioneEsito ? obj.descrizioneEsito : "");
  } else {
    showMessage('error', esito, obj.descrizioneEsito ? obj.descrizioneEsito : "");
  }
}
var myMessages = ['info', 'warning', 'error', 'success'];

function hideAllMessages() {
  var messagesHeights = new Array();
  for (i = 0; i < myMessages.length; i++) {
    messagesHeights[i] = $('.' + myMessages[i]).outerHeight();
    $('.' + myMessages[i]).css('top', -messagesHeights[i]);
  }
}

function showMessage(type, message, title) {
  hideAllMessages();
  $('.' + type).show();
  if (message != null || message != undefined || message != '') {
    $('.' + type + ' p').html(message);
  }
  if (title != null || title != undefined || title != '') {
    $('.' + type + ' h3').html(title);
  }
  $('.' + type).animate({
    top: "0"
  }, 500);
  setTimeout(function () {
    $('.' + type).animate({
      top: -$('.' + type).outerHeight()
    }, 500);
  }, 2000);
}

function krEncodeEntities(s) {
  return $("<div/>").text(s).html();
}

function krDencodeEntities(s) {
  return $("<div/>").html(s).text();
}

function replaceAll(find, replace, str) {
  return str.replace(new RegExp(find, 'g'), replace);
}
function fixDate(pair,value)
{
	  if(pair.indexOf("data")>-1)
	  {
		  if(value!=''){
		  	value=value.replace(new RegExp("%2f", 'g'), "/");
		  	value=value.replace(new RegExp("%2F", 'g'), "/");
		  }
		  return value;
	  }
	  return value;
}