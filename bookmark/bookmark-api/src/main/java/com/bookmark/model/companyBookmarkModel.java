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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the companyBookmark service. Represents a row in the &quot;active_companyBookmark&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.bookmark.model.impl.companyBookmarkModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.bookmark.model.impl.companyBookmarkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmark
 * @see com.bookmark.model.impl.companyBookmarkImpl
 * @see com.bookmark.model.impl.companyBookmarkModelImpl
 * @generated
 */
@ProviderType
public interface companyBookmarkModel extends BaseModel<companyBookmark>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a company bookmark model instance should use the {@link companyBookmark} interface instead.
	 */

	/**
	 * Returns the primary key of this company bookmark.
	 *
	 * @return the primary key of this company bookmark
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this company bookmark.
	 *
	 * @param primaryKey the primary key of this company bookmark
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the company ID of this company bookmark.
	 *
	 * @return the company ID of this company bookmark
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this company bookmark.
	 *
	 * @param companyId the company ID of this company bookmark
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this company bookmark.
	 *
	 * @return the group ID of this company bookmark
	 */
	@AutoEscape
	public String getGroupId();

	/**
	 * Sets the group ID of this company bookmark.
	 *
	 * @param groupId the group ID of this company bookmark
	 */
	public void setGroupId(String groupId);

	/**
	 * Returns the bookmark ID of this company bookmark.
	 *
	 * @return the bookmark ID of this company bookmark
	 */
	@AutoEscape
	public String getBookmarkId();

	/**
	 * Sets the bookmark ID of this company bookmark.
	 *
	 * @param bookmarkId the bookmark ID of this company bookmark
	 */
	public void setBookmarkId(String bookmarkId);

	/**
	 * Returns the bookmark url of this company bookmark.
	 *
	 * @return the bookmark url of this company bookmark
	 */
	@AutoEscape
	public String getBookmarkUrl();

	/**
	 * Sets the bookmark url of this company bookmark.
	 *
	 * @param bookmarkUrl the bookmark url of this company bookmark
	 */
	public void setBookmarkUrl(String bookmarkUrl);

	/**
	 * Returns the bookmark title of this company bookmark.
	 *
	 * @return the bookmark title of this company bookmark
	 */
	@AutoEscape
	public String getBookmarkTitle();

	/**
	 * Sets the bookmark title of this company bookmark.
	 *
	 * @param bookmarkTitle the bookmark title of this company bookmark
	 */
	public void setBookmarkTitle(String bookmarkTitle);

	/**
	 * Returns the user ID of this company bookmark.
	 *
	 * @return the user ID of this company bookmark
	 */
	public Long getUserId();

	/**
	 * Sets the user ID of this company bookmark.
	 *
	 * @param userId the user ID of this company bookmark
	 */
	public void setUserId(Long userId);

	/**
	 * Returns the content of this company bookmark.
	 *
	 * @return the content of this company bookmark
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this company bookmark.
	 *
	 * @param content the content of this company bookmark
	 */
	public void setContent(String content);

	/**
	 * Returns the create date of this company bookmark.
	 *
	 * @return the create date of this company bookmark
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this company bookmark.
	 *
	 * @param createDate the create date of this company bookmark
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the update date of this company bookmark.
	 *
	 * @return the update date of this company bookmark
	 */
	public Date getUpdateDate();

	/**
	 * Sets the update date of this company bookmark.
	 *
	 * @param updateDate the update date of this company bookmark
	 */
	public void setUpdateDate(Date updateDate);

	/**
	 * Returns the is delete of this company bookmark.
	 *
	 * @return the is delete of this company bookmark
	 */
	public Boolean getIsDelete();

	/**
	 * Sets the is delete of this company bookmark.
	 *
	 * @param isDelete the is delete of this company bookmark
	 */
	public void setIsDelete(Boolean isDelete);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.bookmark.model.companyBookmark companyBookmark);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.bookmark.model.companyBookmark> toCacheModel();

	@Override
	public com.bookmark.model.companyBookmark toEscapedModel();

	@Override
	public com.bookmark.model.companyBookmark toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}