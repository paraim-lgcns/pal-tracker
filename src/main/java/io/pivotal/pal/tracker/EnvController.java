package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String PORT;
    private String MEMORY_LIMIT;
    private String CF_INSTANCE_INDEX;
    private String CF_INSTANCE_ADDR;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
                         @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr){

        this.PORT = port;
        this.MEMORY_LIMIT = memoryLimit;
        this.CF_INSTANCE_INDEX = cfInstanceIndex;
        this.CF_INSTANCE_ADDR = cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String,String> getEnv() throws Exception {

        Map<String,String> map = new HashMap();
        map.put("PORT", PORT);
        map.put("MEMORY_LIMIT", MEMORY_LIMIT);
        map.put("CF_INSTANCE_INDEX", CF_INSTANCE_INDEX);
        map.put("CF_INSTANCE_ADDR", CF_INSTANCE_ADDR);

        return map;


    }
}

