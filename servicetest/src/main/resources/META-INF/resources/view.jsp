<%@ include file="/init.jsp" %>
<div style="margin-bottom:10px;">
<button type="button" class="btn btn-primary" onclick="modalOpen();">ADD</button>
</div>
<div id="bookamrkList">
<c:choose>
<c:when test="${not empty bookmarks}">
<c:forEach var="book" items="${bookmarks}">
<div class="panel panel-primary" id="mark${book.getBookmarkId()}">
	<div class="panel-heading">
		<div class="panel-title"><a href="${book.getBookmarkUrl()}">${book.getBookmarkTitle()}</a></div>
	</div>
	<div class="panel-body">
		<div id="aui-message-bar">${book.getContent()}</div
		><button type="button" class="btn btn-danger" onclick="deleteBookmark('${book.getBookmarkId()}')">Remove</button>
	</div>
</div>
</c:forEach>
</c:when>
<c:otherwise>
<span id="nothing">nothing</span>
</c:otherwise>
</c:choose>
</div>
<div class="yui3-skin-sam">
  <div id="modal"></div>
</div>

<script>
function modalOpen(){
YUI().use(
  'aui-modal',
  function(Y) {
    var modal = new Y.Modal(
      {
        bodyContent: '<form class="form-inline"><label>URL</label><input id="url" class="form-control" type="text"><br><label>TITLE</label><input id="title" class="form-control" type="text"><br><label>CONTENT</label><input id="bookmarkContent" class="form-control" type="text"></form><div style="margin-top:10px;"><button type="button" class="btn btn-primary" onclick="addBookmark();">ADD</button></div>',
        centered: true,
        headerContent: '<h3>Add Favotite</h3>',
        modal: true,
        render: '#modal',
        width: 450
      }
    ).render();
  }
);
}
function addBookmark(){
Liferay.Service(
		  '/active.companybookmark/add-company-bookmark',
		  {
			  id: ${userId},
			  url:$("#url").val(),
			  title:$("#title").val(),
			  content:$("#bookmarkContent").val()
		},
		  function(obj) {
		    console.log(obj);
		    var content = '<div class="panel panel-primary" id="mark'+ obj.bookmarkId +'">' +
			'<div class="panel-heading">' +
			'<div class="panel-title"><a href="'+ obj.bookmarkUrl +'">'+ obj.bookmarkTitle +'</a></div>' +
			'</div>' +
			'<div class="panel-body">' +
			'<div id="aui-message-bar">' + obj.content + '</div>' +
			'<button type="button" class="btn btn-danger" onclick="deleteBookmark('+ obj.bookmarkId + ')">Remove</button>' +
			'</div>' +
			'</div>';
			$("#nothing").remove();
		    $("#bookamrkList").append(content);
		  }
);
}

function deleteBookmark(bookmarkNo){
	console.log(bookmarkNo);
	Liferay.Service(
			'/active.companybookmark/delete-company-bookmark',
			  {
			    bookmarkId: bookmarkNo
			  },
			  function(obj) {
			    console.log("1:"+obj.bookmarkId);
			    var bookmarkId = obj.bookmarkId;
			    $("#mark" + bookmarkId).remove();
			    console.log($("#mark" + bookmarkId));
			  }
			);
}
</script>