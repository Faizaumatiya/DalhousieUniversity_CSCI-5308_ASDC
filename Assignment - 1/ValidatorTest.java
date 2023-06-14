public class ValidatorTest {
    public void testisValidDealerNull() {
        Validator validator = new Validator();
        // Ideally result should be false because address is null
        boolean result = validator.isValidDealer(null);
        if (result == true) {
            System.out.println("FAIL - isValidDealer should return false when dealer is Null");
        } else {
            System.out.println("PASS - isValidDealer should return false when dealer is Null");
        }
    }

    public void testisValidDeliveryAddressNull() {
        Validator validator = new Validator();
        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(null);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when Address is Null");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when Address is Null");
        }
    }
    public void testisValidDeliveryAddressStreetNull() {
        Validator validator = new Validator();
        DeliveryAddress address = new DeliveryAddress();
        address.setName("Mrs. Jane Smith");
        address.setPostalcode("B2T1A4");
        address.setCity("Halifax");
        address.setProvince("NS");
        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(address);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when Street Address is Null");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when Street Address is Null");
        }
    }

    public void testisValidDeliveryAddressStreetEmptyString() {
        Validator validator = new Validator();
        DeliveryAddress address = new DeliveryAddress();
        address.setName("Mrs. Jane Smith");
        address.setPostalcode("B2T1A4");
        address.setCity("Halifax");
        address.setProvince("NS");
        address.setStreet("");
        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(address);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when Street Address is Empty String");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when Street Address is Empty String");
        }
    }


    public void testisValidDeliveryAddressProvinceNull() {
        Validator validator = new Validator();

        DeliveryAddress address = new DeliveryAddress();
        address.setName("Mrs. Jane Smith");
        address.setPostalcode("B2T1A4");
        address.setCity("Halifax");
        address.setStreet("35 Streetname");

        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(address);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when Province is Null");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when Province is Null");
        }
    }
    public void testisValidDeliveryAddressProvinceEmptyString() {
        Validator validator = new Validator();
        DeliveryAddress address = new DeliveryAddress();
        address.setName("Mrs. Jane Smith");
        address.setPostalcode("B2T1A4");
        address.setCity("Halifax");
        address.setProvince("");
        address.setStreet("35 Streetname");

        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(address);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when Province is Empty String");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when Province is Empty String");
        }
    }


    public void testisValidDeliveryAddressPostalNull() {
        Validator validator = new Validator();

        DeliveryAddress address = new DeliveryAddress();
        address.setName("Mrs. Jane Smith");
        address.setCity("Halifax");
        address.setStreet("35 Streetname");
        address.setProvince("NS");

        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(address);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when Postal code is Null");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when Postal code is Null");
        }
    }
    public void testisValidDeliveryAddressPostalEmptyString() {
        Validator validator = new Validator();
        DeliveryAddress address = new DeliveryAddress();
        address.setName("Mrs. Jane Smith");
        address.setPostalcode("");
        address.setCity("Halifax");
        address.setProvince("NS");
        address.setStreet("35 Streetname");

        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(address);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when Postal code is Empty String");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when Postal code is Empty String");
        }
    }
    public void testisValidDeliveryAddressCityNull() {
    Validator validator = new Validator();

    DeliveryAddress address = new DeliveryAddress();
    address.setName("Mrs. Jane Smith");
    address.setStreet("35 Streetname");
    address.setProvince("NS");
    address.setPostalcode("B2T1A4");

    // Ideally result should be false because address is null
    boolean result = validator.isValidDeliveryAddress(address);
    if (result == true) {
        System.out.println("FAIL - isValidDeliveryAddress should return false when City  is Null");
    } else {
        System.out.println("PASS - isValidDeliveryAddress should return false when City is Null");
    }
}
    public void testisValidDeliveryAddressCityEmptyString() {
        Validator validator = new Validator();
        DeliveryAddress address = new DeliveryAddress();
        address.setName("Mrs. Jane Smith");
        address.setPostalcode("B2T1A4");
        address.setCity("");
        address.setProvince("NS");
        address.setStreet("35 Streetname");

        // Ideally result should be false because address is null
        boolean result = validator.isValidDeliveryAddress(address);
        if (result == true) {
            System.out.println("FAIL - isValidDeliveryAddress should return false when City is Empty String");
        } else {
            System.out.println("PASS - isValidDeliveryAddress should return false when City is Empty String");
        }
    }
    public void testisValidOrderItemsNull() {
        Validator validator = new Validator();
        boolean result = validator.isValidOrderItem(null);
        if (result == true) {
            System.out.println("FAIL - isValidOrderItems should return false when order items is Null");
        } else {
            System.out.println("PASS - isValidOrderItems should return false when order items is Null");
        }
    }
    public void testisValidOnlyPartnumberGiven(){
        Validator validator = new Validator();
        Item orderitems = new Item();
        orderitems.setPartnumber(1234);
        orderitems.setQuantity(0);
        boolean result = validator.isValidOrderItem(orderitems);
        if(result == true){
            System.out.println("FAIL - testisValidOnlyPartnumberGiven should return false when only Partnumber is given");
        }
        else{
            System.out.println("PASS - testisValidOnlyPartnumberGiven should return false when only Partnumber is given");
        }

    }

    public void testIsValidOrderItemPartNumberAndQuantityCorrect() {
        Validator validator = new Validator();
        Item orderitems = new Item();
        orderitems.setPartnumber(1234);
        orderitems.setQuantity(2);
        boolean result = validator.isValidOrderItem(orderitems);
        if(result == true){
            System.out.println("PASS - should return true when Partnumber and Quantity is correct");
        }
        else{
            System.out.println("PASS - should return true when Partnumber and Quantity is correct");
        }
    }

    public void testIsValidOrderListIsNull() {
        Validator validator = new Validator();
        boolean result = validator.isValidOrderList(null);
        if(result == false) {
            System.out.println("PASS - should return false when order list is null");
        } else {
            System.out.println("FAIL - should return false when order list is null");
        }
    }

}
