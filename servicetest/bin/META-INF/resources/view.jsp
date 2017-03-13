<%@ include file="/init.jsp" %>

<button type="button" class="btn btn-primary" onclick="modalOpen();">ADD</button>

<c:forEach var="book" items="${bookmarks}">
<div class="panel panel-primary">
	<div class="panel-heading">
		<div class="panel-title"><a href="${book.getBookmarkUrl()}">${book.getBookmarkTitle()}</a></div>
	</div>
	<div class="panel-body">
		<button type="button" class="btn btn-danger" onclick="deleteBookmark('${book.getBookmarkId()}')">Remove</button>
	</div>
</div>
</c:forEach>

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
        bodyContent: '<form class="form-inline"><label>URL</label><input id="myInput" class="form-control" type="text"><br><label>TITLE</label><input id="myInput" class="form-control" type="text"></form>',
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

function deleteBookmark(bookmarkId){
	console.log(bookmarkId);
}
</script>