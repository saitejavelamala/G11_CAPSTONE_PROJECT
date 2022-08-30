package com.wipro.doconnect.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.doconnect.chat.entity.Message;
/*@Author:Saumya Raj
 * Modified Date: 29-08-2022
 * Description:Message Repository
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long>
{

}
