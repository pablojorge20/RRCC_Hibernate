<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="js/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="token-input.css" rel="stylesheet" type="text/css" />
    <link href="token-input-facebook.css" rel="stylesheet" type="text/css" />    
    <link href="token-input-mac.css" rel="stylesheet" type="text/css" />    
    
    <link href="easyui.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="icon.css" rel="stylesheet" type="text/css" media="screen" />
    
    <title><s:text name="label.tituloSistema"/></title>
    <decorator:head/>
</head>
<script type="text/javascript" src="js/funciones.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/jquery.maphilight.js"></script>
<script type="text/javascript" src="js/jquery.tooltip.js"></script>
<script type="text/javascript" src="js/jqFancyTransitions.1.8.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="js/jquery.slidertron-1.1.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/datagrid-detailview.js"></script>
<script type="text/javascript" src="js/datagrid-detailview.js"></script>

<script type="text/javascript" src="js/highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/highcharts/modules/exporting.js"></script>

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
<div id="wrapper" style="width: 100%; 
                         padding: 0px auto 0 auto;
                         margin: 0px auto 0 auto;">
    <div id="header" style="width: 100%; 
        padding: 0px 0px 10px 0px;
        height: 0px;	
        border: solid 0px #7E7E7E;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;">
        
    </div>
    <div id="menu" style="width: 99%; padding: 0px 0px 0px 20px;" align="right">
        <%@ include file="/WEB-INF/decorators/header.jsp"%>
    </div>

    <div id="page" style="width: 100%; padding: 10px 0px 15px 0px;">
        <div id="page-bgbtm">
            <!div id="content">
                <decorator:body/>
            <!/div> 
            <!-- end #footer -->
            <div style="clear: both;">&nbsp;</div>
        </div>
    </div>
    <div id="footer" style="width: 100%; margin: 10px 0 10px 0;">
            <%@ include file="/WEB-INF/decorators/footer.jsp" %>
    </div>
    <!-- end #footer -->
</div>



</body>
</html>

