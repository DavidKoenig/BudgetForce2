
package budgetforce.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Locale;
import javax.servlet.http.Part;

/**
 *
 * @author Soi Fon
 */
public class FileHandle 
{
    public static final String relPath = "..\\..\\..\\..\\..\\..\\..\\Schule\\Programmieren IV\\BudgetForce\\Users\\";    
    
    /**
     * Creates a new File at the Server
     * @return returns 2 strings 1. filepath, 2. filename
     */
    public static String[] CreateFile(InputStream uploadedInputStream, String uploadedFileLocation, String _Username, int _ReceiptID) throws IOException
    {
        Calendar calendar   = Calendar.getInstance();
        String subFolder    = calendar.get(Calendar.YEAR) + "_" + calendar.get(Calendar.MONTH);
        String path         = relPath + _Username + "\\" + subFolder;
        String newFileName  = _Username + _ReceiptID + "_" + uploadedFileLocation;
        
        OutputStream out;
        try 
        {
            
            int read;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(path + "\\" + newFileName));
            while ((read = uploadedInputStream.read(bytes)) != -1) 
            {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        String[] destination = new String[2];
        
        destination[0] = _Username + "\\" + subFolder;
        destination[1] = newFileName;            
        
        return destination;
    }    
    
    /**
     * Creates a folder with the username
     * @param _Username
     * @return true if succeed otherwise false
     */
    public static boolean CreateUserDirectory(String _Username)
    {
        File file = new File(relPath + _Username);
        System.out.println(file.getAbsolutePath());
        boolean succeed = false;
        
        if(!file.exists())
        {
            succeed = file.mkdir();
        }
        
        return succeed;
    }
    
    /**
     * Creates a new Subfolder for the acctually month if necessary
     * @param _Username
     * @return true if succeed otherwise false
     */
    public static boolean CreateUserSubDirectory(String _Username)
    {
        Calendar calendar = Calendar.getInstance();
        
        String folderName = relPath + _Username + "\\" + calendar.get(Calendar.YEAR) + "_" + calendar.get(Calendar.MONTH);
        
        File file = new File(folderName);
        
        boolean succeed = false;
        
        if(!file.exists())
        {
            succeed = file.mkdir();
        }
        
        return succeed;
    }
}
