package pl.pragmatists.objectCalisthenics.circuitSimulator;

import static org.fest.assertions.api.Assertions.assertThat;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.circuit.HalfAdder;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;

public class HalfAdderAssert {

    private Bit sum;
    private Bit curry;

    public HalfAdderAssert(int input1, int input2) {
        WireEnd a = new WireEnd();
        WireEnd b = new WireEnd();
        WireEnd sum = new WireEnd();
        sum.addOnSignalChangedListener(new OnSignalChanged() {
            public void signalChangedTo(Bit bit) {
                HalfAdderAssert.this.sum = bit;
            }
        });
        WireEnd curry = new WireEnd();
        curry.addOnSignalChangedListener(new OnSignalChanged() {
            public void signalChangedTo(Bit bit) {
                HalfAdderAssert.this.curry = bit;
            }
        });
        new HalfAdder(a, b, sum, curry);
        a.signaledChangedTo(asBit(input1));
        b.signaledChangedTo(asBit(input2));
    }


    private static Bit asBit(int bit) {
        if (bit == 0) {
            return Bit.zero;
        }
        return Bit.one;
    }


    public HalfAdderAssert hasCurry(int expectedCurry) {
        assertThat(curry).as("on curry").isEqualTo(asBit(expectedCurry));
        return this;
    }


    public HalfAdderAssert hasSum(int expectedSum) {
        assertThat(sum).as("on sum").isEqualTo(asBit(expectedSum));
        return this;
    }

}
