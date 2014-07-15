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
    <h1 class="title">Documento - Stakeholder</h1>
    <div class="entry">        
        <s:actionerror theme="mensaje" />
        <s:actionmessage theme="mensaje" />

      <s:property value="accion"/>
        <s:form action="grabarStakehoder" method="post" theme="simple">
            <s:hidden name="url" value="%{url}" />
<s:hidden name="documento.id" value="%{documento.id}" theme="simple"/>    
             <s:select  list="LRemitente"
                                   listKey="id"
                                   listValue="Nombre"
                                   name="stakeholder.id"
                                   value="%{stakeholder.id}"
                                 
                                   theme="simple"
                                   cssClass="texto"/>  
            <s:submit value="Nuevo" cssClass="boton"/>
        </s:form>

        <s:form action="StakeholderDoc" method="post" theme="simple">
        
            <table width="720" border="0">
                <tr>
                    
                </tr>
                <tr class="rowH" align="center">
                    <th width="650">Stakeholder</th>
                    <th width="30" align="center"></th>
                </tr>
                <s:iterator value="stakeholders" status="status">
                <tr class="<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>"
                    onmouseover="this.className='rowC';"
                    onmouseout ="this.className='<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>';" >
                    <td>
                        <s:url action="StakeholderDoc" id="url" escapeAmp="false">
                            <s:param name="stakeholder.id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">
                            <s:property value="nombre"/>
                        </a>
                    </td>
                    <td>
                        <s:url action="StakeholderDoc!eliminarStakeholderDocumento" id="url" escapeAmp="false">
                            <s:param name="stakeholder.id" value="id"/>
                            <s:param name="documento.id" value="documento.id"/>
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