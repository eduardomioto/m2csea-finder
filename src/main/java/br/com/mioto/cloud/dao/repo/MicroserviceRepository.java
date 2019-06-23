package br.com.mioto.cloud.dao.repo;

import br.com.mioto.cloud.vo.IncomingOutgoing;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.mioto.cloud.vo.Microservice;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MicroserviceRepository extends GraphRepository<Microservice> {

	// derived finder
	public Microservice findByName(String name);

    @Query("MATCH (n:Microservice) RETURN n LIMIT {limit}")
    Collection<Microservice> graph(@Param("limit") int limit);

    @Query("MATCH p=()-[r:DEPENDS]->() RETURN p LIMIT {limit}")
    Collection<Microservice> graphParam(@Param("limit") int limit);

    @Query("MATCH (a:Microservice) RETURN id(a) as id, a.name as name, size((a)-->()) as outgoing, size((a)<--()) as incoming order by incoming desc LIMIT {limit}")
    Collection<IncomingOutgoing> getMicroservicesInOut(@Param("limit") int limit);

    //buscar microserviço ordenado por maior quantidade de incoming e outgoing.
    //a partir dessa busca saberei qual o microserviço mais critico

    //buscar o maior caminho de comunicação entre um microserviço e outro.
    //a partir dessa busca sabarei qual a funcionalidade com maior saltos de comunicação


}