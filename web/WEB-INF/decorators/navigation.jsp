<%@ taglib prefix="s" uri="/struts-tags" %>
<ul>
    <li>
        <ul>
            <s:iterator value="#session.usuario.funcionalidades" status="status">
            <s:set name="code" value="%{action}"/>
            <li>
                <s:url action="%{code}" id="url" escapeAmp="false"/>
                <a href="<s:property value="#url"/>" >
                    <img src="./<s:property value="%{imagen}"/>" >                
                    
                </a>
            </li>
            </s:iterator>
        </ul>
    </li>
    <div align="center">
        <s:url action="welcome" id="url" escapeAmp="false"/>
        <strong>
            <a href="<s:property value="#url"/>" >
                <span style="color: white"><u><s:text name="label.opcionRegresar"/></u></span>
            </a>
        </strong>
    </div>
</ul>

