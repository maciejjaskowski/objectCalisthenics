package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireStart;

public class Output implements WireStart {

    private Bit value;

    public void signaledChangedTo(Bit bit) {
        this.value = bit;
    }

    public Bit value() {
        return value;
    }

}
