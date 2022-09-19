<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 내용" />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
	<div class="container mx-auto px-3">
		<div class="table-box-type-1">
			<table>
				<colgroup>
					<col width="200" />
				</colgroup>
				<tbody>

					<tr>
						<th>위치</th>
						<td>${aram.ol}</td>
					</tr>
					<tr>
						<th>구역</th>
						<td>${aram.area}</td>
					</tr>
					<tr>
						<th>작동날짜</th>
						<td>${aram.workDate.substring(2, 16)}</td>
					</tr>
					<tr>
						<th>점검날짜</th>
						<td>${aram.repairDate.substring(2, 16)}</td>
					</tr>
					<tr>
						<th>특이사항</th>
						<td>${aram.intel}</td>
					</tr>
					<tr>
						<th></th>
						<td>
							<a class="btn btn-primary" href="../aram/modify?id=${aram.id}">게시물
								수정</a>
							<a class="btn btn-primary"
								onclick="if ( confirm('정말 삭제하시겠습니까?') == false) return false;"
								href="../aram/doDelete?id=${aram.id}">게시물 삭제</a>
							<button type="submit" class="btn btn-primary"
								onclick="history.back();">뒤로가기</button>
						</td>

					</tr>
				</tbody>
			</table>
		</div>

	</div>

</section>

<%@ include file="../common/foot.jspf"%>