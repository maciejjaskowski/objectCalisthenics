package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or.GateOr;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WeldWirings;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;

public class Adder {

    public Adder(WireEnd in1, WireEnd in2, WireEnd carryIn, WireEnd sum, WireEnd carryOut) {
        WireEnd halfAdder1End1 = new WireEnd();
        WireEnd halfAdder1End2 = new WireEnd();
        new HalfAdder(in1, in2, halfAdder1End1, halfAdder1End2);


        WireEnd halfAdder2End2 = new WireEnd();
        WireEnd halfAdder2In1 = new WireEnd();
        new HalfAdder(halfAdder2In1, carryIn, sum, halfAdder2End2);

        carryIn.addOnSignalChangedListener(new OnSignalChanged() {

            public void signalChangedTo(Bit bit) {
                System.out.println(bit);
            }
        });

        WireEnd gateOrIn1 = new WireEnd();
        WireEnd gateOrIn2 = new WireEnd();
        new GateOr(gateOrIn1, gateOrIn2, carryOut);

        WeldWirings wirings = new WeldWirings();
        wirings.wire(halfAdder1End1, halfAdder2In1);
        wirings.wire(halfAdder2End2, gateOrIn1);
        wirings.wire(halfAdder1End2, gateOrIn2);
    }
}
