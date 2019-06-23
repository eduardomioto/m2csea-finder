package br.com.mioto.cloud.dao;

import br.com.mioto.cloud.vo.IncomingOutgoing;
import br.com.mioto.cloud.vo.Microservice;

import java.util.Collection;

/**
 * Created by mioto on 03/06/17.
 */
public interface MicroserviceDAO {

    Microservice searchByName(String name);

    Microservice save(Microservice microservice);

    void deleteAll();

    Iterable<Microservice> viewAll();

    Collection<IncomingOutgoing> getMicroservicesInOut();
}
