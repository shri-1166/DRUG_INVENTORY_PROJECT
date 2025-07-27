package drug.inventory.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import drug.inventory.management_system.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
