package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.and;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Operation;

class AndOperation implements Operation {

    public Bit operateOn(Bit[] bits) {
        Bit result = Bit.one;
        for (Bit bit : bits) {
            result = result.and(bit);
        }
        return result;
    }

}