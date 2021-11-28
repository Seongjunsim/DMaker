package com.developers.dmaker.service;

import com.developers.dmaker.dto.CreateDeveloper;
import com.developers.dmaker.entity.Developer;
import com.developers.dmaker.exception.DMakeErrorCode;
import com.developers.dmaker.exception.DMakeException;
import com.developers.dmaker.repository.DeveloperRepository;
import com.developers.dmaker.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DMakerService {
  private final DeveloperRepository developerRepository;

  @Transactional
  public void createDeveloper(CreateDeveloper.Request request){

    validateCreateDeveloperRequest(request);

    Developer developer = Developer.builder()
      .developerLevel(DeveloperLevel.JUNIOR)
      .experienceYears(2)
      .name("Olaf")
      .age(5)
      .build();
    developerRepository.save(developer);
  }

  private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
    // business validation
    if(request.getDeveloperLevel() == DeveloperLevel.SENIER
      && request.getExperienceYears() < 10){
      throw new DMakeException(DMakeErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
    }

    developerRepository.findByMemberId(request.getMemberId())
      .ifPresent((developer -> {
        throw new DMakeException(DMakeErrorCode.DUPLICATED_MEMBER_ID);
      }));



  }

}
