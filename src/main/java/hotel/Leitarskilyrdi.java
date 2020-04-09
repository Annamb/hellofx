package hotel;

public class Leitarskilyrdi {
    private int stars;
    private String city;

    public Leitarskilyrdi() {
        this.stars = 0;
        this.city = null;
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
