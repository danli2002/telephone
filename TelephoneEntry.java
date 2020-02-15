
/**
 * An entry into a telephone book. Consists of a last and first name as well as a phone number
 *
 * @author Daniel Li
 * @version Java 1.8.0
 */
public class TelephoneEntry
{
    private String lastName;
    private String firstName;
    private String number;
    /**
     * Constructor for objects of class TelephoneEntry
     */
    public TelephoneEntry(String last, String first, String phone)
    {
        lastName = last;
        firstName = first;
        number = phone;
    }
    // Returns the last name of the contact
    public String getLast(){
        return lastName;
    }
    // Returns the first name of the contact
    public String getFirst(){
        return firstName;
    }
    // Returns the phone number
    public String getNum(){
        return number;
    }
    // Prints out in a formatted String as Last Name, First Name, Phone #
    public String toString(){

        System.out.printf("%-15s",this.getLast());
        System.out.printf("%-15s",this.getFirst());
        System.out.printf("%-15s",this.getNum());

        return "";
    }
    // Overrides the compareTo class so it can work with the telephone entries.
    public int compareTo (Object other)
    {
        int result;

        if (lastName.equals(((TelephoneEntry)other).lastName))
            result = firstName.compareTo(((TelephoneEntry)other).firstName);
        else
            result = lastName.compareTo(((TelephoneEntry)other).lastName);

        return result;
    }
}
