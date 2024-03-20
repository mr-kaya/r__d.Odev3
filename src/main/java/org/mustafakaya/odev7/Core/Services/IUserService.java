package org.mustafakaya.odev7.Core.Services;

import org.mustafakaya.odev7.Core.DTO.UserSaveDto;
import org.mustafakaya.odev7.Core.Entity.UserEntity;

import java.util.Optional;


public interface IUserService {
    void save(UserSaveDto userSaveDto);
    Optional<UserEntity> findUserById(Long id);
    UserEntity convertDtoToEntity(UserSaveDto userSaveDto);
}
