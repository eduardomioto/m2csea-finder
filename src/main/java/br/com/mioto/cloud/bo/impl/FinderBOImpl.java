package br.com.mioto.cloud.bo.impl;

import br.com.mioto.cloud.bo.FinderBO;
import br.com.mioto.cloud.bo.KVStoreBO;
import br.com.mioto.cloud.dao.MicroserviceDAO;
import br.com.mioto.cloud.dao.repo.MicroserviceRepository;
import br.com.mioto.cloud.vo.IncomingOutgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.mioto.cloud.vo.Microservice;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FinderBOImpl implements FinderBO {

    private static final Logger log = LoggerFactory.getLogger(FinderBOImpl.class);

    @Autowired
    private MicroserviceRepository repo;

    @Autowired
    private KVStoreBO kvStoreBO;

    @Autowired
    private MicroserviceDAO microserviceDAO;

    public Set<Microservice> add() {

        Set<Microservice> microservicesSaved = saveInitialMicroservicesNodes();
        return updateSavedMicroservices(microservicesSaved);
    }

    private Set<Microservice> getMicroservicesFromConsul() {
        log.info("## getMicroservicesFromConsul");

        /**
         * Query Consul KV Store to receive the microservices list
         */
        Set<Microservice> microserviceSet = kvStoreBO.kvGet();
        if (microserviceSet != null && !microserviceSet.isEmpty()) {
            log.info(">> Consul retornou {} microserviços", microserviceSet.size());
        } else {
            log.info("<< MicroserviceSet returned null or empty");
        }
        return microserviceSet;
    }

    private Set<Microservice> updateSavedMicroservices(Set<Microservice> microservicesSaved) {

        Set<Microservice> microservicesSavedDeps = microservicesSaved;

        Set<Microservice> microservicesConsul = getMicroservicesFromConsul();

        //Lista de microserviços salvos, com id mas sem dependencias
        for (Microservice microSaved : microservicesSaved) {

            log.info(">>>> Micro Saved {} ::", microSaved);

            Set<Microservice> microserviceDependenciesUpdated = new HashSet<>();
            Set<Microservice> microserviceConsulDependencies = new HashSet<>();

            //Lista de microserviços retornado do Consul. Não contém o ID obtido da base de dados

            for (Microservice microserviceConsul : microservicesConsul) {
                if (microSaved.getName().equals(microserviceConsul.getName())) {

                    log.info(">>>> Microservice Localizado {} ::", microserviceConsul.getName());
                    log.info(">>>> Dependencias {} ::", microserviceConsul.getDependencies());

                    microserviceConsulDependencies = microserviceConsul.getDependencies();
                    break;
                }
            }
            log.info(">>>> Microservice Consul Dependencies {} ::", microserviceConsulDependencies);

            if (microserviceConsulDependencies != null && !microserviceConsulDependencies.isEmpty()) {
                for (Microservice consulDependecy : microserviceConsulDependencies) {
                    Microservice saved = microserviceDAO.searchByName(consulDependecy.getName());
                    if(saved != null){
                        saved.setDependencies(null);
                        microserviceDependenciesUpdated.add(saved);
                    }
                }
            }
            microSaved.setDependencies(microserviceDependenciesUpdated);

            log.info(">>>> Microservice Updated Dependencies {} ::", microserviceDependenciesUpdated);
            microserviceDAO.save(microSaved);

            log.info("################################################");
        }


        return microservicesSaved;

    }


    private Set<Microservice> saveInitialMicroservicesNodes() {

        Set<Microservice> microservicesConsul = getMicroservicesFromConsul();
        Set<Microservice> microserviceSaved = new HashSet<>();
        for (Microservice microservice : microservicesConsul) {
            microservice.setDependencies(null);
            microserviceSaved.add(microserviceDAO.save(microservice));
        }
        return microserviceSaved;
    }

    /**
     * Associates the dependencies (nodes) with a microservice (node)
     *
     * @param microservice
     */
    private void associateMicroservicesDependencies2(Microservice microservice) {

        log.info("### Verificando as dependencias do Microserviço {} ::", microservice.getName());

        Microservice microSaved = microserviceDAO.searchByName(microservice.getName());
        log.info("Microservice Localizado na Base {} ::", microSaved);

        Set<Microservice> microserviceDependencies = microservice.getDependencies();

        if (microserviceDependencies != null && !microserviceDependencies.isEmpty()) {
            Set<Microservice> microserviceFullDependencies = new HashSet<>();

            for (Microservice microserviceInstance : microserviceDependencies) {
                Microservice dependency = microserviceDAO.searchByName(microserviceInstance.getName());
                if (dependency != null) {
                    microserviceFullDependencies.add(dependency);
                    log.info("------- Dependency {} ::", dependency.getName());
                }
            }
            microSaved.setDependencies(microserviceFullDependencies);

            log.info("Microservice Dependencies {} ::", microserviceFullDependencies);
            microserviceDAO.save(microSaved);
        }

        log.info("### Finalizando Inserção ### ");
    }

    /**
     * Associates the dependencies (nodes) with a microservice (node)
     *
     * @param microservice
     */
    private void associateMicroservicesDependencies(Microservice microservice) {

        log.info("### Verificando as dependencias do Microserviço {} ::", microservice.getName());

        Microservice microSaved = microserviceDAO.searchByName(microservice.getName());
        log.info("Microservice Localizado na Base {} ::", microSaved);

        Set<Microservice> microserviceDependencies = microservice.getDependencies();

        if (microserviceDependencies != null && !microserviceDependencies.isEmpty()) {
            Set<Microservice> microserviceFullDependencies = new HashSet<>();

            for (Microservice microserviceInstance : microserviceDependencies) {
                Microservice dependency = microserviceDAO.searchByName(microserviceInstance.getName());
                if (dependency != null) {
                    microserviceFullDependencies.add(dependency);
                    log.info("------- Dependency {} ::", dependency.getName());
                }
            }
            microSaved.setDependencies(microserviceFullDependencies);

            log.info("Microservice Dependencies {} ::", microserviceFullDependencies);
            microserviceDAO.save(microSaved);
        }

        log.info("### Finalizando Inserção ### ");
    }

    public void deleteAll() {
        microserviceDAO.deleteAll();
    }

    public Microservice searchByName(String name) {
        return microserviceDAO.searchByName(name);
    }

    public Iterable<Microservice> findAll() {
        return microserviceDAO.viewAll();
    }

    public Collection<IncomingOutgoing> getMicroservicesInOut() {
        return microserviceDAO.getMicroservicesInOut();
    }

    public Collection<IncomingOutgoing> getMicroservicesIn() {
        return microserviceDAO.getMicroservicesInOut();
    }

    public Collection<IncomingOutgoing> getMicroservicesOut() {
        return microserviceDAO.getMicroservicesInOut();
    }

}
