public class MockSecurity implements Security {

    @Override
    public boolean IsDealerAuthorized(String dealerid, String dealeraccesskey) {
        if(dealerid==null || dealeraccesskey==null) {
            return false;
        }
         if ((dealerid.equals("XXX-1234-ABCD-1234")) && (dealeraccesskey.equals("kkklas8882kk23nllfjj88290"))) {
                return true;
            }

        return false;
    }
}
