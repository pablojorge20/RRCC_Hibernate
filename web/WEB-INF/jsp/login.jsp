<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RRCC</title>
       
    </head>
    <body>

    <div id="content3">
    <div class="post">
    <div class="post-bgtop">
    <div class="post-bgbtm">
        
	
	<div class="entry">
        <br>
        <br>
        <h1 class="title" align="center">Sistema de Clima social</h1>
        <div id="formulario">
            <s:property value="accion"/>
        <s:form action="check" method="post" theme="simple">
            <s:hidden name="url" value="%{url}" />

            <table align="center" border="0" width="100%">
                <tr>
                    <td width="22%" rowspan="7" align="right">
                    </td>
                </tr>
                <tr style="height:30px;">
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td width="10%" ></td>
                    <td width="10%" style="font-size: 18px;"><s:text name="Usuario"/>:</td>
                    <td width="80%" style="padding: 3px 3px 3px 3px;">
                        <input type="text" name="usuario.cuenta" autofocus="autofocus" style="font-size: 20px; width: 190px;" placeholder="Ingrese su usuario" maxlength="20"/>
                    </td>
                </tr>
               
                <tr>
                    <td></td>
                    <td style="font-size: 18px;"><s:text name="Clave"/>:</td>
                    <td style="padding: 3px 3px 3px 3px;">
                        <input type="password" name="usuario.clave" style="font-size: 18px; width: 190px;" maxlength="20"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td style="padding: 3px 3px 3px 3px;">
                        <s:submit value="Ingresar" style="font-size: 18px;" align="center" cssClass="boton" theme="simple"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2"><s:actionerror theme="mensaje"/></td>
                </tr>
            </table>                                 
        </s:form>
        </div>
    </div>
    </div>
    </div>
    </div>
    </div>

</body>
</html>
