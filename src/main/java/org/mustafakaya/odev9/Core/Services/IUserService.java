package org.mustafakaya.odev9.Core.Services;

import org.mustafakaya.odev9.Core.DTO.UserSaveDto;
import org.mustafakaya.odev9.Core.Entity.UserEntity;

import java.util.Optional;


public interface IUserService {
    void save(UserSaveDto userSaveDto);
    Optional<UserEntity> findUserById(Long id);
    UserEntity convertDtoToEntity(UserSaveDto userSaveDto);
}
