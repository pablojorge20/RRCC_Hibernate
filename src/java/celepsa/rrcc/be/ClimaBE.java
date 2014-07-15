/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celepsa.rrcc.be;

/**
 *
 * @author pmedina
 */
public class ClimaBE {
      private ZonaBE Zona_id;
    private String FechaGeneracion;
    private Integer Clima;
    private String Color;
    private String CFont;
    

    /**
     * @return the Zona_id
     */
    public ZonaBE getZona_id() {
        return Zona_id;
    }

    /**
     * @param Zona_id the Zona_id to set
     */
    public void setZona_id(ZonaBE Zona_id) {
        this.Zona_id = Zona_id;
    }

    /**
     * @return the FechaGeneracion
     */
    public String getFechaGeneracion() {
        return FechaGeneracion;
    }

    /**
     * @param FechaGeneracion the FechaGeneracion to set
     */
    public void setFechaGeneracion(String FechaGeneracion) {
        this.FechaGeneracion = FechaGeneracion;
    }

    /**
     * @return the Clima
     */
    public Integer getClima() {
        return Clima;
    }

    /**
     * @param Clima the Clima to set
     */
    public void setClima(Integer Clima) {
        this.Clima = Clima;
    }

    /**
     * @return the Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(String Color) {
        this.Color = Color;
    }

    /**
     * @return the CFont
     */
    public String getCFont() {
        return CFont;
    }

    /**
     * @param CFont the CFont to set
     */
    public void setCFont(String CFont) {
        this.CFont = CFont;
    }



}
