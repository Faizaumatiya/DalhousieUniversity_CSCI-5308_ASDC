import java.util.HashMap;
import java.util.Map;


public class PARTMANAGERMock implements PARTMANAGER {
    HashMap<Integer, Integer> Map = new HashMap<>();

    public PARTMANAGERMock() {
        Map.put(1234, 2);
        Map.put(2345, -2);
        Map.put(5677, 1);
    }


    @Override
    public PartResponse SubmitPartForManufactureAndDelivery(int partNumber, int quantity, DeliveryAddress deliveryAddress) {

        PartResponse partResp = null;
        System.out.println("quantity"+quantity);
        System.out.println("partnumber"+partNumber);
        System.out.println("Map.get(partNumber)"+Map.get(partNumber));
        if (Map.containsKey(partNumber) && Map.get(partNumber)>=quantity && quantity > 0) {
            System.out.println("inside this loop");
            System.out.println(Map.get(partNumber)>=quantity);
            int initialValue = Map.get(partNumber);

            Map.put(partNumber,initialValue-quantity);
            System.out.println("updated quantity"+ Map.get(partNumber));
            partResp=  PartResponse.SUCCESS;
        } else if (Map.containsKey(partNumber) && Map.get(partNumber) < quantity && quantity > 0) {
            partResp =  PartResponse.OUT_OF_STOCK;
        } else if (Map.containsKey(partNumber) && Map.get(partNumber) < 0) {
            partResp= PartResponse.NO_LONGER_MANUFACTURED;
        }
        return partResp;

    }
}

