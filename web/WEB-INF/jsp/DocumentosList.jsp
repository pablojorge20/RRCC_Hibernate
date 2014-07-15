<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <title><s:text name="Documentos"/></title>
    <sx:head/>
</head>
<body>
    <div id="content">
    <div class="post">
    <div class="post-bgtop">
    <div class="post-bgbtm">
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="Usted esta en :"/>
    <strong>
       Documentos
    </strong>
     <s:form action="DocumentosList!buscarDocumentos" theme="simple">
           
        
    <h1 class="title">Buscar Documentos</h1>  <s:textfield name="textobuscado" value="" size="15" maxLength="10" theme="simple"/> <s:submit value="Buscar" cssClass="boton"/>
    </s:form>
    <div class="entry">        
        <s:actionerror theme="mensaje" />
        <s:actionmessage theme="mensaje" />

        <s:form action="Documentos" theme="simple">
            <s:submit value="Nuevo" cssClass="boton"/>
        </s:form>

        <s:form action="DocumentosList" method="post" theme="simple">
        
            <table width="720" border="0">
                <tr>
                    
                </tr>
                <tr class="rowH" align="center">
                    <th width="650"><s:text name="Asunto de Documento"/></th>
                    <th width="30" align="center"></th>
                </tr>
                <s:iterator value="documentos" status="status">
                <tr class="<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>"
                    onmouseover="this.className='rowC';"
                    onmouseout ="this.className='<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>';" >
                    <td>
                        <s:url action="Documentos" id="url" escapeAmp="false">
                            <s:param name="documento.id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">
                            <s:property value="asunto"/>
                        </a>
                    </td>
                    <td>
                        <s:url action="DocumentosList!eliminarDocumento" id="url" escapeAmp="false">
                            <s:param name="documento.id" value="id"/>
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