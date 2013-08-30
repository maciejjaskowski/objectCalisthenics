package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.inverter;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireStart;

public class GateInverter {

    private WireStart out;
    private Bit bit;

    public GateInverter(WireEnd input, WireStart out) {
        input.addOnSignalChangedListener(updateBit());
        this.out = out;
    }

    public GateInverter() {
        this.out = new Wire();
        this.bit = Bit.zero;
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

    public void wireInputTo(WireEnd wire) {
        wire.addOnSignalChangedListener(updateBit());
    }

    public void wireOutputTo(Wire wire) {
        this.out = wire;
        recalculate();
    }

}
