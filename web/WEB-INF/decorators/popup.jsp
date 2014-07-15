<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><s:text name="label.tituloSistema"/></title>
    <decorator:head/>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="js/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
    <style type="text/css">
    body 
    {
	margin: 0;
	padding: 0;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #555555; /* color texto : #787878*/
        background: #FFFFFF;
    }
    .post 
    {
        background: none;
    }    
    #content {
            float: left;
            width: 100%; /*700px*/
            padding: 0px 0px 0 0;  /*60px 20px 0 0;*/
    }    
    </style>    
</head>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.alerts.js"></script>
<script type="text/javascript" src="js/jquery.maphilight.js"></script>
<script type="text/javascript" src="js/jquery.tooltip.js"></script>
<body>
<decorator:body/>
</body>
</html>

