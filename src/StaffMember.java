import java.io.*;
import java.util.*;

public class StaffMember implements Serializable {
    // class release version:
    private static final long serialVersionUID = 1L;
    // areas with prompts:
    int tableNumber;
    static final String P_tableNumber = "Table Number";
    int departNumber;
    static final String P_departNumber="Department Number";
    String fullName;
    static final String P_fullName = "Full Name";
    int salary;
    static final String P_salary = "Salary";
    String startDate;
    static final String P_startDate = "Start Date";
    int bonus;
    static final String P_bonus = "Bonus";
    int incomeTaks;
    static final String P_incomeTaks = "Income Task";

    // validation methods:
    /*static Boolean validISBN( String str ) {
        int i = 0, ndig = 0;
        for ( ; i < str.length(); i++ ) {
            char ch = str.charAt(i);
            if ( Character.isDigit(ch) ) {
                ndig++;
                continue;
            }
            if ( ch != '-' ) {
                return false;
            }
        }
        return (ndig == 13 || ndig == 10 );
    }*/

    /*private static GregorianCalendar curCalendar = new GregorianCalendar();
    static Boolean validYear( int year ) {
        return year > 0 && year <= curCalendar.get( Calendar.YEAR );
    }*/

    public static Boolean nextRead( Scanner fin, PrintStream out ) {
        return nextRead( P_departNumber, fin, out );
    }

    static Boolean nextRead( final String prompt, Scanner fin, PrintStream out ) {
        out.print( prompt );
        out.print( ": " );
        return fin.hasNextLine();
    }

    public static final String authorDel = ",";

    public static StaffMember read( Scanner fin, PrintStream out )
            throws IOException {
        String str;
        StaffMember StaffMember = new StaffMember();
        StaffMember.tableNumber = Integer.parseInt(fin.nextLine());
        /*if ( StaffMember.validISBN( StaffMember.departNumber )== false ) {
            throw new IOException("");
        }*/
        if ( ! nextRead( P_departNumber, fin, out ))
            return null;
        StaffMember.departNumber = Integer.parseInt(fin.nextLine());
        if ( ! nextRead( P_fullName, fin, out ))
            return null;
        StaffMember.fullName = fin.nextLine();
        if ( ! nextRead( P_salary, fin, out ))
            return null;
        str = fin.nextLine();
        StaffMember.salary = Integer.parseInt(str);
        /*if ( StaffMember.validYear(StaffMember.year) ==  false ) {
            throw new IOException("Invalid StaffMember.year value");
        }*/
        if ( ! nextRead( P_startDate, fin, out ))
            return null;
        StaffMember.startDate = fin.nextLine();
        if ( ! nextRead( P_bonus, fin, out ))
            return null;
        StaffMember.bonus = Integer.parseInt(fin.nextLine());
        if ( ! nextRead( P_incomeTaks, fin, out ))
            return null;
        str = fin.nextLine();
        StaffMember.incomeTaks = Integer.parseInt(str);
        return StaffMember;
    }

    public StaffMember() {
    }

    public static final String areaDel = "\n";

    @Override
    public String toString() {
        return //new String (
                this.tableNumber + areaDel +
                        this.departNumber + areaDel +
                        this.fullName + areaDel +
                        this.salary + areaDel +
                        this.startDate + areaDel +
                        this.bonus + areaDel +
                        this.incomeTaks
                //)
                ;
    }
}
