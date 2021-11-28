package com.developers.dmaker.controller;

import com.developers.dmaker.dto.CreateDeveloper;
import com.developers.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
  private final DMakerService dMakerService;

  @GetMapping("/developers")
  public List<String> getAllDevelopers() {
    return Arrays.asList("snow", "Elsa", "Olaf");
  }


  @PostMapping("/create-developer")
  public List<String> createDevelopers(
    @Valid @RequestBody CreateDeveloper.Request request
  ) {

    dMakerService.createDeveloper(request);

    return List.of("Olaf");
  }
}
