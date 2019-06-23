package br.com.mioto.cloud.controllers;

import br.com.mioto.cloud.bo.FinderBO;
import br.com.mioto.cloud.vo.Edges;
import br.com.mioto.cloud.vo.Nodes;
import br.com.mioto.cloud.vo.IncomingOutgoing;
import br.com.mioto.cloud.vo.Microservice;
import br.com.mioto.cloud.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.*;

@CrossOrigin
@RestController
public class FinderController {

	private static final Logger log = LoggerFactory.getLogger(FinderController.class);

    @Autowired
    private FinderBO finderBO;

    @RequestMapping("/home")
    @ResponseBody
    public String home() {

    	log.info("Fare Rest Service >> Alive!");
        return "Fare Rest Service, I'm Alive";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Set<Microservice> addFromConsul() {
        finderBO.deleteAll();
        return finderBO.add();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        finderBO.deleteAll();
        return "Deleted";
    }

    @RequestMapping("/findAllRaw")
    @ResponseBody
    public Iterable<Microservice> findAll() {
        return finderBO.findAll();
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<String> findAllMicroservices() {
        List<String> listMicroservices = new ArrayList<>();
        Iterable<Microservice> microservicesFullList = finderBO.findAll();
        for (Microservice microservice: microservicesFullList) {
            listMicroservices.add(microservice.getName());
        }

        return listMicroservices;
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public Microservice findByName(@RequestParam(value = "name",required = true) String name) {
        return finderBO.searchByName(name);
    }


    @RequestMapping("/graph")
    @ResponseBody
    @Produces("application/json")
    public Response graph() {
        Iterable<Microservice> microservicesList = finderBO.findAll();
        Collection<IncomingOutgoing> inOutList = finderBO.getMicroservicesInOut();

        Response response = new Response();

        List<Nodes> nodes =  new ArrayList<>();
        List<Edges> edges  =  new ArrayList<>();

        //temporario >> será substituito pela logica de descoberta de criticidade
        int criticalInt = 0;
        Double x = 1.0;
        Double y = 5.0;

        Double mostCritical = 0.0;
        String microserviceMostCritical = "";
        for (IncomingOutgoing inOut: inOutList) {
            Double in = inOut.getIncoming() * 1.5;
            Double out = inOut.getOutgoing() * 0.5;
            inOut.setCriticality(in + out);
            if(inOut.getCriticality() > mostCritical){
                mostCritical = inOut.getCriticality();
                microserviceMostCritical = inOut.getName();
            }
        }

        for (Microservice microservice: microservicesList) {

            IncomingOutgoing inOutMicro = new IncomingOutgoing();
            for (IncomingOutgoing inOut: inOutList) {
                if(inOut.getName().equals(microservice.getName())){
                    inOutMicro = inOut;
                }
            }


            if(microservice.getName().equals(microserviceMostCritical)){
                nodes.add(new Nodes(microservice.getName(), "#CC0000", x, y, inOutMicro.getIncoming(), inOutMicro.getOutgoing(), inOutMicro.getCriticality()));
                criticalInt++;
            }else{
                nodes.add(new Nodes(microservice.getName(), "#b8b8b8", x, y, inOutMicro.getIncoming(), inOutMicro.getOutgoing(), inOutMicro.getCriticality()));
            }

            Set<Microservice> microserviceDependencies = microservice.getDependencies();
            if(microserviceDependencies != null && !microserviceDependencies.isEmpty()){
                for (Microservice dependency : microserviceDependencies) {
                   edges.add(new Edges(microservice.getName(), dependency.getName()));
                }
            }

            if(y == 25.0){
                y = 5.0;
            }else{
                y = y+5;
            }
            x = x + 2;
        }

        response.setEdges(edges);
        response.setNodes(nodes);
        response.setInOut(inOutList);
        return response;
    }

    @RequestMapping("/in-out")
    @ResponseBody
    public Collection<IncomingOutgoing> inOut() {
        return finderBO.getMicroservicesInOut();
    }
}