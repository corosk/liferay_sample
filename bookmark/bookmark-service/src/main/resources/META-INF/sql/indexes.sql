create index IX_87BB20E on active_companyBookmark (bookmarkId[$COLUMN_LENGTH:75$], bookmarkUrl[$COLUMN_LENGTH:75$], bookmarkTitle[$COLUMN_LENGTH:75$]);
create index IX_D8C6CC12 on active_companyBookmark (bookmarkTitle[$COLUMN_LENGTH:75$]);
create index IX_8F9D0769 on active_companyBookmark (bookmarkUrl[$COLUMN_LENGTH:75$]);
create index IX_7143FF1A on active_companyBookmark (userId);