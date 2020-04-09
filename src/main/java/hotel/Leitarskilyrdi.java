package hotel;

public class Leitarskilyrdi {
    private int stars;
    private String city;
    private String leitarstrengur;



    public Leitarskilyrdi() {
        this.stars = 0;
        this.city = null;
        this.leitarstrengur=null;
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
