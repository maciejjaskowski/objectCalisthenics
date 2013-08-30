package pl.pragmatists.objectCalisthenics.circuitSimulator.gate;

import static pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit.zero;
import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Input;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Operation;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;

public class SimpleGate {

    private final WireEnd out;
    private final UnwiredSimpleGate unwiredSimpleGate;

    public SimpleGate(WireEnd wire0, WireEnd wire1, WireEnd out, Operation operation) {
        this.out = out;
        this.unwiredSimpleGate = new UnwiredSimpleGate(operation, new Input(zero, zero));
        wire0.addOnSignalChangedListener(updateBit(0));
        wire1.addOnSignalChangedListener(updateBit(1));
    }

    private OnSignalChanged updateBit(final int index) {
        return new OnSignalChanged() {
            public void signalChangedTo(Bit bit) {
                Bit result = unwiredSimpleGate.changeBit(index, bit);
                out.signaledChangedTo(result);
            }
        };
    }

}