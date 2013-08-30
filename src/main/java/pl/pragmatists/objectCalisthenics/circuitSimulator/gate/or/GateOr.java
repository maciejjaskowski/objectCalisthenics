package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or;

import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.SimpleGate;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;

public class GateOr extends SimpleGate {

    public GateOr(WireEnd wire0, WireEnd wire1, WireEnd out) {
        super(wire0, wire1, out, new OrOperation());
    }

}
