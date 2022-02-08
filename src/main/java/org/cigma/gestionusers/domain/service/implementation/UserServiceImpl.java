package org.cigma.gestionusers.domain.service.implementation;

import org.cigma.gestionusers.data.users.User;
import org.cigma.gestionusers.data.userint.UserRepo;
import org.cigma.gestionusers.domain.transferobjects.UserDto;
import org.cigma.gestionusers.domain.transferobjects.UserAnswer;
import org.cigma.gestionusers.domain.service.UserService;
import org.cigma.gestionusers.domain.service.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
          this.userRepo = userRepo;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // DTO to entity
        User user = UserMapper.mapToEntity(userDto);
        User newUser = userRepo.save(user);

        // Entity to DTO
        UserDto userResponse = UserMapper.mapToDTO(newUser);
        return userResponse;
    }

    @Override
    public UserAnswer getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> users = userRepo.findAll(pageable);

        // get content for page object
        List<User> listOfUsers = users.getContent();
        List<UserDto> content= listOfUsers.stream().map(user -> UserMapper.mapToDTO(user)).collect(Collectors.toList());

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setContent(content);
        userAnswer.setPageNo(users.getNumber());
        userAnswer.setPageSize(users.getSize());
        userAnswer.setTotalElements(users.getTotalElements());
        userAnswer.setTotalPages(users.getTotalPages());
        userAnswer.setLast(users.isLast());

        return userAnswer;
    }


}