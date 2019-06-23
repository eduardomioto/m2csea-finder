package br.com.mioto.cloud.dao.impl;

import br.com.mioto.cloud.dao.MicroserviceDAO;
import br.com.mioto.cloud.dao.repo.MicroserviceRepository;
import br.com.mioto.cloud.vo.IncomingOutgoing;
import br.com.mioto.cloud.vo.Microservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by mioto on 03/06/17.
 */
@Component
public class MicroserviceDAOImpl implements MicroserviceDAO {

    private static final Logger log = LoggerFactory.getLogger(MicroserviceDAOImpl.class);

    @Autowired
    private MicroserviceRepository repo;

    public Microservice searchByName(String name){
        return repo.findByName(name);
    }

    public Microservice save(Microservice microservice){
        return repo.save(microservice);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

    public Iterable<Microservice> viewAll(){
        return repo.findAll();
    }

    public Collection<IncomingOutgoing> getMicroservicesInOut(){
        return repo.getMicroservicesInOut(100);
    }

}
