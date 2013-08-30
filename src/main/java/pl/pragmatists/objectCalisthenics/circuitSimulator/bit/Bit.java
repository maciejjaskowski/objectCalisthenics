package pl.pragmatists.objectCalisthenics.circuitSimulator.bit;

public enum Bit {

    zero(false), one(true);
    private boolean value;

    private Bit(boolean value) {
        this.value = value;
    }

    public Bit and(Bit bit) {
        return bit(bit.value && value);
    }

    public Bit or(Bit bit) {
        return bit(bit.value || value);
    }

    public Bit not() {
        return bit(!value);
    }

    private Bit bit(boolean b) {
        if (b == false) {
            return Bit.zero;
        }
        return Bit.one;
    }

}
