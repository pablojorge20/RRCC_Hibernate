<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <title><s:text name="Clima Social"/></title>
    <sx:head/>
</head>
<body>
    <div id="content">
    <div class="post">
    <div class="post-bgtop">
    <div class="post-bgbtm">
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="Usted esta en :"/>
    <strong>
       Clima Social
    </strong>
   
    <div class="entry">        
        <s:actionerror theme="mensaje" />
        <s:actionmessage theme="mensaje" />

        

        <s:form action="climaSocial" method="post" theme="simple">
        
            <table width="720" border="0">
                <tr>
                    
                </tr>
                <tr class="rowH" align="center">
                    <th width="200">Comunidad</th>
                    <th width="30" align="center">Fecha Generacion</th>
                    <th width="30" align="center">Nivel Clima Social</th>
                </tr>
                <s:iterator value="LClima" status="status">
                <tr class="<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>"
                    onmouseover="this.className='rowC';"
                    onmouseout ="this.className='<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>';" >
                    <td BGCOLOR="<s:property value="Color"/>">
                        <s:url action="climaSocial" id="url" escapeAmp="false">
                            <s:param name="Zona_id.id" value="id"/>
                        </s:url>
                        <font color ="<s:property value="CFont"/>"> 
                            <s:property value="id.tmZonaId.Descripcion"/>
                        </font>
                    </td>
                        <td BGCOLOR="<s:property value="Color"/>">
                            
                        <s:url action="climaSocial" id="url" escapeAmp="false">
                            <s:param name="Zona_id.id" value="id"/>
                        </s:url>
                       <font color ="<s:property value="CFont"/>"> 
                            <s:property value="id.FechaGeneracion"/>
                       </font>
                    </td>
                    <td BGCOLOR="<s:property value="Color"/>">
                        <s:url action="climaSocial" id="url" escapeAmp="false">
                            <s:param name="Zona_id.id" value="id"/>
                        </s:url>
                        <font color ="<s:property value="CFont"/>"> 
                        
                            <s:property value="Clima"/>
                            
                        </font>
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