package vendingmachine;

public class VendingMachine {

    private int changes;

    public VendingMachine() {
        this(0);
    }

    public VendingMachine(int changes) {
        this.changes = changes;
    }

    public void put(final int inputMoney) {
        this.changes += inputMoney;
    }

    public int getChanges() {
        return this.changes;
    }
}
