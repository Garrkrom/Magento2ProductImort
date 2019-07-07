# Magento2ProductImport
This Program is meant to import different Manufacturerer Data into an Magneto2 shop.

To achieve this the program parses LibreOffice ods files or Microsoft Office xlsx files.

The following columns are mandatory, for each import file.

## Mandatory import values

### SKU

#### Unique in file
#### Maximum of 16 characters

Each product needs a unique SKU. This program only checks if the sku is unique in the file.
If the SKU is included in another file, the last imported file will override the shop data.

SKUs can contain any text. But they should not be longer than 16 characters and not contain
any whitespaces.

### Price

### Tax Rate

### Product Name

### Product Description




### Short Description

### Manufacturer

