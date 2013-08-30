package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;

import java.util.ArrayList;
import java.util.List;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;


public class Wire implements WireStart, WireEnd{

    private List<OnSignalChanged> listeners;
    private Bit bit;

    public Wire() {
        listeners = new ArrayList<OnSignalChanged>();
        bit = Bit.zero;
    }

    public void signaledChangedTo(Bit bit) {
        this.bit = bit;
        for (OnSignalChanged listener : listeners) {
            listener.signalChangedTo(bit);
        }
    }

    public void addOnSignalChangedListener(OnSignalChanged onSignalChangedListener) {
        listeners.add(onSignalChangedListener);
        onSignalChangedListener.signalChangedTo(bit);
    }

}
