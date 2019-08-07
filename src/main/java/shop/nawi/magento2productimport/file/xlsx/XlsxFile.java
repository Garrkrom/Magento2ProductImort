package shop.nawi.magento2productimport.file.xlsx;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Hashtable;

public class XlsxFile extends AbstractXlsxFile {

    private String[] _fileHeader;
    private SpreadsheetDocument _odsDoc;
    private Table _productData;
    private int _numCols;
    private int _numRows;
    private Row _headerRow;
    private Hashtable<String, String> _headerHashtable = new Hashtable<>();

    private XlsxFile() {
        super();
    }

    /**
     *
     * @param fNamePath
     * @param attr
     * @throws Exception
     */
    public XlsxFile(Path fNamePath, FileAttribute attr) throws Exception {
        super(fNamePath, attr);
        fNamePath = fNamePath.toRealPath();
        _odsDoc = SpreadsheetDocument.loadDocument(fNamePath.toString());
        _productData = _odsDoc.getSheetByIndex(0);
        _numCols = _productData.getColumnCount();
        _numRows = _productData.getRowCount();
        _headerRow = _productData.getRowByIndex(0);

        _fileHeader = new String[_numCols];

        createHeaderHashtable(_headerRow);

        if(checkFileAttributes(attr)) {
            throw new IllegalAccessException("The file " + fNamePath.toString() + " has insufficient rights.");
        }
    }

    /**
     * Return line of the spreadsheet as a hashtable
     *
     * @param rowNum Row number of the spreadsheet
     * @return Hashtable<String, String> Key = 0-N, Value = String value of cell
     * @throws IllegalAccessException
     */
    public Hashtable<Integer, String> getOdsLine(int rowNum) throws IllegalAccessException {
        Hashtable<Integer, String> line = new Hashtable<Integer, String>();
        Row row = _productData.getRowByIndex(rowNum);
        
        for(int i = 0; i <= _numCols; i++) {
            String cellValue = row.getCellByIndex(i).getStringValue();
            if(cellValue == null) {
                throw new IllegalAccessException("The number of cells in " + (rowNum + 1) + " row does not match the header.\nNear " + row.getCellByIndex(i-1).getStringValue());
            }
            _header[i] = cellValue;
            line.put(i , cellValue);
        }
        return line;
    }

    public Hashtable<String, String> getOdsLineByHeaderValueHashtable(int rowNum) throws IllegalAccessException {
        Hashtable<String, String> line = new Hashtable<>();
        Row row = _productData.getRowByIndex(rowNum);

        for (int i = 0; i <= _numCols; i++) {
            String cellValue = row.getCellByIndex(i).getStringValue();
            if(cellValue == null) {
                throw new IllegalAccessException("The number of cells in " + (rowNum + 1) + " row does not match the header.\nNear " + row.getCellByIndex(i-1).getStringValue());
            }
            line.put(_headerHashtable.get(Integer.toString(i)), cellValue);
        }
        return line;
    }

    @Override
    protected void readHeader(ArrayList<Hashtable> header) {

    }

    @Override
    protected void setFileHeader(String[] fileHeader) {
        _fileHeader = fileHeader;
    }

    @Override
    protected String[] getFileHeader() {
        return _fileHeader;
    }

    @Override
    protected void initialize() {}

    /**
     * The actual file content is not checked at the moment. Only the file ending is checked. The case does not matter,
     * as the filename is first set to lower case.
     *
     * TODO: Use https://odftoolkit.org/conformance/ODFValidator.html for file validation.
     *
     * @param fName Filename of an file which should be checked.
     * @return true if file ends with .ods otherwise false.
     */
    @Override
    protected boolean testFileIsValid(String fName) {
        boolean ret = false;
        if(fName.toLowerCase().matches(".*\\.ods$")) {
            ret = true;
        }
        return ret;
    }

    @Override
    protected boolean printLineToFile(String line) {
        boolean ret = false;

        return ret;
    }

    @Override
    protected boolean checkFileAttributes(FileAttribute attr) {
        boolean ret = false;

        return ret;
    }

    private void createHeaderHashtable(Row row) {
        for(int i = 0; i <= _numCols; i++) {
            _headerHashtable.put(String.valueOf(i), row.getCellByIndex(i).getStringValue());
        }
    }
}
