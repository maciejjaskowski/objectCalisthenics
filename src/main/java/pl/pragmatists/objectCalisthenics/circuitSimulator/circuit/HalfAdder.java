package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.and.GateAnd;
import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.inverter.GateInverter;
import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or.GateOr;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireStart;

public class HalfAdder {

    private GateOr gateOr;
    private GateAnd gateAnd;
    private GateAnd gateAnd2;
    private GateAnd gateAnd3;

    public HalfAdder() {

        gateOr = new GateOr();
        gateAnd = new GateAnd();
        gateAnd2 = new GateAnd();
        gateAnd3 = new GateAnd();
        GateInverter gateInverter = new GateInverter();

        {
            Wire wire = new Wire();
            gateOr.wireOutputTo(wire);
            gateAnd3.wireInput1To(wire);
        }
        {
            Wire wire = new Wire();
            gateAnd.wireOutputTo(wire);
            gateInverter.wireInputTo(wire);
        }
        {
            Wire wire = new Wire();
            gateInverter.wireOutputTo(wire);
            gateAnd3.wireInput2To(wire);
        }


    }

    public void wireInput1To(WireEnd a) {
        gateOr.wireInput1To(a);
        gateAnd.wireInput1To(a);
        gateAnd2.wireInput1To(a);
    }

    public void wireInput2To(WireEnd b) {
        gateOr.wireInput2To(b);
        gateAnd.wireInput2To(b);
        gateAnd2.wireInput2To(b);
    }

    public void wireSumTo(WireStart sum) {
        gateAnd3.wireOutputTo(sum);
    }

    public void wireCarryTo(Wire carry) {
        gateAnd2.wireOutputTo(carry);
    }

}
