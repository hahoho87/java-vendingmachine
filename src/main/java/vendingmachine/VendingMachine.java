package vendingmachine;

public class VendingMachine {

    private int changes;

    public VendingMachine() {
        this(0);
    }

    public VendingMachine(int changes) {
        this.changes = changes;
    }

    public void put(final int changes) {
        this.changes += changes;
    }

    public int getChanges() {
        return this.changes;
    }

    public void withdraw(int changes) {
        int total = this.changes - changes;
        if (total < 0) {
            throw new IllegalStateException();
        }
        this.changes -= changes;
    }
}
