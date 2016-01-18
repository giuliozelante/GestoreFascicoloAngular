<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="${pageContext.request.contextPath}/js/datepicker-it.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/jquery.dataTables/date-eu.js"></script>
<script>
  //<![CDATA[
  $(document).ready(function () {
    $.datepicker.setDefaults($.datepicker.regional["it"]);
    $("#Fascicolo_searchFascicolo_dataAperturaDa").datepicker();
    $("#Fascicolo_searchFascicolo_dataAperturaA").datepicker();
    $("#Fascicolo_searchFascicolo_dataChiusuraDa").datepicker();
    $("#Fascicolo_searchFascicolo_dataChiusuraA").datepicker(); <s:if test="%{fascicoloList.length==0||fascicoloList[0]==null}">$("#warning p").html('${msgNoFascicoli}');
    $("#warning").dialog("open");</s:if>
    /*jQuery.validator.addMethod("greaterThan",

function (value, element, params) {

	if (!/Invalid|NaN/.test(new Date(value))) {
		return new Date(value) > new Date($(params).val());
	}

	return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
}, 'Deve essere maggiore di {0}.');

$("form#Fascicolo").validate({
	rules: {
		Fascicolo_searchFascicolo_dataAperturaA: {
			greaterThan: "#Fascicolo_searchFascicolo_dataAperturaDa"
		}
	},
	submitHandler: function (form) { // for demo
		alert('valid form');
		return false;
	}
});
*/
    $('form#Fascicolo').submit(function (e) {
      if ($('#Fascicolo_searchFascicolo_dataAperturaDa').val() != '' && $('#Fascicolo_searchFascicolo_dataAperturaDa').val() != 'undefined') {
        if (!checkDateValidFormat('#Fascicolo_searchFascicolo_dataAperturaDa')) {
          e.preventDefault();
          $("#warning").dialog("open");
        }
      }
      if ($('#Fascicolo_searchFascicolo_dataAperturaA').val() != '' && $('#Fascicolo_searchFascicolo_dataAperturaA').val() != 'undefined') {
        if (!checkDateValidFormat('#Fascicolo_searchFascicolo_dataAperturaA')) {
          e.preventDefault();
          $("#warning").dialog("open");
        }
        if (!checkDateRange('#Fascicolo_searchFascicolo_dataAperturaDa', '#Fascicolo_searchFascicolo_dataAperturaA')) {
          e.preventDefault();
          $("#warning").dialog("open");
        }
      }
      if ($('#Fascicolo_searchFascicolo_dataChiusuraDa').val() != '' && $('#Fascicolo_searchFascicolo_dataChiusuraDa').val() != 'undefined') {
        if (!checkDateValidFormat('#Fascicolo_searchFascicolo_dataChiusuraDa')) {
          e.preventDefault();
          $("#warning").dialog("open");
        }
      }
      if ($('#Fascicolo_searchFascicolo_dataChiusuraA').val() != '' && $('#Fascicolo_searchFascicolo_dataChiusuraA').val() != 'undefined') {
        if (!checkDateValidFormat('#Fascicolo_searchFascicolo_dataChiusuraA')) {
          e.preventDefault();
          $("#warning").dialog("open");
        }
        if (!checkDateRange('#Fascicolo_searchFascicolo_dataChiusuraDa', '#Fascicolo_searchFascicolo_dataChiusuraA')) {
          e.preventDefault();
          $("#warning").dialog("open");
        }
      }
    });
  });

  function checkDateRange(from, to) {
    var dateDaArr = ($(from).val()).split("\/");
    var dateDa = new Date(dateDaArr[2], dateDaArr[1], dateDaArr[0]);
    var dateAArr = ($(to).val()).split("\/");
    var dateA = new Date(dateAArr[2], dateAArr[1], dateAArr[0]);
    if (dateDa > dateA) {
      $(from).css('border', '1px solid red');
      $(to).css('border', '1px solid red');
      $("#warning p").html('${msgRangeDateErrato}');
      return false;
    }
    return true;
  }

  function checkDateValidFormat(fieldId) {
      var validformat = ${RegexDateFormat}; //Basic check for format validity
      if (!validformat.test($(fieldId).val())) {
        $(fieldId).css('border', '1px solid red');
        $("#warning p").html('${msgFormatoDataErrato}');
        return false;
      }
      return true;
    } 
  
	
	$("#exportListaExcelFascicolo").submit(function(e){
		var temp=$("#tableToExport").html();
		var elencodati=temp
		$("#tableLista").val(elencodati);
	});
  
  //]]>
</script>