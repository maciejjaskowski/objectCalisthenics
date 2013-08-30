package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;



public class GateOrTest {

    @Test
    public void shouldRealculateOnOutputChange() throws Exception {

        GateOr gateOr = new GateOr();
        Output output = new Output();

        WireEnd wire = wireWith(Bit.zero);
        WireEnd wire2 = wireWith(Bit.one);
        gateOr.wireInput1To(wire);
        gateOr.wireInput2To(wire2);
        gateOr.wireOutputTo(output);

        assertThat(output.value()).isEqualTo(Bit.one);

    }

    private WireEnd wireWith(Bit bit) {
        Wire wire = new Wire();
        wire.signaledChangedTo(bit);
        return wire;
    }
}
