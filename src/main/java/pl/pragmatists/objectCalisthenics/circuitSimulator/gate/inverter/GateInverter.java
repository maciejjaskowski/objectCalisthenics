package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.inverter;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;

public class GateInverter {

    private final WireEnd out;
    private Bit bit;

    public GateInverter(WireEnd input, WireEnd out) {
        input.addOnSignalChangedListener(updateBit());
        this.out = out;
    }

    private OnSignalChanged updateBit() {
        return new OnSignalChanged() {
            public void signalChangedTo(Bit bit) {
                GateInverter.this.bit = bit;
                GateInverter.this.recalculate();
            }
        };
    }

    private void recalculate() {
        out.signaledChangedTo(bit.not());
    }

}
