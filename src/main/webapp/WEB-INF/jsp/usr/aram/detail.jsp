<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="../common/head.jspf"%>

<script>
	const params = {};
	params.id = parseInt('${param.id}');
</script>

<script>
	function ArticleDetail__increaseHitCount() {
		const localStorageKey = 'article__' + params.id + '__viewDone';
		if (localStorage.getItem(localStorageKey)) {
			return;
		}
		localStorage.setItem(localStorageKey, true);
		$.get('../article/doIncreaseHitCountRd', {
			id : params.id,
			ajaxMode : 'Y'
		}, function(data) {
			$('.article-detail__hit-count').empty().html(data.data1);
		}, 'json');
	}
	$(function() {
		// 실전코드
		// ArticleDetail__increaseHitCount();
		// 임시코드
		setTimeout(ArticleDetail__increaseHitCount, 500);
	})
</script>



<section class="mt-5">
	<div class="container mx-auto px-3">
		<div class="table-box-type-1">
			<table>
				<colgroup>
					<col width="200" />
				</colgroup>
				<tbody>

					<tr>
						<th>가동날짜</th>
						<td>${aram.regDate}</td>
					</tr>
					<tr>
						<th>점검날짜</th>
						<td>${aram.updateDate}</td>
					</tr>
					<tr>
						<th>위치</th>
						<td>${aram.area}</td>
					</tr>
					<tr>
						<th>상세내용</th>
						<td>${aram.intel}</td>
					</tr>
				</tbody>
			</table>
		</div>


	</div>
</section>







<%@ include file="../common/foot.jspf"%>