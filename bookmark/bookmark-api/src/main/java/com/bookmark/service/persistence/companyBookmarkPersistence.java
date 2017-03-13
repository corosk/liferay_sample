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

import com.bookmark.exception.NoSuchcompanyBookmarkException;

import com.bookmark.model.companyBookmark;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the company bookmark service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.bookmark.service.persistence.impl.companyBookmarkPersistenceImpl
 * @see companyBookmarkUtil
 * @generated
 */
@ProviderType
public interface companyBookmarkPersistence extends BasePersistence<companyBookmark> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link companyBookmarkUtil} to access the company bookmark persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @return the matching company bookmarks
	*/
	public java.util.List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle);

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
	public java.util.List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle, int start, int end);

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
	public java.util.List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

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
	public java.util.List<companyBookmark> findBybookmarkId(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache);

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
	public companyBookmark findBybookmarkId_First(java.lang.String bookmarkId,
		java.lang.String bookmarkUrl, java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the first company bookmark in the ordered set where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarkId_First(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

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
	public companyBookmark findBybookmarkId_Last(java.lang.String bookmarkId,
		java.lang.String bookmarkUrl, java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the last company bookmark in the ordered set where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarkId_Last(java.lang.String bookmarkId,
		java.lang.String bookmarkUrl, java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

	/**
	* Removes all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63; from the database.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	*/
	public void removeBybookmarkId(java.lang.String bookmarkId,
		java.lang.String bookmarkUrl, java.lang.String bookmarkTitle);

	/**
	* Returns the number of company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	*
	* @param bookmarkId the bookmark ID
	* @param bookmarkUrl the bookmark url
	* @param bookmarkTitle the bookmark title
	* @return the number of matching company bookmarks
	*/
	public int countBybookmarkId(java.lang.String bookmarkId,
		java.lang.String bookmarkUrl, java.lang.String bookmarkTitle);

	/**
	* Returns all the company bookmarks where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @return the matching company bookmarks
	*/
	public java.util.List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl);

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
	public java.util.List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl, int start, int end);

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
	public java.util.List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

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
	public java.util.List<companyBookmark> findBybookmarkUrl(
		java.lang.String bookmarkUrl, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public companyBookmark findBybookmarkUrl_First(
		java.lang.String bookmarkUrl,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the first company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarkUrl_First(
		java.lang.String bookmarkUrl,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

	/**
	* Returns the last company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public companyBookmark findBybookmarkUrl_Last(
		java.lang.String bookmarkUrl,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the last company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarkUrl_Last(
		java.lang.String bookmarkUrl,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

	/**
	* Returns the company bookmarks before and after the current company bookmark in the ordered set where bookmarkUrl = &#63;.
	*
	* @param bookmarkId the primary key of the current company bookmark
	* @param bookmarkUrl the bookmark url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public companyBookmark[] findBybookmarkUrl_PrevAndNext(
		java.lang.String bookmarkId, java.lang.String bookmarkUrl,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Removes all the company bookmarks where bookmarkUrl = &#63; from the database.
	*
	* @param bookmarkUrl the bookmark url
	*/
	public void removeBybookmarkUrl(java.lang.String bookmarkUrl);

	/**
	* Returns the number of company bookmarks where bookmarkUrl = &#63;.
	*
	* @param bookmarkUrl the bookmark url
	* @return the number of matching company bookmarks
	*/
	public int countBybookmarkUrl(java.lang.String bookmarkUrl);

	/**
	* Returns all the company bookmarks where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @return the matching company bookmarks
	*/
	public java.util.List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle);

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
	public java.util.List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle, int start, int end);

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
	public java.util.List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

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
	public java.util.List<companyBookmark> findBybookmarTitle(
		java.lang.String bookmarkTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public companyBookmark findBybookmarTitle_First(
		java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the first company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarTitle_First(
		java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

	/**
	* Returns the last company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public companyBookmark findBybookmarTitle_Last(
		java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the last company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarTitle_Last(
		java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

	/**
	* Returns the company bookmarks before and after the current company bookmark in the ordered set where bookmarkTitle = &#63;.
	*
	* @param bookmarkId the primary key of the current company bookmark
	* @param bookmarkTitle the bookmark title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public companyBookmark[] findBybookmarTitle_PrevAndNext(
		java.lang.String bookmarkId, java.lang.String bookmarkTitle,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Removes all the company bookmarks where bookmarkTitle = &#63; from the database.
	*
	* @param bookmarkTitle the bookmark title
	*/
	public void removeBybookmarTitle(java.lang.String bookmarkTitle);

	/**
	* Returns the number of company bookmarks where bookmarkTitle = &#63;.
	*
	* @param bookmarkTitle the bookmark title
	* @return the number of matching company bookmarks
	*/
	public int countBybookmarTitle(java.lang.String bookmarkTitle);

	/**
	* Returns all the company bookmarks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching company bookmarks
	*/
	public java.util.List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId);

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
	public java.util.List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId, int start, int end);

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
	public java.util.List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

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
	public java.util.List<companyBookmark> findBybookmarUserId(
		java.lang.Long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public companyBookmark findBybookmarUserId_First(java.lang.Long userId,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the first company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarUserId_First(java.lang.Long userId,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

	/**
	* Returns the last company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark
	* @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	*/
	public companyBookmark findBybookmarUserId_Last(java.lang.Long userId,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the last company bookmark in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	*/
	public companyBookmark fetchBybookmarUserId_Last(java.lang.Long userId,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

	/**
	* Returns the company bookmarks before and after the current company bookmark in the ordered set where userId = &#63;.
	*
	* @param bookmarkId the primary key of the current company bookmark
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public companyBookmark[] findBybookmarUserId_PrevAndNext(
		java.lang.String bookmarkId, java.lang.Long userId,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException;

	/**
	* Removes all the company bookmarks where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeBybookmarUserId(java.lang.Long userId);

	/**
	* Returns the number of company bookmarks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching company bookmarks
	*/
	public int countBybookmarUserId(java.lang.Long userId);

	/**
	* Caches the company bookmark in the entity cache if it is enabled.
	*
	* @param companyBookmark the company bookmark
	*/
	public void cacheResult(companyBookmark companyBookmark);

	/**
	* Caches the company bookmarks in the entity cache if it is enabled.
	*
	* @param companyBookmarks the company bookmarks
	*/
	public void cacheResult(java.util.List<companyBookmark> companyBookmarks);

	/**
	* Creates a new company bookmark with the primary key. Does not add the company bookmark to the database.
	*
	* @param bookmarkId the primary key for the new company bookmark
	* @return the new company bookmark
	*/
	public companyBookmark create(java.lang.String bookmarkId);

	/**
	* Removes the company bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark that was removed
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public companyBookmark remove(java.lang.String bookmarkId)
		throws NoSuchcompanyBookmarkException;

	public companyBookmark updateImpl(companyBookmark companyBookmark);

	/**
	* Returns the company bookmark with the primary key or throws a {@link NoSuchcompanyBookmarkException} if it could not be found.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark
	* @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	*/
	public companyBookmark findByPrimaryKey(java.lang.String bookmarkId)
		throws NoSuchcompanyBookmarkException;

	/**
	* Returns the company bookmark with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookmarkId the primary key of the company bookmark
	* @return the company bookmark, or <code>null</code> if a company bookmark with the primary key could not be found
	*/
	public companyBookmark fetchByPrimaryKey(java.lang.String bookmarkId);

	@Override
	public java.util.Map<java.io.Serializable, companyBookmark> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the company bookmarks.
	*
	* @return the company bookmarks
	*/
	public java.util.List<companyBookmark> findAll();

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
	public java.util.List<companyBookmark> findAll(int start, int end);

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
	public java.util.List<companyBookmark> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator);

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
	public java.util.List<companyBookmark> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the company bookmarks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of company bookmarks.
	*
	* @return the number of company bookmarks
	*/
	public int countAll();
}