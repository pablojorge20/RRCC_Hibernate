<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    <title><s:text name="label.tituloSistema"/></title>
    <decorator:head/>
</head>
<script src="js/funciones.js" language="JavaScript"></script>
<script src="js/ajax.js" language="JavaScript"></script>
<body onload="iniciarTimer()">
<div id="wrapper">
    <div id="header" align="left">
        <iframe align="left" src="cab/mzFrame.html" width="620" height="102" frameborder="0" name="MotionComposer" scrolling="no"><p>Su explorador no soporta iframes</p></iframe>
        <iframe align="right" src="cab/sistFrame.html" width="360" height="102" frameborder="0" name="MotionComposer" scrolling="no">
            <p>Su explorador no soporta iframes</p>
        </iframe>
    </div>
    <div id="menu" align="right"><%@ include file="/WEB-INF/decorators/header.jsp"%></div>

	<div id="page">
        <div id="page-bgtop">            
            <div id="page-bgbtm">
                <decorator:body/>
                <!-- end #footer -->
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/decorators/footer.jsp" %>
	</div>
	<!-- end #footer -->
</div>



</body>
</html>

