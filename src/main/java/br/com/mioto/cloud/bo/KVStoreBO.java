package br.com.mioto.cloud.bo;

import br.com.mioto.cloud.vo.Microservice;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mioto on 04/06/17.
 */
public interface KVStoreBO {

    Map<String, List<String>> getCatalogServices();

    Set<Microservice> kvGet();
}
