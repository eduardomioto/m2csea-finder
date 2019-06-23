package br.com.mioto.cloud.controllers;

import br.com.mioto.cloud.bo.FinderBO;
import br.com.mioto.cloud.vo.Microservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class MultifactorVisionController {

    private static final Logger log = LoggerFactory.getLogger(MultifactorVisionController.class);

    @Autowired
    private FinderBO finderBO;

    @RequestMapping(value = "/microservices/vision/multi/", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getUserVision() {
        List<String> listMicroservices = new ArrayList<>();
        Iterable<Microservice> microservicesFullList = finderBO.findAll();
        for (Microservice microservice: microservicesFullList) {
            listMicroservices.add(microservice.getName());
        }

        return listMicroservices;
    }
}
