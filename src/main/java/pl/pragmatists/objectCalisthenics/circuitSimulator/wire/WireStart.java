package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;

public interface WireStart {

    public abstract void signaledChangedTo(Bit bit);

}
