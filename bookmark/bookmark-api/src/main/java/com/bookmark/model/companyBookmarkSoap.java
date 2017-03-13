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

package com.bookmark.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bookmark.service.http.companyBookmarkServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.bookmark.service.http.companyBookmarkServiceSoap
 * @generated
 */
@ProviderType
public class companyBookmarkSoap implements Serializable {
	public static companyBookmarkSoap toSoapModel(companyBookmark model) {
		companyBookmarkSoap soapModel = new companyBookmarkSoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setBookmarkId(model.getBookmarkId());
		soapModel.setBookmarkUrl(model.getBookmarkUrl());
		soapModel.setBookmarkTitle(model.getBookmarkTitle());
		soapModel.setUserId(model.getUserId());
		soapModel.setContent(model.getContent());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUpdateDate(model.getUpdateDate());
		soapModel.setIsDelete(model.getIsDelete());

		return soapModel;
	}

	public static companyBookmarkSoap[] toSoapModels(companyBookmark[] models) {
		companyBookmarkSoap[] soapModels = new companyBookmarkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static companyBookmarkSoap[][] toSoapModels(
		companyBookmark[][] models) {
		companyBookmarkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new companyBookmarkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new companyBookmarkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static companyBookmarkSoap[] toSoapModels(
		List<companyBookmark> models) {
		List<companyBookmarkSoap> soapModels = new ArrayList<companyBookmarkSoap>(models.size());

		for (companyBookmark model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new companyBookmarkSoap[soapModels.size()]);
	}

	public companyBookmarkSoap() {
	}

	public String getPrimaryKey() {
		return _bookmarkId;
	}

	public void setPrimaryKey(String pk) {
		setBookmarkId(pk);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getGroupId() {
		return _groupId;
	}

	public void setGroupId(String groupId) {
		_groupId = groupId;
	}

	public String getBookmarkId() {
		return _bookmarkId;
	}

	public void setBookmarkId(String bookmarkId) {
		_bookmarkId = bookmarkId;
	}

	public String getBookmarkUrl() {
		return _bookmarkUrl;
	}

	public void setBookmarkUrl(String bookmarkUrl) {
		_bookmarkUrl = bookmarkUrl;
	}

	public String getBookmarkTitle() {
		return _bookmarkTitle;
	}

	public void setBookmarkTitle(String bookmarkTitle) {
		_bookmarkTitle = bookmarkTitle;
	}

	public Long getUserId() {
		return _userId;
	}

	public void setUserId(Long userId) {
		_userId = userId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	public Boolean getIsDelete() {
		return _isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		_isDelete = isDelete;
	}

	private long _companyId;
	private String _groupId;
	private String _bookmarkId;
	private String _bookmarkUrl;
	private String _bookmarkTitle;
	private Long _userId;
	private String _content;
	private Date _createDate;
	private Date _updateDate;
	private Boolean _isDelete;
}