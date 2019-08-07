package shop.nawi.magento2productimport.parameters;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
     * @param path String used to create a @see Paths
     * @return true if the path is valid else false.
     */
    private static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Get the Settings instance.
     */
    static Settings getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     *
     * @return The manufacturer data filename.
     */
    public static String getManufactuererDataFile() {
        return _manufacturerDataFile;
    }

    /**
     *
     * @return The output filename.
     */
    public static String getOutputFile() {
        return _outputFile;
    }

    /**
     *
     * @return The input filename.
     */
    public static String getInputFile() {
        return _inputFile;
    }

    /**
     *
     * @return The default values filename.
     */
    public static String getDefaultValuesFile() {
        return _defValFile;
    }

    /**
     *
     * @return true if the strict mode flag is set, false otherwise.
     */
    public static boolean getStrictMode() {
        return _strictMode;
    }

    /**
     *
     * @param manufacturerDataFile Filename of the manufacturer data file.
     * @throws InvalidPathException If the path is not valid this exception is thrown. This does not make sure, the file
     * actually exists. It just checks the path is valid for the operating system.
     */
    void setManufacturerDataFile(String manufacturerDataFile) throws InvalidPathException {
        if(!isValidPath(manufacturerDataFile)) {
            throw new InvalidPathException(manufacturerDataFile, "The path is not valid.");
        }
        _manufacturerDataFile = manufacturerDataFile;
    }

    /**
     *
     * @param outputFile Filename of the output file.
     * @throws InvalidPathException If the path is not valid this exception is thrown. This does not make sure, the file
     * actually exists. It just checks the path is valid for the operating system.
     */
    void setOutputFile(String outputFile) throws InvalidPathException {
        if(!isValidPath(outputFile)) {
            throw new InvalidPathException(outputFile, "The path is not valid.");
        }
        _outputFile = outputFile;
    }

    /**
     *
     * @param inputFile The input file filename.
     */
    void setInputFile(String inputFile) {
        if(!isValidPath(inputFile)) {
            throw new InvalidPathException(inputFile, "The path is not valid.");
        }
        _inputFile = inputFile;
    }

    /**
     *
     * @param defValFile The default values filename.
     * @throws InvalidPathException If the path is not valid this exception is thrown. This does not make sure, the file
     * actually exists. It just checks the path is valid for the operating system.
     */
    void setDefaultValuesFile(String defValFile) throws InvalidPathException {
        if(!isValidPath(defValFile)) {
            throw new InvalidPathException(defValFile, "The path is not valid.");
        }
        _defValFile = defValFile;
    }

    /**
     *
     * @param strictMode Set the strict mode. If strict mode is enabled the program quits if there are any missing
     *                   images, non unique SKUs, empty meta description fields, ...
     */
    void setStrictMode(boolean strictMode) {
        _strictMode = strictMode;
    }
}
