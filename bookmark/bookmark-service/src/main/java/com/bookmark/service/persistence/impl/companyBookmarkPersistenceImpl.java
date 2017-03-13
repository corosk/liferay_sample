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

package com.bookmark.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.bookmark.exception.NoSuchcompanyBookmarkException;

import com.bookmark.model.companyBookmark;
import com.bookmark.model.impl.companyBookmarkImpl;
import com.bookmark.model.impl.companyBookmarkModelImpl;

import com.bookmark.service.persistence.companyBookmarkPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the company bookmark service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see companyBookmarkPersistence
 * @see com.bookmark.service.persistence.companyBookmarkUtil
 * @generated
 */
@ProviderType
public class companyBookmarkPersistenceImpl extends BasePersistenceImpl<companyBookmark>
	implements companyBookmarkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link companyBookmarkUtil} to access the company bookmark persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = companyBookmarkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKID =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybookmarkId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKID =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookmarkId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			companyBookmarkModelImpl.BOOKMARKID_COLUMN_BITMASK |
			companyBookmarkModelImpl.BOOKMARKURL_COLUMN_BITMASK |
			companyBookmarkModelImpl.BOOKMARKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKMARKID = new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookmarkId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	 *
	 * @param bookmarkId the bookmark ID
	 * @param bookmarkUrl the bookmark url
	 * @param bookmarkTitle the bookmark title
	 * @return the matching company bookmarks
	 */
	@Override
	public List<companyBookmark> findBybookmarkId(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle) {
		return findBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<companyBookmark> findBybookmarkId(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle, int start, int end) {
		return findBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle, start,
			end, null);
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
	@Override
	public List<companyBookmark> findBybookmarkId(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return findBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle, start,
			end, orderByComparator, true);
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
	@Override
	public List<companyBookmark> findBybookmarkId(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle, int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKID;
			finderArgs = new Object[] { bookmarkId, bookmarkUrl, bookmarkTitle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKID;
			finderArgs = new Object[] {
					bookmarkId, bookmarkUrl, bookmarkTitle,
					
					start, end, orderByComparator
				};
		}

		List<companyBookmark> list = null;

		if (retrieveFromCache) {
			list = (List<companyBookmark>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (companyBookmark companyBookmark : list) {
					if (!Objects.equals(bookmarkId,
								companyBookmark.getBookmarkId()) ||
							!Objects.equals(bookmarkUrl,
								companyBookmark.getBookmarkUrl()) ||
							!Objects.equals(bookmarkTitle,
								companyBookmark.getBookmarkTitle())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE);

			boolean bindBookmarkId = false;

			if (bookmarkId == null) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKID_1);
			}
			else if (bookmarkId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKID_3);
			}
			else {
				bindBookmarkId = true;

				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKID_2);
			}

			boolean bindBookmarkUrl = false;

			if (bookmarkUrl == null) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_1);
			}
			else if (bookmarkUrl.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_3);
			}
			else {
				bindBookmarkUrl = true;

				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_2);
			}

			boolean bindBookmarkTitle = false;

			if (bookmarkTitle == null) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_1);
			}
			else if (bookmarkTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_3);
			}
			else {
				bindBookmarkTitle = true;

				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(companyBookmarkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookmarkId) {
					qPos.add(bookmarkId);
				}

				if (bindBookmarkUrl) {
					qPos.add(bookmarkUrl);
				}

				if (bindBookmarkTitle) {
					qPos.add(bookmarkTitle);
				}

				if (!pagination) {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public companyBookmark findBybookmarkId_First(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarkId_First(bookmarkId,
				bookmarkUrl, bookmarkTitle, orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookmarkId=");
		msg.append(bookmarkId);

		msg.append(", bookmarkUrl=");
		msg.append(bookmarkUrl);

		msg.append(", bookmarkTitle=");
		msg.append(bookmarkTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
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
	@Override
	public companyBookmark fetchBybookmarkId_First(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		List<companyBookmark> list = findBybookmarkId(bookmarkId, bookmarkUrl,
				bookmarkTitle, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public companyBookmark findBybookmarkId_Last(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarkId_Last(bookmarkId,
				bookmarkUrl, bookmarkTitle, orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookmarkId=");
		msg.append(bookmarkId);

		msg.append(", bookmarkUrl=");
		msg.append(bookmarkUrl);

		msg.append(", bookmarkTitle=");
		msg.append(bookmarkTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
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
	@Override
	public companyBookmark fetchBybookmarkId_Last(String bookmarkId,
		String bookmarkUrl, String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		int count = countBybookmarkId(bookmarkId, bookmarkUrl, bookmarkTitle);

		if (count == 0) {
			return null;
		}

		List<companyBookmark> list = findBybookmarkId(bookmarkId, bookmarkUrl,
				bookmarkTitle, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63; from the database.
	 *
	 * @param bookmarkId the bookmark ID
	 * @param bookmarkUrl the bookmark url
	 * @param bookmarkTitle the bookmark title
	 */
	@Override
	public void removeBybookmarkId(String bookmarkId, String bookmarkUrl,
		String bookmarkTitle) {
		for (companyBookmark companyBookmark : findBybookmarkId(bookmarkId,
				bookmarkUrl, bookmarkTitle, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(companyBookmark);
		}
	}

	/**
	 * Returns the number of company bookmarks where bookmarkId = &#63; and bookmarkUrl = &#63; and bookmarkTitle = &#63;.
	 *
	 * @param bookmarkId the bookmark ID
	 * @param bookmarkUrl the bookmark url
	 * @param bookmarkTitle the bookmark title
	 * @return the number of matching company bookmarks
	 */
	@Override
	public int countBybookmarkId(String bookmarkId, String bookmarkUrl,
		String bookmarkTitle) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKMARKID;

		Object[] finderArgs = new Object[] {
				bookmarkId, bookmarkUrl, bookmarkTitle
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COMPANYBOOKMARK_WHERE);

			boolean bindBookmarkId = false;

			if (bookmarkId == null) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKID_1);
			}
			else if (bookmarkId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKID_3);
			}
			else {
				bindBookmarkId = true;

				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKID_2);
			}

			boolean bindBookmarkUrl = false;

			if (bookmarkUrl == null) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_1);
			}
			else if (bookmarkUrl.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_3);
			}
			else {
				bindBookmarkUrl = true;

				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_2);
			}

			boolean bindBookmarkTitle = false;

			if (bookmarkTitle == null) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_1);
			}
			else if (bookmarkTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_3);
			}
			else {
				bindBookmarkTitle = true;

				query.append(_FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookmarkId) {
					qPos.add(bookmarkId);
				}

				if (bindBookmarkUrl) {
					qPos.add(bookmarkUrl);
				}

				if (bindBookmarkTitle) {
					qPos.add(bookmarkTitle);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKID_1 = "companyBookmark.bookmarkId IS NULL AND ";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKID_2 = "companyBookmark.bookmarkId = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKID_3 = "(companyBookmark.bookmarkId IS NULL OR companyBookmark.bookmarkId = '') AND ";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_1 = "companyBookmark.bookmarkUrl IS NULL AND ";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_2 = "companyBookmark.bookmarkUrl = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKURL_3 = "(companyBookmark.bookmarkUrl IS NULL OR companyBookmark.bookmarkUrl = '') AND ";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_1 = "companyBookmark.bookmarkTitle IS NULL";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_2 = "companyBookmark.bookmarkTitle = ?";
	private static final String _FINDER_COLUMN_BOOKMARKID_BOOKMARKTITLE_3 = "(companyBookmark.bookmarkTitle IS NULL OR companyBookmark.bookmarkTitle = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKURL =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybookmarkUrl",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKURL =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookmarkUrl",
			new String[] { String.class.getName() },
			companyBookmarkModelImpl.BOOKMARKURL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKMARKURL = new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookmarkUrl",
			new String[] { String.class.getName() });

	/**
	 * Returns all the company bookmarks where bookmarkUrl = &#63;.
	 *
	 * @param bookmarkUrl the bookmark url
	 * @return the matching company bookmarks
	 */
	@Override
	public List<companyBookmark> findBybookmarkUrl(String bookmarkUrl) {
		return findBybookmarkUrl(bookmarkUrl, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<companyBookmark> findBybookmarkUrl(String bookmarkUrl,
		int start, int end) {
		return findBybookmarkUrl(bookmarkUrl, start, end, null);
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
	@Override
	public List<companyBookmark> findBybookmarkUrl(String bookmarkUrl,
		int start, int end, OrderByComparator<companyBookmark> orderByComparator) {
		return findBybookmarkUrl(bookmarkUrl, start, end, orderByComparator,
			true);
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
	@Override
	public List<companyBookmark> findBybookmarkUrl(String bookmarkUrl,
		int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKURL;
			finderArgs = new Object[] { bookmarkUrl };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKURL;
			finderArgs = new Object[] { bookmarkUrl, start, end, orderByComparator };
		}

		List<companyBookmark> list = null;

		if (retrieveFromCache) {
			list = (List<companyBookmark>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (companyBookmark companyBookmark : list) {
					if (!Objects.equals(bookmarkUrl,
								companyBookmark.getBookmarkUrl())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE);

			boolean bindBookmarkUrl = false;

			if (bookmarkUrl == null) {
				query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_1);
			}
			else if (bookmarkUrl.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_3);
			}
			else {
				bindBookmarkUrl = true;

				query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(companyBookmarkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookmarkUrl) {
					qPos.add(bookmarkUrl);
				}

				if (!pagination) {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first company bookmark in the ordered set where bookmarkUrl = &#63;.
	 *
	 * @param bookmarkUrl the bookmark url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company bookmark
	 * @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark findBybookmarkUrl_First(String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarkUrl_First(bookmarkUrl,
				orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookmarkUrl=");
		msg.append(bookmarkUrl);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
	}

	/**
	 * Returns the first company bookmark in the ordered set where bookmarkUrl = &#63;.
	 *
	 * @param bookmarkUrl the bookmark url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark fetchBybookmarkUrl_First(String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator) {
		List<companyBookmark> list = findBybookmarkUrl(bookmarkUrl, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company bookmark in the ordered set where bookmarkUrl = &#63;.
	 *
	 * @param bookmarkUrl the bookmark url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company bookmark
	 * @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark findBybookmarkUrl_Last(String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarkUrl_Last(bookmarkUrl,
				orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookmarkUrl=");
		msg.append(bookmarkUrl);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
	}

	/**
	 * Returns the last company bookmark in the ordered set where bookmarkUrl = &#63;.
	 *
	 * @param bookmarkUrl the bookmark url
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark fetchBybookmarkUrl_Last(String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator) {
		int count = countBybookmarkUrl(bookmarkUrl);

		if (count == 0) {
			return null;
		}

		List<companyBookmark> list = findBybookmarkUrl(bookmarkUrl, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public companyBookmark[] findBybookmarkUrl_PrevAndNext(String bookmarkId,
		String bookmarkUrl, OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = findByPrimaryKey(bookmarkId);

		Session session = null;

		try {
			session = openSession();

			companyBookmark[] array = new companyBookmarkImpl[3];

			array[0] = getBybookmarkUrl_PrevAndNext(session, companyBookmark,
					bookmarkUrl, orderByComparator, true);

			array[1] = companyBookmark;

			array[2] = getBybookmarkUrl_PrevAndNext(session, companyBookmark,
					bookmarkUrl, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected companyBookmark getBybookmarkUrl_PrevAndNext(Session session,
		companyBookmark companyBookmark, String bookmarkUrl,
		OrderByComparator<companyBookmark> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE);

		boolean bindBookmarkUrl = false;

		if (bookmarkUrl == null) {
			query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_1);
		}
		else if (bookmarkUrl.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_3);
		}
		else {
			bindBookmarkUrl = true;

			query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(companyBookmarkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBookmarkUrl) {
			qPos.add(bookmarkUrl);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(companyBookmark);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<companyBookmark> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company bookmarks where bookmarkUrl = &#63; from the database.
	 *
	 * @param bookmarkUrl the bookmark url
	 */
	@Override
	public void removeBybookmarkUrl(String bookmarkUrl) {
		for (companyBookmark companyBookmark : findBybookmarkUrl(bookmarkUrl,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(companyBookmark);
		}
	}

	/**
	 * Returns the number of company bookmarks where bookmarkUrl = &#63;.
	 *
	 * @param bookmarkUrl the bookmark url
	 * @return the number of matching company bookmarks
	 */
	@Override
	public int countBybookmarkUrl(String bookmarkUrl) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKMARKURL;

		Object[] finderArgs = new Object[] { bookmarkUrl };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPANYBOOKMARK_WHERE);

			boolean bindBookmarkUrl = false;

			if (bookmarkUrl == null) {
				query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_1);
			}
			else if (bookmarkUrl.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_3);
			}
			else {
				bindBookmarkUrl = true;

				query.append(_FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookmarkUrl) {
					qPos.add(bookmarkUrl);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_1 = "companyBookmark.bookmarkUrl IS NULL";
	private static final String _FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_2 = "companyBookmark.bookmarkUrl = ?";
	private static final String _FINDER_COLUMN_BOOKMARKURL_BOOKMARKURL_3 = "(companyBookmark.bookmarkUrl IS NULL OR companyBookmark.bookmarkUrl = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARTITLE =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybookmarTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARTITLE =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookmarTitle",
			new String[] { String.class.getName() },
			companyBookmarkModelImpl.BOOKMARKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKMARTITLE = new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookmarTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the company bookmarks where bookmarkTitle = &#63;.
	 *
	 * @param bookmarkTitle the bookmark title
	 * @return the matching company bookmarks
	 */
	@Override
	public List<companyBookmark> findBybookmarTitle(String bookmarkTitle) {
		return findBybookmarTitle(bookmarkTitle, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<companyBookmark> findBybookmarTitle(String bookmarkTitle,
		int start, int end) {
		return findBybookmarTitle(bookmarkTitle, start, end, null);
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
	@Override
	public List<companyBookmark> findBybookmarTitle(String bookmarkTitle,
		int start, int end, OrderByComparator<companyBookmark> orderByComparator) {
		return findBybookmarTitle(bookmarkTitle, start, end, orderByComparator,
			true);
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
	@Override
	public List<companyBookmark> findBybookmarTitle(String bookmarkTitle,
		int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARTITLE;
			finderArgs = new Object[] { bookmarkTitle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARTITLE;
			finderArgs = new Object[] {
					bookmarkTitle,
					
					start, end, orderByComparator
				};
		}

		List<companyBookmark> list = null;

		if (retrieveFromCache) {
			list = (List<companyBookmark>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (companyBookmark companyBookmark : list) {
					if (!Objects.equals(bookmarkTitle,
								companyBookmark.getBookmarkTitle())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE);

			boolean bindBookmarkTitle = false;

			if (bookmarkTitle == null) {
				query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_1);
			}
			else if (bookmarkTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_3);
			}
			else {
				bindBookmarkTitle = true;

				query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(companyBookmarkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookmarkTitle) {
					qPos.add(bookmarkTitle);
				}

				if (!pagination) {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first company bookmark in the ordered set where bookmarkTitle = &#63;.
	 *
	 * @param bookmarkTitle the bookmark title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company bookmark
	 * @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark findBybookmarTitle_First(String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarTitle_First(bookmarkTitle,
				orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookmarkTitle=");
		msg.append(bookmarkTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
	}

	/**
	 * Returns the first company bookmark in the ordered set where bookmarkTitle = &#63;.
	 *
	 * @param bookmarkTitle the bookmark title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark fetchBybookmarTitle_First(String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		List<companyBookmark> list = findBybookmarTitle(bookmarkTitle, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company bookmark in the ordered set where bookmarkTitle = &#63;.
	 *
	 * @param bookmarkTitle the bookmark title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company bookmark
	 * @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark findBybookmarTitle_Last(String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarTitle_Last(bookmarkTitle,
				orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookmarkTitle=");
		msg.append(bookmarkTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
	}

	/**
	 * Returns the last company bookmark in the ordered set where bookmarkTitle = &#63;.
	 *
	 * @param bookmarkTitle the bookmark title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark fetchBybookmarTitle_Last(String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator) {
		int count = countBybookmarTitle(bookmarkTitle);

		if (count == 0) {
			return null;
		}

		List<companyBookmark> list = findBybookmarTitle(bookmarkTitle,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public companyBookmark[] findBybookmarTitle_PrevAndNext(String bookmarkId,
		String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = findByPrimaryKey(bookmarkId);

		Session session = null;

		try {
			session = openSession();

			companyBookmark[] array = new companyBookmarkImpl[3];

			array[0] = getBybookmarTitle_PrevAndNext(session, companyBookmark,
					bookmarkTitle, orderByComparator, true);

			array[1] = companyBookmark;

			array[2] = getBybookmarTitle_PrevAndNext(session, companyBookmark,
					bookmarkTitle, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected companyBookmark getBybookmarTitle_PrevAndNext(Session session,
		companyBookmark companyBookmark, String bookmarkTitle,
		OrderByComparator<companyBookmark> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE);

		boolean bindBookmarkTitle = false;

		if (bookmarkTitle == null) {
			query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_1);
		}
		else if (bookmarkTitle.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_3);
		}
		else {
			bindBookmarkTitle = true;

			query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(companyBookmarkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBookmarkTitle) {
			qPos.add(bookmarkTitle);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(companyBookmark);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<companyBookmark> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company bookmarks where bookmarkTitle = &#63; from the database.
	 *
	 * @param bookmarkTitle the bookmark title
	 */
	@Override
	public void removeBybookmarTitle(String bookmarkTitle) {
		for (companyBookmark companyBookmark : findBybookmarTitle(
				bookmarkTitle, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(companyBookmark);
		}
	}

	/**
	 * Returns the number of company bookmarks where bookmarkTitle = &#63;.
	 *
	 * @param bookmarkTitle the bookmark title
	 * @return the number of matching company bookmarks
	 */
	@Override
	public int countBybookmarTitle(String bookmarkTitle) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKMARTITLE;

		Object[] finderArgs = new Object[] { bookmarkTitle };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPANYBOOKMARK_WHERE);

			boolean bindBookmarkTitle = false;

			if (bookmarkTitle == null) {
				query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_1);
			}
			else if (bookmarkTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_3);
			}
			else {
				bindBookmarkTitle = true;

				query.append(_FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookmarkTitle) {
					qPos.add(bookmarkTitle);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_1 = "companyBookmark.bookmarkTitle IS NULL";
	private static final String _FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_2 = "companyBookmark.bookmarkTitle = ?";
	private static final String _FINDER_COLUMN_BOOKMARTITLE_BOOKMARKTITLE_3 = "(companyBookmark.bookmarkTitle IS NULL OR companyBookmark.bookmarkTitle = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARUSERID =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybookmarUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARUSERID =
		new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED,
			companyBookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookmarUserId",
			new String[] { Long.class.getName() },
			companyBookmarkModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKMARUSERID = new FinderPath(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookmarUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the company bookmarks where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching company bookmarks
	 */
	@Override
	public List<companyBookmark> findBybookmarUserId(Long userId) {
		return findBybookmarUserId(userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<companyBookmark> findBybookmarUserId(Long userId, int start,
		int end) {
		return findBybookmarUserId(userId, start, end, null);
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
	@Override
	public List<companyBookmark> findBybookmarUserId(Long userId, int start,
		int end, OrderByComparator<companyBookmark> orderByComparator) {
		return findBybookmarUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<companyBookmark> findBybookmarUserId(Long userId, int start,
		int end, OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARUSERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARUSERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<companyBookmark> list = null;

		if (retrieveFromCache) {
			list = (List<companyBookmark>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (companyBookmark companyBookmark : list) {
					if (!Objects.equals(userId, companyBookmark.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE);

			query.append(_FINDER_COLUMN_BOOKMARUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(companyBookmarkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId.longValue());

				if (!pagination) {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first company bookmark in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company bookmark
	 * @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark findBybookmarUserId_First(Long userId,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarUserId_First(userId,
				orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
	}

	/**
	 * Returns the first company bookmark in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark fetchBybookmarUserId_First(Long userId,
		OrderByComparator<companyBookmark> orderByComparator) {
		List<companyBookmark> list = findBybookmarUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company bookmark in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company bookmark
	 * @throws NoSuchcompanyBookmarkException if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark findBybookmarUserId_Last(Long userId,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchBybookmarUserId_Last(userId,
				orderByComparator);

		if (companyBookmark != null) {
			return companyBookmark;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcompanyBookmarkException(msg.toString());
	}

	/**
	 * Returns the last company bookmark in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company bookmark, or <code>null</code> if a matching company bookmark could not be found
	 */
	@Override
	public companyBookmark fetchBybookmarUserId_Last(Long userId,
		OrderByComparator<companyBookmark> orderByComparator) {
		int count = countBybookmarUserId(userId);

		if (count == 0) {
			return null;
		}

		List<companyBookmark> list = findBybookmarUserId(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public companyBookmark[] findBybookmarUserId_PrevAndNext(
		String bookmarkId, Long userId,
		OrderByComparator<companyBookmark> orderByComparator)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = findByPrimaryKey(bookmarkId);

		Session session = null;

		try {
			session = openSession();

			companyBookmark[] array = new companyBookmarkImpl[3];

			array[0] = getBybookmarUserId_PrevAndNext(session, companyBookmark,
					userId, orderByComparator, true);

			array[1] = companyBookmark;

			array[2] = getBybookmarUserId_PrevAndNext(session, companyBookmark,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected companyBookmark getBybookmarUserId_PrevAndNext(Session session,
		companyBookmark companyBookmark, Long userId,
		OrderByComparator<companyBookmark> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE);

		query.append(_FINDER_COLUMN_BOOKMARUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(companyBookmarkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId.longValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(companyBookmark);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<companyBookmark> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company bookmarks where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeBybookmarUserId(Long userId) {
		for (companyBookmark companyBookmark : findBybookmarUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(companyBookmark);
		}
	}

	/**
	 * Returns the number of company bookmarks where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching company bookmarks
	 */
	@Override
	public int countBybookmarUserId(Long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKMARUSERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPANYBOOKMARK_WHERE);

			query.append(_FINDER_COLUMN_BOOKMARUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId.longValue());

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKMARUSERID_USERID_2 = "companyBookmark.userId = ?";

	public companyBookmarkPersistenceImpl() {
		setModelClass(companyBookmark.class);
	}

	/**
	 * Caches the company bookmark in the entity cache if it is enabled.
	 *
	 * @param companyBookmark the company bookmark
	 */
	@Override
	public void cacheResult(companyBookmark companyBookmark) {
		entityCache.putResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkImpl.class, companyBookmark.getPrimaryKey(),
			companyBookmark);

		companyBookmark.resetOriginalValues();
	}

	/**
	 * Caches the company bookmarks in the entity cache if it is enabled.
	 *
	 * @param companyBookmarks the company bookmarks
	 */
	@Override
	public void cacheResult(List<companyBookmark> companyBookmarks) {
		for (companyBookmark companyBookmark : companyBookmarks) {
			if (entityCache.getResult(
						companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
						companyBookmarkImpl.class,
						companyBookmark.getPrimaryKey()) == null) {
				cacheResult(companyBookmark);
			}
			else {
				companyBookmark.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all company bookmarks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(companyBookmarkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the company bookmark.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(companyBookmark companyBookmark) {
		entityCache.removeResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkImpl.class, companyBookmark.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<companyBookmark> companyBookmarks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (companyBookmark companyBookmark : companyBookmarks) {
			entityCache.removeResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
				companyBookmarkImpl.class, companyBookmark.getPrimaryKey());
		}
	}

	/**
	 * Creates a new company bookmark with the primary key. Does not add the company bookmark to the database.
	 *
	 * @param bookmarkId the primary key for the new company bookmark
	 * @return the new company bookmark
	 */
	@Override
	public companyBookmark create(String bookmarkId) {
		companyBookmark companyBookmark = new companyBookmarkImpl();

		companyBookmark.setNew(true);
		companyBookmark.setPrimaryKey(bookmarkId);

		companyBookmark.setCompanyId(companyProvider.getCompanyId());

		return companyBookmark;
	}

	/**
	 * Removes the company bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookmarkId the primary key of the company bookmark
	 * @return the company bookmark that was removed
	 * @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	 */
	@Override
	public companyBookmark remove(String bookmarkId)
		throws NoSuchcompanyBookmarkException {
		return remove((Serializable)bookmarkId);
	}

	/**
	 * Removes the company bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the company bookmark
	 * @return the company bookmark that was removed
	 * @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	 */
	@Override
	public companyBookmark remove(Serializable primaryKey)
		throws NoSuchcompanyBookmarkException {
		Session session = null;

		try {
			session = openSession();

			companyBookmark companyBookmark = (companyBookmark)session.get(companyBookmarkImpl.class,
					primaryKey);

			if (companyBookmark == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcompanyBookmarkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(companyBookmark);
		}
		catch (NoSuchcompanyBookmarkException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected companyBookmark removeImpl(companyBookmark companyBookmark) {
		companyBookmark = toUnwrappedModel(companyBookmark);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(companyBookmark)) {
				companyBookmark = (companyBookmark)session.get(companyBookmarkImpl.class,
						companyBookmark.getPrimaryKeyObj());
			}

			if (companyBookmark != null) {
				session.delete(companyBookmark);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (companyBookmark != null) {
			clearCache(companyBookmark);
		}

		return companyBookmark;
	}

	@Override
	public companyBookmark updateImpl(companyBookmark companyBookmark) {
		companyBookmark = toUnwrappedModel(companyBookmark);

		boolean isNew = companyBookmark.isNew();

		companyBookmarkModelImpl companyBookmarkModelImpl = (companyBookmarkModelImpl)companyBookmark;

		Session session = null;

		try {
			session = openSession();

			if (companyBookmark.isNew()) {
				session.save(companyBookmark);

				companyBookmark.setNew(false);
			}
			else {
				companyBookmark = (companyBookmark)session.merge(companyBookmark);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !companyBookmarkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((companyBookmarkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						companyBookmarkModelImpl.getOriginalBookmarkId(),
						companyBookmarkModelImpl.getOriginalBookmarkUrl(),
						companyBookmarkModelImpl.getOriginalBookmarkTitle()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARKID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKID,
					args);

				args = new Object[] {
						companyBookmarkModelImpl.getBookmarkId(),
						companyBookmarkModelImpl.getBookmarkUrl(),
						companyBookmarkModelImpl.getBookmarkTitle()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARKID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKID,
					args);
			}

			if ((companyBookmarkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKURL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						companyBookmarkModelImpl.getOriginalBookmarkUrl()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARKURL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKURL,
					args);

				args = new Object[] { companyBookmarkModelImpl.getBookmarkUrl() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARKURL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARKURL,
					args);
			}

			if ((companyBookmarkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARTITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						companyBookmarkModelImpl.getOriginalBookmarkTitle()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARTITLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARTITLE,
					args);

				args = new Object[] { companyBookmarkModelImpl.getBookmarkTitle() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARTITLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARTITLE,
					args);
			}

			if ((companyBookmarkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						companyBookmarkModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARUSERID,
					args);

				args = new Object[] { companyBookmarkModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKMARUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKMARUSERID,
					args);
			}
		}

		entityCache.putResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
			companyBookmarkImpl.class, companyBookmark.getPrimaryKey(),
			companyBookmark, false);

		companyBookmark.resetOriginalValues();

		return companyBookmark;
	}

	protected companyBookmark toUnwrappedModel(companyBookmark companyBookmark) {
		if (companyBookmark instanceof companyBookmarkImpl) {
			return companyBookmark;
		}

		companyBookmarkImpl companyBookmarkImpl = new companyBookmarkImpl();

		companyBookmarkImpl.setNew(companyBookmark.isNew());
		companyBookmarkImpl.setPrimaryKey(companyBookmark.getPrimaryKey());

		companyBookmarkImpl.setCompanyId(companyBookmark.getCompanyId());
		companyBookmarkImpl.setGroupId(companyBookmark.getGroupId());
		companyBookmarkImpl.setBookmarkId(companyBookmark.getBookmarkId());
		companyBookmarkImpl.setBookmarkUrl(companyBookmark.getBookmarkUrl());
		companyBookmarkImpl.setBookmarkTitle(companyBookmark.getBookmarkTitle());
		companyBookmarkImpl.setUserId(companyBookmark.getUserId());
		companyBookmarkImpl.setContent(companyBookmark.getContent());
		companyBookmarkImpl.setCreateDate(companyBookmark.getCreateDate());
		companyBookmarkImpl.setUpdateDate(companyBookmark.getUpdateDate());
		companyBookmarkImpl.setIsDelete(companyBookmark.getIsDelete());

		return companyBookmarkImpl;
	}

	/**
	 * Returns the company bookmark with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the company bookmark
	 * @return the company bookmark
	 * @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	 */
	@Override
	public companyBookmark findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcompanyBookmarkException {
		companyBookmark companyBookmark = fetchByPrimaryKey(primaryKey);

		if (companyBookmark == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcompanyBookmarkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return companyBookmark;
	}

	/**
	 * Returns the company bookmark with the primary key or throws a {@link NoSuchcompanyBookmarkException} if it could not be found.
	 *
	 * @param bookmarkId the primary key of the company bookmark
	 * @return the company bookmark
	 * @throws NoSuchcompanyBookmarkException if a company bookmark with the primary key could not be found
	 */
	@Override
	public companyBookmark findByPrimaryKey(String bookmarkId)
		throws NoSuchcompanyBookmarkException {
		return findByPrimaryKey((Serializable)bookmarkId);
	}

	/**
	 * Returns the company bookmark with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the company bookmark
	 * @return the company bookmark, or <code>null</code> if a company bookmark with the primary key could not be found
	 */
	@Override
	public companyBookmark fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
				companyBookmarkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		companyBookmark companyBookmark = (companyBookmark)serializable;

		if (companyBookmark == null) {
			Session session = null;

			try {
				session = openSession();

				companyBookmark = (companyBookmark)session.get(companyBookmarkImpl.class,
						primaryKey);

				if (companyBookmark != null) {
					cacheResult(companyBookmark);
				}
				else {
					entityCache.putResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
						companyBookmarkImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
					companyBookmarkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return companyBookmark;
	}

	/**
	 * Returns the company bookmark with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookmarkId the primary key of the company bookmark
	 * @return the company bookmark, or <code>null</code> if a company bookmark with the primary key could not be found
	 */
	@Override
	public companyBookmark fetchByPrimaryKey(String bookmarkId) {
		return fetchByPrimaryKey((Serializable)bookmarkId);
	}

	@Override
	public Map<Serializable, companyBookmark> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, companyBookmark> map = new HashMap<Serializable, companyBookmark>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			companyBookmark companyBookmark = fetchByPrimaryKey(primaryKey);

			if (companyBookmark != null) {
				map.put(primaryKey, companyBookmark);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
					companyBookmarkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (companyBookmark)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_COMPANYBOOKMARK_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (companyBookmark companyBookmark : (List<companyBookmark>)q.list()) {
				map.put(companyBookmark.getPrimaryKeyObj(), companyBookmark);

				cacheResult(companyBookmark);

				uncachedPrimaryKeys.remove(companyBookmark.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(companyBookmarkModelImpl.ENTITY_CACHE_ENABLED,
					companyBookmarkImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the company bookmarks.
	 *
	 * @return the company bookmarks
	 */
	@Override
	public List<companyBookmark> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<companyBookmark> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<companyBookmark> findAll(int start, int end,
		OrderByComparator<companyBookmark> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<companyBookmark> findAll(int start, int end,
		OrderByComparator<companyBookmark> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<companyBookmark> list = null;

		if (retrieveFromCache) {
			list = (List<companyBookmark>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMPANYBOOKMARK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPANYBOOKMARK;

				if (pagination) {
					sql = sql.concat(companyBookmarkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<companyBookmark>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the company bookmarks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (companyBookmark companyBookmark : findAll()) {
			remove(companyBookmark);
		}
	}

	/**
	 * Returns the number of company bookmarks.
	 *
	 * @return the number of company bookmarks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMPANYBOOKMARK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return companyBookmarkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the company bookmark persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(companyBookmarkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_COMPANYBOOKMARK = "SELECT companyBookmark FROM companyBookmark companyBookmark";
	private static final String _SQL_SELECT_COMPANYBOOKMARK_WHERE_PKS_IN = "SELECT companyBookmark FROM companyBookmark companyBookmark WHERE bookmarkId IN (";
	private static final String _SQL_SELECT_COMPANYBOOKMARK_WHERE = "SELECT companyBookmark FROM companyBookmark companyBookmark WHERE ";
	private static final String _SQL_COUNT_COMPANYBOOKMARK = "SELECT COUNT(companyBookmark) FROM companyBookmark companyBookmark";
	private static final String _SQL_COUNT_COMPANYBOOKMARK_WHERE = "SELECT COUNT(companyBookmark) FROM companyBookmark companyBookmark WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "companyBookmark.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No companyBookmark exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No companyBookmark exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(companyBookmarkPersistenceImpl.class);
}