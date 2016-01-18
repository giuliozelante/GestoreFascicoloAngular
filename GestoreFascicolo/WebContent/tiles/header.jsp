<%@ taglib prefix="s" uri="/struts-tags"%>
<img id="logo_eqs_green" src="${pageContext.request.contextPath}/images/logo_eqs_green-trans.png" alt="logo_eqs_green-trans.png" />
<header><s:if test='%{utenza.cf_user != "" && utenza.cf_user != null}'><h5>Codice fiscale operatore:&nbsp;<strong>${utenza.cf_user}</strong></h5></s:if>&nbsp;
  <div id="blue_headline">
    <div class="topplace">
      <img src="${pageContext.request.contextPath}/images/rounded_top_left-trans.png" alt="rounded_top_left-trans.png" class="placeborder" />
    </div>
    <img id="openspace_title" src="${pageContext.request.contextPath}/images/openspace_title-trans.png" alt="openspace_title-trans.png" />
    <img id="fdc_logo-trans" src="${pageContext.request.contextPath}/images/fdc_logo-trans.png" alt="fdc_logo-trans.png" />
  </div>
</header>