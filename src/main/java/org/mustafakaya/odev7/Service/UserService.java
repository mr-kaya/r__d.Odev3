package org.mustafakaya.odev7.Service;

import org.mustafakaya.odev7.Core.DTO.UserSaveDto;
import org.mustafakaya.odev7.Core.Entity.UserEntity;
import org.mustafakaya.odev7.Core.Services.IUserService;
import org.mustafakaya.odev7.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public void save(UserSaveDto userSaveDto) {
         _userRepository.save(convertDtoToEntity(userSaveDto));
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return _userRepository.findById(id);
    }

    @Override
    public UserEntity convertDtoToEntity(UserSaveDto userSaveDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userSaveDto.getName());
        userEntity.setEmail(userSaveDto.getEmail());
        userEntity.setSurname(userSaveDto.getSurname());
        userEntity.setPhoneNumber(userSaveDto.getPhoneNumber());
        return userEntity;
    }
}
