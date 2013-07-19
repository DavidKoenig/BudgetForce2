/*
 * source: http://www.bennyn.de/programmierung/java/sha-512-verschlusselung-mit-java.html
 */
package budgetforce.control.login;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author kinske
 */
public class SecretMaker2 {


    private static String convertToHex(byte[] data)
    {
        StringBuffer buf = new StringBuffer();
 
        for (int i = 0; i < data.length; i++)
        {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do
            {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            }
            while(two_halfs++ < 1);
        }
        return buf.toString();
    }
 
    public static String SHA512(String text)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md;
        //add at every encryption a secret
        String value = text + "DaVeLicIous";
        md = MessageDigest.getInstance("SHA-512");
        byte[] sha1hash = new byte[40];
        md.update(value.getBytes("UTF-8"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
}
    

