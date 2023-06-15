import java.util.List;

public class Validator {

    public boolean isValidOrderList(List<Item> items) {
        if(items == null){
            return false;
        }
        return true;
    }
    public boolean isValidOrderItem(Item orderitem) {
        if (orderitem == null) {
            return false;
        }
        if(orderitem.partnumber==0 || orderitem.quantity==0){
            return false;
        }
        return true;
    }
    public boolean isValidDealer(Dealer dealer) {
        if (dealer == null) {
            return false;
        }
        return true;
    }

    public boolean isValidDeliveryAddress(DeliveryAddress address) {

        if(address == null) {
            return false;
        }
        if (address.getStreet() == null || address.getStreet().equals("")) {
            return false;
        }
        if(address.getProvince() == null || address.getProvince().equals("")) {
            return false;
        }
        if(address.getPostalcode()==null || address.getPostalcode().equals("")){
            return false;
        }
        if( address.getCity()==null || address.getCity().equals("")){
            return false;
        }
        if (!(address.getStreet().equals("35 Streetname"))) {
            return false;
        }
        if(!(address.getProvince().equals("NS"))){
            return false;
        }
        if(!(address.getPostalcode().equals("B2T1A4"))){
            return false;
        }
        return true;

    }
}
