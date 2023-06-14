import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        Order order = null;
        if (args.length > 0 && args[0].toLowerCase().endsWith(".xml"))
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            OrderHandler handler = new OrderHandler();
            saxParser.parse(new File(args[0]), handler);
            order = handler.result();
            System.out.println(order);

            //dealer not authorized
            MockSecurity s = new MockSecurity();
            if (!order.getDealer().authenticate(s))
            {
                XmlResponse.getXMLDealerResponse("Not Authorized");
                return;
            }
            //incoming xml not valid
            Validator validator = new Validator();
            if (!validator.isValidDeliveryAddress(order.getDeliveryaddress())) {
                XmlResponse.getXMLErrorResponse("Invalid delivery address");
                return;
            } else if (!validator.isValidOrderList(order.getOrderItems())) {
                XmlResponse.getXMLErrorResponse("Invalid order item list");
                return;
            } else {
                List<Item> items = order.getOrderItems();
                for (Item item : items) {
                    if (!validator.isValidOrderItem(item)) {
                        XmlResponse.getXMLErrorResponse("Invalid order item entry");
                        return;
                        }
                    }
                }
            System.out.println("<order>");
            System.out.println("\t <orderitems>");
            System.out.println("\t\t<!-- An item in the list of items ordered by the dealer. -->");
            System.out.println("\t\t<item>");
            System.out.println("\t\t\t\t<!-- The part number submitted to PARTMANAGER. -->");
            Database db = new MockDatabase();
            PARTMANAGER partmanager = new PARTMANAGERMock();
            List<Item> items = order.getOrderItems();
            for (Item item : items)
            {
                if (db.isPartNumberValidOrInvalid(item.partnumber) == true)
                {
                    PARTMANAGER.PartResponse partresponse= partmanager.SubmitPartForManufactureAndDelivery(item.partnumber, item.quantity, order.deliveryaddress);
                    System.out.println("PartResponse "+ partresponse);
                    System.out.println("\t\t\t\t<partnumber>"+ item.partnumber+"</partnumber>");
                    System.out.println("\t\t\t\t<!-- The quantity submitted to PARTMANAGER. -->");
                    System.out.println("\t\t\t\t<quantity>"+item.quantity+"</quantity>");
                    //System.out.println("\t\t\t\t<result>failure</result>");
                    if(partresponse==PARTMANAGER.PartResponse.SUCCESS)
                    {
                        System.out.println("\t\t\t\t<errormessage>success</errormessage>");
                    }
                    else if(partresponse==PARTMANAGER.PartResponse.OUT_OF_STOCK)
                    {
                        System.out.println("\t\t\t\t<errormessage>Out of stock</errormessage>");
                    }
                    else if(partresponse==PARTMANAGER.PartResponse.NO_LONGER_MANUFACTURED)
                    {
                        System.out.println("\t\t\t\t<errormessage>No Longer Manufactured</errormessage>");
                    }
                    //System.out.println("\t\t\t\t<errormessage></errormessage>");
                    else if(partresponse==null)
                    {
                        System.out.println("\t\t\t\t<result>failure</result>");
                    }
                }
                else
                {
                    System.out.println("\t\t</item>");
                    System.out.println("\t\t<item>");
                    System.out.println("\t\t\t\t<partnumber>"+item.partnumber+"</partnumber>");
                    System.out.println("\t\t\t\t<quantity>"+item.quantity+"</quantity>");
                    System.out.println("\t\t\t\t<result>failure</result>");
                    System.out.println("\t\t\t\t<errormessage>invalid part</errormessage>");
                    System.out.println("\t\t</item>");
                    System.out.println("\t</orderitems>");
                    System.out.println("</order>");
                }
            }
        }
        else
        {
            DealerTest test = new DealerTest();
            test.hasAccessBothPass();
            test.hasAcessBothFail();
            test.hasAccessDealeridFail();
            test.hasAccessDealerAcessKeyFail();
            test.hasAccessBothNull();
            test.hasAccessDealerNull();

            ValidatorTest validatorTest = new ValidatorTest();
            validatorTest.testisValidDeliveryAddressStreetNull();
            validatorTest.testisValidDeliveryAddressStreetEmptyString();
            validatorTest.testisValidDeliveryAddressProvinceNull();
            validatorTest.testisValidDeliveryAddressProvinceEmptyString();
            validatorTest.testisValidDeliveryAddressPostalNull();
            validatorTest.testisValidDeliveryAddressPostalEmptyString();
            validatorTest.testisValidDeliveryAddressCityEmptyString();
            validatorTest.testisValidDeliveryAddressCityNull();
            validatorTest.testisValidOrderItemsNull();
            validatorTest.testisValidDealerNull();
            validatorTest.testisValidOnlyPartnumberGiven();
            validatorTest.testIsValidOrderItemPartNumberAndQuantityCorrect();
            validatorTest.testIsValidOrderListIsNull();
            validatorTest.testisValidDeliveryAddressNull();
        }
    }
}


