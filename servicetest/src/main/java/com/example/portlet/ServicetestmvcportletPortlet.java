package com.example.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.bookmark.model.companyBookmark;
import com.bookmark.service.companyBookmarkLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.active",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=お気に入り",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ServicetestmvcportletPortlet extends MVCPortlet {
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {
/*	String id = renderRequest.getRemoteUser();
	System.out.println(id);
	int no = companyBookmarkLocalServiceUtil.getcompanyBookmarksCount() + 1;
	companyBookmark companyMark = companyBookmarkLocalServiceUtil.createcompanyBookmark(String.valueOf(no));
	companyMark.setUserId(Long.parseLong(id));
	companyMark.setBookmarkTitle("CHINTAI.NET");
	companyMark.setBookmarkUrl("http://www.chintai.net");
	companyMark.setCreateDate(new Date());
	companyMark.setIsDelete(false);
	companyBookmarkLocalServiceUtil.addcompanyBookmark(companyMark);*/
	String id = renderRequest.getRemoteUser();
	List<companyBookmark> lists = new ArrayList<companyBookmark>();
	List<companyBookmark> list = companyBookmarkLocalServiceUtil.getcompanyBookmarks(0,companyBookmarkLocalServiceUtil.getcompanyBookmarksCount());
	for (companyBookmark cb : list) {
	    if(cb.getUserId().toString().equals(id)){
		lists.add(cb);
	    }
	}
	
	renderRequest.setAttribute("bookmarks", lists);

	super.doView(renderRequest, renderResponse);
    }
}