package de.tdlabs.training;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/greeting")
class FrontendGreetingResource {

  private final RestTemplate restTemplate;

  @GetMapping
  Object greet(@RequestParam(defaultValue = "World") String name) {

    log.info("Sending greeting request to backend for {}", name);

    Map<String, Object> data = restTemplate.getForObject("http://tdlabs-backend/greeting?name={name}", Map.class, name);

    log.info("Got response from backend {}", data);

    return data;
  }
}
