package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or;

import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.SimpleGate;

public class GateOr extends SimpleGate {

    public GateOr() {
        super(new OrOperation());
    }

}
