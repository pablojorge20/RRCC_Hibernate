<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <title><s:text name="Agrupacions"/></title>
    <sx:head/>
</head>
<body>
    <div id="content">
    <div class="post">
    <div class="post-bgtop">
    <div class="post-bgbtm">
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="Usted esta en :"/>
    <strong>
       Agrupaciones
    </strong>
     <s:form action="StakeAgrupacionList!buscarAgrupacions" theme="simple">
           
        
    <h1 class="title">Buscar Agrupación</h1>  <s:textfield name="textobuscado" value="" size="15" maxLength="10" theme="simple"/> <s:submit value="Buscar" cssClass="boton"/>
    </s:form>
    <div class="entry">        
        <s:actionerror theme="mensaje" />
        <s:actionmessage theme="mensaje" />

        <s:form action="Agrupacions" theme="simple">
            <s:submit value="Nuevo" cssClass="boton"/>
        </s:form>

        <s:form action="StakeAgrupacionList" method="post" theme="simple">
        
            <table width="720" border="0">
                <tr>
                    
                </tr>
                <tr class="rowH" align="center">
                    <th width="650"><s:text name="Apellidos y Nombres"/></th>
                    <th width="30" align="center"></th>
                </tr>
                <s:iterator value="agrupacions" status="status">
                <tr class="<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>"
                    onmouseover="this.className='rowC';"
                    onmouseout ="this.className='<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>';" >
                    <td>
                        <s:url action="Agrupacions" id="url" escapeAmp="false">
                            <s:param name="agrupacion.id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">
                            <s:property value="nombre"/>
                        </a>
                    </td>
                    <td>
                        <s:url action="StakeAgrupacionList!eliminarAgrupacion" id="url" escapeAmp="false">
                            <s:param name="agrupacion.id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>" class="imgLink"  onclick="<s:text name="label.confirmacion"/>">
                            <img src="imagenes/eliminar.png" border="0"  title="<s:text name="accion.eliminar"/>"/>
                        </a>
                    </td>
            
                </tr>
                </s:iterator>
            </table>
        </s:form>
    </div>
    </div>
    </div>
    </div>
    </div>
</body>
</html>