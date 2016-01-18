<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  <%-- bug 2015-04-08 --%>
<fmt:setLocale value="it_IT"/>
<form ng-submit="getListaFascicolo()">
  <s:token />
  <fieldset class="searchForm">
    <legend>Ricerca Fascicolo</legend>
	<ul>
		<li>
        <fieldset style="border:0px">
	        <legend>&nbsp;</legend>
	        <label for="Fascicolo_searchFascicolo_callerId">ID Chiamante</label><s:textfield name="searchFascicolo.callerId" ng-model="searchFascicolo.callerId"/>{{searchFascicolo.callerId}}
	        <br style="clear:both"/><label for="Fascicolo_searchFascicolo_fascicoloId">ID Fascicolo</label><s:textfield name="searchFascicolo.fascicoloId" size="17" ng-model="searchFascicolo.fascicoloId" /><br />
	    </fieldset>
		</li>
		<li>
		<li>
      	<fieldset style="border:0px">
	      	<legend>&nbsp;</legend>
	      	<label for="Fascicolo_searchFascicolo_codiceFiscale">C.F./P.IVA</label><s:textfield name="searchFascicolo.codiceFiscale" size="17" maxlength="16" ng-model="searchFascicolo.codiceFiscale" />
	         <br style="clear:both"/><label for="Fascicolo_searchFascicolo_statoFascicolo">Stato</label><s:select name="searchFascicolo.statoFascicolo" ng-model="searchFascicolo.statoFascicolo" headerKey="" headerValue="Tutti" list="#{'10':'Aperto', '90':'Chiuso'}"/>
      	</fieldset>
	  </li>
	  <li>
        <fieldset>
          <legend>Data Apertura</legend>
          <label for="Fascicolo_searchFascicolo_dataAperturaDa">Da</label><input type="text" name="searchFascicolo.dataAperturaDa" ng-model="searchFascicolo.dataAperturaDa" id="Fascicolo_searchFascicolo_dataAperturaDa" size="9" />
		  <br style="clear:both"/><label for="Fascicolo_searchFascicolo_dataAperturaA">A</label><input type="text" name="searchFascicolo.dataAperturaA" ng-model="searchFascicolo.dataAperturaA" value="<s:date name="searchFascicolo.dataAperturaA" format="%{getText('format.date')}"/>" id="Fascicolo_searchFascicolo_dataAperturaA" size="9" />
        </fieldset>
		</li>
		<li>
        <fieldset>
          <legend>Data Chiusura</legend>
          <label for="Fascicolo_searchFascicolo_dataChiusuraDa">Da</label><input type="text" name="searchFascicolo.dataChiusuraDa" ng-model="searchFascicolo.dataChiusuraDa" value="<s:date name="searchFascicolo.dataChiusuraDa" format="%{getText('format.date')}"/>" id="Fascicolo_searchFascicolo_dataChiusuraDa" size="9" />
          <br style="clear:both"/><label for="Fascicolo_searchFascicolo_dataChiusuraDa">A</label><input type="text" name="searchFascicolo.dataChiusuraA" ng-model="searchFascicolo.dataChiusuraA"  value="<s:date name="searchFascicolo.dataChiusuraA" format="%{getText('format.date')}"/>" id="Fascicolo_searchFascicolo_dataChiusuraA" size="9" />
        </fieldset>
		</li>
	  </ul>
	  <div class="buttons">
	  	<button id="Fascicolo_listaFascicolo" value="Cerca" class="submit" type="submit">
		Cerca
		</button>
   	  </div>
  </fieldset>
</form>

<%--<s:if test="%{fascicoloList.length!=0&&fascicoloList[0]!=null}"> --%>
 <div class="showBeforeLoad" > </div> <!-- ric-2015-03-26 -->
 <div class="showAfterLoad"> <!-- ric-2015-03-26 -->
  <table >
    <thead>
      <tr>
        <th scope="col" style="text-align:center;">ID Fascicolo</th>
        <th scope="col" style="text-align:center;">ID Chiamante</th>
        <th scope="col" style="text-align:center;">C.F./P.IVA</th>
        <th scope="col" style="text-align:center;">Stato</th>
        <th scope="col" style="text-align:center;">Data Apertura</th>
        <th scope="col" style="text-align:center;">Data Chiusura</th>
      </tr>
    </thead>
    <tbody>
    <%--
      <s:iterator status="i" value="fascicoloList">
        <s:url var="dettaglioFascicoloUrl" action="dettaglioFascicolo">
          <s:param name="fascicolo.fascicoloId">${fascicoloId}</s:param>
          <s:param name="fascicolo.callerId">${callerId}</s:param>
          <s:param name="struts.token.name" value="%{'token'}"/>
          <s:param name="token" value="%{token}"/>


           	<s:param name="searchFascicolo.callerId" value="%{searchFascicolo.callerId}"/>
            <s:param name="searchFascicolo.fascicoloId" value="%{searchFascicolo.fascicoloId}"/>
            <s:param name="searchFascicolo.codiceFiscale" value="%{searchFascicolo.codiceFiscale}"/>
            <s:param name="searchFascicolo.statoFascicolo" value="%{searchFascicolo.statoFascicolo}"/>



           <s:param name="searchFascicolo.dataAperturaDa">
         	  	<s:date name="searchFascicolo.dataAperturaDa" format="%{getText('format.date')}"/>
           </s:param>

            <s:param name="searchFascicolo.dataAperturaA">
    	       	<s:date name="searchFascicolo.dataAperturaA" format="%{getText('format.date')}"/>
            </s:param>

            <s:param name="searchFascicolo.dataChiusuraDa">
            	 	<s:date name="searchFascicolo.dataChiusuraDa" format="%{getText('format.date')}"/>
            </s:param>

            <s:param name="searchFascicolo.dataChiusuraA">
          		 	<s:date name="searchFascicolo.dataChiusuraA" format="%{getText('format.date')}"/>
            </s:param>

        </s:url>
        <tr <s:if test="%{#i.odd}"> class="odd"</s:if> <s:else> class="even"</s:else>>
          <td class="head" style="text-align:center;" href=""><s:a href="%{dettaglioFascicoloUrl}" >${fascicoloId}</s:a></td>
          <td class="head" style="text-align:center;" href=""><s:a href="%{dettaglioFascicoloUrl}" >${callerId}</s:a></td>
          <td style="text-align:center;">${codiceFiscale}</td>
          <td style="text-align:center;">${statoFascicoloDescr}</td>
          <td style="text-align:center;" class="date"><span style="display:none !important;">${dataApertura}</span><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(dataApertura)" format="dd/MM/yyyy" /><!-- ${dataApertura} --></td>
          <td style="text-align:center;" class="date"><s:if test="statoFascicoloId==90"><span style="display:none !important">${dataChiusura}</span><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(dataChiusura)" format="dd/MM/yyyy" /></s:if><s:else>-</s:else></td>
        </tr>
      </s:iterator> --%>
      <tr ng-repeat="x in fascicoloList">
          <td class="head" style="text-align:center;" href="">{{x.fascicoloId}}</td>
          <td class="head" style="text-align:center;" href="">{{x.callerId}}</td>
          <td style="text-align:center;">{{x.codiceFiscale}}</td>
          <td style="text-align:center;">{{x.statoFascicoloDescr}}</td>
          <td style="text-align:center;" class="date"><span style="display:none !important;">{{x.dataApertura}}</span><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(dataApertura)" format="dd/MM/yyyy" /><!-- {{x.dataApertura}} --></td>
          <td style="text-align:center;" class="date"><s:if test="statoFascicoloId==90"><span style="display:none !important">{{x.dataChiusura}}</span><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(dataChiusura)" format="dd/MM/yyyy" /></s:if><s:else>-</s:else></td>
        </tr>
    </tbody>
  </table>
 </div>
 <%--</s:if> --%>


 <s:if test="%{fascicoloList.length!=0&&fascicoloList[0]!=null}">
 <div style="display: none" id="tableToExport">
 <table id="elencoDati">
    <thead>
      <tr>
        <th scope="col" style="text-align:center;">ID Fascicolo</th>
        <th scope="col" style="text-align:center;">ID Chiamante</th>
        <th scope="col" style="text-align:center;">C.F./P.IVA</th>
        <th scope="col" style="text-align:center;">Stato</th>
        <th scope="col" style="text-align:center;">Data Apertura</th>
        <th scope="col" style="text-align:center;">Data Chiusura</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator status="i" value="fascicoloList">
        <tr>
 		  <td class="head" style="text-align:center;" href=""><s:a href="%{dettaglioFascicoloUrl}" >${fascicoloId}</s:a></td>
          <td class="head" style="text-align:center;" href=""><s:a href="%{dettaglioFascicoloUrl}" >${callerId}</s:a></td>
          <td style="text-align:center;">${codiceFiscale}</td>
          <td style="text-align:center;">${statoFascicoloDescr}</td>
          <td style="text-align:center;" class="date"><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(dataApertura)" format="dd/MM/yyyy" /></td>
          <td style="text-align:center;" class="date"><s:if test="statoFascicoloId==90"><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(dataChiusura)" format="dd/MM/yyyy" /></s:if><s:else>-</s:else></td>
        </tr>
      </s:iterator>
    </tbody>
  </table>
 </div>
 <div id="exportTabella">
           <s:form action="exportListaExcelFascicolo" method="POST" >
             <s:hidden name="tableLista" id="tableLista" value="" />
             <div style="position:relative;width:100%;height:40px"><s:submit id="buttonExport" value=" " /></div>
           </s:form>
 </div>
</s:if>


