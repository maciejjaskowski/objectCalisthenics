package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or.GateOr;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireStart;

public class Adder {

    private HalfAdder halfAdder;
    private HalfAdder halfAdder2;
    private GateOr gateOr;

    public Adder() {
        halfAdder = new HalfAdder();
        halfAdder2 = new HalfAdder();
        gateOr = new GateOr();

        {
            Wire wire = new Wire();
            halfAdder.wireSumTo(wire);
            halfAdder2.wireInput1To(wire);
        }
        {
            Wire wire = new Wire();
            halfAdder.wireCarryTo(wire);
            gateOr.wireInput1To(wire);
        }
        {
            Wire wire = new Wire();
            halfAdder2.wireCarryTo(wire);
            gateOr.wireInput2To(wire);
        }
    }

    public Adder(WireEnd in1, WireEnd in2, WireEnd carryIn, WireStart sum, WireStart carryOut) {

        HalfAdder halfAdder = new HalfAdder();
        HalfAdder halfAdder2 = new HalfAdder();
        GateOr gateOr = new GateOr();

        {
            halfAdder.wireInput1To(in1);
            halfAdder.wireInput2To(in2);
            halfAdder2.wireInput2To(carryIn);
            halfAdder2.wireSumTo(sum);
            gateOr.wireOutputTo(carryOut);
        }
        {
            Wire wire = new Wire();
            halfAdder.wireSumTo(wire);
            halfAdder2.wireInput1To(wire);
        }
        {
            Wire wire = new Wire();
            halfAdder.wireCarryTo(wire);
            gateOr.wireInput1To(wire);
        }
        {
            Wire wire = new Wire();
            halfAdder2.wireCarryTo(wire);
            gateOr.wireInput2To(wire);
        }


    }

    public void wireInput1To(WireEnd wire) {
        halfAdder.wireInput1To(wire);
    }

    public void wireInput2To(WireEnd wire) {
        halfAdder.wireInput2To(wire);

    }

    public void wireCarryTo(WireEnd wire) {
        halfAdder2.wireInput2To(wire);
    }

    public void wireSumTo(WireStart wire) {
        halfAdder2.wireSumTo(wire);
    }

    public void wireCarryOutputTo(WireStart wire) {
        gateOr.wireOutputTo(wire);
    }


}
