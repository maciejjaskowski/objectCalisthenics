package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import static org.fest.assertions.api.Assertions.assertThat;
import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;

public class AdderAssert {

    protected Bit sum;
    protected Bit carry;

    public AdderAssert(int input1, int input2, int carryIn) {
        Adder adder = new Adder();

        {
            Wire wire = new Wire();
            adder.wireInput1To(wire);
            wire.signaledChangedTo(asBit(input1));
        }
        {
            Wire wire = new Wire();
            adder.wireInput2To(wire);
            wire.signaledChangedTo(asBit(input2));
        }
        {
            Wire wire = new Wire();
            adder.wireCarryTo(wire);
            wire.signaledChangedTo(asBit(carryIn));
        }

        {
            Wire wire = new Wire();
            wire.addOnSignalChangedListener(new OnSignalChanged() {
                public void signalChangedTo(Bit bit) {
                    AdderAssert.this.sum = bit;
                }
            });
            adder.wireSumTo(wire);
        }
        {
            Wire wire = new Wire();
            wire.addOnSignalChangedListener(new OnSignalChanged() {
                public void signalChangedTo(Bit bit) {
                    AdderAssert.this.carry = bit;
                }
            });
            adder.wireCarryOutputTo(wire);
        }


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
