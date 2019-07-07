package shop.nawi.magento2productimport.file.columns;

public abstract class AbstractColumn {

    public abstract boolean colIsValid();

    public abstract void setDefaultValue(String defValue);
    public abstract String getDefaultValue();

    public abstract void setColumnName(String name);
    public abstract String getColumnName();

}
