package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import static org.fest.assertions.api.Assertions.assertThat;
import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;

public class HalfAdderAssert {

    private Bit sum;
    private Bit curry;

    public HalfAdderAssert(int input1, int input2) {


        HalfAdder halfAdder = new HalfAdder();

        {
            Wire input1Wire = new Wire();
            halfAdder.wireInput1To(input1Wire);
            input1Wire.signaledChangedTo(asBit(input1));
        }
        {
            Wire input2Wire = new Wire();
            halfAdder.wireInput2To(input2Wire);
            input2Wire.signaledChangedTo(asBit(input2));
        }

        {
            Wire wire = new Wire();
            halfAdder.wireCarryTo(wire);
            wire.addOnSignalChangedListener(new OnSignalChanged() {
                public void signalChangedTo(Bit bit) {
                    HalfAdderAssert.this.curry = bit;
                }
            });
        }
        {
            Wire wire = new Wire();
            halfAdder.wireSumTo(wire);
            wire.addOnSignalChangedListener(new OnSignalChanged() {
                public void signalChangedTo(Bit bit) {
                    HalfAdderAssert.this.sum = bit;
                }
            });
        }



    }


    private static Bit asBit(int bit) {
        if (bit == 0) {
            return Bit.zero;
        }
        return Bit.one;
    }


    public HalfAdderAssert hasCarry(int expectedCurry) {
        assertThat(curry).as("on carry").isEqualTo(asBit(expectedCurry));
        return this;
    }


    public HalfAdderAssert hasSum(int expectedSum) {
        assertThat(sum).as("on sum").isEqualTo(asBit(expectedSum));
        return this;
    }

}
