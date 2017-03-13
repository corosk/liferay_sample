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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link companyBookmark}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmark
 * @generated
 */
@ProviderType
public class companyBookmarkWrapper implements companyBookmark,
	ModelWrapper<companyBookmark> {
	public companyBookmarkWrapper(companyBookmark companyBookmark) {
		_companyBookmark = companyBookmark;
	}

	@Override
	public Class<?> getModelClass() {
		return companyBookmark.class;
	}

	@Override
	public String getModelClassName() {
		return companyBookmark.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("bookmarkId", getBookmarkId());
		attributes.put("bookmarkUrl", getBookmarkUrl());
		attributes.put("bookmarkTitle", getBookmarkTitle());
		attributes.put("userId", getUserId());
		attributes.put("content", getContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("isDelete", getIsDelete());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String groupId = (String)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String bookmarkId = (String)attributes.get("bookmarkId");

		if (bookmarkId != null) {
			setBookmarkId(bookmarkId);
		}

		String bookmarkUrl = (String)attributes.get("bookmarkUrl");

		if (bookmarkUrl != null) {
			setBookmarkUrl(bookmarkUrl);
		}

		String bookmarkTitle = (String)attributes.get("bookmarkTitle");

		if (bookmarkTitle != null) {
			setBookmarkTitle(bookmarkTitle);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}

		Boolean isDelete = (Boolean)attributes.get("isDelete");

		if (isDelete != null) {
			setIsDelete(isDelete);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _companyBookmark.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _companyBookmark.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _companyBookmark.isNew();
	}

	@Override
	public com.bookmark.model.companyBookmark toEscapedModel() {
		return new companyBookmarkWrapper(_companyBookmark.toEscapedModel());
	}

	@Override
	public com.bookmark.model.companyBookmark toUnescapedModel() {
		return new companyBookmarkWrapper(_companyBookmark.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _companyBookmark.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.bookmark.model.companyBookmark> toCacheModel() {
		return _companyBookmark.toCacheModel();
	}

	@Override
	public int compareTo(com.bookmark.model.companyBookmark companyBookmark) {
		return _companyBookmark.compareTo(companyBookmark);
	}

	@Override
	public int hashCode() {
		return _companyBookmark.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _companyBookmark.getPrimaryKeyObj();
	}

	/**
	* Returns the is delete of this company bookmark.
	*
	* @return the is delete of this company bookmark
	*/
	@Override
	public java.lang.Boolean getIsDelete() {
		return _companyBookmark.getIsDelete();
	}

	/**
	* Returns the user ID of this company bookmark.
	*
	* @return the user ID of this company bookmark
	*/
	@Override
	public java.lang.Long getUserId() {
		return _companyBookmark.getUserId();
	}

	@Override
	public java.lang.Object clone() {
		return new companyBookmarkWrapper((companyBookmark)_companyBookmark.clone());
	}

	/**
	* Returns the bookmark ID of this company bookmark.
	*
	* @return the bookmark ID of this company bookmark
	*/
	@Override
	public java.lang.String getBookmarkId() {
		return _companyBookmark.getBookmarkId();
	}

	/**
	* Returns the bookmark title of this company bookmark.
	*
	* @return the bookmark title of this company bookmark
	*/
	@Override
	public java.lang.String getBookmarkTitle() {
		return _companyBookmark.getBookmarkTitle();
	}

	/**
	* Returns the bookmark url of this company bookmark.
	*
	* @return the bookmark url of this company bookmark
	*/
	@Override
	public java.lang.String getBookmarkUrl() {
		return _companyBookmark.getBookmarkUrl();
	}

	/**
	* Returns the content of this company bookmark.
	*
	* @return the content of this company bookmark
	*/
	@Override
	public java.lang.String getContent() {
		return _companyBookmark.getContent();
	}

	/**
	* Returns the group ID of this company bookmark.
	*
	* @return the group ID of this company bookmark
	*/
	@Override
	public java.lang.String getGroupId() {
		return _companyBookmark.getGroupId();
	}

	/**
	* Returns the primary key of this company bookmark.
	*
	* @return the primary key of this company bookmark
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _companyBookmark.getPrimaryKey();
	}

	@Override
	public java.lang.String toString() {
		return _companyBookmark.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _companyBookmark.toXmlString();
	}

	/**
	* Returns the create date of this company bookmark.
	*
	* @return the create date of this company bookmark
	*/
	@Override
	public Date getCreateDate() {
		return _companyBookmark.getCreateDate();
	}

	/**
	* Returns the update date of this company bookmark.
	*
	* @return the update date of this company bookmark
	*/
	@Override
	public Date getUpdateDate() {
		return _companyBookmark.getUpdateDate();
	}

	/**
	* Returns the company ID of this company bookmark.
	*
	* @return the company ID of this company bookmark
	*/
	@Override
	public long getCompanyId() {
		return _companyBookmark.getCompanyId();
	}

	@Override
	public void persist() {
		_companyBookmark.persist();
	}

	/**
	* Sets the bookmark ID of this company bookmark.
	*
	* @param bookmarkId the bookmark ID of this company bookmark
	*/
	@Override
	public void setBookmarkId(java.lang.String bookmarkId) {
		_companyBookmark.setBookmarkId(bookmarkId);
	}

	/**
	* Sets the bookmark title of this company bookmark.
	*
	* @param bookmarkTitle the bookmark title of this company bookmark
	*/
	@Override
	public void setBookmarkTitle(java.lang.String bookmarkTitle) {
		_companyBookmark.setBookmarkTitle(bookmarkTitle);
	}

	/**
	* Sets the bookmark url of this company bookmark.
	*
	* @param bookmarkUrl the bookmark url of this company bookmark
	*/
	@Override
	public void setBookmarkUrl(java.lang.String bookmarkUrl) {
		_companyBookmark.setBookmarkUrl(bookmarkUrl);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_companyBookmark.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this company bookmark.
	*
	* @param companyId the company ID of this company bookmark
	*/
	@Override
	public void setCompanyId(long companyId) {
		_companyBookmark.setCompanyId(companyId);
	}

	/**
	* Sets the content of this company bookmark.
	*
	* @param content the content of this company bookmark
	*/
	@Override
	public void setContent(java.lang.String content) {
		_companyBookmark.setContent(content);
	}

	/**
	* Sets the create date of this company bookmark.
	*
	* @param createDate the create date of this company bookmark
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_companyBookmark.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_companyBookmark.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_companyBookmark.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_companyBookmark.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this company bookmark.
	*
	* @param groupId the group ID of this company bookmark
	*/
	@Override
	public void setGroupId(java.lang.String groupId) {
		_companyBookmark.setGroupId(groupId);
	}

	/**
	* Sets the is delete of this company bookmark.
	*
	* @param isDelete the is delete of this company bookmark
	*/
	@Override
	public void setIsDelete(java.lang.Boolean isDelete) {
		_companyBookmark.setIsDelete(isDelete);
	}

	@Override
	public void setNew(boolean n) {
		_companyBookmark.setNew(n);
	}

	/**
	* Sets the primary key of this company bookmark.
	*
	* @param primaryKey the primary key of this company bookmark
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_companyBookmark.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_companyBookmark.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the update date of this company bookmark.
	*
	* @param updateDate the update date of this company bookmark
	*/
	@Override
	public void setUpdateDate(Date updateDate) {
		_companyBookmark.setUpdateDate(updateDate);
	}

	/**
	* Sets the user ID of this company bookmark.
	*
	* @param userId the user ID of this company bookmark
	*/
	@Override
	public void setUserId(java.lang.Long userId) {
		_companyBookmark.setUserId(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof companyBookmarkWrapper)) {
			return false;
		}

		companyBookmarkWrapper companyBookmarkWrapper = (companyBookmarkWrapper)obj;

		if (Objects.equals(_companyBookmark,
					companyBookmarkWrapper._companyBookmark)) {
			return true;
		}

		return false;
	}

	@Override
	public companyBookmark getWrappedModel() {
		return _companyBookmark;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _companyBookmark.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _companyBookmark.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_companyBookmark.resetOriginalValues();
	}

	private final companyBookmark _companyBookmark;
}