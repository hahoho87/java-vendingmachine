package vendingmachine;

public class ChangesModule {

    private int changes;

    public ChangesModule() {
        this(0);
    }

    public ChangesModule(int changes) {
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
