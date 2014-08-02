<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
    <head>
        <title><s:text name="Documentos"/></title>
        <sx:head/>
    </head>
    <script>

        function init_upload()
        {
            var progressbox = $('#progressbox1'); //progress bar wrapper
            var progressbar = $('#progressbar1'); //progress bar element
            var statustxt = $('#statustxt1'); //status text element    
            var completed = '0%'; //initial progressbar value    
            var form_files = $("#UploadFileForm"); //upload form

            $(form_files).ajaxForm({
                beforeSend: function() { //brfore sending form
                    statustxt.empty();
                    progressbox.show(); //show progressbar
                    progressbar.width(completed); //initial value 0% of progressbar
                    statustxt.html(completed); //set status text
                    statustxt.css('color', '#000'); //initial color of status text 
                    $("#loading").show();
                },
                uploadProgress: function(event, position, total, percentComplete) { //on progress
                    progressbar.width(percentComplete + '%') //update progressbar percent complete
                    statustxt.html(percentComplete + '%'); //update status text
                    if (percentComplete > 50)
                    {
                        statustxt.css('color', '#fff'); //change status text to white after 50%
                    }
                    else
                    {
                        statustxt.css('color', '#000');
                    }
                },
                complete: function(response) { // on complete
                    progressbox.hide(); // hide progressbar
                    //$("#uploaderform").slideUp(); // hide form after upload
                    //$("#uploaderform_file").hide();
                    //window.UploadFileForm.reset();
                    $("#UploadFileForm").form('clear');

                    var data = JSON.parse(response.responseText);

                    $("#loading").hide();
                    if (data.msgAction != null && data.msgAction.length > 0)
                    {
                        $.messager.alert('Mensaje', data.msgAction, 'info');
                    }
                    else
                    {
                        $.messager.alert('Mensaje', 'Los activos fueron cargados correctamente.', 'info');
                        $('#tablaActivos').datagrid('reload');
                    }
                }
            });
        }

        function uploadAttachFile()
        {
            $("#UploadFileForm").submit();
        }

    </script>
    <body>
        <div id="content">
            <div class="post">
                <div class="post-bgtop">
                    <div class="post-bgbtm">
                        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="Usted esta en :"/>
                        <strong>
                            Documentos
                        </strong>
                        <h1 class="title">Documento - Adjuntos</h1>
                        <div class="entry">        
                            <s:actionerror theme="mensaje" />
                            <s:actionmessage theme="mensaje" />

                            <s:property value="accion"/>
                            <s:form action="grabarAdjunto" method="post" theme="simple">
                                <s:hidden name="url" value="%{url}" />






                            </s:form>
                            <div id="formulario">            

                                <form name="UploadFileForm" id="UploadFileForm" action="loadAdjuntoJSON.action" method="POST" enctype="multipart/form-data">
                                    <s:hidden name="documento.id" value="%{documento.id}" theme="simple"/>   
                                    <table width="100%">
                                        <tr>
                                            <td>
                                                <i>Cargar documento, seleccionar el archivo&nbsp;&nbsp;</i>
                                                <input id="upload" type="file" size="45" name="upload" onchange="javascript: uploadAttachFile();" style="margin-bottom: 5px;">
                                                <img id="loading" src="images/loading.gif" style="display:none;">
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                                <div id="progressbox1" class="progressbox" style="display: none; ">
                                    <div id="progressbar1" class="progressbar" style="width: 100%; "></div>
                                    <div id="statustxt1" class="statustxt" style="color: rgb(255, 255, 255); ">100%</div>
                                </div>                          
                            </div> 
                            <s:form action="AdjuntosDoc" method="post" theme="simple">

                                <table width="720" border="0">
                                    <tr>

                                    </tr>
                                    <tr class="rowH" align="center">
                                        <th width="650">Documentos Adjuntos</th>
                                        <th width="30" align="center"></th>
                                        <th width="30" align="center"></th>
                                    </tr>
                                    <s:iterator value="adjuntos" status="status">
                                        <tr class="<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>"
                                            onmouseover="this.className = 'rowC';"
                                                onmouseout ="this.className = '<s:if test="#status.even">rowA</s:if><s:else>rowB</s:else>';" >
                                                <td>
                                                        <a href="uploads/<s:property value="scodigo"/>" title="<s:property value="scodigo"/>">
                                                    <s:property value="nombre"/>
                                                </a>
                                            </td>
                                            <td>
                                                <s:url action="AdjuntosDoc!eliminarAdjuntoDocumento" id="url" escapeAmp="false">
                                                    <s:param name="adjunto.id" value="id"/>
                                                    <s:param name="documento.id" value="documento.id"/>
                                                </s:url>
                                                <a href="<s:property value="#url"/>" class="imgLink"  onclick="<s:text name="label.confirmacion"/>">
                                                    <img src="imagenes/eliminar.png" border="0"  title="<s:text name="accion.eliminar"/>"/>
                                                </a>
                                            </td>
                                            <td>
                                                <s:url action="AdjuntosDoc!eliminarAdjuntoDocumento" id="url" escapeAmp="false">
                                                    <s:param name="adjunto.id" value="id"/>
                                                    <s:param name="documento.id" value="documento.id"/>
                                                </s:url>
                                                <a href="<s:property value="#url"/>" class="imgLink"  onclick="<s:text name="label.confirmacion"/>">
                                                    <img src="imagenes/edit.png" border="0"  title="<s:text name="accion.interpretacion"/>"/>
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