<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/tld/util-functions.tld" prefix="uf" %>
<fmt:setLocale value="it_IT" /> <s:hidden id="nofocus" />
<div id="dialog-confirm-relate" style="display:none" title-holder="Documento n&deg;">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>Relate aggiornate al <span id="dataRelate"></span> </p>
</div>
<s:iterator value="fascicolo.cartelle" status="cartelleLStatus">
  <s:iterator value="dataValues" status="dataValuesStatus">
    <!--renderingType: ${renderingType} -->
    <s:if test="%{#dataValuesStatus.even==true}">
      <s:if test="%{renderingType>=32}">
        <div id="pop${cartelleLStatus.index}${dataValuesStatus.index}" class="popup">
          <div class="popup-body"> <span class="popup-exit"></span>
            <div class="popup-content">
              <table>
                <tr>
                  <th scope="col">
                    <s:if test="%{dataTypeId==9||dataTypeId==5}">Dettaglio <s:property value='%{dataTypeDescr.replace("<br />", "")}' /> </s:if>
                  </th>
                </tr>
                <tr>
                  <td>Totale iniziale:
                    <fmt:formatNumber value="${value}" type="currency" currencyCode="EUR" /> </td>
                </tr>
              </table>
              <br style="clear:both" />
              <table>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <!--renderingType: ${renderingType} -->
                    <s:if test="%{dataTypeId!=16}">
                      <th scope="col">${dataTypeDescr}</th>
                    </s:if>
                  </s:iterator>
                </tr>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <!--renderingType: ${renderingType} -->
                    <s:if test="%{dataTypeId!=16}">
                      <td><span class="${valueCssClass}"><fmt:formatNumber value="${value}" type="currency" currencyCode="EUR" /></span> </td>
                    </s:if>
                  </s:iterator>
                </tr>
              </table>
              <br /> <span style="font-size:10pt; color:#0046ad; text-decoration:none; font-family: Trebuchet ms,Arial,sans-serif;"></span> </div>
          </div>
        </div>
        <div class="popup-overlay${cartelleLStatus.index}${dataValuesStatus.index}"></div>
      </s:if>
    </s:if>
    <s:else>
      <s:if test="%{renderingType>=32}">
        <div id="pop${cartelleLStatus.index}${dataValuesStatus.index}" class="popup">
          <div class="popup-body"> <span class="popup-exit"></span>
            <div class="popup-content">
              <table>
                <tr>
                  <th scope="col">
                    <s:if test="%{dataTypeId==9||dataTypeId==5}">Dettaglio <s:property value='%{dataTypeDescr.replace("<br />", "")}' /> </s:if>
                  </th>
                </tr>
                <tr>
                  <td>Totale iniziale:
                    <fmt:formatNumber value="${value}" type="currency" currencyCode="EUR" /> </td>
                </tr>
              </table>
              <br style="clear:both" />
              <table>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <!--renderingType: ${renderingType} -->
                    <th scope="col">${dataTypeDescr}</th>
                  </s:iterator>
                </tr>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <!--renderingType: ${renderingType} -->
                    <td><span class="${valueCssClass}"><fmt:formatNumber value="${value}" type="currency" currencyCode="EUR" /></span> </td>
                  </s:iterator>
                </tr>
              </table>
              <br /> <span style="font-size:10pt; color:#0046ad; text-decoration:none; font-family: Trebuchet ms,Arial,sans-serif;"></span> </div>
          </div>
        </div>
        <div class="popup-overlay${cartelleLStatus.index}${dataValuesStatus.index}"></div>
      </s:if>
    </s:else>
  </s:iterator>
</s:iterator>
<div class="absolute">
  <fieldset class="datiAnagrafici">
    <legend>
      <h3>Dati Anagrafici</h3> </legend>
    <s:form action="Fascicolo" method="POST"> <s:token /> <s:hidden name="fascicolo.fascicoloId" /> <s:hidden name="fascicolo.callerId" /> <s:hidden name="fascicolo.dataApertura" /> <s:hidden name="fascicolo.dataChiusura" /> <s:hidden name="fascicolo.statoFascicoloId" /> <s:hidden name="fascicolo.statoFascicoloDescr" /> <s:hidden name="fascicolo.anagrafica.ragioneSociale" /> <s:hidden name="fascicolo.anagrafica.nome" /> <s:hidden name="fascicolo.anagrafica.cognome" /> <s:hidden name="fascicolo.anagrafica.naturaGiuridica" />
      <div style="float:left;width:50%">
        <ul>
          <li>
            <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>
              <label for="fascicolo.anagrafica.codiceFiscale">Codice Fiscale</label> <s:textfield readonly="true" name="fascicolo.anagrafica.codiceFiscale" size="18" /> </s:if>
            <s:else>
              <label for="fascicolo.anagrafica.codiceFiscale">Partita IVA</label> <s:textfield readonly="true" name="fascicolo.anagrafica.codiceFiscale" size="13" /> </s:else>
          </li>
          <li>
            <!-- ############################## INDIRIZZI ###################################### -->
            <div>
              <s:iterator value="fascicolo.anagrafica.indirizzi" status="status">
                <s:if test='%{#status.count==1&&indirizzoPrincipale.equals("S")}'>
                  <label for="Fascicolo_indirizzo">Indirizzo</label>
                  <div><s:textfield readonly="true" name="indirizzo" size="60" /> </div>
                  <label for="Fascicolo_anagrafica_indirizzoNew">Indirizzi alternativi</label>
                </s:if>
                <s:if test="%{#status.count==1&&fascicolo.statoFascicoloId!=fascicoloChiuso}"> <a href="javascript:void(0)" onclick="addIndirizzoAlternativo()" id="aggiungiIndirizzoAlternativo" <s:if test="%{#status.count==1&&fascicolo.anagrafica.indirizzi.length>indirizziAlternatiMax}">style="display:none"</s:if>>
<img src="${pageContext.request.contextPath}/images/add2-trans.png" alt="add2-trans.png" />
</a> </s:if>
                <s:if test='%{#status.count>1&&#status.count <=3}'>
                  <div class="indirizzoAlternativo">
                    <input type="text" name="anagrafica.indirizzoAlternativo" id="Fascicolo_anagrafica_indirizzoAlternativo" value="${indirizzo}" readonly="readonly" size="60" />
                    <input type="hidden" name="indirizzoId" value="${indirizzoId}" id="indirizzoId${indirizzoId}" />
                    <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}">
                      <a href="javascript:void(0)" onclick="removeIndirizzoAlternativo('indirizzoId${indirizzoId}');" id="removeIndirizzoAlternativo${indirizzoId}" style="font-weight:bold;color:#f00"> <img src="${pageContext.request.contextPath}/images/delete2-trans.png" alt="delete2-trans.png" /> </a>
                    </s:if>
                  </div>
                </s:if> <s:set var="indirizzoCount" value="%{#status.count}" /> </s:iterator>
              <input type="hidden" name="anagrafica.indirizzoRemove" />
              <div style="display:none" class="indirizzoAlternativo">
                <input type="text" name="anagrafica.indirizzoNew" value="" id='indirizzoNew0' size="60" />
                <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}">
                  <a href="javascript:void(0)" onclick="removeIndirizzoAlternativo('indirizzoNew0')" id="removeIndirizzoAlternativo0" style="font-weight:bold;color:#f00"> <img src="${pageContext.request.contextPath}/images/delete2-trans.png" alt="delete2-trans.png" /> </a>
                </s:if>
              </div>
          </li>
        </ul>
        </div>
        <div style="float:left;width:50%">
          <ul>
            <li>
              <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>
                <label for="nomeCognome">Nome e Cognome</label>
                <input type="text" name="nomeCognome" id="nomeCognome" value="${fascicolo.anagrafica.nome} ${fascicolo.anagrafica.cognome}" readonly="readonly" size="60" /> </s:if>
              <s:else>
                <label for="ragioneSociale">Denominazione</label> <s:textfield readonly="true" name="fascicolo.anagrafica.ragioneSociale" size="60" /> </s:else>
            </li>
            <li>
              <!-- ############################## TELEFONO ###################################### -->
              <div>
                <label for="Fascicolo_telefono"> Telefono
                  <!--
<s:property value="%{telefoniMax}" />
<s:property value="%{fascicolo.anagrafica.telefoni.length}" />
<s:property value="%{fascicolo.anagrafica.telefoni.length>=(telefoniMax)}" />
-->
                  <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}"> <a href="javascript:void(0)" onclick="addTelefono()" id="addTelefono" <s:if test="%{fascicolo.anagrafica.telefoni.length>=(telefoniMax)}">style="display:none"</s:if>>
<img src="${pageContext.request.contextPath}/images/add2-trans.png" alt="add2-trans.png" />
</a> </s:if>
                </label>
                <s:iterator value="fascicolo.anagrafica.telefoni" status="status">
                  <div class="telefono"> <s:textfield readonly="true" name="telefono" size="12" />
                    <input type="hidden" name="telefonoId" value="${telefonoId}" id="telefonoId${telefonoId}" />
                    <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}">
                      <a href="javascript:void(0)" onclick="removeTelefono('telefonoId${telefonoId}');" id="removeTelefono${telefonoId}" style="font-weight:bold;color:#f00"> <img src="${pageContext.request.contextPath}/images/delete2-trans.png" alt="delete2-trans.png" /> </a>
                  </div>
                  </s:if> <s:set var="telefonoCount" value="%{#status.count}" /> </s:iterator>
                <input type="hidden" name="anagrafica.telefonoRemove" />
                <div style="display:none" class="telefono">
                  <input type="text" name="anagrafica.telefonoNew" value="" id='telefonoNew0' size="12" />
                  <a href="javascript:void(0)" onclick="removeTelefono('telefonoNew0')" id="removeTelefono0" style="font-weight:bold;color:#f00"> <img src="${pageContext.request.contextPath}/images/delete2-trans.png" alt="delete2-trans.png" /> </a>
                </div>
            </li>
            <li>
              <!-- ############################## EMAIL ###################################### -->
              <div>
                <label for="Fascicolo_email">e-mail
                  <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}"> <a href="javascript:void(0)" onclick="addEmail()" id="addEmail" <s:if test="%{fascicolo.anagrafica.email.length>=emailMax}"> style="display:none"</s:if>>
<img src="${pageContext.request.contextPath}/images/add2-trans.png" alt="add2-trans.png" />
</a> </s:if>
                </label>
                <s:iterator value="fascicolo.anagrafica.email" status="status">
                  <div class="email"> <s:textfield readonly="true" name="eMail" size="60" />
                    <input type="hidden" name="eMailId" value="${eMailId}" id="eMailId${eMailId}" />
                    <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}">
                      <a href="javascript:void(0)" onclick="removeEmail('eMailId${eMailId}');" id="removeEmail${eMailId}" style="font-weight:bold;color:#f00"> <img src="${pageContext.request.contextPath}/images/delete2-trans.png" alt="delete2-trans.png" /> </a>
                    </s:if>
                  </div> <s:set var="emailCount" value="%{#status.count}" /> </s:iterator>
                <input type="hidden" name="anagrafica.emailRemove" />
                <div style="display:none" class="email">
                  <input type="text" name="anagrafica.emailNew" value="" id='emailNew0' size="60" />
                  <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}">
                    <a href="javascript:void(0)" onclick="removeEmail('emailNew0')" id="removeEmail0" style="font-weight:bold;color:#f00"> <img src="${pageContext.request.contextPath}/images/delete2-trans.png" alt="delete2-trans.png" /> </a>
                  </s:if>
                </div>
            </li>
          </ul>
          </div>
          <div class="buttons">
            <!-- <s:submit type="button" action="#" value="Estratto di Ruolo" cssClass="submit" />-->

            <s:set var="salvaAnagButtonValue" value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('dettaglio_fascicolo.salva_anagrafica')"/>
            <s:set var="estrattoContoSaldButtonValue" value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('dettaglio_fascicolo.estratto_conto_saldati')"/>
            <s:set var="estrattoContoInsButtonValue" value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('dettaglio_fascicolo.estratto_conto_insoluti')"/>
            <s:set var="altriDocEsattButtonValue" value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('dettaglio_fascicolo.altri_doc_esattoriali')"/>

            <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso}">
            	<s:submit type="button" cssClass="submit" action="salvaAnagraficaFascicolo" >${salvaAnagButtonValue}</s:submit>
            </s:if>
            <s:submit type="button" cssClass="submit" action="getPdfEstrattoContoSolutiFascicolo" >${estrattoContoSaldButtonValue}</s:submit>
            <s:submit type="button" cssClass="submit" action="getPdfEstrattoContoInsolutiFascicolo" >${estrattoContoInsButtonValue}</s:submit>
            <s:submit type="button" cssClass="submit" action="apriDocumentiEsattorialiFascicolo" >${altriDocEsattButtonValue}</s:submit>
            </div>
    </s:form>
  </fieldset>
<div id="loadingDett"  style="position: relative;">
 <div class="center" style="z-index:9999;">
     <img class="loading" style="left: 50%;" src="${pageContext.request.contextPath}/images/ajax-loader.gif" alt="loading">
  </div>
</div>
  <s:if test="%{fascicolo.cartelle!=null && fascicolo.cartelle.length!=0 && fascicolo.cartelle[0]!=null}">
    <div class="showBeforeLoad"> </div>
    <!-- ric-2015-03-26 -->
    <div class="showAfterLoad">
      <!-- ric-2015-03-26 -->
      <table class="dataTable compact">
        <thead>
          <tr>
            <s:iterator value="fascicolo.cartelle" begin="0" end="0" status="cartelleLStatus">
              <s:iterator value="dataValues">
                <!--renderingType: ${renderingType} -->
                <s:if test="%{renderingType!=0}">
                  <th class="<s:property value=" %{titleCssClass} " />" scope="col" style="text-align:center;"><s:property value="%{dataTypeDescr}" /> </th>
                </s:if>
              </s:iterator>
            </s:iterator>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="fascicolo.cartelle" status="cartelleLStatus">
            <tr <s:if test="%{#cartelleLStatus.odd}"> class="odd"</s:if>
  <s:else> class="even"</s:else>>
  <s:iterator value="dataValues" status="dataValuesStatus">
    <s:if test="%{dataTypeId==21}">
        <s:set var="tipoDocumento">${value}</s:set>
    </s:if>

    <!-- renderingType: ${renderingType} -->
    <s:if test="%{renderingType!=0}">
      <s:if test="%{dataTypeId==1}">
        <s:set var="numeroCartella">${value}</s:set>
      </s:if>

      <td style="text-align:center;" class="<c:if test='${uf:isValueLink(renderingType)}'>popup-link </c:if><c:if test='${uf:isValueData(renderingType)}'>date </c:if>renderingType${renderingType}">
        <s:if test="%{renderingType>=32}"> <span style="display:none">${value}</span>
          <a href="javascript:void(0)" data-popup-target="#pop${cartelleLStatus.index}${dataValuesStatus.index}">
        </s:if>
        <c:choose>
          <c:when test="${uf:isValueData(renderingType)}"><span style="display:none">${value}</span><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(value)" format="%{getText('format.date')}" /></c:when>
          <c:when test="${uf:isValueValuta(renderingType)}">
            <fmt:formatNumber value="${value}" type="currency" currencyCode="EUR" /> </c:when>
          <c:otherwise> ${value} </c:otherwise>
        </c:choose>
        <s:if test="%{renderingType>=32}">
          </a>
        </s:if> &nbsp; </td>
    </s:if>
  </s:iterator>
  <td class="buttons"><!-- ${fascicolo.anagrafica.nome} -->
    <s:url var="dettaglioCartellaUrl" action="dettaglioCartellaFascicolo">
      <s:param name="inCartellaWSRequest.numeroCartella">${numeroCartella}</s:param>
      <s:param name="fascicolo.anagrafica.codiceFiscale">${fascicolo.anagrafica.codiceFiscale}</s:param>
      <s:param name="fascicolo.anagrafica.naturaGiuridica">${fascicolo.anagrafica.naturaGiuridica}</s:param>
      <s:param name="fascicolo.anagrafica.nome">${fascicolo.anagrafica.nome}</s:param>
      <s:param name="fascicolo.anagrafica.cognome">${fascicolo.anagrafica.cognome}</s:param>
      <s:param name="fascicolo.anagrafica.ragioneSociale">${fascicolo.anagrafica.ragioneSociale}</s:param>
      <s:param name="fascicolo.statoFascicoloDescr">${fascicolo.statoFascicoloDescr}</s:param>
      <s:param name="fascicolo.statoFascicoloId">${fascicolo.statoFascicoloId}</s:param>
      <s:param name="fascicolo.dataApertura">${fascicolo.dataApertura}</s:param>
      <s:param name="fascicolo.dataChiusura">${fascicolo.dataChiusura}</s:param>
      <s:param name="fascicolo.callerId">${fascicolo.callerId}</s:param>
      <s:param name="fascicolo.fascicoloId">${fascicolo.fascicoloId}</s:param>
      <s:param name="inCartellaWSRequest.tipoDocumento">${tipoDocumento}</s:param>
    </s:url>
    <s:a href="%{dettaglioCartellaUrl}" data-tool="Dettaglio Documento">
      <div style="background: url(${pageContext.request.contextPath}/images/folder_view.png) no-repeat 0 0;width: 22px;height: 22px;position:relative;display:inline-block;" title="Dettaglio Documento"></div>
    </s:a>
  </td>
  <s:iterator value="dataValues" status="dataValuesStatus">
    <!--renderingType: ${renderingType} -->
    <s:if test="%{renderingType==0}">
      <s:if test="dataTypeId==92">
        <td class="buttons">
          <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso||value=='DI'}">
            <s:if test="%{value=='NR'}">
              <s:set var="title"> <s:text name="link.title.pdf.richiedi" /> </s:set>
            </s:if>
            <s:elseif test="%{value=='RI'}">
              <s:set var="title"> <s:text name="link.title.pdf.richiesto" /> </s:set>
            </s:elseif>
            <s:elseif test="%{value=='DI'}">
              <s:set var="title"> <s:text name="link.title.pdf.disponibile" /> </s:set>
              <%--<s:url var="getPdfDocumentoCrmUrl#dataValuesStatus.index" action="getPdfDocumentoFascicolo">
                <s:param name="fascicolo.callerId">${fascicolo.callerId}</s:param>
                <s:param name="fascicolo.fascicoloId">${fascicolo.fascicoloId}</s:param>
                <s:param name="getPdfDocumentoWSRequest.callerId">${fascicolo.callerId}</s:param>
                <s:param name="getPdfDocumentoWSRequest.fascicoloId">${fascicolo.fascicoloId}</s:param>
                <s:param name="getPdfDocumentoWSRequest.numeroDocumento">${numeroCartella}</s:param>
                <s:param name="getPdfDocumentoWSRequest.cf">${fascicolo.anagrafica.codiceFiscale}</s:param>
                <s:param name="downloadPDF">true</s:param>
                </s:url>
                <s:a href="%{getPdfDocumentoCrmUrl#dataValuesStatus.index}" data-tool="${title}" title="%{#title}">
                  <div class="statoPdf ${value}">&nbsp;</div>
                </s:a>--%> </s:elseif>
            <s:elseif test="%{value=='ND'}">
              <s:set var="title"> <s:text name="link.title.pdf.nondisponibile" /> </s:set>
            </s:elseif>
            <%--<s:if test="%{value=='NR'||value=='RI'||value=='ND'}">--%>
              <a href="javascript:void(0)" onclick="getPdfDocumento(this,'${fascicolo.callerId}','${fascicolo.fascicoloId}','${numeroCartella}','${fascicolo.anagrafica.codiceFiscale}','')" title="${title}">
                <div class="statoPdf ${value}">&nbsp;</div>
              </a>
              <%--</s:if>--%> </s:if> &nbsp; </td>
      </s:if>
      <s:if test="dataTypeId==93">
        <td class="buttons">
          <s:if test="%{fascicolo.statoFascicoloId!=fascicoloChiuso||value=='DI'}">
            <s:if test="%{value=='NR'}">
              <s:set var="title"> <s:text name="link.title.relate.richiedi" /> </s:set>
            </s:if>
            <s:elseif test="%{value=='RI'}">
              <s:set var="title"> <s:text name="link.title.relate.richiesto" /> </s:set>
            </s:elseif>
            <s:elseif test="%{value=='DI'}">
              <s:set var="title"> <s:text name="link.title.relate.disponibile" /> </s:set>
            </s:elseif>
            <s:elseif test="%{value=='ND'}">
              <s:set var="title"> <s:text name="link.title.relate.nondisponibile" /> </s:set>
            </s:elseif>
            <a href="javascript:void(0)" onclick="getRelate(this,'${fascicolo.callerId}','${fascicolo.fascicoloId}','${numeroCartella}','${fascicolo.anagrafica.codiceFiscale}','dataRelate<s:property value="%{#cartelleLStatus.index}" />','statoRelate<s:property value="%{#cartelleLStatus.index}" />')" title="${title}">
              <div class="statoRelate ${value}">&nbsp;</div>
            </a>
            <input type="hidden" id="statoRelate<s:property value="%{#cartelleLStatus.index}" />" value="${value}" /> </s:if> &nbsp; </td>
      </s:if>
      <s:if test="dataTypeId==94">
        <input type="hidden" id="dataRelate<s:property value="%{#cartelleLStatus.index}" />" value="<s:date name=" new java.text.SimpleDateFormat( 'yyyy-MM-dd').parse(value) " format="%{getText( 'format.date')} " />"/></s:if>
    </s:if>
    <!--cartelleLStatus.index: <s:property value="%{#cartelleLStatus.index}" />--></s:iterator>
  </tr>
  </s:iterator>
  </tbody>
  </table>
  </div>
  <!-- ########## TABLE TO EXPORT #################### -->
  <div class="export" style="display: none">
    <input type="hidden" name="fascicoloId" id="fascicoloId" value="${fascicolo.fascicoloId}" />
    <table id="datiFascicolo">
      <caption>Dati Fascicolo</caption>
      <tr>
        <th scope="row">Fascicolo:</th>
        <td>${fascicolo.fascicoloId}</td>
        <th scope="row">Applicazione di riferimento:</th>
        <td>${fascicolo.callerId}</td>
      </tr>
      <tr>
        <th scope="row">Aperto il:</th>
        <td><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(fascicolo.dataApertura)" format="dd/MM/yyyy" /> </td>
        <s:if test='%{fascicolo.statoFascicoloId==90}'>
          <th scope="row">e Chiuso il:</th>
          <td><s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(fascicolo.dataChiusura)" format="dd/MM/yyyy" /> </td>
        </s:if>
        <s:else>
          <th scope="row"></th>
          <td></td>
        </s:else>
      </tr>
      <tr>
        <th scope="row">Stato:</th>
        <td>${fascicolo.statoFascicoloDescr}</td>
        <th scope="row"></th>
        <td></td>
      </tr>
    </table>
    <table id="datiAnagrafici">
      <caption>Dati Anagrafici</caption>
      <tr id="soggetto">
        <th scope="row">
          <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>Codice Fiscale:</s:if>
          <s:else>Partita IVA:</s:else>
        </th>
        <td>${fascicolo.anagrafica.codiceFiscale}</td>
        <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>
          <th scope="row">Nome e Cognome:</th>
          <td>${fascicolo.anagrafica.nome} ${fascicolo.anagrafica.cognome}</td>
        </s:if>
        <s:else>
          <th scope="row">Denominazione:</th>
          <td>${fascicolo.anagrafica.ragioneSociale}</td>
        </s:else>
      </tr>
      <s:if test="%{fascicolo.anagrafica.indirizzi.length==1}">
        <s:iterator value="fascicolo.anagrafica.indirizzi" status="status">
            <tr id="indirizzoPrincipale">
              <th>Indirizzo:</th>
              <td>${indirizzo}</td>
            </tr>
            <tr id="indirizziAlternativi">
            <td></td>
        </s:iterator>
      </s:if>
      <s:else>
        <s:iterator value="fascicolo.anagrafica.indirizzi" status="status">
          <s:if test='%{#status.count==1&&indirizzoPrincipale.equals("S")}'>
            <tr id="indirizzoPrincipale">
              <th>Indirizzo:</th>
              <td>${indirizzo}</td>
            </tr>
            <tr id="indirizziAlternativi">
          </s:if>
          <s:else>
            <td>${indirizzo}</td>
          </s:else>
        </s:iterator>
      </s:else>
      </tr>
      <tr id="telefoni">
        <s:if test="%{fascicolo.anagrafica.telefoni.length>0}">
          <s:iterator value="fascicolo.anagrafica.telefoni" status="status">
            <td>${telefono}</td>
          </s:iterator>
        </s:if>
        <s:else>
          <td></td>
        </s:else>
      </tr>
      <tr id="email">
        <s:if test="%{fascicolo.anagrafica.email.length>0}">
          <s:iterator value="fascicolo.anagrafica.email" status="status">
            <td>${eMail}</td>
          </s:iterator>
        </s:if>
        <s:else>
          <td></td>
        </s:else>
      </tr>
    </table>
    <table id="listaCartelle">
      <caption>Lista Cartelle</caption>
      <thead>
        <tr>
          <s:iterator value="fascicolo.cartelle" begin="0" end="0" status="cartelleLStatus">
            <s:iterator value="dataValues">
              <!--renderingType: ${renderingType} -->
              <s:if test="%{renderingType!=0}">
                <s:if test="%{dataTypeId!=16}">
                  <th scope="col" class="renderingType${renderingType}" renderingType="${renderingType}"> <s:property value="%{dataTypeDescr}" /> </th>
                </s:if>
              </s:if>
              <s:iterator value="detailDataValues" status="dataValuesStatus">
                <!--renderingType: ${renderingType} -->
                <s:if test="%{dataTypeId!=16}">
                  <th class="renderingType${renderingType}" renderingType="${renderingType}" scope="col">${dataTypeDescr}</th>
                </s:if>
              </s:iterator>
            </s:iterator>
          </s:iterator>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="fascicolo.cartelle" status="cartelleLStatus">
          <tr <s:if test="%{#cartelleLStatus.odd}"> class="odd"</s:if>
            <s:else> class="even"</s:else>>
            <s:iterator value="dataValues" status="dataValuesStatus">
              <!--renderingType: ${renderingType} -->
              <s:if test="%{renderingType!=0}">
                <s:if test="%{dataTypeId!=16}">
                  <s:if test="%{dataTypeId==1}">
                    <s:set var="numeroCartella">${value}</s:set>
                  </s:if>
                  <td class="renderingType${renderingType}" renderingType="${renderingType}">
                    <s:if test="%{renderingType==2}"> <s:date name="new java.text.SimpleDateFormat('yyyy-MM-dd').parse(value)" format="%{getText('format.date')}" /> </s:if>
                    <s:elseif test="%{renderingType>=32}">
                      <fmt:formatNumber value="${value}" type="currency" currencyCode="EUR" /> </s:elseif>
                    <s:else>${value}</s:else>&nbsp; </td>
                </s:if>
              </s:if>
              <s:iterator value="detailDataValues" status="dataValuesStatus">
                <s:if test="%{dataTypeId!=16}">
                  <!--renderingType: ${renderingType} -->
                  <s:if test="%{renderingType>=32}">
                    <td class="renderingType${renderingType}" renderingType="${renderingType}">
                      <fmt:formatNumber value="${value}" type="currency" currencyCode="EUR" /> </td>
                  </s:if>
                </s:if>
              </s:iterator>
            </s:iterator>
          </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
  </s:if>
  </div>