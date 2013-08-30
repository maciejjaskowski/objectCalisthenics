package pl.pragmatists.objectCalisthenics.circuitSimulator;

public interface Transformation<S,T> {

    public T transform (S s);
}
