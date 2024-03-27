package org.mustafakaya.odev9.Repository;

import org.mustafakaya.odev9.Core.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
