package org.mbartel.csv2vcardconv.vcard;

import ezvcard.parameter.EmailType;
import ezvcard.parameter.TelephoneType;
import ezvcard.property.StructuredName;

/**
 * Subclass of VCard
 *
 * @author mbartel
 */
public class VCard extends ezvcard.VCard {

    private final StructuredName sn;

    public VCard(final String given, final String family, final String displayName, 
            final String department, final String mobileNumber, final String email1) {
        sn = new StructuredName();
        sn.setFamily(family);
        sn.setGiven(given);
        setStructuredName(sn);

        setFormattedName(displayName);
        setOrganization(department);
        addEmail(email1, EmailType.WORK);
        addTelephoneNumber(mobileNumber, TelephoneType.WORK);
    }
}
