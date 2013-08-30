package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import static org.fest.assertions.api.Assertions.assertThat;
import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;

public class AdderAssert {

    protected Bit sum;
    protected Bit carry;

    public AdderAssert(int input1, int input2, int carryIn) {
        WireEnd a = new WireEnd();
        WireEnd b = new WireEnd();
        WireEnd c = new WireEnd();
        WireEnd sum = new WireEnd();
        sum.addOnSignalChangedListener(new OnSignalChanged() {
            public void signalChangedTo(Bit bit) {
                AdderAssert.this.sum = bit;
            }
        });
        WireEnd carry = new WireEnd();
        carry.addOnSignalChangedListener(new OnSignalChanged() {
            public void signalChangedTo(Bit bit) {
                AdderAssert.this.carry = bit;
            }
        });
        new Adder(a, b, c, sum, carry);
        a.signaledChangedTo(asBit(input1));
        b.signaledChangedTo(asBit(input2));
        c.signaledChangedTo(asBit(carryIn));
    }

    private Bit asBit(int input) {
        return input == 0 ? Bit.zero : Bit.one;
    }

    public AdderAssert hasSum(int expectedSum) {
        assertThat(sum).as("sum").isEqualTo(asBit(expectedSum));
        return this;
    }

    public AdderAssert hasCarry(int expectedCarry) {
        assertThat(carry).as("carry").isEqualTo(asBit(expectedCarry));
        return this;
    }

}
