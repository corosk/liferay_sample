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

package com.bookmark.service.base;

import aQute.bnd.annotation.ProviderType;

import com.bookmark.model.companyBookmark;

import com.bookmark.service.companyBookmarkLocalService;
import com.bookmark.service.persistence.companyBookmarkPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.CompanyPersistence;
import com.liferay.portal.kernel.service.persistence.GroupPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the company bookmark local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bookmark.service.impl.companyBookmarkLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.bookmark.service.impl.companyBookmarkLocalServiceImpl
 * @see com.bookmark.service.companyBookmarkLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class companyBookmarkLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements companyBookmarkLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bookmark.service.companyBookmarkLocalServiceUtil} to access the company bookmark local service.
	 */

	/**
	 * Adds the company bookmark to the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyBookmark the company bookmark
	 * @return the company bookmark that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public companyBookmark addcompanyBookmark(companyBookmark companyBookmark) {
		companyBookmark.setNew(true);

		return companyBookmarkPersistence.update(companyBookmark);
	}

	/**
	 * Creates a new company bookmark with the primary key. Does not add the company bookmark to the database.
	 *
	 * @param bookmarkId the primary key for the new company bookmark
	 * @return the new company bookmark
	 */
	@Override
	public companyBookmark createcompanyBookmark(String bookmarkId) {
		return companyBookmarkPersistence.create(bookmarkId);
	}

	/**
	 * Deletes the company bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookmarkId the primary key of the company bookmark
	 * @return the company bookmark that was removed
	 * @throws PortalException if a company bookmark with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public companyBookmark deletecompanyBookmark(String bookmarkId)
		throws PortalException {
		return companyBookmarkPersistence.remove(bookmarkId);
	}

	/**
	 * Deletes the company bookmark from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyBookmark the company bookmark
	 * @return the company bookmark that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public companyBookmark deletecompanyBookmark(
		companyBookmark companyBookmark) {
		return companyBookmarkPersistence.remove(companyBookmark);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(companyBookmark.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return companyBookmarkPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return companyBookmarkPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return companyBookmarkPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return companyBookmarkPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return companyBookmarkPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public companyBookmark fetchcompanyBookmark(String bookmarkId) {
		return companyBookmarkPersistence.fetchByPrimaryKey(bookmarkId);
	}

	/**
	 * Returns the company bookmark with the primary key.
	 *
	 * @param bookmarkId the primary key of the company bookmark
	 * @return the company bookmark
	 * @throws PortalException if a company bookmark with the primary key could not be found
	 */
	@Override
	public companyBookmark getcompanyBookmark(String bookmarkId)
		throws PortalException {
		return companyBookmarkPersistence.findByPrimaryKey(bookmarkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return companyBookmarkLocalService.deletecompanyBookmark((companyBookmark)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return companyBookmarkPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<companyBookmark> getcompanyBookmarks(int start, int end) {
		return companyBookmarkPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of company bookmarks.
	 *
	 * @return the number of company bookmarks
	 */
	@Override
	public int getcompanyBookmarksCount() {
		return companyBookmarkPersistence.countAll();
	}

	/**
	 * Updates the company bookmark in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param companyBookmark the company bookmark
	 * @return the company bookmark that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public companyBookmark updatecompanyBookmark(
		companyBookmark companyBookmark) {
		return companyBookmarkPersistence.update(companyBookmark);
	}

	/**
	 * Returns the company bookmark local service.
	 *
	 * @return the company bookmark local service
	 */
	public companyBookmarkLocalService getcompanyBookmarkLocalService() {
		return companyBookmarkLocalService;
	}

	/**
	 * Sets the company bookmark local service.
	 *
	 * @param companyBookmarkLocalService the company bookmark local service
	 */
	public void setcompanyBookmarkLocalService(
		companyBookmarkLocalService companyBookmarkLocalService) {
		this.companyBookmarkLocalService = companyBookmarkLocalService;
	}

	/**
	 * Returns the company bookmark persistence.
	 *
	 * @return the company bookmark persistence
	 */
	public companyBookmarkPersistence getcompanyBookmarkPersistence() {
		return companyBookmarkPersistence;
	}

	/**
	 * Sets the company bookmark persistence.
	 *
	 * @param companyBookmarkPersistence the company bookmark persistence
	 */
	public void setcompanyBookmarkPersistence(
		companyBookmarkPersistence companyBookmarkPersistence) {
		this.companyBookmarkPersistence = companyBookmarkPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the company local service.
	 *
	 * @return the company local service
	 */
	public com.liferay.portal.kernel.service.CompanyLocalService getCompanyLocalService() {
		return companyLocalService;
	}

	/**
	 * Sets the company local service.
	 *
	 * @param companyLocalService the company local service
	 */
	public void setCompanyLocalService(
		com.liferay.portal.kernel.service.CompanyLocalService companyLocalService) {
		this.companyLocalService = companyLocalService;
	}

	/**
	 * Returns the company persistence.
	 *
	 * @return the company persistence
	 */
	public CompanyPersistence getCompanyPersistence() {
		return companyPersistence;
	}

	/**
	 * Sets the company persistence.
	 *
	 * @param companyPersistence the company persistence
	 */
	public void setCompanyPersistence(CompanyPersistence companyPersistence) {
		this.companyPersistence = companyPersistence;
	}

	/**
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.kernel.service.GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.kernel.service.GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.bookmark.model.companyBookmark",
			companyBookmarkLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.bookmark.model.companyBookmark");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return companyBookmarkLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return companyBookmark.class;
	}

	protected String getModelClassName() {
		return companyBookmark.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = companyBookmarkPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = companyBookmarkLocalService.class)
	protected companyBookmarkLocalService companyBookmarkLocalService;
	@BeanReference(type = companyBookmarkPersistence.class)
	protected companyBookmarkPersistence companyBookmarkPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.CompanyLocalService.class)
	protected com.liferay.portal.kernel.service.CompanyLocalService companyLocalService;
	@ServiceReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.GroupLocalService.class)
	protected com.liferay.portal.kernel.service.GroupLocalService groupLocalService;
	@ServiceReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}