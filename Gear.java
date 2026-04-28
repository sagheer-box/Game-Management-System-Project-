public class Gear {
    private String gearTitle;
    private String category;
    private int stock;
    private int strength;

    public Gear(String gearTitle, String category, int stock, int strength) {
        this.gearTitle = gearTitle;
        this.category = category;
        this.stock = stock;
        this.strength = strength;
    }

    public String getGearTitle() {
        return gearTitle;
    }

    public void setGearTitle(String gearTitle) {
        this.gearTitle = gearTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return String.format("| %-25s | %-20s | %-8d | %-10d |", gearTitle, category, stock, strength);
    }
}
