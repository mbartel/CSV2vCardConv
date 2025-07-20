package org.mbartel.csv2vcardconv.csv;

import java.util.Date;

/**
 * Interface for CSV reader beans
 *
 * @author mbartel
 */
public interface CSVBean {

    /**
     * @return the display name
     */
    String getDisplayName();

    /**
     * @return the given name
     */
    String getGivenName();

    /**
     * @return the surname / family name
     */
    String getSurname();

    /**
     * @return the title
     */
    String getTitle();

    /**
     * @return the company name
     */
    String getCompanyName();

    /**
     * @return the mobile phone number
     */
    String getMobileNumber();
    
    /**
     * @return the first email address 
     */
    String getEmailAddress1();
    
    /**
     * @return true, if the all properties of the event are empty (means equal to NULL)
     */
    boolean isNotEmpty();
}
