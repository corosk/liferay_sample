create table active_companyBookmark (
	companyId LONG,
	groupId VARCHAR(75) null,
	bookmarkId VARCHAR(75) not null primary key,
	bookmarkUrl VARCHAR(75) null,
	bookmarkTitle VARCHAR(75) null,
	userId LONG,
	content VARCHAR(75) null,
	createDate DATE null,
	updateDate DATE null,
	isDelete BOOLEAN
);