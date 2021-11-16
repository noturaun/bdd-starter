package util;

import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configs {
    private static final Logger log = LoggerFactory.getLogger("Configs");
    private static Config conf;

    public static Config getConfig(){
        if (conf == null){
            conf = ConfigFactory.parseResources("browser.conf");
        }
        return conf;
    }
}
