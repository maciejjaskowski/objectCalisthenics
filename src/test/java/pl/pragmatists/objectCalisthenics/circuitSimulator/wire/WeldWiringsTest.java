package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import pl.pragmatists.objectCalisthenics.circuitSimulator.OnSignalChanged;
import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;



public class WeldWiringsTest {

    private Bit outputSignal;

    private Wirings directWirings;

    private WireEnd end;

    @Before
    public void setUp() {
        directWirings = new WeldWirings();
        end = new WireEnd() {{
                addOnSignalChangedListener(new OnSignalChanged() {
                    public void signalChangedTo(Bit bit) {
                        WeldWiringsTest.this.outputSignal = bit;
                    }
                });
            }};
    }

    @Test
    public void shouldSignalOneAtTheEnd() throws Exception {
        WireEnd start = new WireEnd();
        directWirings.wire(start, end);

        end.signaledChangedTo(Bit.one);

        assertThat(outputSignal).isEqualTo(Bit.one);
    }

    @Test
    public void shouldSignalZeroAtTheEnd() throws Exception {
        WireEnd start = new WireEnd();
        directWirings.wire(start, end);

        end.signaledChangedTo(Bit.zero);

        assertThat(outputSignal).isEqualTo(Bit.zero);
    }


}
