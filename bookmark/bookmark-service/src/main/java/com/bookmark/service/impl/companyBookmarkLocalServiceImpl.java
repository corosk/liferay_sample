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

import java.util.Date;

import com.bookmark.model.companyBookmark;
import com.bookmark.service.companyBookmarkLocalServiceUtil;
import com.bookmark.service.base.companyBookmarkLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the company bookmark local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bookmark.service.companyBookmarkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmarkLocalServiceBaseImpl
 * @see com.bookmark.service.companyBookmarkLocalServiceUtil
 */
@ProviderType
public class companyBookmarkLocalServiceImpl extends companyBookmarkLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link
     * com.bookmark.service.companyBookmarkLocalServiceUtil} to access the
     * company bookmark local service.
     */
    public companyBookmark addCompanyBookmark(String id, String url, String title, String content) {
	int no = companyBookmarkLocalServiceUtil.getcompanyBookmarksCount() + 1;
	companyBookmark companyMark = companyBookmarkLocalServiceUtil.createcompanyBookmark(String.valueOf(no));
	// ユーザーID
	companyMark.setUserId(Long.parseLong(id));
	// ブックマークID
	companyMark.setBookmarkId(String.valueOf(no));
	// タイトル
	companyMark.setBookmarkTitle(title);
	// 登録URL
	companyMark.setBookmarkUrl(url);
	// 説明
	companyMark.setContent(content);
	// 登録更新日時
	Date registryDate = new Date();
	companyMark.setCreateDate(registryDate);
	companyMark.setUpdateDate(registryDate);
	// デリートフラグ
	companyMark.setIsDelete(false);
	// 部門番号（現在、未実装のため1固定）
	companyMark.setGroupId("1");
	return companyBookmarkLocalServiceUtil.addcompanyBookmark(companyMark);
    }

    public companyBookmark deleteCompanyBookmark(String bookmarkId) {
	companyBookmark companyMark = null;
	try {
	    companyMark = companyBookmarkLocalServiceUtil.getcompanyBookmark(bookmarkId);
	} catch (PortalException e) {
	    e.printStackTrace();
	}
	// デリートフラグ
	companyMark.setIsDelete(true);
	return companyBookmarkLocalServiceUtil.updatecompanyBookmark(companyMark);
    }
}