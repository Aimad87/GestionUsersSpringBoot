package org.cigma.gestionusers.data.userint;

import org.cigma.gestionusers.data.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
