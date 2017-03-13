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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing companyBookmark in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmark
 * @generated
 */
@ProviderType
public class companyBookmarkCacheModel implements CacheModel<companyBookmark>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof companyBookmarkCacheModel)) {
			return false;
		}

		companyBookmarkCacheModel companyBookmarkCacheModel = (companyBookmarkCacheModel)obj;

		if (bookmarkId.equals(companyBookmarkCacheModel.bookmarkId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookmarkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", bookmarkId=");
		sb.append(bookmarkId);
		sb.append(", bookmarkUrl=");
		sb.append(bookmarkUrl);
		sb.append(", bookmarkTitle=");
		sb.append(bookmarkTitle);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", isDelete=");
		sb.append(isDelete);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public companyBookmark toEntityModel() {
		companyBookmarkImpl companyBookmarkImpl = new companyBookmarkImpl();

		companyBookmarkImpl.setCompanyId(companyId);

		if (groupId == null) {
			companyBookmarkImpl.setGroupId(StringPool.BLANK);
		}
		else {
			companyBookmarkImpl.setGroupId(groupId);
		}

		if (bookmarkId == null) {
			companyBookmarkImpl.setBookmarkId(StringPool.BLANK);
		}
		else {
			companyBookmarkImpl.setBookmarkId(bookmarkId);
		}

		if (bookmarkUrl == null) {
			companyBookmarkImpl.setBookmarkUrl(StringPool.BLANK);
		}
		else {
			companyBookmarkImpl.setBookmarkUrl(bookmarkUrl);
		}

		if (bookmarkTitle == null) {
			companyBookmarkImpl.setBookmarkTitle(StringPool.BLANK);
		}
		else {
			companyBookmarkImpl.setBookmarkTitle(bookmarkTitle);
		}

		companyBookmarkImpl.setUserId(userId);

		if (content == null) {
			companyBookmarkImpl.setContent(StringPool.BLANK);
		}
		else {
			companyBookmarkImpl.setContent(content);
		}

		if (createDate == Long.MIN_VALUE) {
			companyBookmarkImpl.setCreateDate(null);
		}
		else {
			companyBookmarkImpl.setCreateDate(new Date(createDate));
		}

		if (updateDate == Long.MIN_VALUE) {
			companyBookmarkImpl.setUpdateDate(null);
		}
		else {
			companyBookmarkImpl.setUpdateDate(new Date(updateDate));
		}

		companyBookmarkImpl.setIsDelete(isDelete);

		companyBookmarkImpl.resetOriginalValues();

		return companyBookmarkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();
		groupId = objectInput.readUTF();
		bookmarkId = objectInput.readUTF();
		bookmarkUrl = objectInput.readUTF();
		bookmarkTitle = objectInput.readUTF();

		userId = objectInput.readLong();
		content = objectInput.readUTF();
		createDate = objectInput.readLong();
		updateDate = objectInput.readLong();

		isDelete = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyId);

		if (groupId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupId);
		}

		if (bookmarkId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookmarkId);
		}

		if (bookmarkUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookmarkUrl);
		}

		if (bookmarkTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookmarkTitle);
		}

		objectOutput.writeLong(userId);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(updateDate);

		objectOutput.writeBoolean(isDelete);
	}

	public long companyId;
	public String groupId;
	public String bookmarkId;
	public String bookmarkUrl;
	public String bookmarkTitle;
	public long userId;
	public String content;
	public long createDate;
	public long updateDate;
	public boolean isDelete;
}