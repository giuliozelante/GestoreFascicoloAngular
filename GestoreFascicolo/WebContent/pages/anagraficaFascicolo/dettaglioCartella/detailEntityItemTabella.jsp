<%-- creata per mod 2015-03-12 --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="uf" uri="/WEB-INF/tld/util-functions.tld" %>
<fmt:setLocale value="it_IT" />
<c:set var="primoEntityItem" value="${ listaEntityItem[0] }" />
<c:if test="${ primoEntityItem.renderingType ==  2 }">
  <fieldset class="detailEntityItemTabella">
    <legend id="legendDetailEntityItemTabella_<%=request.getParameter("parentEntityItemId")%>"> <span><strong>${primoEntityItem.entityDescr}</strong></span> </legend>
    <table class="dataTableDetails compact">
      <!--  intestazione della tabella -->
      <thead>
        <tr>
          <c:forEach items="${primoEntityItem.dataValues}" var="dataValue">
            <c:if test="${dataValue.renderingType!= '0'}">
              <c:set var="renderingType" value="${dataValue.renderingType}" />
              <th scope="col" style="text-align:center" class="renderingType${renderingType}" renderingType="${renderingType}">${ dataValue.dataTypeDescr }</th>
            </c:if>
          </c:forEach>
        </tr>
      </thead>
      <tbody>
        <c:set var="indiceRiga" value="${0}" />
        <!--  righe della tabella -->
        <c:forEach var="entityItem" items="${ listaEntityItem }">
          <c:choose>
            <c:when test="${ indiceRiga % 2 == 0 }">
              <c:set var="rigaClass" value="odd" /> </c:when>
            <c:otherwise>
              <c:set var="rigaClass" value="even" /> </c:otherwise>
          </c:choose>
          <tr class="${ rigaClass }" style="font-weight: normal;">
            <c:forEach var="dataValue" items="${ entityItem.dataValues }">
              <c:if test="${dataValue.renderingType!=0}">
                <c:choose>
                  <c:when test="${ uf:hasDetailDataValues(dataValue) }">
                    <c:set var="cssClass" value="popup-link" /> </c:when>
                  <c:when test="${ uf:isValueLink(dataValue.renderingType)  }">
                    <c:set var="cssClass" value="link" /> </c:when>
                  <c:otherwise>
                    <c:set var="cssClass" value="" /> </c:otherwise>
                </c:choose>
                <td class="${cssClass} renderingType${renderingType}<c:if test="${ uf:isValueData(dataValue.renderingType) }"> date</c:if>" renderingType="${renderingType}" style="text-align:center;">
                  <c:choose>
                    <c:when test="${ uf:isValueData(dataValue.renderingType) }">
                      <span style="display:none">${dataValue.value}</span>
                      <fmt:parseDate var="dateTemp" value="${dataValue.value}" pattern="yyyy-MM-dd" />
                      <fmt:formatDate value="${dateTemp}" pattern="dd/MM/yyyy" /> </c:when>
                    <c:when test="${ uf:isValueValuta(dataValue.renderingType)  }">
                      <a href="javascript:void(0)" data-popup-target="#pop${entityItem.entityItemId}_${dataValue.dataTypeId}">
                        <fmt:formatNumber value="${dataValue.value}" type="currency" /> </a>
                    </c:when>
                    <c:otherwise>
                      <c:choose>
                        <c:when test="${ uf:isValueLink(dataValue.renderingType)  and  uf:getNumeroCartella(cartellaSession)!= dataValue.value  }">
                          <%-- se è un link ad un altra cartella --%>
                            <s:url var="dettaglioCartellaUrl" action="dettaglioCartellaFascicolo">
                              <s:param name="inCartellaWSRequest.numeroCartella">${dataValue.value}</s:param>
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
                            </s:url> <a href="${dettaglioCartellaUrl}" title="Dettaglio Cartella">${dataValue.value}</a> </c:when>
                        <c:otherwise> ${dataValue.value} </c:otherwise>
                      </c:choose>
                    </c:otherwise>
                  </c:choose>
                </td>
              </c:if>
            </c:forEach>
          </tr>
          <c:set var="indiceRiga" value="${indiceRiga+1}" /> </c:forEach>
      </tbody>
    </table>
  </fieldset>
</c:if>