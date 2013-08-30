package pl.pragmatists.objectCalisthenics.circuitSimulator;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;

public interface OnSignalChanged {

    void signalChangedTo(Bit bit);

}
