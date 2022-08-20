package com.titanic.javatest.serializable.jackson;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class JackSonController {

    @PostMapping("/serialize")
    public JackSonResponse serialize(@RequestBody JackSonRequest jackSonRequest) {
        System.out.println(jackSonRequest);
        return new JackSonResponse("success");
    }

    @GetMapping("call")
    public String call() {
        JackSonRequest request = new JackSonRequest("name");
        RestTemplate restTemplate = new RestTemplate();

        JackSonResponse jackSonResponse = restTemplate.postForObject("http://localhost:8080/serialize", request, JackSonResponse.class);
        System.out.println(jackSonResponse);
        return "success";
    }
}
