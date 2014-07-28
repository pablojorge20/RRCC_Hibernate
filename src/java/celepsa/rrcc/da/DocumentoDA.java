/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celepsa.rrcc.da;

import celepsa.rrcc.be.AdjuntoBE;
import celepsa.rrcc.be.CriticidadBE;
import celepsa.rrcc.be.DocumentoBE;
import celepsa.rrcc.be.IngrsoSalidaBE;
import celepsa.rrcc.be.StakeholderBE;
import celepsa.rrcc.be.TipoDocumentoBE;
import celepsa.rrcc.bd.ConexionBD;
import celepsa.rrcc.be.EstadoBE;
import celepsa.rrcc.web.util.HibernateUtil;
import celepsa.rrcc.eh.Tmdocumento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pmedina
 */
public class DocumentoDA {

    private static final Logger logger = Logger.getLogger(DocumentoDA.class);
    Session session = null;

    public DocumentoDA() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public int registrarDocumento(Tmdocumento documento) throws Exception {
        try {
            documento.setId(CrearIDDoc());
            logger.debug("antes del insert con hibernate");
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(documento);
            logger.debug("luego del commit ");
            tx.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean ActualizarDocumento(Tmdocumento documento) throws Exception {

        try {
            logger.debug("update");
            org.hibernate.Transaction tx = session.beginTransaction();
            session.merge(documento);
            tx.commit();
            return true;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            return false;// no actualizo nada 
        }

    }

    public List<Tmdocumento> listarDocumentos(Integer tdoc) throws Exception {
        try {
            logger.debug("listarDocumentos");
            String sQuery = "";
            if (tdoc == 0) {
                sQuery = " from Tmdocumento where  eliminado='0'";
            } else {
                sQuery = "from Tmdocumento where tmTipoDocumentoid.id=" + tdoc + " OR tmTipoDocumentoid.id=0  and eliminado='0' ";
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery(sQuery);
            return query.list();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<DocumentoBE> listarDocumentosVarios() throws Exception {
        try {
            logger.debug("listarDocumentosVarios");

            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Tmdocumento where  eliminado='0' ");
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public List<DocumentoBE> buscarDocumentosVarios(String AsuntoBuscado) throws Exception {
        try {

            logger.debug("buscarDocumentosVarios");
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Tmdocumento where  eliminado='0' and asunto like :asunto ");
            query.setString("asunto", "%" + AsuntoBuscado + "%");
            return query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private DocumentoBE populateDocumento(ResultSet resultado) throws SQLException {
        DocumentoBE objDocumentoBE = new DocumentoBE();
        DocumentoBE objConvenioBE = new DocumentoBE();
        DocumentoBE objProgramaBE = new DocumentoBE();
        DocumentoBE objProyectoBE = new DocumentoBE();
        DocumentoBE objOtroDocsBE = new DocumentoBE();
        TipoDocumentoBE objTipoDocumentoBE = new TipoDocumentoBE();
        StakeholderBE objStakeholderBE = new StakeholderBE();
        IngrsoSalidaBE objIngreoSalidaBE = new IngrsoSalidaBE();
        CriticidadBE objCriticidadBE = new CriticidadBE();
        EstadoBE objEstadoBE = new EstadoBE();

        objDocumentoBE.setId(resultado.getString("id"));

        objDocumentoBE.setFechaRegistro(resultado.getString("FechaRegistro"));
        objDocumentoBE.setFechaRecepcion(resultado.getString("FechaRecepcion"));

        objTipoDocumentoBE.setId(resultado.getString("tmTipoDocumento_id"));
        objDocumentoBE.setTipoDocumento(objTipoDocumentoBE);

        objStakeholderBE.setId(resultado.getString("tmStakePersona_id"));
        objDocumentoBE.setStakeholder(objStakeholderBE);

        objDocumentoBE.setObservaciones(resultado.getString("Observaciones"));
        objDocumentoBE.setAsunto(resultado.getString("Asunto"));

        objIngreoSalidaBE.setId(resultado.getString("IngresoSalida"));
        objDocumentoBE.setIngreso(objIngreoSalidaBE);

        objCriticidadBE.setId(resultado.getString("Criticidad_id"));
        objDocumentoBE.setCriticidad(objCriticidadBE);
        objDocumentoBE.setFechaCaducidad(resultado.getString("FechaCaducidad"));

        objConvenioBE.setId(resultado.getString("RefConvenio"));
        objDocumentoBE.setConvenio(objConvenioBE);

        objProgramaBE.setId(resultado.getString("RefPrograma"));
        objDocumentoBE.setPrograma(objProgramaBE);

        objProyectoBE.setId(resultado.getString("RefProyecto"));
        objDocumentoBE.setProyecto(objProyectoBE);

        objOtroDocsBE.setId(resultado.getString("RefDocumento"));
        objDocumentoBE.setDocumento(objOtroDocsBE);

        objEstadoBE.setId(resultado.getString("tmEstado_id"));
        objDocumentoBE.setEstado(objEstadoBE);

        return objDocumentoBE;
    }

    private AdjuntoBE populateAdjunto(ResultSet resultado) throws SQLException {
        AdjuntoBE objAdjuntoBE = new AdjuntoBE();
        DocumentoBE objDocumentoBE = new DocumentoBE();

        objAdjuntoBE.setId(resultado.getString("id"));

        objDocumentoBE.setId(resultado.getString("tmDocumento_id"));
        objAdjuntoBE.setDocumento(objDocumentoBE);

        objAdjuntoBE.setNombre(resultado.getString("Nombre"));
        objAdjuntoBE.setEliminado(resultado.getString("eliminado"));
        objAdjuntoBE.setScodigo(resultado.getString("scodigo"));

        return objAdjuntoBE;
    }

    private Integer CrearIDDoc() throws Exception {
        Integer idnew = 0;
        ConexionBD objConexion2 = null;
        // DocumentoBE objDocumentoBE = new DocumentoBE();
        try {
            objConexion2 = new ConexionBD();
            logger.debug("CrearIDDoc");
            //List<DocumentoBE> lstRetorno = new ArrayList<DocumentoBE>();
            String sQuery = "SELECT  * FROM Tmdocumento ORDER BY id DESC LIMIT 1";
            objConexion2.open();
            objConexion2.prepararSentencia(sQuery);
            ResultSet objResult = objConexion2.ejecutarQuery();
            if (objResult != null) {
                objResult.next();

                if (objResult.getRow() == 0) {
                    idnew = 0;
                } else {
                    idnew = Integer.parseInt(populateDocumento(objResult).getId());
                }

            } else {
                idnew = 0;
            }

        //objDocumentoBE.setId(resultado.getString("id"));
            //objDocumentoBE.setId(objResult.getString("id"));
            if (idnew == 0) {
                idnew = 1;
            } else {
                idnew = idnew + 1;
            }
            return idnew;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion2.close();
        }

    }

    public Tmdocumento obtenerDocumento(Tmdocumento objDocumento) throws Exception {
        try {            
            Query query = session.createQuery("from Tmdocumento where id = :id ");
            query.setInteger("id", objDocumento.getId());
            return (Tmdocumento) query.list().get(0);
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean eliminarDocumento(DocumentoBE objDocumento) throws Exception {
        // eliminar con hibernate 
        try {
            Query query = session.createQuery(" update Tmdocumento set eliminado= :eliminado where id = :id ");
            query.setString("eliminado", objDocumento.getEliminado());
            query.setInteger("id", Integer.parseInt(objDocumento.getId()));
            return query.executeUpdate() > 0;
        } catch (NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public int registrarAdjunto(AdjuntoBE objSistema, DocumentoBE objDocumento) throws Exception {

        ConexionBD objConexion = null;
        String query = "";

        query = "INSERT INTO `tmAdjunto`(`id`,`tmDocumento_id`,`Nombre`,`eliminado`, `scodigo`)"
                + "VALUES (?,?,?,'0',?)";

        int cont = 1;
        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
            objConexion.agregarParametro(cont++, CrearIDAdjunto());
            objConexion.agregarParametro(cont++, objDocumento.getId());
            objConexion.agregarParametro(cont++, objSistema.getNombre());
            objConexion.agregarParametro(cont++, objSistema.getScodigo());
            return objConexion.insertar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }

    }

    private Integer CrearIDAdjunto() throws Exception {
        Integer idnew = 0;
        ConexionBD objConexion2 = null;
        // DocumentoBE objDocumentoBE = new DocumentoBE();
        try {
            objConexion2 = new ConexionBD();

            //List<DocumentoBE> lstRetorno = new ArrayList<DocumentoBE>();
            String sQuery = "SELECT  * FROM tmAdjunto ORDER BY id DESC LIMIT 1";
            objConexion2.open();
            objConexion2.prepararSentencia(sQuery);
            ResultSet objResult = objConexion2.ejecutarQuery();
            if (objResult != null) {
                objResult.next();

                if (objResult.getRow() == 0) {
                    idnew = 0;
                } else {
                    idnew = Integer.parseInt(populateAdjunto(objResult).getId());
                }

            } else {
                idnew = 0;
            }

            if (idnew == 0) {
                idnew = 1;
            } else {
                idnew = idnew + 1;
            }
            return idnew;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion2.close();
        }

    }

    public List<AdjuntoBE> listarAdjuntos(Integer tdoc) throws Exception {
        ConexionBD objConexion = null;
        try {
            objConexion = new ConexionBD();
            List<AdjuntoBE> lstRetorno = new ArrayList<AdjuntoBE>();
            String sQuery = "";
            if (tdoc == 0) {
                sQuery = "SELECT id, tmDocumento_id, Nombre, eliminado, scodigo  FROM "
                        + "tmAdjunto where tmDocumento_id =" + tdoc + "";

            } else {
                sQuery = "SELECT id, tmDocumento_id, Nombre, eliminado, scodigo  FROM "
                        + "tmAdjunto where tmDocumento_id =" + tdoc + "";

            }

            objConexion.open();
            objConexion.prepararSentencia(sQuery);
            ResultSet objResult = objConexion.ejecutarQuery();
            if (objResult != null) {
                while (objResult.next()) {
                    lstRetorno.add(populateAdjunto(objResult));
                }
            }
            return lstRetorno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }

    public boolean eliminarDocumentoAdjunto(AdjuntoBE objAdjunto, DocumentoBE objDocumento) throws Exception {
        ConexionBD objConexion = null;
        int cont = 1;
        //String query = " UPDATE tmDocumento SET eliminado = ? WHERE id = ? ";
        String query = "DELETE FROM `RRHH`.`tmAdjunto` WHERE `id`=? and`tmDocumento_id`=?";
        try {
            objConexion = new ConexionBD();
            objConexion.open();
            objConexion.prepararSentencia(query);
            // objConexion.agregarParametro(cont++, objStakeholder.getEliminado());
            objConexion.agregarParametro(cont++, objAdjunto.getId());
            objConexion.agregarParametro(cont++, objDocumento.getId());
            objConexion.ejecutar();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            objConexion.close();
        }
    }
}
