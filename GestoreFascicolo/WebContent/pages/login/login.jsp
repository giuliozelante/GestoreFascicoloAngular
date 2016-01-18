<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="!''.equals(#parameters.auth)">
<script type='text/javascript'>//<![CDATA[ 
	$("div.alert-message.error p").text("Authorization Failed");
	$("div.alert-message.error").show();
//]]>  
</script>
</s:if>
<form action="<%=request.getContextPath()%>/j_security_check" method="POST" >
	<ul>
		<li><label for="j_username">Codice Fiscale</label> <input type="text" name="j_username" /></li>
	<%--<s:text name="logon.password"/> <input type="password" name="j_password" /> <br/>--%>
		<li><input class="submit" type="submit" value="Login" /></li>
	</ul>
</form>