package de.tdlabs.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
class BackendGreetingResource {

  @GetMapping
  Object greet(String name){
    Map<String,Object> data = new HashMap<>();
    data.put("greeting", "Hello " + name);
    data.put("timestamp", LocalDateTime.now());
    data.put("nodeId", ManagementFactory.getRuntimeMXBean().getName());
    return data;
  }
}
