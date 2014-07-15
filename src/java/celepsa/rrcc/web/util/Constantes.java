package celepsa.rrcc.web.util;

import java.util.Locale;

public class Constantes {
    //ESTADOS
    public static String estCodRegistrado = "R";    // "REGISTRADO"
    public static String estCodEliminado = "E";     // "ELIMINADO"
    public static String estCodRemitido = "K";      // "REMITIDO"
    public static String estCodObservado = "O";     // "OBSERVADO"
    public static String estCodAprobado = "F";      // "APROBADO"
    public static String estCodRechazado = "X";     // "RECHAZADO"
    public static String estCodEnEvaluacion = "V";  // "EN EVALUACIÓN"
    public static String estCodBloqueado = "B";     // "BLOQUEADO"
    public static String estCodActivo = "A";        // "ACTIVO"
    public static String estCodInactivo = "I";      // "INACTIVO"
    public static String estCodCancelado = "C";     // "CANCELADO"
    public static String estCodPublicado = "P";     // "PUBLICADO"
    public static String estCodPorFinanciar = "D";  // "POR FINANCIAR"
    public static String estCodFinanciado = "S";    // "FINANCIADO"
    public static String estCodPorImplementar = "T";// "POR IMPLEMENTAR"
    public static String estCodPendiente = "2";     // "PENDIENTE"
    public static String estCodEjecutado = "1";     // "EJECUTADO"

    // SI / NO
    public static String SI = "S";
    public static String NO = "N";

    //INICIO DE SECCIONES DEFINIDAS POR EL USUARIO
    public static Integer inicioSeccionesDef = 100; 

    public static String vacio = "-1";

    public static Integer maxTimeRegUserExt = 180; // segundos

    // TIPOS DE LOCALIDADES
    public static String Paises    ="0001";
    public static String Regiones  ="0002";
    public static String Provincias="0003";
    public static String Ciudades  ="0004";
    
    // VARIABLES DE MENSAJES
    public static String properLabel = "1general";
    public static String properMessage = "3messages";
    public static Locale locale = Locale.ENGLISH;

    /****************************** PARAMETROS ********************************/
    //GRUPOS DE PARAMETROS
    public static String grupoParamGenerales = "1";
    public static String grupoParamItems = "3";
    public static String grupoParamEstados = "4";

    public static String paramPaisOrigen = "PAIS"; //PERU
    public static String paramWebService = "WEBSERVICE"; //PERU
    public static String paramRutaIndice = "RUTAINDICE"; //
    public static String paramTamPagina = "TPAG";
    public static String paramSegActions = "SEGA";

    public static String paramCantPortadas = "C_PORT";
    
    public static String predefinida = "1";
    
}
