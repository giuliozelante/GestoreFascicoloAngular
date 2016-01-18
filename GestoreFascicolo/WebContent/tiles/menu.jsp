<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="bc" uri="/struts-arianna-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--#context['struts.actionMapping'].name:  <s:property value="%{#context['struts.actionMapping'].name}"/> -->
<!--otherParams:  ${otherParams} <s:property value='%{#session["other-params"]}' /> -->
<!--#session["utenza"].user:  <s:property value='%{#session["utenza"].user}' /> -->
<s:if test='%{otherParams=="NONE"||#session["utenza"].user==true}'>
<div id="menu">
  <ul>
      <li>
          <div class="menu left">&nbsp;</div><s:a action="Fascicolo" namespace="/"><div class="title"><s:property value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('menu.cerca.fascicolo')" /><br /></div></s:a><div class="menu right">&nbsp;</div>
      </li><% if( request.isUserInRole("FSC_ADMIN") ){ %>
	  <li>
	       <div class="menu left">&nbsp;</div><s:a action="indexAdmin" namespace="/admin"><div class="title"><s:property value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('menu.admin')" /><br /></div></s:a><div class="menu right">&nbsp;</div>
	   </li><% } %>
  </ul>
</div>
</s:if>
<bc:breadcrumbs var='c' status='s'>
<div id="breadcrumb">
<c:if test="${empty showHome}">
  <ul class="crumbs">
      <c:set var="i" value="${10-s.index}" />
      <s:url var="surl" action="%{action}" namespace="%{namespace}" includeContext="false" />
      <!-- use the tags: url and param to effectively build the url -->
      <c:url var="url" value="${surl}">
        <c:forEach var="p" items="${c.params}">
          <c:forEach var="v" items="${p.value}">${v}
              <c:param name="${p.key}" value="${v}" />
          </c:forEach>
        </c:forEach>
      </c:url>
      <s:if test="!#s.last">
      <li <s:if test="#s.first"> class="first"</s:if>><s:a href="%{#attr['url']}" style="z-index:${i}">${c.name}</s:a>&nbsp;>&nbsp;</li>
      </s:if>
      <s:else>
      <li <s:if test="#s.first"> class="first"</s:if>><span>${c.name}</span></li>
      </s:else>
  </ul>
</c:if>
</div>
</bc:breadcrumbs>
<div style="height: 6px">&nbsp;</div>