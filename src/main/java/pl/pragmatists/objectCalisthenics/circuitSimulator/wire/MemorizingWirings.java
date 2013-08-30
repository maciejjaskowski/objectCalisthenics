package pl.pragmatists.objectCalisthenics.circuitSimulator.wire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MemorizingWirings implements Wirings {

    private Map<WireEnd, List<WireEnd>> wirings = new HashMap<WireEnd, List<WireEnd>>();
    private final Wirings decoratee;

    public MemorizingWirings(Wirings decoratee) {
        this.decoratee = decoratee;
    }

    public void wire(final WireEnd start, final WireEnd end) {
        decoratee.wire(start, end);

        get(start).add(end);
    }

    private List<WireEnd> get(final WireEnd start) {
        if (wirings.get(start) == null) {
            wirings.put(start, new ArrayList<WireEnd>());
        }
        List<WireEnd> list = wirings.get(start);
        return list;
    }

}
