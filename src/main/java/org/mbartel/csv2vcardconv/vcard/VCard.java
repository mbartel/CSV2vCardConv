package org.mbartel.csv2vcardconv.vcard;

import ezvcard.property.StructuredName;

/**
 * Subclass of VCard
 *
 * @author mbartel
 */
public class VCard extends ezvcard.VCard {

    private final StructuredName sn;

    public VCard(final String given, final String family) {
        sn = new StructuredName();

        sn.setFamily(family);
        sn.setGiven(given);
        //sn.getPrefixes().add("Mr");
        setStructuredName(sn);

        setFormattedName(given + " " + family);
    }
}
