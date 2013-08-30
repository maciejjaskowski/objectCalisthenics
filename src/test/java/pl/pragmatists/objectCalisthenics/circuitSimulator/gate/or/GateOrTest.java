package pl.pragmatists.objectCalisthenics.circuitSimulator.gate.or;

import static org.fest.assertions.api.Assertions.assertThat;
import static pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit.one;
import static pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit.zero;

import org.junit.Test;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.Wire;
import pl.pragmatists.objectCalisthenics.circuitSimulator.wire.WireEnd;



public class GateOrTest {

    private GateOr gateOr = new GateOr();
    private Output output = new Output();

    @Test
    public void shouldRealculateOnOutputChange() throws Exception {
        //given
        gateOr.wireInput1To(aWireWithSignal(zero));
        gateOr.wireInput2To(aWireWithSignal(one));

        //when
        gateOr.wireOutputTo(output);

        //then
        assertThat(output.value()).isEqualTo(Bit.one);
    }

    private WireEnd aWireWithSignal(Bit bit) {
        Wire wire = new Wire();
        wire.signaledChangedTo(bit);
        return wire;
    }
}
