<%@ taglib prefix="s" uri="/struts-tags" %>
<ul>
    
    <s:iterator value="#session.usuario.modulos" status="status">
    <li class="first">
        <span class="opener"><s:property value="%{nombre}"/><b></b></span>
        <ul>        
            <s:iterator value="#session.usuario.modulos[#status.index].funcionalidades" status="status">
                <li>
                    <s:url action="%{action}" id="url" escapeAmp="false"/>
                    <a href="<s:property value="#url"/>" >
                        <s:property value="%{nombre}"/>
                    </a>
                </li>
            </s:iterator>
        </ul>
    </li>
    </s:iterator>
    
    <s:if test='#session.usuario!=null'>
        <li style="color: white;">
            
            Usuario: <s:property value="#session.usuario.cuenta"/>
        </li>        
        <li style="color: white; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;">
            <s:url action="ayuda" id="url" escapeAmp="false"/>
            <a href="<s:property value="#url"/>"><img src="imagenes/ayuda.png" height="25" width="25" title="Ayuda" /></a>
            &nbsp;&nbsp;&nbsp;&nbsp;
        </li>                        
        <li style="color: white; padding: 0px 0px 0px 0px; margin: 0px 0px 0px 0px;">
            <s:url action="logout" id="url" escapeAmp="false"/>
            <a href="<s:property value="#url"/>"><img src="imagenes/logout.png" height="24" title="Salir del sistema"/></a>
            
        </li>        
    </s:if>
    <s:else>
        <li style="color: white; padding: 10px 10px 10px 10px; margin: 0px 0px 0px 0px;">
            <s:url action="login" id="url" escapeAmp="false"/>
            <a href="<s:property value="#url"/>"><img src="imagenes/login.png" title="Ingresar al sistema" height="24"/></a>
        </li>
    </s:else>
        
</ul>    
