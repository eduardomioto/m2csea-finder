package br.com.mioto.cloud.vo;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Microservice {

    @GraphId
    private Long id;

    private String name;

    private String version;

    @Relationship(type="DEPENDS", direction = Relationship.OUTGOING)
    private Set<Microservice> dependencies;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<Microservice> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<Microservice> dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public String toString() {
        return "Microservice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", dependencies=" + dependencies +
                '}';
    }
}