package hotel;

public class Leitarskilyrdi {
    private int stars;
    private String city;
    private String leitarstrengur;
    private int numGuest;

    public Leitarskilyrdi() {
        this.stars = 0;
        this.city = null;
        this.leitarstrengur=null;
        this.numGuest=0;
    }
    public int getNumGuest() {
        return numGuest;
    }

    public void setNumGuest(int numGuest) {
        this.numGuest = numGuest;
    }

    public String getLeitarstrengur() {
        return leitarstrengur;
    }

    public void setLeitarstrengur(String leitarstrengur) {
        this.leitarstrengur = leitarstrengur;
    }
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
