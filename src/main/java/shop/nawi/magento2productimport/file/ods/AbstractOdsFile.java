package shop.nawi.magento2productimport.file.ods;

import shop.nawi.magento2productimport.file.AbstractFile;

import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractOdsFile extends AbstractFile {

    protected AbstractOdsFile() {
        super();
    }

    protected AbstractOdsFile(Path fNamePath, FileAttribute attr) /* throws IOException */ {
        super(fNamePath, attr);
    }

    abstract protected void setFileHeader(String[] fHeader);
    abstract protected String[] getFileHeader();

}
