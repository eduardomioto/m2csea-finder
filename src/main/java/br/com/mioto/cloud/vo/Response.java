package br.com.mioto.cloud.vo;

import java.util.Collection;
import java.util.List;

public class Response {

    private List<Nodes> nodes;

    private List<Edges> edges;

    private Collection<IncomingOutgoing> inOut;

    public List<Nodes> getNodes() {
        return nodes;
    }

    public void setNodes(List<Nodes> nodes) {
        this.nodes = nodes;
    }

    public List<Edges> getEdges() {
        return edges;
    }

    public void setEdges(List<Edges> edges) {
        this.edges = edges;
    }


    public Collection<IncomingOutgoing> getInOut() {
        return inOut;
    }

    public void setInOut(Collection<IncomingOutgoing> inOut) {
        this.inOut = inOut;
    }
}
