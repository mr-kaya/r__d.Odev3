package org.mustafakaya.odev8.Repository;

import org.mustafakaya.odev8.Core.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
