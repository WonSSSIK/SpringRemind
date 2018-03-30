<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<%@include file="../include/header.jsp"%>
<script>
var result = '${msg}';

if(result=='success'){
	alert("처리가 완료되었습니다.");
}

</script>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">List ALL PAGE</h3>
				</div>
				<!-- /.box-header -->

	<table class="table table-bordered">
		<tr>
			<th style="width:10px">BNO</th>
			<th>Title</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th style="width:40px">VIEWCNT</th>
		</tr>
		
	<c:forEach items="${list}" var="boardVO">
		<tr>
			<td>${boardVO.bno }</td>
			<td><a href='/board/read?bno=${boardVO.bno }'>${boardVO.title }</a></td>
			<td>${boardVO.writer }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate }"/></td>
			<td><span class="badge ge-red">${boardVO.viewcnt }</span></td>
		</tr>
	</c:forEach>
	</table>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
