package pl.pragmatists.objectCalisthenics.circuitSimulator.input;

import static java.util.Arrays.copyOf;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;

public class Input {
    private final Bit[] bits;

    public Input(Bit ...bits) {
        this.bits = bits;
    }

    public Input changeBit(int index, Bit bit) {
        Bit[] copy = copyOf(bits, bits.length);
        copy[index] = bit;
        return new Input(copy);
    }

    public Bit runOperation(Operation operation) {
        return operation.operateOn(bits);
    }
}