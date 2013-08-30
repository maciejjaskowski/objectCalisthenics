package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.and;

import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.SimpleGate;

public class GateAnd extends SimpleGate {

    public GateAnd() {
        super(new AndOperation());
    }

}
