package com.wipro.doconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.doconnect.entity.User;
/*@Author:Arpit Verma
 * Modified Date: 27-08-2022
 * Description:User Repository
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	public User findByEmail(String email);
}
