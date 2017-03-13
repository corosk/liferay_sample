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

package com.bookmark.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.bookmark.model.companyBookmark;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the company bookmark service. This utility wraps {@link com.bookmark.service.persistence.impl.companyBookmarkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmarkPersistence
 * @see com.bookmark.service.persistence.impl.companyBookmarkPersistenceImpl
 * @generated
 */
@ProviderType
public class companyBookmarkUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(companyBookmark companyBookmark) {
		getPersistence().clearCache(companyBookmark);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<companyBookmark> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<companyBookmark> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<companyBookmark> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static companyBookmark update(companyBookmark companyBookmark) {
		return getPersistence().update(companyBookmark);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static companyBookmark update(companyBookmark companyBookmark,
		ServiceContext serviceContext) {
		return getPersistence().update(companyBookmark, serviceContext);
	}

	/**
	* Returns all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @return the matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle) {
		return getPersistence()
				   .findBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle);
	}

	/**
	* Returns a range of all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @return the range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle, int start, int end) {
		return getPersistence()
				   .findBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle,
			start, end);
	}

	/**
	* Returns an ordered range of all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .findBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first company bookmark in the ordered set where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarkId_First(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarkId_First(bookmarkId, bookmarkUrl,
			bookmarkTitle, orderByComparator);
	}

	/**
	* Returns the first company bookmark in the ordered set where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarkId_First(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarkId_First(bookmarkId, bookmarkUrl,
			bookmarkTitle, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarkId_Last(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarkId_Last(bookmarkId, bookmarkUrl,
			bookmarkTitle, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarkId_Last(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarkId_Last(bookmarkId, bookmarkUrl,
			bookmarkTitle, orderByComparator);
	}

	/**
	* Removes all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63; from the database.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	*/
	public static void removeBybookmarkId(java.lang.String bookmarkId,
		java.lang.String bookmarkUrl, java.lang.String bookmarkTitle) {
		getPersistence()
			.removeBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle);
	}

	/**
	* Returns the number of company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @return the number of matching company bookmarks
	*/
	public static int countBybookmarkId(java.lang.String bookmarkId,
		java.lang.String bookmarkUrl, java.lang.String bookmarkTitle) {
		return getPersistence()
				   .countBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle);
	}

	/**
	* Returns all the company bookmarks where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @return the matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl) {
		return getPersistence().findBybookmarkUrl(bookmarkUrl);
	}

	/**
	* Returns a range of all the company bookmarks where bookmarkUrl = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkUrl the bookmark url
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @return the range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl, int start, int end) {
		return getPersistence().findBybookmarkUrl(bookmarkUrl, start, end);
	}

	/**
	* Returns an ordered range of all the company bookmarks where bookmarkUrl = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkUrl the bookmark url
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .findBybookmarkUrl(bookmarkUrl, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the company bookmarks where bookmarkUrl = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkUrl the bookmark url
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybookmarkUrl(bookmarkUrl, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarkUrl_First(
		java.lang.String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarkUrl_First(bookmarkUrl, orderByComparator);
	}

	/**
	* Returns the first company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarkUrl_First(
		java.lang.String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarkUrl_First(bookmarkUrl, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarkUrl_Last(
		java.lang.String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarkUrl_Last(bookmarkUrl, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarkUrl_Last(
		java.lang.String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarkUrl_Last(bookmarkUrl, orderByComparator);
	}

	/**
	* Returns the company bookmarks before and after the current company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkId the primary key of the current company bookmark
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public static companyBookmark[] findBybookmarkUrl_PrevAndNext(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarkUrl_PrevAndNext(bookmarkId, bookmarkUrl,
			orderByComparator);
	}

	/**
	* Removes all the company bookmarks where bookmarkUrl = &#63; from the database.
	*
	* @param bookmarkUrl the bookmark url
	*/
	public static void removeBybookmarkUrl(java.lang.String bookmarkUrl) {
		getPersistence().removeBybookmarkUrl(bookmarkUrl);
	}

	/**
	* Returns the number of company bookmarks where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @return the number of matching company bookmarks
	*/
	public static int countBybookmarkUrl(java.lang.String bookmarkUrl) {
		return getPersistence().countBybookmarkUrl(bookmarkUrl);
	}

	/**
	* Returns all the company bookmarks where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @return the matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle) {
		return getPersistence().findBybookmarTitle(bookmarkTitle);
	}

	/**
	* Returns a range of all the company bookmarks where bookmarkTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkTitle the bookmark title
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @return the range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle, int start, int end) {
		return getPersistence().findBybookmarTitle(bookmarkTitle, start, end);
	}

	/**
	* Returns an ordered range of all the company bookmarks where bookmarkTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkTitle the bookmark title
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .findBybookmarTitle(bookmarkTitle, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the company bookmarks where bookmarkTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookmarkTitle the bookmark title
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybookmarTitle(bookmarkTitle, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarTitle_First(
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarTitle_First(bookmarkTitle, orderByComparator);
	}

	/**
	* Returns the first company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarTitle_First(
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarTitle_First(bookmarkTitle, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarTitle_Last(
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarTitle_Last(bookmarkTitle, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarTitle_Last(
		java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarTitle_Last(bookmarkTitle, orderByComparator);
	}

	/**
	* Returns the company bookmarks before and after the current company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkId the primary key of the current company bookmark
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public static companyBookmark[] findBybookmarTitle_PrevAndNext(
		java.lang.String bookmarkId, java.lang.String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarTitle_PrevAndNext(bookmarkId, bookmarkTitle,
			orderByComparator);
	}

	/**
	* Removes all the company bookmarks where bookmarkTitle = &#63; from the database.
	*
	* @param bookmarkTitle the bookmark title
	*/
	public static void removeBybookmarTitle(java.lang.String bookmarkTitle) {
		getPersistence().removeBybookmarTitle(bookmarkTitle);
	}

	/**
	* Returns the number of company bookmarks where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @return the number of matching company bookmarks
	*/
	public static int countBybookmarTitle(java.lang.String bookmarkTitle) {
		return getPersistence().countBybookmarTitle(bookmarkTitle);
	}

	/**
	* Returns all the company bookmarks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId) {
		return getPersistence().findBybookmarUserId(userId);
	}

	/**
	* Returns a range of all the company bookmarks where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @return the range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId, int start, int end) {
		return getPersistence().findBybookmarUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the company bookmarks where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .findBybookmarUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the company bookmarks where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching company bookmarks
	*/
	public static List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybookmarUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarUserId_First(
		java.lang.Long userId,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarUserId_First(
		java.lang.Long userId,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public static companyBookmark findBybookmarUserId_Last(
		java.lang.Long userId,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public static companyBookmark fetchBybookmarUserId_Last(
		java.lang.Long userId,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence()
				   .fetchBybookmarUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the company bookmarks before and after the current company bookmark in the ordered set where userId = &#63;.
	*
	* @param bookmarkId the primary key of the current company bookmark
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public static companyBookmark[] findBybookmarUserId_PrevAndNext(
		java.lang.String bookmarkId, java.lang.Long userId,
		OrderByComparator<companyBookmark> orderByComparator)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence()
				   .findBybookmarUserId_PrevAndNext(bookmarkId, userId,
			orderByComparator);
	}

	/**
	* Removes all the company bookmarks where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeBybookmarUserId(java.lang.Long userId) {
		getPersistence().removeBybookmarUserId(userId);
	}

	/**
	* Returns the number of company bookmarks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching company bookmarks
	*/
	public static int countBybookmarUserId(java.lang.Long userId) {
		return getPersistence().countBybookmarUserId(userId);
	}

	/**
	* Caches the company bookmark in the entity cache if it is enabled.
	*
	* @param companyBookmark the company bookmark
	*/
	public static void cacheResult(companyBookmark companyBookmark) {
		getPersistence().cacheResult(companyBookmark);
	}

	/**
	* Caches the company bookmarks in the entity cache if it is enabled.
	*
	* @param companyBookmarks the company bookmarks
	*/
	public static void cacheResult(List<companyBookmark> companyBookmarks) {
		getPersistence().cacheResult(companyBookmarks);
	}

	/**
	* Creates a new company bookmark with the primary key. Does not add the company bookmark to the database.
	*
	* @param bookmarkId the primary key for the new company bookmark
	* @return the new company bookmark
	*/
	public static companyBookmark create(java.lang.String bookmarkId) {
		return getPersistence().create(bookmarkId);
	}

	/**
	* Removes the company bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark that was removed
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public static companyBookmark remove(java.lang.String bookmarkId)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence().remove(bookmarkId);
	}

	public static companyBookmark updateImpl(companyBookmark companyBookmark) {
		return getPersistence().updateImpl(companyBookmark);
	}

	/**
	* Returns the company bookmark with the primary key or throws a {@link NoSuchcompanyBookmarkException} if it could not be found.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public static companyBookmark findByPrimaryKey(java.lang.String bookmarkId)
		throws com.bookmark.exception.NoSuchcompanyBookmarkException {
		return getPersistence().findByPrimaryKey(bookmarkId);
	}

	/**
	* Returns the company bookmark with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark, or <code>null</code> if a company bookmark with the primary key could not be found
	*/
	public static companyBookmark fetchByPrimaryKey(java.lang.String bookmarkId) {
		return getPersistence().fetchByPrimaryKey(bookmarkId);
	}

	public static java.util.Map<java.io.Serializable, companyBookmark> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the company bookmarks.
	*
	* @return the company bookmarks
	*/
	public static List<companyBookmark> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the company bookmarks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @return the range of company bookmarks
	*/
	public static List<companyBookmark> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the company bookmarks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of company bookmarks
	*/
	public static List<companyBookmark> findAll(int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the company bookmarks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link companyBookmarkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company bookmarks
	* @param end the upper bound of the range of company bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of company bookmarks
	*/
	public static List<companyBookmark> findAll(int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the company bookmarks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of company bookmarks.
	*
	* @return the number of company bookmarks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static companyBookmarkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<companyBookmarkPersistence, companyBookmarkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(companyBookmarkPersistence.class);
}