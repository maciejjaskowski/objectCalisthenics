package pl.pragmatists.objectCalisthenics.circuitSimulator.gate;

import static pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit.zero;
import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Input;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Operation;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireStart;

public class SimpleGate {

    private WireStart out;
    private UnwiredSimpleGate unwiredSimpleGate;

    public SimpleGate(Operation operation) {
        this.unwiredSimpleGate = new UnwiredSimpleGate(operation, new Input(zero, zero));
        this.out = new Wire();
    }

    public void wireInput1To(WireEnd wire) {
        wire.addOnSignalChangedListener(updateBit(0));
    }

    public void wireInput2To(WireEnd wire) {
        wire.addOnSignalChangedListener(updateBit(1));
    }

    public void wireOutputTo(WireStart wire) {
        this.out = wire;
        recalculate();
    }

    private void recalculate() {
        out.signaledChangedTo(unwiredSimpleGate.calculate());
    }

    private OnSignalChanged updateBit(final int index) {
        return new OnSignalChanged() {
            public void signalChangedTo(Bit bit) {
                unwiredSimpleGate.changeBit(index, bit);
                recalculate();
            }
        };
    }

}