package celepsa.rrcc.bd;

import celepsa.rrcc.encript.Encriptador;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class ConexionBD {
    
    private Connection conexion = null;
    private PreparedStatement sentencia = null;
    
    public void open() throws Exception
    {
        Properties properties = new Properties();
        System.out.println(" anets de la bd.properties ");
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        if (inputStream != null)
        {
            
             System.out.println("properties directo  ");
             
            properties.load(inputStream);
        }
        else
        {
            String curDir = System.getProperty("user.dir") + "/db.properties";
            System.out.println(" carpeta dnde busca archivo " + curDir );
            FileInputStream file = new FileInputStream(curDir); 
            if (file != null)
            {
                properties.load(file);    
            }
            else
            {
                throw new Exception("No existe archivo db.properties");
            }
        }
        
        //System.out.println("ruta"+Thread.currentThread().getContextClassLoader().getResource("config.properties").getPath());
        String url = properties.getProperty("jdbc.url");
        String driver = properties.getProperty("jdbc.driver");
        String userName = properties.getProperty("jdbc.username");
        //String password = Encriptador.desencriptar(properties.getProperty("jdbc.password"));
        String password = (properties.getProperty("jdbc.password"));
        System.out.println("url="+url +",user=" + userName + " pass=" + password);
        try 
        {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url,userName,password);
        } 
        catch (Exception e) 
        {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public void close() throws Exception
    {
        try 
        {
            if (sentencia != null) // && !sentencia.isClosed())
            {
                sentencia.close();
            }
            
            if (conexion != null && !conexion.isClosed())
            {
                conexion.close();
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public void prepararSentencia(String sQuery) throws SQLException
    {
        if (sentencia != null) // && !sentencia.isClosed())
        {
            sentencia.close();
        }
        sentencia = conexion.prepareStatement(sQuery, Statement.RETURN_GENERATED_KEYS);
    }
    
    public void agregarParametro(int i, String sParametro) throws SQLException, Exception
    {
        if (sentencia != null) // && !sentencia.isClosed())
        {
            sentencia.setString(i, sParametro);
        }
        else
        {
            throw new Exception("Objeto de conexión NULL o cerrado.");
        }        
    }
    
    public void agregarParametro(int i, int iParametro) throws SQLException, Exception
    {
        if (sentencia != null) // && !sentencia.isClosed())
        {
            if (iParametro > 0)
            {
                sentencia.setInt(i, iParametro);
            }
            else
            {
                sentencia.setNull(i, iParametro);
            }
        }
        else
        {
            throw new Exception("Objeto de conexión NULL o cerrado.");
        }
    }
    
    public int ejecutar() throws SQLException, Exception
    {
        if (sentencia != null) // && !sentencia.isClosed())
        {
            return sentencia.executeUpdate();
        }
        else
        {
            throw new Exception("Objeto de conexión NULL o cerrado.");
        }
    }
    
    public int insertar() throws SQLException, Exception
    {
        if (sentencia != null) // && !sentencia.isClosed())
        {
            sentencia.executeUpdate();
                ResultSet keys = sentencia.getGeneratedKeys();
            int id = 0;
            while (keys.next()) 
            {
                id = keys.getInt(1);
            }
            return id;
        }
        else
        {
            throw new Exception("Objeto de conexión NULL o cerrado.");
        }
    }
    
        
    public ResultSet ejecutarQuery() throws SQLException, Exception
    {
        if (sentencia != null) // && !sentencia.isClosed())
        {
            return sentencia.executeQuery();
        }
        else
        {
            throw new Exception("Objeto de conexión NULL o cerrado.");
        }
    }
}
