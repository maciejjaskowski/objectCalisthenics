package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;

import java.util.ArrayList;
import java.util.List;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;


public class WireEnd {

    private List<OnSignalChanged> listeners = new ArrayList<OnSignalChanged>();

    public void signaledChangedTo(Bit bit) {
        for (OnSignalChanged listener : listeners) {
            listener.signalChangedTo(bit);
        }
    }

    public void addOnSignalChangedListener(OnSignalChanged onSignalChangedListener) {
        listeners.add(onSignalChangedListener);
    }

}
