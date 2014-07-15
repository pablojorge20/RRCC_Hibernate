<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <link href="imagenes/style.css" rel="stylesheet" type="text/css" media="screen" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><s:text name="label.tituloSistema"/></title>
    <sx:head/>
</head>
<body>
    <!-- cabecera -->
    <div id="wrapper">
	<div id="header">
                    <iframe src="cab/mzFrame.html" width="968" height="160" frameborder="0" name="MotionComposer" scrolling="no"><p>Su explorador no soporta iframes</p></iframe>
        </div>
    <div id="menu">
        <%@ include file="/WEB-INF/decorators/header.jsp"%>
    </div>
	<div id="page">
    <div id="page-bgtop">
    <div id="page-bgbtm">
    <!-- fin cabecera -->

    <div id="content3">
    <div class="post">
    <div class="post-bgtop">
    <div class="post-bgbtm">
        <!--<h1 class="title" align="center"><img src="imagenes/SAS.png" /> </h1>-->
       
	<div class="entry">

    <table border="0px" align="center" >
        <tr><td height="10px"></td></tr>
 
        
        
        
        <s:iterator value="#session.usuario.modulos" status="status">
            <s:url action="welcome!obtenerFuncionalidades" id="url" escapeAmp="false">
                <s:param name="modulo.id" value="%{id}"/>
            </s:url>

            <td height="80">
                <a href="<s:property value="#url"/>">
                <img src="<s:property value="imagen"/>" border="0" width="64px" height="64px"/>
                </a>
            </td>
            <td width=7"></td>
            <td width="150" align="left">
                <a href="<s:property value="#url"/>">
                    <strong><s:property value="nombre"/></strong>
                </a>
                <br/>
                <s:property value="descripcion"/>

            
            <td width="7"></td>
        <s:if test="#status.even">
            
        </s:if>
        
        </s:iterator>
            </tr>
    </table>

            
            

    </div>
    </div>
    </div>
    </div>
    </div>

    <!-- footer -->

    <div style="clear: both;">&nbsp;</div>
    </div>
    </div>
	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/decorators/footer.jsp" %>
	</div>
    <!-- end footer -->
</div>
</body>
</html>
