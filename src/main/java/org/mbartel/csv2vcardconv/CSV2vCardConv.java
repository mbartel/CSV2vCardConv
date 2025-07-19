package org.mbartel.csv2vcardconv;

import ezvcard.Ezvcard;
import ezvcard.VCardVersion;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.mbartel.csv2vcardconv.csv.CSVParser;
import org.mbartel.csv2vcardconv.csv.XstReaderBean;
import org.mbartel.csv2vcardconv.vcard.VCard;

/**
 * CSV to vCard converter
 *
 * @author mbartel
 */
public class CSV2vCardConv {

    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FAILED_READ_INFILE = 1;
    public static final int EXIT_FAILED_WRITE_OUTFILE = 2;

    private static Reader getReader(final String inputfile) {
        try {
            return Files.newBufferedReader(Paths.get(inputfile));
        } catch (final IOException | IllegalStateException ex) {
            System.out.println("Error parsing the inputfile " + inputfile);
            System.exit(EXIT_FAILED_READ_INFILE);
        }
        return Reader.nullReader();
    }

    public static void main(final String[] args) {
        if (args == null || args.length != 2) {
            System.out.println("Usage: java -jar " + CSV2vCardConv.class.getSimpleName() + ".jar inputfile.csv outfile.ics");
            System.exit(EXIT_SUCCESS);
        }
        final String inputfile = args[0], outputfile = args[1];

        System.out.println("Start reading lines from CSV file " + inputfile + " ...");
        final Reader reader = getReader(inputfile);

        try {
            Ezvcard.write(CSVParser.parse(reader, XstReaderBean.class).stream().map(csvBean -> new VCard(
                    csvBean.getSummary(),
                    csvBean.getDescription()
            )).collect(Collectors.toList())).version(VCardVersion.V4_0).go(Paths.get(outputfile));
        } catch (final IOException ex) {
            System.out.println("Error writing to outputfile " + outputfile);
            System.exit(EXIT_FAILED_READ_INFILE);
        }
    }
}
