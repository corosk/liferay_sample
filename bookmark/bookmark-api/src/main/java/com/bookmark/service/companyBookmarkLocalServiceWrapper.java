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

package com.bookmark.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link companyBookmarkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmarkLocalService
 * @generated
 */
@ProviderType
public class companyBookmarkLocalServiceWrapper
	implements companyBookmarkLocalService,
		ServiceWrapper<companyBookmarkLocalService> {
	public companyBookmarkLocalServiceWrapper(
		companyBookmarkLocalService companyBookmarkLocalService) {
		_companyBookmarkLocalService = companyBookmarkLocalService;
	}

	/**
	* Adds the company bookmark to the database. Also notifies the appropriate model listeners.
	*
	* @param companyBookmark the company bookmark
	* @return the company bookmark that was added
	*/
	@Override
	public com.bookmark.model.companyBookmark addcompanyBookmark(
		com.bookmark.model.companyBookmark companyBookmark) {
		return _companyBookmarkLocalService.addcompanyBookmark(companyBookmark);
	}

	/**
	* Creates a new company bookmark with the primary key. Does not add the company bookmark to the database.
	*
	* @param bookmarkId the primary key for the new company bookmark
	* @return the new company bookmark
	*/
	@Override
	public com.bookmark.model.companyBookmark createcompanyBookmark(
		java.lang.String bookmarkId) {
		return _companyBookmarkLocalService.createcompanyBookmark(bookmarkId);
	}

	/**
	* Deletes the company bookmark from the database. Also notifies the appropriate model listeners.
	*
	* @param companyBookmark the company bookmark
	* @return the company bookmark that was removed
	*/
	@Override
	public com.bookmark.model.companyBookmark deletecompanyBookmark(
		com.bookmark.model.companyBookmark companyBookmark) {
		return _companyBookmarkLocalService.deletecompanyBookmark(companyBookmark);
	}

	/**
	* Deletes the company bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark that was removed
	* @throws PortalException if a company bookmark with the primary key could not be found
	*/
	@Override
	public com.bookmark.model.companyBookmark deletecompanyBookmark(
		java.lang.String bookmarkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyBookmarkLocalService.deletecompanyBookmark(bookmarkId);
	}

	@Override
	public com.bookmark.model.companyBookmark fetchcompanyBookmark(
		java.lang.String bookmarkId) {
		return _companyBookmarkLocalService.fetchcompanyBookmark(bookmarkId);
	}

	/**
	* Returns the company bookmark with the primary key.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark
	* @throws PortalException if a company bookmark with the primary key could not be found
	*/
	@Override
	public com.bookmark.model.companyBookmark getcompanyBookmark(
		java.lang.String bookmarkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyBookmarkLocalService.getcompanyBookmark(bookmarkId);
	}

	/**
	* Updates the company bookmark in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param companyBookmark the company bookmark
	* @return the company bookmark that was updated
	*/
	@Override
	public com.bookmark.model.companyBookmark updatecompanyBookmark(
		com.bookmark.model.companyBookmark companyBookmark) {
		return _companyBookmarkLocalService.updatecompanyBookmark(companyBookmark);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _companyBookmarkLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyBookmarkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _companyBookmarkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of company bookmarks.
	*
	* @return the number of company bookmarks
	*/
	@Override
	public int getcompanyBookmarksCount() {
		return _companyBookmarkLocalService.getcompanyBookmarksCount();
	}

	@Override
	public java.lang.String getHelloWorld() {
		return _companyBookmarkLocalService.getHelloWorld();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _companyBookmarkLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _companyBookmarkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bookmark.model.impl.companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _companyBookmarkLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bookmark.model.impl.companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _companyBookmarkLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the company bookmarks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bookmark.model.impl.companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @return the range of company bookmarks
	*/
	@Override
	public java.util.List<com.bookmark.model.companyBookmark> getcompanyBookmarks(
		int start, int end) {
		return _companyBookmarkLocalService.getcompanyBookmarks(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _companyBookmarkLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _companyBookmarkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public companyBookmarkLocalService getWrappedService() {
		return _companyBookmarkLocalService;
	}

	@Override
	public void setWrappedService(
		companyBookmarkLocalService companyBookmarkLocalService) {
		_companyBookmarkLocalService = companyBookmarkLocalService;
	}

	private companyBookmarkLocalService _companyBookmarkLocalService;
}