package shop.nawi.magento2productimport.parameters;

public class Settings {

    private static String _manufacturerDataFile = "";
    private static String _outputFile = "";
    private static String _inputFile = "";
    private static String _defValFile = "";
    private static boolean _strictMode = false;

    // Inner private class used for a singleton pattern. When the class is used for the first time this instance gets
    // initialized
    private static final class InstanceHolder {
        static final Settings INSTANCE = new Settings();
    }

    // This class must be created with the getInstance. The constructor must not be used.
    private Settings() {}

    /**
     *
     * @return Get the Settings instance.
     */
    static Settings getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static String getManufactuererDataFile() {
        return _manufacturerDataFile;
    }

    public static String getOutputFile() {
        return _outputFile;
    }

    public static String getInputFile() {
        return _inputFile;
    }

    public static String getDefaultValuesFile() {
        return _defValFile;
    }

    public static boolean getStrictMode() {
        return _strictMode;
    }

    void setManufacturerDataFile(String manufacturerDataFile) {
        _manufacturerDataFile = manufacturerDataFile;
    }

    void setOutputFile(String outputFile) {
        _outputFile = outputFile;
    }

    void setInputFile(String inputFile) {
        _inputFile = inputFile;
    }

    void setDefaultValuesFile(String defValFile) {
        _defValFile = defValFile;
    }

    void setStrictMode(boolean strictMode) {
        _strictMode = strictMode;
    }
}
