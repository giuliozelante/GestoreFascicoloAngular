<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%><%@ taglib prefix="s" uri="/struts-tags"%><%@ taglib prefix="bc" uri="/struts-arianna-tags"%><%response.setCharacterEncoding("UTF-8");%>
<!--[if lt IE 7]>      <html ng-app="gestoreFascicolo" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html ng-app="gestoreFascicolo" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html ng-app="gestoreFascicolo" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html ng-app="gestoreFascicolo" class="no-js"> <!--<![endif]-->
    <head>
        <title>FASCICOLO DEL CONTRIBUENTE - <tiles:insertAttribute name="title" ignore="true" />
        </title>
        <meta http-equiv="X-UA-Compatible" content="IE=8,chrome=1">
        <meta charset="utf-8">
        <meta name="description" content="FASCICOLO DEL CONTRIBUENTE">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/jqueryui/jquery-ui.min.css">
        <link rel="stylesheet" type="text/css" media="screen, projection" href="${pageContext.request.contextPath}/css/stile.css">

 		<script src="${pageContext.request.contextPath}/js/prefixfree.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/html5.js"></script>
        <script src="${pageContext.request.contextPath}/js/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/gestoreFascicolo.js"></script>
    </head>
    <body ng-controller="fascicoloController">
<s:if test="hasActionErrors()"><!-- Errore: <s:actionerror /> --></s:if>
        <div id="loading" style="display:none">
         <iframe id="slct_blck" src="${pageContext.request.contextPath}/blank.htm"></iframe>
         <div class="center">
             <img class="loading" style="left: 50%;" src="${pageContext.request.contextPath}/images/ajax-loader.gif" alt="loading">
             </div>
         </div>
            <div id="wrapper" class="clearfix">
                <tiles:insertAttribute name="header" />
                <tiles:insertAttribute name="menu" />
                <tiles:insertAttribute name="menuAdmin"/>
                <div id="content"><!-- {{name}} -->
                    <tiles:insertAttribute name="intestazione" />
                    <tiles:insertAttribute name="body" />
                    <div class="push"></div>
                </div>
                <div id="error" title="Errore!" style="display:none">
                    <p>Errore - Sistema non disponibile&nbsp;</p>
                </div>
                <div id="warning" title="Attenzione!" style="display:none">
                    <p><s:if test="hasActionMessages()"><s:actionmessage /></s:if>&nbsp;</p>
                </div>
            </div>
            <tiles:insertAttribute name="footer" />
            <form style="display:none" id="linkMaskForm" action="" method="POST">
            	<input type="submit" />
	        </form>
          <div id="exportForm" style="display:none">
           <s:form action="exportExcelFascicolo" method="POST">
             <s:hidden name="table" id="table" value="" />
             <div style="position:relative;width:100%;height:40px"><s:submit id="buttonExport" value=" " /></div>
           </s:form>
           </div>
            <img class="loading" src="${pageContext.request.contextPath}/images/ajax-loader.gif" alt="loading" id="over-loading" style="display:none;z-index:200;position:absolute">
            <script src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.11.2.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/vendor/jquery-migrate-1.2.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/vendor/jquery.validate.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/message_it.js"></script>
            <script> window.jQuery || document .write('<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.11.2.min.js"><\/script>\n<script src="${pageContext.request.contextPath}/js/vendor/jquery-migrate-1.2.1.min.js"><\/script>\n<script src="${pageContext.request.contextPath}/js/vendor/jquery.validate.min.js"><\/script>')</script>
	        <script src="${pageContext.request.contextPath}/jqueryui/jquery-ui.min.js"></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/tableExport/tableExport.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/tableExport/jquery.base64.js"></script>
	        <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/jquery.dataTables/jquery.dataTables.min.js"></script>
	        <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/main.js"></script>
	        <script type='text/javascript'>
	        //<![CDATA[
              $(document).ready(function() {
            	  <s:if test="hasActionErrors()">
            	     $("#error").dialog("open");
            	  </s:if>
            	  <s:if test="!hasActionErrors()">
	            	  <s:if test="hasActionMessages()">
	            	      $("#warning").dialog("open");
	            	  </s:if>
            	  </s:if>
                  });
            //]]>
	        </script>
            <tiles:insertAttribute name="script" />
	</body>
</html>