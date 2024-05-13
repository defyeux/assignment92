public class Transiction {
    private final String who;
    private final int amount;

    public Transiction(String who, int amount) {
        this.who = who;
        this.amount = amount;
    }

    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + Integer.hashCode(amount);
        return Math.abs(hash);
    }
}
