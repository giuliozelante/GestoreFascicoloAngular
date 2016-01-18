<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/WEB-INF/tld/util-functions.tld" prefix="uf" %>
<%-- mod 2015-03-12 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div id="loadingDett" style="position: fixed;z-index:9998">
 <iframe id="slct_blckDett" src="${pageContext.request.contextPath}/blank.htm"></iframe>
 <div class="center" style="z-index:9999">
     <img class="loading" src="${pageContext.request.contextPath}/images/ajax-loader.gif" alt="loading">
     </div>
 </div>
<fmt:setLocale value="it_IT" />
<s:set value="%{getText('format.date')}" var="outputDateFormat"/>
<s:iterator value="cartella" status="cartellaStatus">
  <s:iterator value="dataValues" status="dataValuesStatus">
    <s:if test="%{renderingType>=32}">
      <div id="pop${cartellaStatus.index}${dataValuesStatus.index}" class="popup">
        <div class="popup-body"> <span class="popup-exit"></span>
          <div class="popup-content">
            <table>
              <thead>
                <tr>
                  <th scope="row">
                    <s:if test="%{dataTypeId==9||dataTypeId==5}"> Dettaglio <s:property value='%{dataTypeDescr.replace("<br />", "")}' /> </s:if>
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Totale iniziale:
                    <fmt:formatNumber value="${value}" type="currency" /> </td>
                </tr>
              </tbody>
            </table>
            <br style="clear:both" />
            <table>
              <thead>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <s:if test="dataTypeId!=16">
                      <th scope="col">${dataTypeDescr}</th>
                    </s:if>
                  </s:iterator>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <s:if test="dataTypeId!=16">
                      <td><span class="${valueCssClass}"><fmt:formatNumber value="${value}" type="currency" /> </span> </td>
                    </s:if>
                  </s:iterator>
                </tr>
              </tbody>
            </table>
            <br style="clear:both" />
            <table>
              <thead>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <s:if test="dataTypeId==16">
                      <th scope="col">${dataTypeDescr}</th>
                    </s:if>
                  </s:iterator>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <s:iterator value="detailDataValues" status="dataValuesStatus">
                    <s:if test="dataTypeId==16">
                      <td>${value}</td>
                      <%-- <s:iterator value='value.split(ravSeparator)' var="ravSplit" begin="1">
                        <td><span class="${valueCssClass}">${ravSplit}</span> </td>
                  </s:iterator>--%> </s:if>
  </s:iterator>
  </tr>
  </tbody>
  </table>
  <br /> <span style="font-size:10pt; color:#0046ad; text-decoration:none; font-family: Trebuchet ms,Arial,sans-serif;"></span> </div>
  </div>
  </div>
  <div class="popup-overlay${cartellaStatus.index}${dataValuesStatus.index}"></div>
  </s:if>
</s:iterator>
</s:iterator>
<fieldset class="datiAnagrafici">
  <legend>
    <h3>Dati Anagrafici</h3> </legend>
  <div style="float:left;width:50%">
    <ul>
      <li>
        <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>
          <label for="fascicolo.anagrafica.codiceFiscale">Codice Fiscale</label> <s:textfield readonly="true" name="fascicolo.anagrafica.codiceFiscale" size="18" /></s:if>
        <s:else>
          <label for="fascicolo.anagrafica.codiceFiscale">Partita IVA</label> <s:textfield readonly="true" name="fascicolo.anagrafica.codiceFiscale" size="13" /></s:else>
      </li>
    </ul>
  </div>
  <div style="float:left;width:50%">
    <ul>
      <li>
        <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>
          <label for="nomeCognome">Nome e Cognome</label>
          <input type="text" name="nomeCognome" id="nomeCognome" value='${fascicolo.anagrafica.nome} ${fascicolo.anagrafica.cognome}' readonly="readonly" size="60" /> </s:if>
        <s:else>
          <label for="ragioneSociale">Denominazione</label> <s:textfield readonly="true" name="fascicolo.anagrafica.ragioneSociale" size="60" /> </s:else>
      </li>
    </ul>
  </div>
</fieldset>
<fieldset>
  <legend>
    <h3>Dettaglio Documento</h3> </legend>
  <table class="dettaglioCartella">
    <thead>
      <tr>
        <s:iterator value="cartella" status="cartellaStatus">
          <s:iterator value="dataValues" status="dataValuesStatus">
            <s:if test="%{renderingType!=0}">
              <th scope="col" style="text-align:center"><s:property value="dataTypeDescr" escapeHtml="true" /> </th>
            </s:if>
          </s:iterator>
        </s:iterator>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="cartella" status="cartellaStatus">
        <tr <s:if test="%{#cartellaStatus.odd}"> class="odd"</s:if>
          <s:else> class="even"</s:else>>
          <s:iterator value="dataValues" status="dataValuesStatus">
            <s:if test="%{dataTypeId==1}">
              <s:set var="numeroCartella">${value}</s:set>
            </s:if>
            <s:if test="%{renderingType!=0}">
              <!-- renderingType: ${renderingType} -->
              <td style="text-align:center" class="<s:if test="%{renderingType==2}">date</s:if>">
                <!--${value}-->
                <s:if test="%{renderingType>=32}">
                  <a href="javascript:void(0)" data-popup-target="#pop${cartellaStatus.index}${dataValuesStatus.index}">
                </s:if>
                <s:if test="%{renderingType==2}"><span style="display:none">${value}</span>
                ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) }
                </s:if>
                <s:elseif test="%{renderingType==40||renderingType==8}">
                  <fmt:formatNumber value="${value}" type="currency" /> </s:elseif>
                <s:else>${value} </s:else>
                <s:if test="%{renderingType>=32}">
                  </a>
                </s:if>
			</td>
            </s:if>
          </s:iterator>
        </tr>
      </s:iterator>
    </tbody>
  </table>
</fieldset>
<s:iterator value="cartella.detailEntityItems" status="detailEntityItemsStatus">
  <s:if test='%{renderingType!=0}'>
    <s:if test='%{#detailEntityItemsStatus.index==0||(#detailEntityItemsStatus.index!=0&&!entityDescr.equals(#previousEntityDescr))}'>
      <div class="showBeforeLoad"> </div>
      <!-- ric-2015-03-26 -->
      <div class="showAfterLoad">
        <!-- ric-2015-03-26 -->
        <s:if test='%{renderingType==2}'>
          <fieldset class="detail">
            <legend>
              <div class="arrow" style="background-position:0 0;"></div> <span><strong>${entityDescr}</strong></span> </legend>
        </s:if>
        <s:if test='%{renderingType==1}'>
          <h4>${entityDescr}</h4> </s:if>
        <table class="dataTable compact">
          <thead>
            <tr>
              <!-- inizio mod 2015-03-12 aggiungo colonna per il pulsantino "+" di dettaglio item figli -->
              <c:if test="${ uf:hasEntityItemChils(cartella, entityItemId) }">
                <th scope="col" class="espandiComprimiColumn"></th>
              </c:if>
              <!-- fine mod 2015-03-12 -->
              <s:iterator value="dataValues" status="dataValuesStauts">
                <s:if test="%{renderingType!=0}">
                  <th scope="col" style="text-align:center"><s:property value="dataTypeDescr" escapeHtml="true" /> </th>
                </s:if>
              </s:iterator>
            </tr>
          </thead>
          <tbody>
    </s:if>
    <tr <s:if test="%{#detailEntityItemsStatus.odd}"> class="odd"</s:if>
  <s:else> class="even"</s:else>>
  <!-- inizio mod 2015-03-12 aggiungo colonna per il pulsantino "+" di dettaglio item figli -->
  <c:if test="${ uf:hasEntityItemChils(cartella, entityItemId) }">
    <th scope="col" class="espandiComprimiColumn">
      <div style="position: relative;"> <img onclick="showHideTabellaEntityItemId(${ entityItemId });" id="EspandiComprimiImg_${ entityItemId }" alt="Espandi/Comprimi" src="${pageContext.request.contextPath}/images/plus-128.png" style="height: 15px;">
        <!-- per ogni entità figlia di secondo livello della cartella creo una tabella dentro un div nascosto -->
        <c:if test="${ uf:hasEntityItemChils(cartella, entityItemId) }">
          <c:set var="distinctEntityIds" value="${ uf:getDistinctEntityIdsEntityItemChils(cartella, entityItemId) }" />
          <c:forEach items="${distinctEntityIds}" var="entityId">
            <div id="tabellaEntityItemId_${entityItemId}" style="position: absolute; background-color: white; left: 20px; font-size: 130%; top: 34px; display: none;">
              <jsp:include page="/unfiltered/FascicoloServlet">
                <jsp:param value="${entityItemId}" name="parentEntityItemId" /> </jsp:include>
            </div>
          </c:forEach>
        </c:if>
      </div>
    </th>
  </c:if>
  <!-- fine mod 2015-03-12 -->
  <s:iterator value="dataValues" status="dataValuesStauts" var="dataValue">
    <!-- renderingType: ${renderingType} -->
    <s:if test="%{renderingType!=0}">
      <td class="<c:if test="${ uf:hasDetailDataValues(dataValue) }">popup-link </c:if><c:if test="${ uf:isValueData(renderingType) }">date </c:if>" style="text-align:center;">
        <c:if test="${ uf:hasDetailDataValues(dataValue) }">
          <a href="javascript:void(0)" data-popup-target="#pop${entityItemId}_${ dataValue.dataTypeId}">
        </c:if>
        <c:choose>
          <c:when test="${ uf:isValueData(renderingType) }"><span style="display:none">${value}</span>
 ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) } </c:when>
          <c:when test="${ uf:isValueValuta(renderingType) }">
            <fmt:formatNumber value="${value}" type="currency" /> </c:when>
          <c:otherwise> <s:property value="value" escapeHtml="true" /> </c:otherwise>
        </c:choose>
        <c:if test="${ uf:hasDetailDataValues(dataValue) }">
          </a>
        </c:if>
      </td>
    </s:if>
  </s:iterator>
  </tr>
  <s:if test='%{#detailEntityItemsStatus.last||(#detailEntityItemsStatus.last!=true&&!entityDescr.equals(cartella.detailEntityItems[#detailEntityItemsStatus.count].getEntityDescr()))}'>
    </tbody>
    </table>
    <s:if test='%{renderingType==2}'>
      </fieldset>
    </s:if>
    </div>
  </s:if> <s:set var="previousEntityDescr" value="%{entityDescr}" /> </s:if>
</s:iterator>
<!-- creo le popup -->
<c:forEach items="${ cartellaSession.detailEntityItems }" var="detailEntityItem">
  <c:forEach items="${ detailEntityItem.dataValues }" var="dataValue">
    <c:if test="${ uf:hasDetailDataValues(dataValue) }">
      <div id="pop${detailEntityItem.entityItemId}_${ dataValue.dataTypeId}" class="popup">
        <div class="popup-body"> <span class="popup-exit"></span>
          <div class="popup-content">
            <table>
              <tr>
                <th scope="col">Dettaglio ${ dataValue.dataTypeDescr}</th>
              </tr>
			 	 <c:if test="${ uf:isValueValuta(dataValue.renderingType) }">
	              <tr>
	                <td>Totale:
	                  <fmt:formatNumber value="${dataValue.value}" type="currency" /> </td>
	              </tr>
			  </c:if>
            </table>
            <br style="clear:both" />
            <table>
              <tr>
                <c:forEach items="${ dataValue.detailDataValues }" var="detailDataValue">
                  <th scope="col">${detailDataValue.dataTypeDescr}</th>
                </c:forEach>
              </tr>
              <tr>
                <c:forEach items="${ dataValue.detailDataValues }" var="detailDataValue">
                  <td>
               	   <span class="valoreCampo">
	                    <c:choose >
	                    	<c:when test="${ uf:isValueValuta(detailDataValue.renderingType) }">
	                   			 <fmt:formatNumber value="${detailDataValue.value}" type="currency" />
	                    	</c:when>
	                    	<c:otherwise>
		                    	${detailDataValue.value}
	                    	</c:otherwise>
	                    </c:choose>
					</span>
				  </td>
                </c:forEach>
              </tr>
            </table>
            <br /> <span style="font-size:10pt; color:#0046ad; text-decoration:none; font-family: Trebuchet ms,Arial,sans-serif;"></span> </div>
        </div>
      </div>
    </c:if>
  </c:forEach>
  <!-- creo le popup degli entity item figli -->
  <c:forEach items="${ detailEntityItem.detailEntityItems }" var="childDetailEntityItem">
    <c:forEach items="${ childDetailEntityItem.dataValues }" var="dataValue">
      <c:if test="${ uf:hasDetailDataValues(dataValue) }">
        <div id="pop${childDetailEntityItem.entityItemId}_${ dataValue.dataTypeId}" class="popup">
          <div class="popup-body"> <span class="popup-exit"></span>
            <div class="popup-content">
              <table>
                <tr>
                  <th scope="col">Dettaglio ${ dataValue.dataTypeDescr}</th>
                </tr>
			 	 <c:if test="${ uf:isValueValuta(dataValue.renderingType) }">
        			<tr>
	                  <td>Totale:
	                    <fmt:formatNumber value="${dataValue.value}" type="currency" /> </td>
	                </tr>
        		</c:if>

              </table>
              <br style="clear:both" />
              <table>
                <tr>
                  <c:forEach items="${ dataValue.detailDataValues }" var="detailDataValue">
                    <th scope="col">${detailDataValue.dataTypeDescr}</th>
                  </c:forEach>
                </tr>
                <tr>
                  <c:forEach items="${ dataValue.detailDataValues }" var="detailDataValue">
                    <td>
	                    <span class="valoreCampo">
	                    <c:choose >
	                    	<c:when test="${ uf:isValueValuta(detailDataValue.renderingType) }">
	                   			 <fmt:formatNumber value="${detailDataValue.value}" type="currency" />
	                    	</c:when>
	                    	<c:otherwise>
		                    	${detailDataValue.value}
	                    	</c:otherwise>
	                    </c:choose>
						</span>
					</td>
                  </c:forEach>
                </tr>
              </table>
              <br /> <span style="font-size:10pt; color:#0046ad; text-decoration:none; font-family: Trebuchet ms,Arial,sans-serif;"></span> </div>
          </div>
        </div>
      </c:if>
    </c:forEach>
  </c:forEach>
</c:forEach>
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
        <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>Codice Fiscale</s:if>
        <s:else>Partita IVA</s:else>
      </th>
      <td>${fascicolo.anagrafica.codiceFiscale}</td>
      <s:if test='%{fascicolo.anagrafica.naturaGiuridica.equals("F")}'>
        <th scope="row">Nome e Cognome</th>
        <td>${fascicolo.anagrafica.nome} ${fascicolo.anagrafica.cognome}</td>
      </s:if>
      <s:else>
        <th scope="row">Denominazione</th>
        <td>${fascicolo.anagrafica.ragioneSociale}</td>
      </s:else>
    </tr>
  </table>
  <table id="dettaglioCartella">
    <caption>Dettaglio Documento</caption>
    <tr>
      <s:iterator value="cartella" status="cartellaStatus">
        <s:iterator value="dataValues" status="dataValuesStatus">
          <s:if test="%{renderingType!=0}">
            <th class="renderingType${renderingType}" renderingType="${renderingType}"><s:property value="dataTypeDescr" escapeHtml="true" /> </th>
          </s:if>
          <s:iterator value="detailDataValues" status="dataValuesStatus">
            <th class="renderingType${renderingType}" renderingType="${renderingType}">${dataTypeDescr}</th>
          </s:iterator>
        </s:iterator>
      </s:iterator>
    </tr>
    <s:iterator value="cartella" status="cartellaStatus">
      <tr>
        <s:iterator value="dataValues" status="dataValuesStatus">
          <s:if test="%{renderingType!=0}">
              <td class="renderingType${renderingType}" renderingType="${renderingType}">
                <s:if test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueData(renderingType)}">
  ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) }</s:if>
                <s:elseif test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueValuta(renderingType)}">
                  <fmt:formatNumber value="${value}" type="currency" /> </s:elseif>
                <s:else>${value} </s:else>
              </td>
          </s:if>
          <s:iterator value="detailDataValues" status="dataValuesStatus">
            <s:if test="%{renderingType>=32}">
            	<td class="renderingType${renderingType}" renderingType="${renderingType}">
                   <s:if test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueData(renderingType)}">   ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) }</s:if>
                   <s:elseif test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueValuta(renderingType)}">
                  <fmt:formatNumber value="${value}" type="currency" /> </s:elseif>
                <s:else>${value}</s:else></td>
            </s:if>
          </s:iterator>
        </s:iterator>
      </tr>
    </s:iterator>
  </table>
  <s:iterator value="cartella.detailEntityItems" status="detailEntityItemsStatus">
    <s:if test='%{renderingType!=0}'>
        <table class="item">
          <s:if test='%{#detailEntityItemsStatus.index==0||(#detailEntityItemsStatus.index!=0&&!entityDescr.equals(#previousEntityDescr))}'>
          <caption>${entityDescr}</caption>
          <thead>
            <tr>
              <s:iterator value="dataValues" status="dataValuesStauts">
                <s:if test="%{renderingType!=0}">
                  <th class="renderingType${renderingType}" renderingType="${renderingType}"><s:property value="dataTypeDescr" escapeHtml="true" /> </th>
                  <s:iterator value="detailDataValues">
					<th class="renderingType${renderingType}" renderingType="${renderingType}"><s:property value="dataTypeDescr" escapeHtml="true" /> </th>
				 </s:iterator>
                </s:if>
              </s:iterator>
            </tr>
          </thead>
          <tbody>
          </s:if><s:set var="previousEntityDescr" value="%{entityDescr}" />
      <tr>
    <s:iterator value="dataValues" status="dataValuesStauts">
      <s:if test="%{renderingType!=0}">
        <td class="renderingType${renderingType}" renderingType="${renderingType}">
            <s:if test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueData(renderingType)}">   ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) }</s:if>
            <s:elseif test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueValuta(renderingType)}">
              <fmt:formatNumber value="${value}" type="currency" />
            </s:elseif>
            <s:else>${value}</s:else>
        </td>
        <s:iterator value="detailDataValues">
		<td class="renderingType${renderingType}" renderingType="${renderingType}">
		<s:if test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueData(renderingType)}">
			  ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) }
		</s:if>
		<s:elseif test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueValuta(renderingType)}">
			<fmt:formatNumber value="${value}" type="currency" />
		</s:elseif><s:else>${value}</s:else></td>
		</s:iterator>
      </s:if>
      <c:if test="${ uf:hasEntityItemChils(cartella, entityItemId) }">
        <c:if test="${ uf:hasEntityItemChils(cartella, entityItemId) }">
          <c:if test="${dataValuesStauts.last }">
            <s:iterator value="detailEntityItems" status="detailEntityItemsStatus" begin="0" end="0">
              </tr>
              </table>
              <c:if test="${detailEntityItemsStatus.first}">
                <table class="sub item">
                  <caption>${entityDescr}</caption>
              </c:if>
              <tr>
                <s:iterator value="dataValues" status="thStatus">
                  <th class="renderingType${renderingType}" renderingType="${renderingType}">${dataTypeDescr}</th>
                  <s:iterator value="detailDataValues">
						<th class="renderingType${renderingType}" renderingType="${renderingType}">${dataTypeDescr}</th>
					</s:iterator>
                </s:iterator>
              </tr>
            </s:iterator>
            <s:iterator value="detailEntityItems" status="detailEntityItemsStatus">
              <tr>
                <s:iterator value="dataValues">
					<td class="renderingType${renderingType}" renderingType="${renderingType}">
						<s:if test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueData(renderingType)}">
							  ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) }
						</s:if>
						<s:elseif test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueValuta(renderingType)}">
							<fmt:formatNumber value="${value}" type="currency" />
						</s:elseif><s:else>${value}</s:else></td>
						<s:iterator value="detailDataValues">
						<td class="renderingType${renderingType}" renderingType="${renderingType}">
						<s:if test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueData(renderingType)}">
						 	  ${ uf:formatDate("yyyy-MM-dd", outputDateFormat, value) }
						</s:if>
						<s:elseif test="%{@it.equitalia.gestorefascicolo.web.util.DataValueRenderingType@isValueValuta(renderingType)}">
							<fmt:formatNumber value="${value}" type="currency" />
						</s:elseif><s:else>${value}</s:else></td>
						</s:iterator>
					</s:iterator>
              </tr>
              <c:if test="${detailEntityItemsStatus.last}">
              	</table>
              </c:if>
            </s:iterator>
          </c:if>
</c:if>
</c:if>
</s:iterator>
</tr>
<s:if test='%{#detailEntityItemsStatus.last||(#detailEntityItemsStatus.last!=true&&!entityDescr.equals(cartella.detailEntityItems[#detailEntityItemsStatus.count].getEntityDescr()))}'>
</tbody>
</table>
</s:if>
<s:set var="previousEntityDescr" value="%{entityDescr}" /></s:if>
</s:iterator>
</div>
<!-- inizio mod 2015-03-12 -->
            <script type='text/javascript'>
            //<![CDATA[
            function showHideTabellaEntityItemId(entityItemId) {
                var espandiComprimiImg = $('#EspandiComprimiImg_' + entityItemId);
                var tabellaFiglia = $('#tabellaEntityItemId_' + entityItemId);
                var tabellaPadre = espandiComprimiImg.parent().parent().parent().parent().parent();
                var rigaPadre = espandiComprimiImg.parent().parent().parent(); //sostituisco l'immagine del pulsantino "+" con il pulsantino "-" o viceversa
                if (espandiComprimiImg.attr('src').indexOf('${pageContext.request.contextPath}/images/minus-128.png') > -1) {
                  espandiComprimiImg.attr('src', '${pageContext.request.contextPath}/images/plus-128.png');
                  rigaPadre.css('font-weight', 'normal');
                } else {
                  espandiComprimiImg.attr('src', '${pageContext.request.contextPath}/images/minus-128.png');
                  rigaPadre.css('font-weight', 'bold');
                }
                var tabellaFigliaWidth = (tabellaPadre.css('width').substring(0, tabellaPadre.css('width').length - 2) - 20) + "px";
                tabellaFiglia.css({
                  width: tabellaFigliaWidth
                }); /* var table = tabellaPadre.DataTable(); $('.espandiComprimiColumn').css( 'width', '30px' ); table.columns.adjust().draw(); */
                var rigaTabellaPadre = espandiComprimiImg.parent().parent().parent(); //rendo la tabella di dettaglio da visibile ad invisibile o viceversa
                if (tabellaFiglia.is(":visible")) {
                  rigaTabellaPadre.css({
                    height: "34px"
                  });
                  tabellaFiglia.hide();
                } else {
                  rigaTabellaPadre.css({
                    height: (tabellaFiglia.height() + 38) + "px"
                  });
                  tabellaFiglia.show();
                }
              } //]]>
            </script>
            <!-- fine mod 2015-03-12 -->