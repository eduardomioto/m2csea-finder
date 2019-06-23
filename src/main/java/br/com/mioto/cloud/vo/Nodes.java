package br.com.mioto.cloud.vo;

public class Nodes {

    public Nodes(String nome, String hex, Double x, Double y, Integer incoming, Integer outgoing, Double criticality){
        this.setName(nome);
        this.setHex(hex);
        this.setX(x);
        this.setY(y);
        this.setIncoming(incoming);
        this.setOutgoing(outgoing);
        this.setCriticality(criticality);
    }

    //Unique name
    private String name;

    //Color
    private String hex;

    //Position Axis x
    private Double x;

    //Position Axis y
    private Double y;

    private Integer incoming;

    private Integer outgoing;

    private Double criticality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
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
