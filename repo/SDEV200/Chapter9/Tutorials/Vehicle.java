package Chapter9.Tutorials;

public abstract class Vehicle {
    private String powerSource;
    private int wheels;
    protected int price;

    public String getPowerSource() {
        return this.powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public int getWheels() {
        return this.wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getPrice() {
        return this.price;
    }

    public abstract void setPrice();

    public Vehicle(String powerSource, int wheels) {
        setPowerSource(powerSource);
        setWheels(wheels);
        setPrice();
    }
}
