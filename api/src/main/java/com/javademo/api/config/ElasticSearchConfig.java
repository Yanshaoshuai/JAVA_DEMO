package com.javademo.api.config;


import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestClient configClient(ElasticsearchRestClient elasticsearchRestClient) {
        List<ElasticsearchRestClient.ESServer> esServers = elasticsearchRestClient.getEsServers();
        HttpHost[] hosts = new HttpHost[esServers.size()];
        for (int i = 0; i < esServers.size(); i++) {
            ElasticsearchRestClient.ESServer esServer = esServers.get(i);
            hosts[i] = new HttpHost(esServer.getIpDomain(), esServer.getPort(), esServer.getProtocol());
        }
        return RestClient.builder(hosts)
                .setCompressionEnabled(true)
                .setHttpClientConfigCallback(httpClientBuilder -> {
                    BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
                    basicCredentialsProvider.setCredentials(AuthScope.ANY,
                            new UsernamePasswordCredentials(elasticsearchRestClient.getUsername(), elasticsearchRestClient.getPassword()));
                    try {
                        return httpClientBuilder.setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
                                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                                .setDefaultCredentialsProvider(basicCredentialsProvider);
                    } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
                        throw new RuntimeException(e);
                    }
                })
                .build();
    }
}
