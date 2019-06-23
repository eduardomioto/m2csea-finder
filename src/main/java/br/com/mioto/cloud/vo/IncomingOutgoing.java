package br.com.mioto.cloud.vo;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class IncomingOutgoing {

    private Long id;

    private String name;

    private Integer incoming;

    private Integer outgoing;

    private Double criticality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIncoming() {
        return incoming;
    }

    public void setIncoming(Integer incoming) {
        this.incoming = incoming;
    }

    public Integer getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(Integer outgoing) {
        this.outgoing = outgoing;
    }


    public Double getCriticality() {
        return criticality;
    }

    public void setCriticality(Double criticality) {
        this.criticality = criticality;
    }
}