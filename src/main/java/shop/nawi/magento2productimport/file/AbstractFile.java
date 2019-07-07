package shop.nawi.magento2productimport.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

public abstract class AbstractFile {

    private final Path _fileNamePath;
    protected BufferedReader _fileReader;
    protected Files _file;

    protected String[] _header;

    protected AbstractFile(Path fNamePath, FileAttribute attr) /* throws IOException */ {_fileNamePath = fNamePath; checkFile(attr); initialize();}

    protected Path getFilename() {return _fileNamePath;}

    private void initialize() {}

    private void checkFile(FileAttribute attr) /* throws IOException */ {
        Charset charset = Charset.forName("UTF-8");

        /*
        _fileReader = Files.newBufferedReader(_fileNamePath, charset);
        if(!file.createFile(_filename) && mustRead) {
            throw new IllegalAccessException("The given input File is not readable.");
        } else {
            _file = new File(_filename);
        }
         */
    }

    abstract protected boolean testFileIsValid(String fName);
    abstract protected void setFileHeader(String[] fHeader);

    abstract protected boolean printLineToFile(String fName);

}
