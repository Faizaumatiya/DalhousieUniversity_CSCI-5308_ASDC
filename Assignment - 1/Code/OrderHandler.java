import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class OrderHandler extends DefaultHandler {
    private static final String Dealer = "dealer";
    private static final String DealerID = "dealerid";
    private static final String DealerAccessKey = "dealeraccesskey";
    private static final String OrderItems = "orderitems";
    private static final String Item = "item";
    private static final String PartNumber = "partnumber";
    private static final String Quantity = "quantity";

    private static final String DeliveryAddress = "deliveryaddress";
    private static final String Name = "name";
    private static final String Street = "street";
    private static final String City = "city";
    private static final String Province = "province";
    private static final String PostalCode = "postalcode";
    private Order order;
    private Dealer dealer;
    private DeliveryAddress deliveryaddress;
    private ArrayList<Item> orderitems;
    private StringBuilder str;


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (str == null) {
            str = new StringBuilder();
        } else {
            str.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        order = new Order();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case Dealer:
                dealer = new Dealer();
                break;
            case  DealerID:
                str= new StringBuilder();
                break;
            case DealerAccessKey:
                str = new StringBuilder();
                break;
            case  OrderItems:
                orderitems = new ArrayList<Item>();
                order.setOrderitems(orderitems);
                break;
            case  Item:
               orderitems.add(new Item());
                break;
            case  PartNumber:
                str= new StringBuilder();
                break;
            case  Quantity:
                str= new StringBuilder();
                break;
            case  DeliveryAddress:
                deliveryaddress = new DeliveryAddress();
                order.setDeliveryaddress(deliveryaddress);
                break;
            case  Name:
                str= new StringBuilder();
                break;
            case  Street:
                str= new StringBuilder();
                break;
            case  City:
                str= new StringBuilder();
                break;
            case  Province:
                str= new StringBuilder();
                break;
            case  PostalCode:
                str= new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case Dealer:
                order.setDealer(dealer);
                break;
            case DealerID:
                dealer.setDealerid(str.toString());
                break;
            case DealerAccessKey:
                dealer.setDealeracesskey(str.toString());
                break;
            case PartNumber:
                latestItem().setPartnumber(Integer.parseInt(str.toString()));
                break;
            case Quantity:
                latestItem().setQuantity(Integer.parseInt(str.toString()));
                break;
//

           case Name:
               order.getDeliveryaddress().setName(str.toString());
                break;
            case Street:
                    order.getDeliveryaddress().setStreet(str.toString());
                break;
            case City:
                    order.getDeliveryaddress().setCity(str.toString());
                break;
            case Province:
                    order.getDeliveryaddress().setProvince(str.toString());
                break;
            case PostalCode:
                    order.getDeliveryaddress().setPostalcode(str.toString());
                break;

        }
    }
    private Item latestItem(){
        return orderitems.get(orderitems.size() - 1);
    }

    public Order result() {
        return this.order;
    }
}
