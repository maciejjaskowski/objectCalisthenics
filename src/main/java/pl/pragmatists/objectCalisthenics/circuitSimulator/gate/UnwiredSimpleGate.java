package pl.pragmatists.objectCalisthenics.circuitSimulator.gate;

import pl.pragmatists.objectCalisthenics.circuitSimulator.bit.Bit;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Input;
import pl.pragmatists.objectCalisthenics.circuitSimulator.input.Operation;

public class UnwiredSimpleGate {
    private Input input;
    private final Operation operation;

    public UnwiredSimpleGate(Operation operation, Input input) {
        this.operation = operation;
        this.input = input;
    }

    public Bit changeBit(int index, Bit bit) {
        input = input.changeBit(index, bit);
        return input.runOperation(operation);
    }
}