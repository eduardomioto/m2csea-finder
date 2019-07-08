package br.com.mioto.cloud.bo.impl;

import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.kv.model.GetValue;
import com.google.gson.Gson;

import br.com.mioto.cloud.bo.KVStoreBO;
import br.com.mioto.cloud.vo.Microservice;

/**
 * Created by mioto on 04/06/17.
 */
@Component
public class KVStoreBOImpl implements KVStoreBO {

    private static final Logger log = LoggerFactory.getLogger(KVStoreBOImpl.class);

    @Autowired
    private ConsulClient consulClient;

    //watch updates on Key: https://stackoverflow.com/questions/40885028/watching-for-changes-on-specific-key-in-consul-using-orbitzworlds-consul-client

    /**
     * Set of Services with dependencies
     * 
     * @return
     */
    public Set<Microservice> kvGet() {

        final Map<String, List<String>> mapServices = this.getCatalogServices();

        final Set<Microservice> dependenciesSet = new HashSet<Microservice>();

        if (mapServices != null) {
            final Set<String> servicesSet = mapServices.keySet();
            for (final String service : servicesSet) {

                final String kvValue = this.getKV(service);

                if (kvValue != null) {
                    final Microservice microservice = this.treatKVCatalog(service, kvValue);
                    dependenciesSet.add(microservice);
                }
            }
        }
        return dependenciesSet;
    }

    /**
     * Convert Json value to Object
     * 
     * @param key
     * @param kvValue
     * @return
     */
    private Microservice treatKVCatalog(final String key, final String kvValue) {

        final Gson gson = new Gson();
        final Microservice microservice = gson.fromJson(kvValue, Microservice.class);
        microservice.setName(key);

        return microservice;
    }

    /**
     * Return the value related to a key on K/V Store
     * 
     * @param key
     * @return value
     */
    private String getKV(final String key) {
        final GetValue getValue = consulClient.getKVValue(key).getValue();
        return getValue == null ? null : new String(Base64.getDecoder().decode(getValue.getValue()));
    }

    /**
     * Get all services present on Service Catalog
     * 
     * @return
     */
    public Map<String, List<String>> getCatalogServices() {
        return consulClient.getCatalogServices(QueryParams.DEFAULT).getValue();
    }
}
