<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<aside id="menuAdmin">
  <ul>
  <li><s:a action="aperturaAdminPanel" namespace="/admin"> <s:property value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('menu.admin.fascicolo.apertura')" /></s:a></li>
  <li><s:a action="chiusuraAdminPanel" namespace="/admin"> <s:property value="@it.equitalia.gestorefascicolo.web.util.MessageResources@getProperty('menu.admin.fascicolo.chiusura')" /></s:a></li>
</ul></aside></div>