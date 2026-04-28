import java.util.ArrayList;

public class Arsenal {
    private ArrayList<Gear> vault;

    public Arsenal() {
        vault = new ArrayList<>();
    }

    public void registerGear(Gear g) {
        for (Gear gear : vault) {
            if (gear.getGearTitle().equalsIgnoreCase(g.getGearTitle())) {
                System.out.println("Duplicate gear title. Registration failed.");
                return;
            }
        }
        vault.add(g);
        System.out.println("Gear registered successfully.");
    }

    public void removeGear(String title) {
        for (int i = 0; i < vault.size(); i++) {
            if (vault.get(i).getGearTitle().equalsIgnoreCase(title)) {
                vault.remove(i);
                System.out.println("Gear removed successfully.");
                return;
            }
        }
        System.out.println("Gear not found.");
    }

    public void modifyGear(String title, int newStock, int newStrength) {
        for (Gear gear : vault) {
            if (gear.getGearTitle().equalsIgnoreCase(title)) {
                gear.setStock(newStock);
                gear.setStrength(newStrength);
                System.out.println("Gear modified successfully.");
                return;
            }
        }
        System.out.println("Gear not found.");
    }

    public void locateGear(String title) {
        for (Gear gear : vault) {
            if (gear.getGearTitle().equalsIgnoreCase(title)) {
                System.out.println("\n========== GEAR FOUND ==========");
                System.out.println(String.format("| %-25s | %-20s | %-8s | %-10s |", "Gear Title", "Category", "Stock", "Strength"));
                System.out.println("===================================================================================================");
                System.out.println(gear.toString());
                System.out.println("===================================================================================================\n");
                return;
            }
        }
        System.out.println("Gear not found.");
    }

    public void showArsenal() {
        if (vault.isEmpty()) {
            System.out.println("Arsenal is empty.");
            return;
        }
        System.out.println("\n========== ARSENAL INVENTORY ==========");
        System.out.println(String.format("| %-25s | %-20s | %-8s | %-10s |", "Gear Title", "Category", "Stock", "Strength"));
        System.out.println("===================================================================================================");
        for (Gear gear : vault) {
            System.out.println(gear.toString());
        }
        System.out.println("===================================================================================================\n");
    }
}
