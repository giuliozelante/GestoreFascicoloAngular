<%@ taglib prefix="s" uri="/struts-tags"%>
<!--
<h4>Exception Name: <s:property value="exception" /> </h4>
<h4>Exception Details: <s:property value="exceptionStack" /></h4>
-->
<div class="error message" style="display:none">
   <h3>&nbsp;</h3>
   <p><s:actionerror /><s:property value="exceptionStack" />&nbsp;</p>
  </div>
  <div id="error" title="&nbsp;" style="display:none">
    <p>Errore - Sistema non disponibile&nbsp;</p>
  </div>