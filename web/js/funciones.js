function getNumMeses () {
    return 12;
}

function getNumAnios () {
    return 3;
}

function isDecimal (numero) {
    var Template = /^-?\d+(\.\d+)?$/ ;
    return (Template.test(numero)) ? 1 : 0;
}

function isUnsignedInteger (numero) {
    var Template = /^\d+$/ ;
    return (Template.test(numero)) ? 1 : 0;
}

function isInteger (numero) {
    var Template = /^[\+\-]?[0-9]*$/;
    return (Template.test(numero)) ? 1 : 0;
}

function getUnsignedInteger (element) {
    if (!isUnsignedInteger(parseInt(element.value)))
        element.value = 0;
    else
        element.value = parseInt(element.value);
    return parseInt(element.value);
}

function getInteger (element) {
    if (!isInteger(parseInt(element.value)))
        element.value = 0;
    else
        element.value = parseInt(element.value);
    return parseInt(element.value);
}

/*params: ( var_item,
 *          var_indicador_cuadro, (mensual o anual)
 *          var_totales_filas,
 *          var_totales_columnas,
 *          var_numero_items,
 *          var_numero_periodos ) */
function calcSumCuadroFinanciero(element,vTipo,varTotF,varTotC,varTot,numItems,numPeriodos){
    /* obtener coordenadas del item*/
    var item = getVaribleCuadroFinanc(element,vTipo);
    item.value = getUnsignedInteger(item);
    var indices = element.split("-") ;

    calcTotalFil(vTipo,indices[0],varTotF,numItems);
    calcTotalCol(vTipo,indices[1],varTotC,numPeriodos);
    calcTotal(varTotC,varTot,numItems);
}

function calcTotalesAnuales(nroItems,varTotMesC,varAnio,varTotAnio1,varTotMes) {
    /* Cuando se modifica un valor mensual */
    var itemMensual,itemAnual;
    var element;
    var i;
    /* Copia de valores de los totales mensuales a los totales del primer año*/
    for ( i=1 ; i<=nroItems ; i++ ){
        element = varTotMesC + i;
        itemMensual = document.getElementById(element);
        element = varAnio + i;
        itemAnual = document.getElementById(element);
        itemAnual.value = parseInt(itemMensual.value);
    }
    /* Copia del total mensual al total del primer año */
    itemMensual = document.getElementById(varTotMes);
    itemAnual = document.getElementById(varTotAnio1);
    itemAnual.value = parseInt(itemMensual.value);
}

function calcTotalFil(vTipo,numFila,varTotF,numItems){
    /* obtener total de la fila */
    var element,item;
    var totalf = 0;
    var i = 0;
    for ( i=1 ; i<=numItems ; i++ ){
        element = vTipo+numFila+i;
        item = document.getElementById(element);
        totalf = totalf + parseInt(item.value);
    }
    var totmf = document.getElementById(varTotF+numFila);
    totmf.value = parseInt(totalf);
}
function calcTotalCol(vTipo,numColumna,varTotC,numPeriodos){
    /* obtener total de la columna */
    var element,item;
    var totalc = 0;
    var i = 0;
    for ( i=1 ; i<=numPeriodos ; i++ ){
        element = vTipo+i+numColumna;
        item = document.getElementById(element);
        totalc = totalc + parseInt(item.value);
    }
    var totmc = document.getElementById(varTotC+numColumna);
    totmc.value = parseInt(totalc);
}
function calcTotal(varTotC,varTot,numPeriodos){
    /* obtener total del cuadro */
    var element,item;
    var totalm = 0;
    var i = 0;
    for ( i=1 ; i<=numPeriodos ; i++ ){
        element = varTotC+i;
        item = document.getElementById(element);
        totalm = totalm + parseInt(item.value);
    }
    var totm = document.getElementById(varTot);
    totm.value = parseInt(totalm);
}
function getVaribleCuadroFinanc(element,vTipo) {
 /*       params: ( var_item,
  *                 var_indicador_cuadro [mensual,anual] ) => formato a-b ; a=fila,b=columna */
    var variable = vTipo + element.replace("-","");
    return document.getElementById(variable);
}
/* Seleccionar / Deseleccionar todos */
function check(total,element) {
 /*       params: ( total_checkbox,
  *                 control_element )*/
    var item,checkbox,i;
    item = document.getElementById(element);
    for ( i=1 ; i<=total ; i++ ){
        element = "c"+i;
        checkbox = document.getElementById(element);
        if (item.checked==true)
            checkbox.checked = true;
        else
            checkbox.checked = false;
    }
}
/* Seleccionar uno */
function seleccionar (idElement,total){
    var id,fila,element;
    var i;
    for (i=0; i<total; i++){
        id = "check" + i;
        element = document.getElementById(id);
        fila = document.getElementById("fil"+i);
        if (i == idElement && element.checked)
        {
            element.checked = true;
            fila.className = "rowC";
        }
        else
        {
            if ( i % 2 == 0 )
                fila.className = "rowB";
            else
                fila.className = "rowA";
            element.checked = false;
        }
    }
    //element = document.getElementById("check"+idElement);
    //fila = document.getElementById("fil"+idElement);
}

function verificarSeleccion(total){
    var id,element;
    var i;
    for (i=0; i<total; i++){
        id = "check" + i;
        element = document.getElementById(id);
        if (element.checked)
        {
            return true;
        }
    }
    return false;
}

/* Funciones Timer para mensajes */
function iniciarTimer()
{
    setTimeout("ocultarMensajes()", 30000);
}

function ocultarMensajes()
{
    var element;
    element = document.getElementById("divActionMessage");
    if (element != null)
        element.style.display = "none";

    element = document.getElementById("divActionError");
    if (element != null)
        element.style.display = "none";
}

function obtenerError(xhr)
{
    if (xhr.responseText.indexOf("usuario.clave") > 0)
    {
        alert("Su sesión ha terminado. Por favor, vuelva a ingresar al sistema.");
        window.location = "login.action";
        throw "Login";
    }
    
    try
    {
        var linea = xhr.responseText.split("\n")[0];
        var pos = linea.indexOf("<pre>");
        var msg = linea.substring(pos); 
        var pos2 = msg.indexOf(":");
        if (pos2 != -1)
        {
            return msg.substring(pos2 + 3); 
        }
        else
        {
            return msg;
        }
    }
    catch(e)
    {
        return "Error: " + e;
    }
}

var G_ESTADOS_REQUERIMIENTO = [ 
  { "id":"1", "text":"Pendiente solped", 
    "children": [
        { "id": "0", "text": "Planificado" }, 
        { "id": "A", "text": "Sin solped" }, 
        { "id": "B", "text": "Solped por aprobar" }, 
        { "id": "C", "text": "Sin TDR" }
    ]
  },
  { "id":"2", "text":"Pendiente OC / Contrato",
    "children": [
        { "id": "F", "text": "En cotizaci&oacute;n" }, 
        { "id": "G", "text": "OC en aprobaci&oacute;n" }, 
        { "id": "H", "text": "Contrato Elaboraci&oacute;n / Firma" }, 
        { "id": "I", "text": "Pendiente pago adelanto" }
    ]      
  }, 
  { "id":"3", "text":"En ejecuci&oacute;n",
    "children": [
        { "id": "L", "text": "Entrega en curso" }, 
        { "id": "M", "text": "Ejecuci&oacute;n en curso" }, 
        { "id": "N", "text": "Pendiente de conformidad" }
    ]            
  }, 
  { "id":"4", "text":"Cerrado",
    "children": [
        { "id": "R", "text": "Cerrado" }
    ]                  
  } 
];

var G_MODOS_CONTRATACION = [ 
    { "id":"S", "text":"Suma alzada" }, 
    { "id":"P", "text":"Precios unitarios" }, 
    { "id":"M", "text":"Sistema mixto" }, 
    { "id":"C", "text":"Administraci&oacute;n controlada" } 
];

var G_PROCESOS_SELECCION = [ 
    { "id":"D", "text":"Selecci&oacute;n directa" }, 
    { "id":"C", "text":"Concurso cerrado" }, 
    { "id":"A", "text":"Concurso abierto" }, 
    { "id":"X", "text":"No definido" } 
];

function padDigits(number, digits) 
{
    return Array(Math.max(digits - String(number).length + 1, 0)).join(0) + number;
}

