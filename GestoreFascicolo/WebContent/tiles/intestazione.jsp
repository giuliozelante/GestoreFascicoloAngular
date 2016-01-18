<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test='%{fascicolo!=null&&fascicolo.fascicoloId!=null&&fascicolo.fascicoloId!=""}'>
  <fieldset class="intestazione"><legend><h3>Dati Fascicolo</h3></legend>
    <div style="width: 30%;float: left;">
      Fascicolo:&nbsp;<strong>${fascicolo.fascicoloId}</strong><br />
      Aperto il:&nbsp;<strong><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(fascicolo.dataApertura)" format="dd/MM/yyyy" /></strong>
      <s:if test='%{fascicolo.statoFascicoloId==90}'>&nbsp;e Chiuso il:&nbsp;<strong>
        <s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(fascicolo.dataChiusura)" format="dd/MM/yyyy" /></strong>
      </s:if>
      <br /> Stato:&nbsp;<strong>${fascicolo.statoFascicoloDescr}</strong><br />
    </div>
    <div style="width: 50%;color: #a00;position: relative;top: 0;margin-left: 50%;">
      <table style="width: 100%">
        <tr>
          <td style="text-align:right;padding:0.2em">Applicazione di riferimento:</td>
          <th style="padding:0.2em;text-align: left">${fascicolo.callerId}</th>
        </tr>
      </table>
    </div>
	</fieldset>
	<input type="hidden" id="statoFascicoloId" value="${fascicolo.statoFascicoloId}" />
</s:if>