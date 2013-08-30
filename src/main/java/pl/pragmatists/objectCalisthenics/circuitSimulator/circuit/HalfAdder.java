package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.and.GateAnd;
import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.inverter.GateInverter;
import pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or.GateOr;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WeldWirings;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wirings;

public class HalfAdder {

    private Wirings weldWirings;

    public HalfAdder(WireEnd a, WireEnd b, WireEnd sum, WireEnd carry) {

        WireEnd orOut = new WireEnd();
        new GateOr(a, b, orOut);

        new GateAnd(a, b, carry);


        WireEnd inverterOut = new WireEnd();
        WireEnd inverterIn = new WireEnd();
        new GateInverter(inverterIn, inverterOut);

        WireEnd gateAnd2WireEnd = new WireEnd();
        WireEnd gateAnd2Wire2End = new WireEnd();
        new GateAnd(gateAnd2WireEnd, gateAnd2Wire2End, sum);

        weldWirings = new WeldWirings();
        weldWirings.wire(orOut, gateAnd2WireEnd);
        weldWirings.wire(inverterOut, gateAnd2Wire2End);
        weldWirings.wire(carry, inverterIn);
    }

}
