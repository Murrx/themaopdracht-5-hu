/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 24 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model.validators;

import java.util.List;

public interface ValidatorInterface<T> {

	List<AttributeError> validate(T obj);
}
