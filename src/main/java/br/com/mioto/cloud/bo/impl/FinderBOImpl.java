package br.com.mioto.cloud.bo.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mioto.cloud.bo.CriticalityBO;
import br.com.mioto.cloud.bo.FinderBO;
import br.com.mioto.cloud.bo.KVStoreBO;
import br.com.mioto.cloud.dao.MicroserviceDAO;
import br.com.mioto.cloud.dao.repo.MicroserviceRepository;
import br.com.mioto.cloud.vo.CriticalityVO;
import br.com.mioto.cloud.vo.IncomingOutgoing;
import br.com.mioto.cloud.vo.Microservice;

@Component
public class FinderBOImpl implements FinderBO {

    private static final Logger log = LoggerFactory.getLogger(FinderBOImpl.class);

    @Autowired
    private MicroserviceRepository repo;

    @Autowired
    private KVStoreBO kvStoreBO;

    @Autowired
    private MicroserviceDAO microserviceDAO;

    @Autowired
    private CriticalityBO criticalityBO;

    @Override
    public Set<Microservice> add() {

        final Set<Microservice> microservicesSaved = saveInitialMicroservicesNodes();
        return updateSavedMicroservices(microservicesSaved);
    }

    private Set<Microservice> getMicroservicesFromConsul() {
        log.info("## getMicroservicesFromConsul");

        /**
         * Query Consul KV Store to receive the microservices list
         */
        final Set<Microservice> microserviceSet = kvStoreBO.kvGet();
        if ((microserviceSet != null) && !microserviceSet.isEmpty()) {
            log.info(">> Consul retornou {} microserviços", microserviceSet.size());
        } else {
            log.info("<< MicroserviceSet returned null or empty");
        }
        return microserviceSet;
    }

    private Set<Microservice> updateSavedMicroservices(Set<Microservice> microservicesSaved) {

        final Set<Microservice> microservicesSavedDeps = microservicesSaved;

        final Set<Microservice> microservicesConsul = getMicroservicesFromConsul();

        //Lista de microserviços salvos, com id mas sem dependencias
        for (final Microservice microSaved : microservicesSaved) {

            log.info(">>>> Micro Saved {} ::", microSaved);

            final Set<Microservice> microserviceDependenciesUpdated = new HashSet<>();
            Set<Microservice> microserviceConsulDependencies = new HashSet<>();

            //Lista de microserviços retornado do Consul. Não contém o ID obtido da base de dados

            for (final Microservice microserviceConsul : microservicesConsul) {
                if (microSaved.getName().equals(microserviceConsul.getName())) {

                    log.info(">>>> Microservice Localizado {} ::", microserviceConsul.getName());
                    log.info(">>>> Dependencias {} ::", microserviceConsul.getDependencies());

                    microserviceConsulDependencies = microserviceConsul.getDependencies();
                    break;
                }
            }
            log.info(">>>> Microservice Consul Dependencies {} ::", microserviceConsulDependencies);

            if ((microserviceConsulDependencies != null) && !microserviceConsulDependencies.isEmpty()) {
                for (final Microservice consulDependecy : microserviceConsulDependencies) {
                    final Microservice saved = microserviceDAO.searchByName(consulDependecy.getName());
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

        final Set<Microservice> microservicesConsul = getMicroservicesFromConsul();
        final Set<Microservice> microserviceSaved = new HashSet<>();
        for (final Microservice microservice : microservicesConsul) {
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

        final Microservice microSaved = microserviceDAO.searchByName(microservice.getName());
        log.info("Microservice Localizado na Base {} ::", microSaved);

        final Set<Microservice> microserviceDependencies = microservice.getDependencies();

        if ((microserviceDependencies != null) && !microserviceDependencies.isEmpty()) {
            final Set<Microservice> microserviceFullDependencies = new HashSet<>();

            for (final Microservice microserviceInstance : microserviceDependencies) {
                final Microservice dependency = microserviceDAO.searchByName(microserviceInstance.getName());
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

        final Microservice microSaved = microserviceDAO.searchByName(microservice.getName());
        log.info("Microservice Localizado na Base {} ::", microSaved);

        final Set<Microservice> microserviceDependencies = microservice.getDependencies();

        if ((microserviceDependencies != null) && !microserviceDependencies.isEmpty()) {
            final Set<Microservice> microserviceFullDependencies = new HashSet<>();

            for (final Microservice microserviceInstance : microserviceDependencies) {
                final Microservice dependency = microserviceDAO.searchByName(microserviceInstance.getName());
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

    @Override
    public void deleteAll() {
        microserviceDAO.deleteAll();
    }

    @Override
    public Microservice searchByName(String name) {
        return microserviceDAO.searchByName(name);
    }

    @Override
    public Iterable<Microservice> findAll() {
        return microserviceDAO.viewAll();
    }

    @Override
    public Collection<IncomingOutgoing> getMicroservicesInOut() {
        return microserviceDAO.getMicroservicesInOut();
    }

    public Collection<IncomingOutgoing> getMicroservicesIn() {
        return microserviceDAO.getMicroservicesInOut();
    }

    public Collection<IncomingOutgoing> getMicroservicesOut() {
        return microserviceDAO.getMicroservicesInOut();
    }


    @Override
    public void saveCriticality(Collection<IncomingOutgoing> inOutList) throws SQLException {

        final List<IncomingOutgoing> listIncomingOutgoing = new ArrayList<IncomingOutgoing>();
        for (final IncomingOutgoing incomingOutgoing : inOutList) {
            listIncomingOutgoing.add(incomingOutgoing);
        }

        Collections.sort(listIncomingOutgoing, Collections.reverseOrder());

        final IncomingOutgoing incomingOutgoing = listIncomingOutgoing.get(0);
        checkCriticality(incomingOutgoing);

    }

    /**
     * Check criticality.
     *
     * @param computationalResources the computational resources
     * @throws SQLException the SQL exception
     */
    private void checkCriticality(final IncomingOutgoing incomingOutgoing) throws SQLException {

        final Integer criticalityFactor = this.calculateCriticalityFactor(incomingOutgoing.getCriticality());

        final String value = "Incoming: " + incomingOutgoing.getIncoming() + " | Outgoing: "  + incomingOutgoing.getOutgoing();
        final CriticalityVO vo = criticalityBO.populate(incomingOutgoing.getName(), criticalityFactor, value, "microservices-interdependecies");
        criticalityBO.saveCriticality(vo);
    }

    /**
     * Calculate criticality factor.
     *
     * @param value the value
     * @return the integer
     */
    public Integer calculateCriticalityFactor(Double value) {

        if((value > 0) && (value <= 2)) {
            return 1;

        }else if((value > 2) && (value <= 4)) {
            return 2;

        }else if((value > 4) && (value <= 6)) {
            return 3;

        }else if((value > 6) && (value <= 8)) {
            return 4;
        }

        return 5;
    }



}
