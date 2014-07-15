package celepsa.rrcc.web.util;

import java.util.ResourceBundle;

public class Messenger {
    public static String errorUsuarioInvalido = "message.errorUsuarioInvalido";
    public static String errorGrabar = "message.errorGrabar";
    public static String valorOblig = "message.valorOblig";
    public static String exitoGrabar = "message.exitoGrabar";
    public static String errorImagenCaptcha = "message.errorImagenCaptcha";
    public static String errorRepetirClave = "message.errorRepetirClave";
    public static String errorOperacionNoPermitida = "message.errorOperacionNoPermitida";
    public static String errorUsuarioExiste = "message.errorUsuarioExiste";
    public static String errorFaltanAprobaciones = "message.errorFaltanAprobaciones";
    public static String errorMontoPagoObligatorio = "message.errorMontoPagoObligatorio";
    public static String errorFechaInicioFin = "message.errorFechaInicioFin";
    public static String errorClaveActual = "message.errorClaveActual";
    public static String errorClaveNueva = "message.errorClaveNueva";
    public static String errorAsigInv = "message.errorAsigInv";
    public static String errorAsigInv2 = "message.errorAsigInv2";
    public static String errorAsigEnc = "message.errorAsigEnc";
    public static String exitoRegInteres = "message.exitoRegInteres";
    public static String exitoPublicar = "message.exitoPublicar";
    public static String errorPublicar = "message.errorPublicar";
    public static String errorPublicar2 = "message.errorPublicar2";
    public static String exitoOcultar = "message.exitoOcultar";
    public static String errorOcultar = "message.errorOcultar";

    public static String exitoIdGrabar = "message.exitoIdGrabar";
    public static String exitoIdEliminar = "message.exitoIdEliminar";
    public static String errorIdEliminar = "message.errorIdEliminar";
    public static String exitoGrabarUsuario = "message.exitoGrabarUsuario";
    public static String exitoBloquearUsuario = "message.exitoBloquearUsuario";
    public static String exitoEliminarUsuario = "message.exitoEliminarUsuario";

    // Listas
    public static String listObligFases = "message.listObligFases";
    public static String listObligFuncionalidades = "message.listObligFuncionalidades";
    public static String listObligAreas = "message.listObligAreas";
    public static String listObligEvaluadores = "message.listObligEvaluadores";
    public static String listObligSecciones = "message.listObligSecciones";
    public static String listObligSectores = "message.listObligSectores";
    public static String listObligAlternativas = "message.listObligAlternativas";
    public static String listObligPerfiles = "message.listObligPerfiles";
    public static String listObligBloquesPreg = "message.listObligBloquesPreg";
    public static String listObligPreguntas = "message.listObligPreguntas";
    public static String listObligEmprendedores = "message.listObligEmprendedores";

    // ESTADOS
    public static String estAprobado = "label.estAprobado";
    public static String estRechazado = "label.estRechazado";
    public static String estEjecutado = "label.estEjecutado";
    public static String estPendiente = "label.estPendiente";
    public static String estEnProceso = "label.estEnProceso";
    
    public static String getMessage(String mensaje){
        try {
            ResourceBundle myResources = ResourceBundle.getBundle(Constantes.properMessage, Constantes.locale);
            return myResources.getString(mensaje);
        }
        catch(Exception ex){
            return "No existe mensaje";
        }
    }

    public static String getLabel(String label){
        try {
            ResourceBundle myResources = ResourceBundle.getBundle(Constantes.properLabel, Constantes.locale);
            return myResources.getString(label);
        }
        catch(Exception ex){
            return "No existe label";
        }
    }


    public static String getLabelPeriodoInicial(){
        return getLabel("label.periodoInicial");
    }
/*
/*
/*
    // Tipos de Comentario
    public static String getLabelComentarioTipoObservacion(){
        return getLabel("label.comentarioTipoObservacion");
    }

    public static String getLabelComentarioTipoSugerencia(){
        return getLabel("label.comentarioTipoSugerencia");
    }

    // Tipos de Acceso
    public static String getLabelAccesoTipoPublico(){
        return getLabel("label.accesoTipoPublico");
    }

    public static String getLabelAccesoTipoPrivado(){
        return getLabel("label.accesoTipoPrivado");
    }

    // Tipos de Usuario
    public static String getLabelUsuarioTipoInversionista(){
        return getLabel("label.usuarioTipoInversionista");
    }

    public static String getLabelUsuarioTipoEmprendedor(){
        return getLabel("label.usuarioTipoEmprendedor");
    }

    public static String getLabelUsuarioTipoEmpleado(){
        return getLabel("label.usuarioTipoEmpleado");
    }

    // Tipos de Respuesta
    public static String getLabelRptaTipoLibre(){
        return getLabel("label.rptaTipoLibre");
    }

    public static String getLabelRptaTipoMultiple(){
        return getLabel("label.rptaTipoMultiple");
    }

    // Tipos de Evaluación
    public static String getLabelTipoEvaPart(){
        return getLabel("label.tipoEvaPart");
    }


    // Estados

    public static String getLabelEstRegistrado(){
        return getLabel("label.estRegistrado");
    }

    public static String getLabelEstEliminado(){
        return getLabel("label.estEliminado");
    }

    public static String getLabelEstRemitido(){
        return getLabel("label.estRemitido");
    }

    public static String getLabelEstObservado(){
        return getLabel("label.estObservado");
    }

    public static String getLabelEstAprobado(){
        return getLabel("label.estAprobado");
    }

    public static String getLabelEstRechazado(){
        return getLabel("label.estRechazado");
    }

    public static String getLabelEstEnEvaluacion(){
        return getLabel("label.estEnEvaluacion");
    }

    public static String getLabelEstBloqueado(){
        return getLabel("label.estBloqueado");
    }

    public static String getLabelEstActivo(){
        return getLabel("label.estActivo");
    }

    public static String getLabelEstInactivo(){
        return getLabel("label.estInactivo");
    }

    public static String getLabelEstCancelado(){
        return getLabel("label.estCancelado");
    }

    public static String getLabelEstPublicado(){
        return getLabel("label.estPublicado");
    }

    public static String getLabelEstPorFinanciar(){
        return getLabel("label.estPorFinanciar");
    }

    public static String getLabelEstFinanciado(){
        return getLabel("label.estFinanciado");
    }

    public static String getLabelEstPendiente(){
        return getLabel("label.estPendiente");
    }

    public static String getLabelEstEjecutado(){
        return getLabel("label.estEjecutado");
    }

    public static String getLabelEstEnProceso(){
        return getLabel("label.estEnProceso");
    }
*/

}
