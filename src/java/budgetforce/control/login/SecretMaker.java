//this one is not implementet, because apache commons creates always the same hash value, no matter which values you give

package budgetforce.control.login;

import org.apache.commons.codec.digest.Crypt;

/**
 *
 * @author David König
 */
public class SecretMaker 
{
    private SecretMaker()
    {
        this.m_Secret = "DavElicIouS";
    }
    
    public static SecretMaker getInstance()
    {
        if (m_SecretMaker == null)   m_SecretMaker = new SecretMaker();
                               
        return m_SecretMaker;
    }
    
    public String makeSecretSHA512(String _Values)
    {
        System.out.println("VALES: " + _Values);
        String hashed = Crypt.crypt("secret", "$6$" + "bla" + "$" + _Values + this.m_Secret);
        System.out.println("HASED: " + hashed);
        return hashed;
    }
 
    
    private static SecretMaker m_SecretMaker = null;
    private String m_Secret;
}
