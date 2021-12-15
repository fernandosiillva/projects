package com.ms.email.application.ports;

import com.ms.email.application.domain.Email;
import com.ms.email.application.domain.PageInfo;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmailRepositoryPort {

    Email save(Email email);
    List<Email> findAll(PageInfo pageInfo);
    Optional<Email> findById(UUID emailId);
}
