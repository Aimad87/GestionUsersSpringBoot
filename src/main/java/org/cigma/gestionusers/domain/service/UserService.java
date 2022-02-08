package org.cigma.gestionusers.domain.service;

import org.cigma.gestionusers.domain.transferobjects.UserDto;
import org.cigma.gestionusers.domain.transferobjects.UserAnswer;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserAnswer getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
}
