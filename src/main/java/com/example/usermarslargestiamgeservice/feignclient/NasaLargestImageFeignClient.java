package com.example.usermarslargestiamgeservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://mars-largest-image-service:8080/largest/picture", name = "mars-largest-image-service")
public interface NasaLargestImageFeignClient {
    @GetMapping(value = "/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE})
    byte[] getImage(@PathVariable String id);
}
