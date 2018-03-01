package jdg.client;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.exceptions.TransportException;

public class UnknownHosts {

   public static void main(String[] args) throws InterruptedException {
      ConfigurationBuilder cfg = new ConfigurationBuilder();
      cfg.addServers("127.0.0.1:11222; 127.0.0.2:11222; 127.0.0.2:11222; 127.0.0.3:11222; 127.0.0.4:11222;");
      RemoteCacheManager cacheContainer = new RemoteCacheManager(cfg.build());

      try {
         //obtain a handle to the remote default cache
         RemoteCache<String, String> cache = cacheContainer.getCache();
      } catch (TransportException e) {
         while (true)
            Thread.sleep(10000);
      }
   }

}
