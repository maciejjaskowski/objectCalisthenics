package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;

public interface WireEnd {

    public abstract void addOnSignalChangedListener(OnSignalChanged onSignalChangedListener);

}
