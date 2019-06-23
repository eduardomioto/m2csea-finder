package br.com.mioto.cloud.controllers;

import br.com.mioto.cloud.bo.KVStoreBO;
import br.com.mioto.cloud.vo.Microservice;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.kv.model.GetValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin
@RestController
public class ConsulController {

	private static final Logger log = LoggerFactory.getLogger(ConsulController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private KVStoreBO kvStoreBO;

	@Value("${spring.application.name:mcpd-finder}")
	private String appName;

	@RequestMapping("/me")
	public ServiceInstance me() {
		return discoveryClient.getLocalServiceInstance();
	}

	@RequestMapping(value = "/kv-get", method = RequestMethod.GET, produces = "application/json")
	public Set<Microservice> kvGet() {
        return kvStoreBO.kvGet();
	}

    @RequestMapping(value = "/services", method = RequestMethod.GET, produces = "application/json")
    public Map<String, List<String>> getCatalogServices() {
        return kvStoreBO.getCatalogServices();
    }
}