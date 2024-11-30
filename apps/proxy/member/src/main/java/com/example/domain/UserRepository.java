package com.example.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<NsUser> findByUserId(String userId);
}
