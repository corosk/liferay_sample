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

package com.bookmark.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.bookmark.model.companyBookmark;
import com.bookmark.model.companyBookmarkModel;
import com.bookmark.model.companyBookmarkSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the companyBookmark service. Represents a row in the &quot;active_companyBookmark&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link companyBookmarkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link companyBookmarkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmarkImpl
 * @see companyBookmark
 * @see companyBookmarkModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class companyBookmarkModelImpl extends BaseModelImpl<companyBookmark>
	implements companyBookmarkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a company bookmark model instance should use the {@link companyBookmark} interface instead.
	 */
	public static final String TABLE_NAME = "active_companyBookmark";
	public static final Object[][] TABLE_COLUMNS = {
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.VARCHAR },
			{ "bookmarkId", Types.VARCHAR },
			{ "bookmarkUrl", Types.VARCHAR },
			{ "bookmarkTitle", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "content", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "updateDate", Types.TIMESTAMP },
			{ "isDelete", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookmarkId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookmarkUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookmarkTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updateDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("isDelete", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table active_companyBookmark (companyId LONG,groupId VARCHAR(75) null,bookmarkId VARCHAR(75) not null primary key,bookmarkUrl VARCHAR(75) null,bookmarkTitle VARCHAR(75) null,userId LONG,content VARCHAR(75) null,createDate DATE null,updateDate DATE null,isDelete BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table active_companyBookmark";
	public static final String ORDER_BY_JPQL = " ORDER BY companyBookmark.bookmarkId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY active_companyBookmark.bookmarkId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.bookmark.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.bookmark.model.companyBookmark"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.bookmark.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.bookmark.model.companyBookmark"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.bookmark.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.bookmark.model.companyBookmark"),
			true);
	public static final long BOOKMARKID_COLUMN_BITMASK = 1L;
	public static final long BOOKMARKTITLE_COLUMN_BITMASK = 2L;
	public static final long BOOKMARKURL_COLUMN_BITMASK = 4L;
	public static final long USERID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static companyBookmark toModel(companyBookmarkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		companyBookmark model = new companyBookmarkImpl();

		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setBookmarkId(soapModel.getBookmarkId());
		model.setBookmarkUrl(soapModel.getBookmarkUrl());
		model.setBookmarkTitle(soapModel.getBookmarkTitle());
		model.setUserId(soapModel.getUserId());
		model.setContent(soapModel.getContent());
		model.setCreateDate(soapModel.getCreateDate());
		model.setUpdateDate(soapModel.getUpdateDate());
		model.setIsDelete(soapModel.getIsDelete());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<companyBookmark> toModels(
		companyBookmarkSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<companyBookmark> models = new ArrayList<companyBookmark>(soapModels.length);

		for (companyBookmarkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.bookmark.service.util.PropsUtil.get(
				"lock.expiration.time.com.bookmark.model.companyBookmark"));

	public companyBookmarkModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _bookmarkId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setBookmarkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookmarkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public String getGroupId() {
		if (_groupId == null) {
			return StringPool.BLANK;
		}
		else {
			return _groupId;
		}
	}

	@Override
	public void setGroupId(String groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public String getBookmarkId() {
		if (_bookmarkId == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookmarkId;
		}
	}

	@Override
	public void setBookmarkId(String bookmarkId) {
		_columnBitmask |= BOOKMARKID_COLUMN_BITMASK;

		if (_originalBookmarkId == null) {
			_originalBookmarkId = _bookmarkId;
		}

		_bookmarkId = bookmarkId;
	}

	public String getOriginalBookmarkId() {
		return GetterUtil.getString(_originalBookmarkId);
	}

	@JSON
	@Override
	public String getBookmarkUrl() {
		if (_bookmarkUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookmarkUrl;
		}
	}

	@Override
	public void setBookmarkUrl(String bookmarkUrl) {
		_columnBitmask |= BOOKMARKURL_COLUMN_BITMASK;

		if (_originalBookmarkUrl == null) {
			_originalBookmarkUrl = _bookmarkUrl;
		}

		_bookmarkUrl = bookmarkUrl;
	}

	public String getOriginalBookmarkUrl() {
		return GetterUtil.getString(_originalBookmarkUrl);
	}

	@JSON
	@Override
	public String getBookmarkTitle() {
		if (_bookmarkTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookmarkTitle;
		}
	}

	@Override
	public void setBookmarkTitle(String bookmarkTitle) {
		_columnBitmask |= BOOKMARKTITLE_COLUMN_BITMASK;

		if (_originalBookmarkTitle == null) {
			_originalBookmarkTitle = _bookmarkTitle;
		}

		_bookmarkTitle = bookmarkTitle;
	}

	public String getOriginalBookmarkTitle() {
		return GetterUtil.getString(_originalBookmarkTitle);
	}

	@JSON
	@Override
	public Long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(Long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public Long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	@JSON
	@Override
	public Boolean getIsDelete() {
		return _isDelete;
	}

	@Override
	public void setIsDelete(Boolean isDelete) {
		_isDelete = isDelete;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public companyBookmark toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (companyBookmark)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		companyBookmarkImpl companyBookmarkImpl = new companyBookmarkImpl();

		companyBookmarkImpl.setCompanyId(getCompanyId());
		companyBookmarkImpl.setGroupId(getGroupId());
		companyBookmarkImpl.setBookmarkId(getBookmarkId());
		companyBookmarkImpl.setBookmarkUrl(getBookmarkUrl());
		companyBookmarkImpl.setBookmarkTitle(getBookmarkTitle());
		companyBookmarkImpl.setUserId(getUserId());
		companyBookmarkImpl.setContent(getContent());
		companyBookmarkImpl.setCreateDate(getCreateDate());
		companyBookmarkImpl.setUpdateDate(getUpdateDate());
		companyBookmarkImpl.setIsDelete(getIsDelete());

		companyBookmarkImpl.resetOriginalValues();

		return companyBookmarkImpl;
	}

	@Override
	public int compareTo(companyBookmark companyBookmark) {
		String primaryKey = companyBookmark.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof companyBookmark)) {
			return false;
		}

		companyBookmark companyBookmark = (companyBookmark)obj;

		String primaryKey = companyBookmark.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		companyBookmarkModelImpl companyBookmarkModelImpl = this;

		companyBookmarkModelImpl._originalBookmarkId = companyBookmarkModelImpl._bookmarkId;

		companyBookmarkModelImpl._originalBookmarkUrl = companyBookmarkModelImpl._bookmarkUrl;

		companyBookmarkModelImpl._originalBookmarkTitle = companyBookmarkModelImpl._bookmarkTitle;

		companyBookmarkModelImpl._originalUserId = companyBookmarkModelImpl._userId;

		companyBookmarkModelImpl._setOriginalUserId = false;

		companyBookmarkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<companyBookmark> toCacheModel() {
		companyBookmarkCacheModel companyBookmarkCacheModel = new companyBookmarkCacheModel();

		companyBookmarkCacheModel.companyId = getCompanyId();

		companyBookmarkCacheModel.groupId = getGroupId();

		String groupId = companyBookmarkCacheModel.groupId;

		if ((groupId != null) && (groupId.length() == 0)) {
			companyBookmarkCacheModel.groupId = null;
		}

		companyBookmarkCacheModel.bookmarkId = getBookmarkId();

		String bookmarkId = companyBookmarkCacheModel.bookmarkId;

		if ((bookmarkId != null) && (bookmarkId.length() == 0)) {
			companyBookmarkCacheModel.bookmarkId = null;
		}

		companyBookmarkCacheModel.bookmarkUrl = getBookmarkUrl();

		String bookmarkUrl = companyBookmarkCacheModel.bookmarkUrl;

		if ((bookmarkUrl != null) && (bookmarkUrl.length() == 0)) {
			companyBookmarkCacheModel.bookmarkUrl = null;
		}

		companyBookmarkCacheModel.bookmarkTitle = getBookmarkTitle();

		String bookmarkTitle = companyBookmarkCacheModel.bookmarkTitle;

		if ((bookmarkTitle != null) && (bookmarkTitle.length() == 0)) {
			companyBookmarkCacheModel.bookmarkTitle = null;
		}

		companyBookmarkCacheModel.userId = getUserId();

		companyBookmarkCacheModel.content = getContent();

		String content = companyBookmarkCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			companyBookmarkCacheModel.content = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			companyBookmarkCacheModel.createDate = createDate.getTime();
		}
		else {
			companyBookmarkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date updateDate = getUpdateDate();

		if (updateDate != null) {
			companyBookmarkCacheModel.updateDate = updateDate.getTime();
		}
		else {
			companyBookmarkCacheModel.updateDate = Long.MIN_VALUE;
		}

		companyBookmarkCacheModel.isDelete = getIsDelete();

		return companyBookmarkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", bookmarkId=");
		sb.append(getBookmarkId());
		sb.append(", bookmarkUrl=");
		sb.append(getBookmarkUrl());
		sb.append(", bookmarkTitle=");
		sb.append(getBookmarkTitle());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append(", isDelete=");
		sb.append(getIsDelete());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.bookmark.model.companyBookmark");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookmarkId</column-name><column-value><![CDATA[");
		sb.append(getBookmarkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookmarkUrl</column-name><column-value><![CDATA[");
		sb.append(getBookmarkUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookmarkTitle</column-name><column-value><![CDATA[");
		sb.append(getBookmarkTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDate</column-name><column-value><![CDATA[");
		sb.append(getUpdateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDelete</column-name><column-value><![CDATA[");
		sb.append(getIsDelete());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = companyBookmark.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			companyBookmark.class
		};
	private long _companyId;
	private String _groupId;
	private String _bookmarkId;
	private String _originalBookmarkId;
	private String _bookmarkUrl;
	private String _originalBookmarkUrl;
	private String _bookmarkTitle;
	private String _originalBookmarkTitle;
	private Long _userId;
	private Long _originalUserId;
	private boolean _setOriginalUserId;
	private String _content;
	private Date _createDate;
	private Date _updateDate;
	private Boolean _isDelete;
	private long _columnBitmask;
	private companyBookmark _escapedModel;
}