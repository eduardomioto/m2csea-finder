package br.com.mioto.cloud.bo;

import br.com.mioto.cloud.vo.IncomingOutgoing;
import br.com.mioto.cloud.vo.Microservice;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by mioto on 04/06/17.
 */
public interface FinderBO {

   

    void deleteAll();

    Iterable<Microservice> findAll();

    Microservice searchByName(String name);

    Collection<IncomingOutgoing> getMicroservicesInOut();

    Set<Microservice> add();
}
