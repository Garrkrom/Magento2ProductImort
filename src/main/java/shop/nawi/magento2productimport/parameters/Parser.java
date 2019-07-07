package shop.nawi.magento2productimport.parameters;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

public class Parser {

    private String[] _args;
    private CommandLineParser _parser = new DefaultParser();
    private ProductImportOptions _options = new ProductImportOptions();

    private String _error = "";

    public Parser(String[] args) throws ParseException {
        _args = args;
        parseCmdLine(_options, args);
    }

    private void parseCmdLine(ProductImportOptions opts, String[] args) throws ParseException {

        Settings settings = Settings.getInstance();
        CommandLine cmdLine = _parser.parse(_options.getProductImportOptions(), args);
        if(cmdLine.hasOption("i")) {
            settings.setInputFile(cmdLine.getOptionValue('i'));
        } else {
            throw new ParseException("The program needs an input file to run.");
        }

        if(cmdLine.hasOption("o")) {
            settings.setOutputFile(cmdLine.getOptionValue('i'));
        } else {
            throw new ParseException("The program needs an output file to run");
        }

        if(cmdLine.hasOption("m")) {
            settings.setManufacturerDataFile(cmdLine.getOptionValue('m'));
        }

        if(cmdLine.hasOption("d")) {
            settings.setDefaultValuesFile(cmdLine.getOptionValue('d'));
        }

        if(cmdLine.hasOption("s")) {
            settings.setStrictMode(true);
        }
    }
}
