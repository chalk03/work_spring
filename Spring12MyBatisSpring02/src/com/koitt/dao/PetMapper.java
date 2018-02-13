package com.koitt.dao;

import org.apache.ibatis.annotations.Select;

import com.koitt.model.Owner;
import com.koitt.model.Pet;

/*
 * 작성한 PetMapper 인터페이스의 경로 (com.koitt.dao.PetMapper)는
 * mapper.xml의 namespace 값과 일치해야한다.
 */

public interface PetMapper {

	/*
	 * 메소드명은 SQL문의 id값과 동일한 것을 찾는다 (id)
	 * 파라미터로 전달하는 값은 SQL문으로 전달된다. (parameterType)
	 * 리턴타입은 resultType 속성과 일치하면 된다. (resultType)
	 */
	public Pet selectPet(Integer petId);
	
	@Select("SELECT * FROM owner WHERE owner_name = #{ownerName}")
	public Owner selectHong(String ownerName);
	
}
