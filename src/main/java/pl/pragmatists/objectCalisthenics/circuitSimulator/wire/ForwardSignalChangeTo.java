package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;

class ForwardSignalChangeTo implements OnSignalChanged {
    private final WireEnd end;

    ForwardSignalChangeTo(WireEnd end) {
        this.end = end;
    }

    public void signalChangedTo(Bit bit) {
        end.signaledChangedTo(bit);
    }
}