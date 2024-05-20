package Model;

public class Purchase implements Comparable<Purchase>{
    private String Description;
    private double value;

    public Purchase(String description, double value) {
        Description = description;
        this.value = value;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int compareTo(Purchase other) {
        return (this.getValue() < other.getValue()) ? -1: ((this.getValue()==other.getValue())?0:1);
    }

    @Override
    public String toString() {
        return "Compra: "+ this.getDescription() + " Valor:" + Double.toString(this.value);
    }
}
