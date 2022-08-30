package com.wipro.doconnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
/*@Author:Saumya Raj
 * Modified Date: 27-08-2022
 * Description:Image Model Entity
 * Parameters: Id,Name,Image type,Image size
 */
@Entity
@Data
@AllArgsConstructor
public class ImageModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "picByte", length = 1000)
	private byte[] picByte;

	public ImageModel()
	{
		super();
	}

	public ImageModel(String name, String type, byte[] picByte)
	{
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

}
