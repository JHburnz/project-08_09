<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 리스트" />
<%@ include file="../common/head.jspf"%>
<section class="mt-5">
	<div class="container mx-auto px-3">
		<form class="table-box-type-1" method="POST" action="../usr/aram/list">
			<table>
				<colgroup>
					<col width="50" />
					<col width="150" />
					<col width="150" />
					<col width="50" />
				</colgroup>
				<thead>
					<tr>
						<th>위치</th>
						<th>설치날짜</th>
						<th>점검날짜</th>
						<th>구역</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="aram" items="${arams}">
						<c:if test="${rq.loginedMember.location == aram.ol}">
							<tr>
								<td>${aram.ol}</td>
								<td>${aram.workDate.substring(2, 16)}</td>
								<td>${aram.repairDate.substring(2, 16)}</td>
								<td>
									<a class="btn-text-link" href="../aram/detail?id=${aram.id}">${aram.area}</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</form>

	</div>

</section>

<%@ include file="../common/foot.jspf"%>