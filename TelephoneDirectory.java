
/**
 * This is the class of a telephone directory. It adds new entries to a telephone book.
 * Telephone directory allows for people to search for a contact by name or number
 *
 * @author Daniel Li
 * @version Java 1.8.0
 */

import java.util.*;
public class TelephoneDirectory
{
    // Initializes the file reader that will eventually add telephone contacts to the book
    ScannerReadFile scanData = new ScannerReadFile();
    Scanner scan = new Scanner(System.in);
    // Creating a new directory consisting of TelephoneEntries, contacts if you will.
    TelephoneEntry[] directory = new TelephoneEntry[scanData.returnData().size() / 3];
    public TelephoneDirectory(){

    }

    public void addEntries(){
        /* Adds products from a text file. We initialized ScannerReadFile 
        to read the file, return the data in a large array */
        /* We then used ArrayList.get() to loop through the data in a 
        systematic manner to extract Tel. number infos. */
        for(int z = 0; z < scanData.returnData().size() / 3; z++){

            String last = (String)scanData.returnData().get(z * 3);
            String first = (String)scanData.returnData().get(z * 3 + 1);
            String number = (String)scanData.returnData().get(z * 3 + 2);
            TelephoneEntry entry = new TelephoneEntry(last,  first, number);
            directory[z] = entry;

        }
    }
    // Makes it easy to access the whole directory
    public TelephoneEntry[] returnDir(){
        return directory;
    }
    // Prints the whole directory in a formatted table. This is only for testing 
    // purposes to see if the sort worked out.
    public void printDir(){
        System.out.println();
        System.out.printf("%-15s","Last Name");
        System.out.printf("%-15s","First Name");
        System.out.printf("%-15s","Tel. #");
        System.out.println();

        for(int i = 0; i < scanData.returnData().size() / 3; i++){
            System.out.println();
            directory[i].toString();
        }
        System.out.println();
    }
    // Uses insertion sort to sort the contacts by their last names.
    public static void sortContacts (TelephoneEntry[] objects)
    {
        for (int index = 1; index < objects.length; index++)
        {
            TelephoneEntry key = objects[index];
            int position = index;

            // shift larger values to the right
            while (position > 0 && objects[position-1].getLast().compareTo(key.getLast()) > 0)
            {
                objects[position] = objects[position-1];
                position--;
            }
            // Replacing
            objects[position] = key;
        }
    }
    // This is the same structure of the sortContacts but it compares the phone number string
    public static void sortNumbers (TelephoneEntry[] objects)
    {
        for (int index = 1; index < objects.length; index++)
        {
            TelephoneEntry key = objects[index];
            int position = index;

            // shift larger values to the right
            while (position > 0 && objects[position-1].getNum().compareTo(key.getNum()) > 0)
            {
                objects[position] = objects[position-1];
                position--;
            }

            objects[position] = key;
        }
    }
    // Uses binary search. To avoid ambiguous searches of a person with say, the same last name but different first, I had to incorporate the first and last names together
    // so that they could be searched for together as a single, concatenated string
    public String searchNames(TelephoneEntry[] arr, String last, String first) 
    { 
        String fullName = (last + " " + first);
        System.out.println("\nShowing results for " + last + ", " + first + " through name lookup" + "\n");
        this.sortContacts(directory);
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            
            int outcome = fullName.compareTo(arr[m].getLast() + arr[m].getFirst()); 

            // Check if x is present at mid 
            if (outcome == 0) 
                return ("Here's what I got for " + last + ", " + first + ":" + arr[m].getNum()); 

            // If x greater, ignore left half 
            if (outcome > 0) 
                l = m + 1; 

            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 

        return "No such entry was found."; 
    } 

    public String searchNumbers(TelephoneEntry[] arr, String tel) 
    { 
        System.out.println("\nShowing results for " + tel + " through reverse number lookup" + "\n");
        this.sortNumbers(directory);
        String num = " " + tel;
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            int outcome = num.compareTo(arr[m].getNum()); 

            // Check if x is present at mid 
            if (outcome == 0) 
                return ("Here's what I got for" + num + ":" + arr[m].getFirst() + " " + arr[m].getLast()); 

            // If x greater, ignore left half 
            if (outcome > 0) 
                l = m + 1; 

            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 

        return "No such entry was found."; 
    } 
}
