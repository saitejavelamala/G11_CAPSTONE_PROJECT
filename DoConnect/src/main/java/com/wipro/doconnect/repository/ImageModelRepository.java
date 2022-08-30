package com.wipro.doconnect.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.doconnect.entity.ImageModel;
/*@Author:Saumya Raj
 * Modified Date: 27-08-2022
 * Description:Image Model Repository
 */
@Repository
public interface ImageModelRepository extends JpaRepository<ImageModel, Long>
{
	public Optional<ImageModel> findByName(String name);
}
