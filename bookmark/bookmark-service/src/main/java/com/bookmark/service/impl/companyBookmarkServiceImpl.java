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

import com.bookmark.model.companyBookmark;
import com.bookmark.service.base.companyBookmarkServiceBaseImpl;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

/**
 * The implementation of the company bookmark remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bookmark.service.companyBookmarkService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmarkServiceBaseImpl
 * @see com.bookmark.service.companyBookmarkServiceUtil
 */
@ProviderType
public class companyBookmarkServiceImpl extends companyBookmarkServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.bookmark.service.companyBookmarkServiceUtil} to access the company bookmark remote service.
	 */
    @JSONWebService(method = "GET")
    public  companyBookmark addCompanyBookmark(String id, String url, String title, String content) {
       return companyBookmarkLocalService.addCompanyBookmark(id, url, title, content);
    }
    
    @JSONWebService(method = "GET")
    public  companyBookmark deleteCompanyBookmark(String bookmarkId) {
       return companyBookmarkLocalService.deleteCompanyBookmark(bookmarkId);
    }
}