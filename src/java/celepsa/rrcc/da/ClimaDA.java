/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;
import celepsa.rrcc.eh.Tmzona;
import celepsa.rrcc.web.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class ClimaDA {

    private static final Logger logger = Logger.getLogger(ClimaDA.class);
    Session session = null;

    public ClimaDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    private Integer SumCri;
    private Integer SumInf;
    private Integer SumInfxDoc;
    private Integer SumPerDoc;

    public int CriticidadZona(Tmzona objSistema) throws Exception {
        logger.debug("eliminarAgrupacion id=" + objSistema.getId());
        String sQuery = " SELECT tmZona.id as zona_id, tmZona.Descripcion,"
                + " SUm( tmTipoDocumento.Criticidad_id) as sumCri "
                + "FROM tmDocumento, tmTipoDocumento, tmStakePersona, tmZona "
                + "where tmDocumento.eliminado = 0 and "
                + "tmDocumento.tmEstado_id = 1 and tmDocumento.tmTipoDocumento_id <>0 "
                + "and tmDocumento.tmTipoDocumento_id = tmTipoDocumento.id "
                + "and tmDocumento.tmStakePersona_id = tmStakePersona.id "
                + "and tmStakePersona.tmZona_id =tmZona.id "
                + "and tmZona.id='" + objSistema.getId() + "'";
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery(sQuery);
            Integer res = (Integer) query.uniqueResult();
            if (res != null) {
                setSumCri(res);
            } else {
                setSumCri(0);
            }
            tx.commit();
            return getSumCri();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public int InfluenciaPersonas(Tmzona objSistema) throws Exception {
        logger.debug("eliminarAgrupacion id=" + objSistema.getId());
        String sQuery = "select tmStakePersona.tmZona_id, SUM(tmStakePersona.tmNivelInfluencia_id) as SumNin "
                + "from tmStakePersona,tmNivelInfluencia "
                + "where tmStakePersona.tmZona_id='" + objSistema.getId() + "' and "
                + "tmStakePersona.tmNivelInfluencia_id=tmNivelInfluencia.id ";
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery(sQuery);
            Integer res = (Integer) query.uniqueResult();
            if (res != null) {
                setSumInf(res);
            } else {
                setSumInf(0);
            }
            tx.commit();
            return getSumInf();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public int InfluenciaPersonasDocumento(Tmzona objSistema) throws Exception {
       String sQuery = "Select tmDocumento.id as DocID "
           + "from tmDocumento, tmStakePersona "
           + "where "
           + "tmDocumento.tmStakePersona_id=tmStakePersona.id and "
           + "tmStakePersona.tmZona_id='" + objSistema.getId() + "'";

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery(sQuery);
            Integer res = (Integer) query.uniqueResult();
            SumInfxDoc = SumInfxDoc + this.PersonasDocumento( res+"" );
            tx.commit();
            return getSumInfxDoc();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
  
    
    }

    public int PersonasDocumento(String IdDOC) throws Exception {
        String sQuery = "Select "
                    + " Sum(tmStakePersona.tmNivelInfluencia_id) as Ninf,  tmDocumento.id as nrodoc "
                    + "from PersonaDocumento, tmStakePersona, tmDocumento "
                    + "where "
                    + "PersonaDocumento.tmStakePersona_id=tmStakePersona.id and "
                    + "PersonaDocumento.tmDocumento_id=tmDocumento.id and "
                    + "PersonaDocumento.tmDocumento_id='" + IdDOC + "'";

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery(sQuery);
            Integer res = (Integer) query.uniqueResult();
            SumPerDoc = SumPerDoc + ((Integer) Integer.parseInt( res +"" ));
            tx.commit();
            return getSumPerDoc();
        } catch (NumberFormatException | HibernateException e) {
            logger.error( e.getMessage() );
            throw e;
        }
    
    }

    /**
     * @return the SumCri
     */
    public Integer getSumCri() {
        return SumCri;
    }

    /**
     * @param SumCri the SumCri to set
     */
    public void setSumCri(Integer SumCri) {
        this.SumCri = SumCri;
    }

    /**
     * @return the SumInf
     */
    public Integer getSumInf() {
        return SumInf;
    }

    /**
     * @param SumInf the SumInf to set
     */
    public void setSumInf(Integer SumInf) {
        this.SumInf = SumInf;
    }

    /**
     * @return the SumInfxDoc
     */
    public Integer getSumInfxDoc() {
        return SumInfxDoc;
    }

    /**
     * @param SumInfxDoc the SumInfxDoc to set
     */
    public void setSumInfxDoc(Integer SumInfxDoc) {
        this.SumInfxDoc = SumInfxDoc;
    }

    /**
     * @return the SumPerDoc
     */
    public Integer getSumPerDoc() {
        return SumPerDoc;
    }

    /**
     * @param SumPerDoc the SumPerDoc to set
     */
    public void setSumPerDoc(Integer SumPerDoc) {
        this.SumPerDoc = SumPerDoc;
    }
}
