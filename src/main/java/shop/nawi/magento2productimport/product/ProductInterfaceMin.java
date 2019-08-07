package shop.nawi.magento2productimport.product;

public interface ProductInterfaceMin {

    /**
     *
     * @param sku SKU of the Product
     */
    void setSku(String sku);

    /**
     *
     * @return SKU of the Product
     */
    String getSku();

    /**
     * The default attribute set code is Default with a capital D
     *
     * @param attrSetCode Attribute Set Code of the product. For example Default|Microscope|Chemicals|...
     */
    void setAttributeSetCode(String attrSetCode);

    /**
     *
     * @return Attribute Set Code of the product. For example Microscope|Chemicals|...
     */
    String getAttributeSetCode();

    /**
     *
     * @param productType simple|grouped|...
     */
    void setProductType(String productType);

    /**
     *
     * @return productType simple|grouped|...
     */
    String getProductType();

    void setProductWebsites(String websites);
    String getProductWebsites();

    void setProductName(String name);
    String getProductName();

    void setProductOnline(boolean online);
    boolean getProductOnline();

    void setTaxClassName(String taxClassName);
    String getTaxClassName();

    void setProductPrice(float price);
    float getProductPrice();
}
