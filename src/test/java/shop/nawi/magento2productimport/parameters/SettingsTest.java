package shop.nawi.magento2productimport.parameters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.geom.IllegalPathStateException;
import java.nio.file.InvalidPathException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SettingsTest {

    private Settings settings = Settings.getInstance();

    @Test
    @DisplayName("Test the Manufacturer File getter and setter.")
    void testSetAndGetManufacturerFilename() {
        settings.setManufacturerDataFile("/etc/hosts");
        Assertions.assertTrue(Settings.getManufactuererDataFile().equals("/etc/hosts"));
    }

    @Test
    @DisplayName("Test the Manufacturer File setter throws exception.")
    void testSetManufacturerFilenameThrowsException() {
        Assertions.assertThrows(InvalidPathException.class, () -> settings.setManufacturerDataFile("/etc\0/hosts"));
    }

    @Test
    @DisplayName("Test the Output File getter and setter.")
    void testSetAndGetOutputFilename() {
        settings.setOutputFile("/etc/hosts");
        Assertions.assertTrue(Settings.getOutputFile().equals("/etc/hosts"));
    }

    @Test
    @DisplayName("Test the Output File setter throws exception.")
    void testSetOutputFilenameThrowsException() {
        Assertions.assertThrows(InvalidPathException.class, () -> settings.setOutputFile("/etc\0/hosts"));
    }

    @Test
    @DisplayName("Test the Input File getter and setter.")
    void testSetAndGetInputFilename() {
        settings.setInputFile("/etc/hosts");
        Assertions.assertTrue(Settings.getInputFile().equals("/etc/hosts"));
    }

    @Test
    @DisplayName("Test the Input File setter throws exception.")
    void testSetInputFilenameThrowsException() {
        Assertions.assertThrows(InvalidPathException.class, () -> settings.setInputFile("/etc\0/hosts"));
    }

    @Test
    @DisplayName("Test the Default Values File getter and setter.")
    void testSetAndGetDefaultValuesFilename() {
        settings.setDefaultValuesFile("/etc/hosts");
        Assertions.assertTrue(Settings.getDefaultValuesFile().equals("/etc/hosts"));
    }

    @Test
    @DisplayName("Test the Default Values File setter throws exception.")
    void testSetDefaultValuesFilenameThrowsException() {
        Assertions.assertThrows(InvalidPathException.class, () -> settings.setDefaultValuesFile("/etc\0/hosts"));
    }

    @Test
    @DisplayName("Test the Strict Mode getter and setter")
    void testSetAndGetStrictMode() {
        Assertions.assertFalse(settings.getStrictMode());
        settings.setStrictMode(true);
        Assertions.assertTrue(settings.getStrictMode());
    }
}
