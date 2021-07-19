
package com.abc.film.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * Hotelsys的基础对象
 * 
 * @author joeyang ong
 *
 */
public abstract class ValueObject {
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
