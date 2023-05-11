package com.example.usermarslargestiamgeservice.controller;

import com.example.usermarslargestiamgeservice.dto.CommandDTO;
import com.example.usermarslargestiamgeservice.feignclient.NasaLargestImageFeignClient;
import com.example.usermarslargestiamgeservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user/largest/image")
public class CommandController {
    private final RabbitTemplate rabbitTemplate;
    private final UserService userService;
    private final NasaLargestImageFeignClient nasaLargestImageFeignClient;
    @Value("${rabbitmq.routing.key}")
    private String RABBIT_KEY;
    @Value("${rabbitmq.exchange.name}")
    private String RABBIT_EXCHANGE;

    @PostMapping
    public ResponseEntity<?> submitCommand(@RequestBody CommandDTO commandDTO) {
        if (userService.isIncorrectCommand(commandDTO)) return ResponseEntity.noContent().build();
        rabbitTemplate.convertAndSend(RABBIT_EXCHANGE, RABBIT_KEY, commandDTO);
        return ResponseEntity.ok("COMMAND_SENT");
    }

    @GetMapping(value = "/{id}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<?> getLargestImage(@PathVariable String id) {
        byte[] image = nasaLargestImageFeignClient.getImage(id);
        return ResponseEntity.ok(image);
    }
    @GetMapping("/hello")
    public String getMessage(){
        return "HELLO";
    }
}
