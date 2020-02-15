
/**
 * Tests the PhoneDirectory stuff
 *
 * @author Daniel Li
 * @version Java 1.8.0 1/31/20
 */
public class DirDriver
{
    public static void main(String [] args){
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.addEntries();
        directory.sortContacts(directory.returnDir());
        directory.printDir();

        System.out.println(directory.searchNames(directory.returnDir(),"Buckman", "Rowan"));
        directory.sortNumbers(directory.returnDir());
        directory.printDir();
        System.out.println(directory.searchNumbers(directory.returnDir(),"217-382-1047"));

    }
    
    /** Output
     * 
     * Here's what I got for Mostana, Morn: 652-652-3851
     * Here's what I got for 652-652-3851: Morn Mostana
     * 
     */
}
