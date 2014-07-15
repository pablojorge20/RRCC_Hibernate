<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%;width:100%;">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="js/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="token-input.css" rel="stylesheet" type="text/css" />
    <link href="token-input-facebook.css" rel="stylesheet" type="text/css" />    
    <link href="token-input-mac.css" rel="stylesheet" type="text/css" />    
    
    <link href="easyui-1.3.5.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="icon.css" rel="stylesheet" type="text/css" media="screen" />
    <title><s:text name="label.tituloSistema"/></title>
    <decorator:head/>
</head>
<script type="text/javascript" src="js/funciones.js"></script>
<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/jquery.maphilight.js"></script>
<script type="text/javascript" src="js/jquery.tooltip.js"></script>
<script type="text/javascript" src="js/jqFancyTransitions.1.8.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min-1.3.5.js"></script>
<script type="text/javascript" src="js/jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="js/jquery.slidertron-1.1.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/jquery.caret.1.02.js"></script>
<script type="text/javascript" src="js/jquery.tokeninput.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>

<script type="text/javascript">
    $(function() {
        $('#menu > ul').dropotron({
                mode: 'fade',
                globalOffsetY: 11,
                offsetY: -15
        });
    });
</script>

<body>
<div id="wrapper">
    <div id="header">
        <iframe align="left" src="cab/mzFrame.html" width="620" height="102" frameborder="0" name="MotionComposer" scrolling="no"><p>Su explorador no soporta iframes</p></iframe>
        <iframe align="right" src="cab/sistFrame.html" width="360" height="102" frameborder="0" name="MotionComposer" scrolling="no">
            <p>Su explorador no soporta iframes</p>
        </iframe>        
    </div>
    <div id="menu" align="right"><%@ include file="/WEB-INF/decorators/header.jsp"%></div>

	<div id="page">
            <div id="page-bgbtm">
                <!div id="content">
                    <decorator:body/>
                <!/div> 
                <!-- end #footer -->
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
	<div id="footer">
		<%@ include file="/WEB-INF/decorators/footer.jsp" %>
	</div>
	<!-- end #footer -->
</div>



</body>
</html>

