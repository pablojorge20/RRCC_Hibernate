package celepsa.rrcc.encript;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


public class Encriptador {
    private static String encryptKey  = "C3!3p5@_31P1474N41";
    private static int iterationCount = 19;
    private static String algoritmo = "PBE";
    private static int keyLength = 8;
    private static byte[] salt = {	(byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
                            (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03	};

    public static String encriptar( String clave )
    {
        try 
        {
            // CONFIGURACION DE PARAMETROS
            PBEKeySpec keySpec = new PBEKeySpec(encryptKey.toCharArray(), salt, iterationCount, keyLength );
            PBEParameterSpec paramSpec = new PBEParameterSpec( keySpec.getSalt(), keySpec.getIterationCount() );
            // Crear el KeyFactory: Parámetro: el algoritmo "PBE"
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algoritmo);
            // Crear un KEY: Parámetro: la contraseña, salt, iteraciones, tamaño => todo en keySpec
            SecretKey key = keyFactory.generateSecret( keySpec );
            // Crear el cipher: Parámetro el algoritmo "PBE"
            Cipher cipher = Cipher.getInstance( key.getAlgorithm() );
            // Configurar encriptación
            cipher.init( Cipher.ENCRYPT_MODE, key, paramSpec );
            // Encriptar
            byte bencrypt[] = cipher.doFinal( clave.getBytes() );
            
            return new sun.misc.BASE64Encoder().encode(bencrypt);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public static String desencriptar( String claveEncriptada ) 
    {
        try 
        {
            byte bencrypt[] = new sun.misc.BASE64Decoder().decodeBuffer(claveEncriptada);
            
            // CONFIGURACION DE PARAMETROS
            PBEKeySpec keySpec = new PBEKeySpec( encryptKey.toCharArray(), salt, iterationCount, keyLength );
            PBEParameterSpec paramSpec = new PBEParameterSpec( keySpec.getSalt(), keySpec.getIterationCount() );
            // Crear el KeyFactory: Parámetro: el algoritmo "PBE"
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algoritmo);
            // Crear un KEY: Parámetro: la contraseña, salt, iteraciones, tamaño => todo en keySpec
            SecretKey key = keyFactory.generateSecret( keySpec );
            // Crear el cipher: Parámetro el algoritmo "PBE"
            Cipher cipher = Cipher.getInstance( key.getAlgorithm() );
            // Configurar desencriptación
            cipher.init( Cipher.DECRYPT_MODE, key, paramSpec );
            // Desencriptar
            byte bdecrypt[] = cipher.doFinal( bencrypt );
            return new String( bdecrypt );
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
