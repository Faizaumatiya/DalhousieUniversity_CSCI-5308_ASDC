import java.sql.SQLOutput;

public class DealerTest {
    public void hasAccessBothPass() {
        Dealer d = new Dealer();
        d.setDealerid("XXX-1234-ABCD-1234");
        d.setDealeracesskey("kkklas8882kk23nllfjj88290");
        MockSecurity m = new MockSecurity();
        if (d.authenticate(m)) {
            System.out.println("PASS - has access Both Pass");
        } else {
            System.out.println("FAIL - has access Both Pass ");
        }
    }
    public void hasAcessBothFail(){
        Dealer d1 = new Dealer();
        d1.setDealerid("TTT-7890-3333");
        d1.setDealeracesskey("aaadas7773ll25jjdi29361");
        MockSecurity m = new MockSecurity();
        if (!d1.authenticate(m)){
            System.out.println("PASS - has access both Fail");
        }
        else
            System.out.println("FAIL - has access both fail");
    }
    public void hasAccessDealeridFail(){
        Dealer d2 = new Dealer();
        d2.setDealerid("TTT-7890-3333");
        d2.setDealeracesskey("kkklas8882kk23nllfjj88290");
        MockSecurity m = new MockSecurity();
        if (!d2.authenticate(m)){
            System.out.println("PASS - has access dealer id fail");
        }
        else
            System.out.println("FAIL - has access dealer id fail");
    }
    public void hasAccessDealerAcessKeyFail(){
        Dealer d3 = new Dealer();
        d3.setDealerid("XXX-1234-ABCD-1234");
        d3.setDealeracesskey("aaadas7773ll25jjdi29361");
        MockSecurity m = new MockSecurity();
        if (!d3.authenticate(m)){
            System.out.println("PASS - has access dealer acess key fail");
        }
        else
            System.out.println("FAIL - has access dealer access key fail");
    }
    public void hasAccessBothNull(){
        Dealer d4 = new Dealer();
        MockSecurity m = new MockSecurity();
        if (!d4.authenticate(m)){
            System.out.println("PASS - has access both Null");
        }
        else
            System.out.println("FAIL - has access both Null");
    }
    public void hasAccessDealerNull(){
        Dealer d5 = new Dealer();
        MockSecurity m = new MockSecurity();
        if(!d5.authenticate(m)){
            System.out.println("PASS - has access Dealer is NULL");
        }
        else
            System.out.println("FAIL - has access Dealer NULL");
    }
}



