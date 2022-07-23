package com.javademo.es.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "elasticsearch-rest-client")
public class ElasticsearchRestClient {
    private String username;
    private String password;
    List<String> servers;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> serverUrls) {
        this.servers = serverUrls;
    }

    public List<ESServer> getEsServers() {
        List<ESServer> result = new LinkedList<>();
        for (String server : servers) {
            String[] splitArr = server.split(":");
            ESServer esServer = new ESServer();
            switch (splitArr.length) {
                case 2:
                    esServer.setProtocol("http");
                    esServer.setIpDomain(splitArr[0]);
                    esServer.setPort(Integer.parseInt(splitArr[1]));
                    break;
                case 3:
                    esServer.setProtocol(splitArr[0]);
                    esServer.setIpDomain(splitArr[1]);
                    esServer.setPort(Integer.parseInt(splitArr[2]));
                    break;
                default:
                    throw new RuntimeException("servers config error");
            }
            result.add(esServer);

        }
        return result;
    }

    public static class ESServer {
        private String protocol;
        private String ipDomain;
        private int port;

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getIpDomain() {
            return ipDomain;
        }

        public void setIpDomain(String ipDomain) {
            this.ipDomain = ipDomain;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }
}
