package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Operation;

class OrOperation implements Operation {
    public Bit operateOn(Bit[] bits) {
        Bit result = Bit.zero;
        for (Bit bit : bits) {
            result = result.or(bit);
        }
        return result;
    }
}