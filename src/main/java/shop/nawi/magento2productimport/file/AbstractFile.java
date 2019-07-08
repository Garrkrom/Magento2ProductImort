package shop.nawi.magento2productimport.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public abstract class AbstractFile {

    protected final Path _fileNamePath;
    protected BufferedReader _fileReader;
    protected Files _file;

    protected String[] _header;

    protected AbstractFile(){
        _fileNamePath = Paths.get("");
        initialize();
    }

    protected AbstractFile(Path fNamePath, FileAttribute attr) /* throws IOException */ {_fileNamePath = fNamePath; checkFile(attr); initialize();}

    protected Path getFilenameAsPath() { return _fileNamePath; }

    protected String getFilenameAsString() { return _fileNamePath.toString(); }

    protected void initialize() {}

    abstract protected boolean checkFileAttributes(FileAttribute attr);

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

    abstract protected void readHeader(ArrayList<Hashtable> header);

    abstract protected boolean testFileIsValid(String fName);

    abstract protected boolean printLineToFile(String fName);

}
