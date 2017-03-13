/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bookmark.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.bookmark.service.base.companyBookmarkLocalServiceBaseImpl;

/**
 * The implementation of the company bookmark local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bookmark.service.companyBookmarkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmarkLocalServiceBaseImpl
 * @see com.bookmark.service.companyBookmarkLocalServiceUtil
 */
@ProviderType
public class companyBookmarkLocalServiceImpl
	extends companyBookmarkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.bookmark.service.companyBookmarkLocalServiceUtil} to access the company bookmark local service.
	 */
    	public String getHelloWorld() {
    	    return "Hello World";
    	}
}