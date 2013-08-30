package pl.pragmatists.objectCalisthenics.circuitSimulator.input;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;

public interface Operation {

    Bit operateOn(Bit[] bits);

}
