package com.wipro.doconnect.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.wipro.doconnect.entity.Question;
/*@Author:Gaurav Pal
 * Modified Date: 27-08-2022
 * Description:Question Repository
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>
{
	@Query("from Question where isApproved = false")
	public List<Question> findByIsApproved();

	@Query("from Question where isApproved = true")
	public List<Question> findByIsApprovedTrue();

	@Query("from Question where topic =?1 and isApproved = true")
	public List<Question> findByTopicAndApproved(String topic);
}
