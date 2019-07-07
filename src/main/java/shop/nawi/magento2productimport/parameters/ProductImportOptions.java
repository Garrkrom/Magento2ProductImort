package shop.nawi.magento2productimport.parameters;

import org.apache.commons.cli.Options;

class ProductImportOptions  extends org.apache.commons.cli.Options {

    private Options _options = new Options();

    ProductImportOptions() {
        initialize();
    }

    private void initialize() {
        _options.addOption("o", true, "Output file");
        _options.addOption("i", true, "Input file");
        _options.addOption("m", true, "Manufacturers file");
        _options.addOption("d", true, "File with default values for different columns");
        _options.addOption("s", false, "Use strict mode. The parsing will fail on errors.");
    }

    Options getProductImportOptions() { return _options; }
}
