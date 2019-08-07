package shop.nawi.magento2productimport.file.xlsx;

import shop.nawi.magento2productimport.file.AbstractFile;

import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

public abstract class AbstractXlsxFile extends AbstractFile {

    AbstractXlsxFile() {
        super();
    }

    AbstractXlsxFile(Path fNamePath, FileAttribute attr) /* throws IOException */ {
        super(fNamePath, attr);
    }

    abstract protected void setFileHeader(String[] fHeader);
    abstract protected String[] getFileHeader();

}
