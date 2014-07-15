/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.web.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author durbina
 */
public class Funciones {
    
    public static String INSERCION = "1";
    public static String MODIFICACION = "2";
    public static String ELIMINACION = "3";
    
    public static String formatearFecha_yyyyMMdd(Date dtFecha)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return formatter.format(dtFecha);
    }
    
    public static String formatearFecha_ddMMyyyy(Date dtFecha)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dtFecha);
    }    
    
    public static String formatearHora_hhmmss(Date dtFechaHora)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(dtFechaHora);
    }
    
    public static String formatearHora_hhmm(Date dtFechaHora)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(dtFechaHora);
    }
    
    public static String formatearfecha_yyyyMMdd_hhmmss(Date dtFecha)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formatter.format(dtFecha);
    }    
    
    public static String formatearfecha_ddMMyyyy_hhmmss(Date dtFecha)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(dtFecha);
    }     
    
    public static String obtenerSiguienteFecha_yyyyMMdd(Date dtFecha)
    {
        Date dtDateResult = new Date();
        dtDateResult.setTime(dtFecha.getTime() + 1 * 24 * 60 * 60 * 1000);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return formatter.format(dtDateResult);
    }
    
    public static Date obtenerSgteDiaSemana(Date dtFecha)
    {
        Date dtDateResult = new Date();
        dtDateResult.setTime(dtFecha.getTime() + 1 * 24 * 60 * 60 * 1000);
        return dtDateResult;
    }

    public static int obtenerDiaNumericoSemana(Date dtFecha)
    {
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(dtFecha);  
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String formatearFecha_yyyyMMdd_ddMMyyyy(String sFecha)
    {
        String sAnio = sFecha.substring(0,4);
        String sMes = sFecha.substring(5,7);
        String sDia = sFecha.substring(8,10);
        return sDia + "/" + sMes + "/" + sAnio;
    }
    
    public static String formatearFecha_yyyyMMdd_ddMMyyyy_especial(String sFecha)
    {
        String sAnio = sFecha.substring(0,4);
        String sMes = sFecha.substring(4,6);
        String sDia = sFecha.substring(6,8);
        return sDia + "/" + sMes + "/" + sAnio;
    }    

    public static String formatearHora_especial(String sHora)
    {
        String sHoras = sHora.substring(0,2);
        String sMinutos = sHora.substring(2,4);
        String sSegundos = sHora.substring(4,6);
        return sHoras + ":" + sMinutos + ":" + sSegundos;
    }    
    
    public static String formatearFecha_ddMMyyyy_yyyyMMdd(String sFecha)
    {
        String sDia = sFecha.substring(0,2);
        String sMes = sFecha.substring(3,5);
        String sAnio = sFecha.substring(6,10);
        return sAnio + "/" + sMes + "/" + sDia;

    }
    
    
    public static Date obtenerDate(String sFecha)
    {
        try
        {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            return (Date)formatter.parse(sFecha);  
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public static String obtenerDiaSemana(String sFecha) 
    {
        Date dtFecha = Funciones.obtenerDate(sFecha);
        int iDia = Funciones.obtenerDiaNumericoSemana(dtFecha);
        String sDia;
        if (iDia == Calendar.MONDAY)
        {
            sDia = "Lunes"; 
        }
        else if (iDia == Calendar.TUESDAY)
        {
            sDia = "Martes"; 
        }
        else if (iDia == Calendar.WEDNESDAY)
        {
            sDia = "Miércoles"; 
        }
        else if (iDia == Calendar.THURSDAY)
        {
            sDia = "Jueves"; 
        }
        else if (iDia == Calendar.FRIDAY)
        {
            sDia = "Viernes"; 
        }
        else if (iDia == Calendar.SATURDAY)
        {
            sDia = "Sábado"; 
        }
        else if (iDia == Calendar.SUNDAY)
        {
            sDia = "Domingo"; 
        }
        else
        {
            sDia = "Otro"; 
        }
        return sDia;
        
    }
    
    public static String transformarFormatoHTML(String sMsg) 
    {
        sMsg = sMsg.replace("á", "&aacute;");
        sMsg = sMsg.replace("é", "&eacute;");
        sMsg = sMsg.replace("í", "&iacute;");
        sMsg = sMsg.replace("ó", "&oacute;");
        sMsg = sMsg.replace("ú", "&uacute;");
        sMsg = sMsg.replace("Ñ", "&Ntilde;");
        sMsg = sMsg.replace("ñ", "&ntilde;");
        return sMsg;
    }    
    
    public static String quitarTildes(String sTexto) 
    {
        return sTexto.replaceAll("á", "a").replaceAll("é", "e").replaceAll("í", "i").replaceAll("ó", "o").replaceAll("ú", "u").replaceAll("Á", "A").replaceAll("É", "E").replaceAll("Í", "I").replaceAll("Ó", "O").replaceAll("Ú", "U");
    }      

    public static String quitarEnhes(String sTexto) 
    {
        return sTexto.replaceAll("ñ", "n").replaceAll("Ñ", "N");
    }      
    
    public static String formatearMontoDecimalYMiles(double iMonto) 
    { 
        double value; 
        String numberFormat = "###,###,###,###.##"; 
        DecimalFormat formatter = new DecimalFormat(numberFormat); 
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);        
        try 
        { 
            value = Double.parseDouble(String.valueOf(iMonto)); 
        } 
        catch (Exception e) 
        { 
            return null; 
        } 
        String sValue = formatter.format(value); 
        if (!sValue.contains("."))
        {
            //sValue = sValue + ".00";
        }
        return sValue;
    }     
    
    public static String formatearMontoDecimal(double dMonto) 
    { 
        String numberFormat = "#.##"; 
        DecimalFormat formatter = new DecimalFormat(numberFormat); 
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);                
        String sValue = formatter.format(dMonto); 
        if (!sValue.contains("."))
        {
            sValue = sValue + ".00";
        }
        return sValue;
    }        
    
    public static String formatearMontoDecimal_4_decimales(double dMonto) 
    { 
        String numberFormat = "#.####"; 
        DecimalFormat formatter = new DecimalFormat(numberFormat); 
        formatter.setMinimumFractionDigits(4);
        formatter.setMaximumFractionDigits(4);                
        String sValue = formatter.format(dMonto); 
        if (!sValue.contains("."))
        {
            //sValue = sValue + ".0000";
        }
        return sValue;
    }            
    
    public static double obtenerDecimalFromExcel(String sValor)
    {
        double nValor = 0;
        if (!sValor.isEmpty())
        {
            int iSigno = 1;
            sValor = sValor.replaceAll(",","");
            if (sValor.indexOf("(") != -1)
            {
                sValor = sValor.replace(")","");
                sValor = sValor.replace("(","");
                iSigno = -1;
            }                        
            double nImporte = Double.parseDouble(sValor);
            nValor = nImporte * iSigno;
        }
        return nValor;
    }
    
    
}
