package org.mustafakaya.odev7.Repository;

import org.mustafakaya.odev7.Core.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
