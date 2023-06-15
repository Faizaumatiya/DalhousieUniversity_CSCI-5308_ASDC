public class Dealer {
    public String dealerid;
    public String dealeracesskey;
    public Dealer() {

    }
    public String getDealerid(String s) {
        return dealerid;
    }
    public void setDealerid(String dealerid) {
        this.dealerid = dealerid;
    }

    public String getDealeracesskey() {
        return dealeracesskey;
    }
    public boolean authenticate(Security s) {
        return s.IsDealerAuthorized(this.dealerid, this.dealeracesskey);
    }
    public void setDealeracesskey(String dealeracesskey) {
        this.dealeracesskey = dealeracesskey;
    }

    public Dealer(String dealerid, String dealeracesskey) {
        this.dealerid = dealerid;
        this.dealeracesskey = dealeracesskey;
    }
    @Override
    public String toString() {
        return "Dealer{" +
                "dealerid='" + dealerid + '\'' +
                ", dealeracesskey='" + dealeracesskey + '\'' +
                '}';
    }
}
