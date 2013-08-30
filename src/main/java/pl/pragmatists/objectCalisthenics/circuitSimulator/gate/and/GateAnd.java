package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.and;

import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.SimpleGate;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;

public class GateAnd extends SimpleGate {

    public GateAnd(WireEnd wire0, WireEnd wire1, WireEnd out) {
        super(wire0, wire1, out, new AndOperation());
    }

}
