package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import org.junit.Test;

import pl.pragmatists.objectCalisthenics.circuitSimulator.HalfAdderAssert;




public class HalfAdderTest {

    @Test
    public void shouldAdd1() throws Exception {
        assertThat(0,0).hasSum(0).hasCurry(0);
    }

    @Test
    public void shouldAdd2() throws Exception {
        assertThat(0,1).hasSum(1).hasCurry(0);
    }

    @Test
    public void shouldAdd3() throws Exception {
        assertThat(1,0).hasSum(1).hasCurry(0);
    }

    @Test
    public void shouldAdd4() throws Exception {
        assertThat(1,1).hasSum(0).hasCurry(1);
    }

    private HalfAdderAssert assertThat(int i, int j) {
        return new HalfAdderAssert(i, j);
    }
}
