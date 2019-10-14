package br.com.mioto.cloud.bo;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import br.com.mioto.cloud.vo.IncomingOutgoing;
import br.com.mioto.cloud.vo.Microservice;

/**
 * Created by mioto on 04/06/17.
 */
public interface FinderBO {



    void deleteAll();

    Iterable<Microservice> findAll();

    Microservice searchByName(String name);

    Collection<IncomingOutgoing> getMicroservicesInOut();

    Set<Microservice> add();

    void saveCriticality(Collection<IncomingOutgoing> inOutList) throws SQLException;
}
