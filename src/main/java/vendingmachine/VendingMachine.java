package vendingmachine;

public class VendingMachine {

    private int changes;

    public void put(final int inputMoney) {
        changes += inputMoney;
    }

    public int getChanges() {
        return this.changes;
    }
}
