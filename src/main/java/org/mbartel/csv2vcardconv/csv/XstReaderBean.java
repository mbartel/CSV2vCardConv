package org.mbartel.csv2vcardconv.csv;

import com.opencsv.bean.CsvBindByName;

/**
 * CSV bean for XstReader (https://github.com/Dijji/XstReader)
 *
 * @author mbartel
 */
public class XstReaderBean implements CSVBean {

    // CSV date pattern for 31.10.2016 23:00:00
    private final static String DATE_PATTERN = "dd.MM.yyyy HH:mm:ss";

    @CsvBindByName(column = "DisplayName")
    private String displayName;

    @CsvBindByName(column = "GivenName")
    private String givenName;

    @CsvBindByName(column = "Surname")
    private String surname;

    @CsvBindByName(column = "Title")
    private String title;

    @CsvBindByName(column = "CompanyName")
    private String companyName;

    @CsvBindByName(column = "MobileTelephoneNumber")
    private String mobileNumber;

    @CsvBindByName(column = "PSETID_Address: Email1EmailAddress")
    private String emailAddress1;

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getGivenName() {
        return givenName;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String getEmailAddress1() {
        return emailAddress1;
    }
    
    @Override
    public boolean isNotEmpty() {
        return displayName != null
                || surname != null
                || givenName != null
                || title != null
                || companyName != null
                || mobileNumber != null
                || emailAddress1 != null;
    }

    @Override
    public String toString() {
        return "displayName: " + displayName
                + ", surname: " + surname
                + ", givenName: " + givenName
                + ", title: " + title
                + ", companyName: " + companyName
                + ", mobileTelephoneNumber:" + mobileNumber
                + ", emailAddress1:" + emailAddress1;
    }
}
