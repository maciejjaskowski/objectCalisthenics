package pl.pragmatists.objectCalisthenics.circuitSimulator.circuit;

import org.junit.Test;



public class AdderTest {

    @Test
    public void shouldAdd8() {
        assertThat(1,1,1).hasSum(1).hasCarry(1);
    }

    @Test
    public void shouldAdd7() {
        assertThat(1,1,0).hasSum(0).hasCarry(1);
    }

    @Test
    public void shouldAdd6() {
        assertThat(1,0,1).hasSum(0).hasCarry(1);
    }

    @Test
    public void shouldAdd5() {
        assertThat(1,0,0).hasSum(1).hasCarry(0);
    }

    @Test
    public void shouldAdd4() {
        assertThat(0,1,1).hasSum(0).hasCarry(1);
    }

    @Test
    public void shouldAdd3() {
        assertThat(0,1,0).hasSum(1).hasCarry(0);
    }

    @Test
    public void shouldAdd2() {
        assertThat(0,0,1).hasSum(1).hasCarry(0);
    }

    @Test
    public void shouldAdd1() throws Exception {
        assertThat(0,0,0).hasSum(0).hasCarry(0);
    }

    private AdderAssert assertThat(int c1, int c2, int carryIn) {
        return new AdderAssert(c1, c2, carryIn);
    }
}
