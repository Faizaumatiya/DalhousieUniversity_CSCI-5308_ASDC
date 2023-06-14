
public class MockDatabase implements Database{

    @Override
    public boolean isPartNumberValidOrInvalid(int partnumber) {
        if(partnumber==(1234) || partnumber==(2345) || partnumber==(5677)){
            return true;
        }
        return false;
    }

}

