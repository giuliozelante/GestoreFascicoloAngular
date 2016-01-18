<%@ taglib prefix="s" uri="/struts-tags"%>
<a style="display:none" id="dettaglioFascicoloUrl" href='<s:url action="dettaglioFascicolo"><s:param name="fascicolo.callerId">${fascicolo.callerId}</s:param><s:param name="fascicolo.fascicoloId">${fascicolo.fascicoloId}</s:param></s:url>'>&nbsp;</a>
<s:form action="getPdfDocumentoFascicolo" id="hiddenFormPdf" cssStyle="display:none" method="POST">
  <s:hidden name="fascicolo.callerId" id="pdf_fascicolo_callerId" value="" />
  <s:hidden name="fascicolo.fascicoloId" id="pdf_fascicolo_fascicoloId" value="" />
  <s:hidden name="getPdfDocumentoWSRequest.callerId" id="pdf_callerId" value="" />
  <s:hidden name="getPdfDocumentoWSRequest.fascicoloId" id="pdf_fascicoloId" value="" />
  <s:hidden name="getPdfDocumentoWSRequest.numeroDocumento" id="pdf_numeroDocumento" value="" />
  <s:hidden name="getPdfDocumentoWSRequest.cf" id="pdf_cf" value="" />
  <input type="hidden" name="downloadPDF" id="downloadPDF" value="true" />
  <input type="hidden" name="pdfTimeInMillis" id="pdfTimeInMillis" value="" />
</s:form>
<s:form action="getRelateFascicolo" id="hiddenFormRelate" cssStyle="display:none" method="POST">
  <s:hidden name="fascicolo.callerId" id="relate_fascicolo_callerId" value="" />
  <s:hidden name="fascicolo.fascicoloId" id="relate_fascicolo_fascicoloId" value="" />
  <s:hidden name="getRelateWSRequest.callerId" id="relate_callerId" value="" />
  <s:hidden name="getRelateWSRequest.fascicoloId" id="relate_fascicoloId" value="" />
  <s:hidden name="getRelateWSRequest.numeroDocumento" id="relate_numeroDocumento" value="" />
  <s:hidden name="getRelateWSRequest.cf" id="relate_cf" value="" />
  <s:hidden name="getRelateWSRequest.download" id="download" value="" />
  <input type="hidden" name="downloadRelate" id="downloadRelate" value="true" />
  <input type="hidden" name="relateTimeInMillis" id="relateTimeInMillis" value="" />
</s:form>
<script>
//<![CDATA[
 $(document).ready (function(){
	 <s:if test="%{hasActionMessages()&&(#context['struts.actionMapping'].name=='dettaglioCartellaFascicolo'||#context['struts.actionMapping'].name=='apriDocumentiEsattorialiFascicolo')}">
	 $( "#warning" ).dialog({
		  close: function( event, ui ) {
			  window.location.href = $('a#dettaglioFascicoloUrl').attr('href');
		  }
		});
	 </s:if>
	 <s:if test="%{hasActionErrors()&&(#context['struts.actionMapping'].name=='dettaglioCartellaFascicolo'||#context['struts.actionMapping'].name=='apriDocumentiEsattorialiFascicolo')}">
	 $( "#error" ).dialog({
		  close: function( event, ui ) {
			  window.location.href = $('a#dettaglioFascicoloUrl').attr('href');
		  }
		});
	 </s:if>
	 $('div#loadingDett').hide();
	 $('form#Fascicolo').submit(function (e) {
		 $('input').each(function (i) {
		   $(this).val($.trim($(this).val()))
		 });
		 $('[name="anagrafica.emailNew"]').each(function (i) {
		   if (!isValidEmailAddress(this)) {
		     e.preventDefault();
		     $("#warning").dialog("open");
		   }
		 });
		 $('[name="anagrafica.telefonoNew"]').each(function (i) {
		   if (!isValidTelephone(this)) {
		     e.preventDefault();
		     $("#warning").dialog("open");
		   }
		 });
		 $("[id$='salvaAnagraficaFascicolo']").click(function () {
		   $("div#loading").fadeIn(2000);
		 });
	    });
	 });
		 function getPdfDocumento(element, callerId, fascicoloId, numeroDocumento, cf, _url) {
		   $("[id^='ui-id']").not(".ui-dialog-title").hide();
		   var destination = $(element).offset();
		   $('img#over-loading').css({
		     top: destination.top,
		     left: destination.left
		   }).show();
		   $.ajax({
		     url: $('form#hiddenFormPdf').attr('action'),
		     type: "GET",
		     data: {
		       'fascicolo.callerId': callerId,
		       'fascicolo.fascicoloId': fascicoloId,
		       'getPdfDocumentoWSRequest.callerId': callerId,
		       'getPdfDocumentoWSRequest.fascicoloId': fascicoloId,
		       'getPdfDocumentoWSRequest.numeroDocumento': numeroDocumento,
		       'getPdfDocumentoWSRequest.cf': cf,
		       'pdfTimeInMillis': new Date().getTime()
		     },
		     success: function (result, status, xhr) {
		       $('img#over-loading').hide();
		       obj = $.parseJSON(result);
		       $(element).children('div.statoPdf').attr('class', 'statoPdf').addClass('' + obj.esito + '');
		       if (obj.esito == 'NR') {
		         $(element).attr('title', '<s:text name="link.title.pdf.richiedi" />');
		       } else if (obj.esito == 'RI') {
		         $(element).attr('title', '<s:text name="link.title.pdf.richiesto" />');
		       } else if (obj.esito == 'DI') {
		         $(element).attr('title', '<s:text name="link.title.pdf.disponibile" />');
		         $("#pdf_fascicolo_callerId").val(callerId);
		         $("#pdf_fascicolo_fascicoloId").val(fascicoloId);
		         $("#pdf_callerId").val(callerId);
		         $("#pdf_fascicoloId").val(fascicoloId);
		         $("#pdf_numeroDocumento").val(numeroDocumento);
		         $("#pdf_cf").val(cf);
		         $("#pdfTimeInMillis").val(new Date().getTime());
		         $('#hiddenFormPdf').submit();
		       } else if (obj.esito == 'ND' || obj.esito.indexOf('KO') != -1) {
		         if (obj.esito.indexOf('KO') != -1) {
		           $("#error").dialog("open");
		         }
		         $(element).attr('title', '<s:text name="link.title.pdf.nondisponibile" />');
		       }
		     }
		   });
		   return false;
		 }

		 function getRelate(element, callerId, fascicoloId, numeroDocumento, cf, dataRelate, statoRelate) {
		   $("[id^='ui-id']").not(".ui-dialog-title").hide();
		   $("#dialog-confirm-relate span#dataRelate").text($('#' + dataRelate).val());
		   if ($('#' + statoRelate).val() == 'DI') {
		     $("#dialog-confirm-relate").show();
		     $("#dialog-confirm-relate").dialog({
		       title: $("#dialog-confirm-relate").attr("title-holder") + numeroDocumento,
		       resizable: false,
		       height: 160,
		       width: 300,
		       modal: true,
		       buttons: { <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}"> "Aggiorna": function () {
		           var destination = $(element).offset();
		           $('img#over-loading').css({
		             top: destination.top,
		             left: destination.left
		           }).show();
		           $.ajax({
		             url: $('form#hiddenFormRelate').attr('action'),
		             type: "GET",
		             data: {
		               'fascicolo.callerId': callerId,
		               'fascicolo.fascicoloId': fascicoloId,
		               'getRelateWSRequest.callerId': callerId,
		               'getRelateWSRequest.fascicoloId': fascicoloId,
		               'getRelateWSRequest.numeroDocumento': numeroDocumento,
		               'getRelateWSRequest.cf': cf,
		               'getRelateWSRequest.download': 'N',
		               'relateTimeInMillis': new Date().getTime()
		             },
		             success: function (result, status, xhr) {
		               $('img#over-loading').hide();
		               obj = $.parseJSON(result);
		               $(element).children('div.statoRelate').attr('class', 'statoRelate').addClass('' + obj.esito + '');
		               $('#' + statoRelate).val('' + obj.esito + '')
		               if (obj.esito == 'NR') {
		                 $(element).attr('title', '<s:text name="link.title.relate.richiedi" />');
		               } else if (obj.esito == 'RI') {
		                 $(element).attr('title', '<s:text name="link.title.relate.richiesto" />');
		               } else if (obj.esito == 'DI') {
		                 $(element).attr('title', '<s:text name="link.title.relate.disponibile" />');
		                 $('#' + dataRelate).val('' + obj.dataAggiornamento + '');
		               } else if (obj.esito == 'ND' || obj.esito.indexOf('KO') != -1) {
		                 if (obj.esito.indexOf('KO') != -1) {
		                   $("#error").dialog("open");
		                 }
		                 $(element).attr('title', '<s:text name="link.title.relate.nondisponibile" />');
		               }
		             }
		           });
		           $(this).dialog("close");
		         }, </s:if>
		         "Scarica": function () {
		           $(this).dialog("close");
		           $.ajax({
		             url: $('form#hiddenFormRelate').attr('action'),
		             type: "GET",
		             data: {
		               'fascicolo.callerId': callerId,
		               'fascicolo.fascicoloId': fascicoloId,
		               'getRelateWSRequest.callerId': callerId,
		               'getRelateWSRequest.fascicoloId': fascicoloId,
		               'getRelateWSRequest.numeroDocumento': numeroDocumento,
		               'getRelateWSRequest.cf': cf,
		               'getRelateWSRequest.download': 'S',
		               'relateTimeInMillis': new Date().getTime()
		             },
		             success: function (result, status, xhr) {
		               $('img#over-loading').hide();
		               obj = $.parseJSON(result);
		               $(element).children('div.statoRelate').attr('class', 'statoRelate').addClass('' + obj.esito + '');
		               $('#' + statoRelate).val('' + obj.esito + '')
		               if (obj.esito == 'DI') {
		                 $(element).attr('title', '<s:text name="link.title.relate.disponibile" />');
		                 var destination = $(element).offset();
		                 $('img#over-loading').css({
		                   top: destination.top,
		                   left: destination.left
		                 }).show();
		                 $("#relate_fascicolo_callerId").val(callerId);
		                 $("#relate_fascicolo_fascicoloId").val(fascicoloId);
		                 $("#relate_callerId").val(callerId);
		                 $("#relate_fascicoloId").val(fascicoloId);
		                 $("#relate_numeroDocumento").val(numeroDocumento);
		                 $("#relate_cf").val(cf);
		                 $("#download").val('S');
		                 $("#relateTimeInMillis").val(new Date().getTime());
		                 $('#hiddenFormRelate').submit();
		                 $('img#over-loading').hide();
		               } else if (obj.esito == 'ND' || obj.esito.indexOf('KO') != -1) {
		                 if (obj.esito.indexOf('KO') != -1) {
		                   $("#error").dialog("open");
		                 }
		                 $(element).attr('title', '<s:text name="link.title.relate.nondisponibile" />');
		               }
		             }
		           });
		         }
		       }
		     });
		   } else {
		     var destination = $(element).offset();
		     $('img#over-loading').css({
		       top: destination.top,
		       left: destination.left
		     }).show();
		     var download = 'N'
		     if ($('#' + statoRelate).val() == 'RI') {
		       download = 'S'
		     }
		     $.ajax({
		       url: $('form#hiddenFormRelate').attr('action'),
		       type: "GET",
		       data: {
		         'fascicolo.callerId': callerId,
		         'fascicolo.fascicoloId': fascicoloId,
		         'getRelateWSRequest.callerId': callerId,
		         'getRelateWSRequest.fascicoloId': fascicoloId,
		         'getRelateWSRequest.numeroDocumento': numeroDocumento,
		         'getRelateWSRequest.cf': cf,
		         'getRelateWSRequest.download': download
		       },
		       success: function (result, status, xhr) {
		         $('img#over-loading').hide();
		         obj = $.parseJSON(result);
		         $(element).children('div.statoRelate').attr('class', 'statoRelate').addClass('' + obj.esito + '');
		         $('#' + statoRelate).val('' + obj.esito + '');
		         if (obj.esito == 'NR') {
		           $(element).attr('title', '<s:text name="link.title.relate.richiedi" />');
		         } else if (obj.esito == 'RI') {
		           $(element).attr('title', '<s:text name="link.title.relate.richiesto" />');
		         } else if (obj.esito == 'DI') {
		           $(element).attr('title', '<s:text name="link.title.relate.disponibile" />');
		           $('#' + dataRelate).val('' + obj.dataAggiornamento + '');
		           $("#fascicolo_callerId").val(callerId);
		           $("#fascicolo_fascicoloId").val(fascicoloId);
		           $("#relate_callerId").val(callerId);
		           $("#relate_fascicoloId").val(fascicoloId);
		           $("#relate_numeroDocumento").val(numeroDocumento);
		           $("#relate_cf").val(cf);
		           $("#download").val('S');
		           $('#hiddenFormRelate').submit();
		         } else if (obj.esito == 'ND' || obj.esito.indexOf('KO') != -1) {
		           if (obj.esito.indexOf('KO') != -1) {
		             $("#error").dialog("open");
		           }
		           $(element).attr('title', '<s:text name="link.title.relate.nondisponibile" />');
		         }
		       }
		     });
		     return false;
		   }
		 }

		 function removeIndirizzoAlternativo(id) {
		   //alert(id);
		   var last = $("[name='anagrafica.indirizzoRemove']:last");
		   if (id != '' && $('#' + id).val() != '') {
		     $("[name='anagrafica.indirizzoRemove']:last").clone().insertAfter("[name='anagrafica.indirizzoRemove']:last");
		     last.val($('#' + id).val());
		   }
		   $('#' + id).parent('div').remove();
		   if (($("[name='anagrafica.indirizzoNew']").length) <=${indirizziAlternatiMax}) {
		     $("#aggiungiIndirizzoAlternativo").show();
		   }
		 }

		 function addIndirizzoAlternativo() {
		   //alert('addIndirizzoAlternativo');
		   if (($("[name='anagrafica.indirizzoAlternativo']").length) <=${indirizziAlternatiMax}) {
		     var indAlt = $("div.indirizzoAlternativo:last").clone()
		     indAlt.find("[type='text']").attr("id", "indirizzoNew0").removeAttr('disabled');
		     indAlt.insertBefore("div.indirizzoAlternativo:last").show();
		     if (($("[name='anagrafica.indirizzoNew']").length + $("[name='anagrafica.indirizzoAlternativo']").length) > ${indirizziAlternatiMax}) {
		       $("#aggiungiIndirizzoAlternativo").hide();
		     }
		   }
		 }

		 function removeTelefono(id) {
		   var last = $("[name='anagrafica.telefonoRemove']:last");
		   if (id != '' && $('#' + id).val() != '') {
		     $("[name='anagrafica.telefonoRemove']:last").clone().insertAfter("[name='anagrafica.telefonoRemove']:last");
		     last.val($('#' + id).val());
		   }
		   $('#' + id).parent('div').remove();
		   if (($("[name='telefono']").length + $("[name='anagrafica.telefonoNew']").length) <=${telefoniMax}) {
		     $("#addTelefono").show();
		   }
		 }

		 function addTelefono() {
		   if (($("[name='telefono']").length + $("[name='anagrafica.telefonoNew']").length) <=${telefoniMax}) {
		     $("div.telefono:last").clone().insertBefore("div.telefono:last").show();
		     $("[name='anagrafica.telefonoNew']").removeAttr('disabled');
		     if (($("[name='telefono']").length + $("[name='anagrafica.telefonoNew']").length) > ${telefoniMax}) {
		       $("#addTelefono").hide();
		     }
		   }
		 }

		 function removeEmail(id) {
		   var last = $("[name='anagrafica.emailRemove']:last");
		   if (id != '' && $('#' + id).val() != '') {
		     $("[name='anagrafica.emailRemove']:last").clone().insertAfter("[name='anagrafica.emailRemove']:last");
		     last.val($('#' + id).val());
		   }
		   $('#' + id).parent('div').remove();
		   if (($("[name='anagrafica.emailNew']").length) <=${emailMax}) {
		     $("#addEmail").show();
		   }
		 }

		 function addEmail() {
		   if (($("[name='eMail']").length + $("[name='anagrafica.emailNew']").length) <=${emailMax}) {
		     $("div.email:last").clone().insertBefore("div.email:last").show();
		     $("[name='anagrafica.emailNew']").removeAttr('disabled');
		     if (($("[name='eMail']").length + $("[name='anagrafica.emailNew']").length) > ${emailMax}) {
		       $("#addEmail").hide();
		     }
		   }
		 }

		 function salvaAnagrafica() {
		   $("div#loading").fadeIn(2000);
		   $.ajax({
		     url: '<s:url action="salvaAnagraficaFascicolo"/>',
		     type: "POST",
		     data: $('form').serialize(),
		     success: function (result, status, xhr) {
		       $('div#loading').hide();
		     }
		   });
		   return false;
		 }

		 function isValidEmailAddress(element) {
		   var pattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		   if ($(element).val() != '' && !pattern.test($(element).val())) {
		     $(element).css('border', '1px solid red');
		     $("#warning p").html('formato e-mail sbagliato');
		     return false;
		   } else {
		     $(element).css('border', '1px solid #000')
		   };
		   return true;
		 };

		 function isValidTelephone(element) {
		   var pattern = ${regexTelephoneFormat};
		   if ($(element).val() != '' && !pattern.test($(element).val())) {
		     $(element).css('border', '1px solid red');
		     $("#warning p").html('telefono formalmente sbagliato');
		     return false;
		   } else {
		     $(element).css('border', '1px solid #000')
		   };
		   return true;
		 }//]]>
</script>