package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;



public class WeldWirings implements Wirings {

    public void wire(final WireEnd start, final WireEnd end) {
        start.addOnSignalChangedListener(new ForwardSignalChangeTo(end));
    }

}
