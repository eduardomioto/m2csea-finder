package br.com.mioto.cloud.vo;

public class Edges {

    public Edges(String source, String target){
        this.setSource(source);
        this.setTarget(target);
    }

    private String source;
    private String target;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
