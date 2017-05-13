<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp"/>

検索結果：<s:property value="noteList.size"/>件
<br>
<table class="table table-striped table-hover">
    <thead>
        <tr>
        	<th>No.</th>
        	<th>note_id</th>
        	<th>Title</th>
        	<th>Tags</th>
        	<th>LastUpdate</th>
        </tr>
    </thead>
    <tbody>
		<s:iterator value="noteList" status="st">
	    	<tr>
	    		<td><s:property value="#st.index + 1"/></td>
	    		<td><s:property value="note_id"/></td>
	    		<td><s:property value="title"/></td>
	    		<td><s:property value="tag"/></td>
	    		<td><s:property value="last_update"/></td>
	    	</tr>
		</s:iterator>
    </tbody>
</table>


<jsp:include page="footer.jsp"/>
