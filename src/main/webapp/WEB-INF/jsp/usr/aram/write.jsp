<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="경보기 추가" />
<%@ include file="../common/head.jspf"%>


<script>
	let AramWrite__submitDone = false;
	function AramWrite__submit(form) {
		if (AramWrite__submitDone) {
			alert('처리중입니다.');
			return;
		}

		form.area.value = form.area.value.trim();
		if (form.area.value.length == 0) {
			alert('구역을 입력해주세요.');
			form.area.focus();
			return;
		}

		form.intel.value = form.intel.value.trim();
		if (form.intel.value.length == 0) {
			alert('정보를 입력해주세요.');
			form.intel.focus();
			return;
		}

		form.submit();
		AramWrite__submitDone = true;
	}
</script>


<section class="mt-5">





	<div class="container mx-auto px-3">
		<form onsubmit="AramWrite__submit(this); return false;"
			class="table-box-type-1" method="POST" action="../aram/doWrite">
			<table>
				<colgroup>
					<col width="200" />
				</colgroup>
				<tbody>
					<tr>
						<th>구역</th>
						<td>
							<input class="form-style" name="area" placeholder="감지기가 추가된구역"
								type="text" />
						</td>
					</tr>
					<tr>
						<th>정보</th>
						<td>
							<input class="form-style" name="intel" placeholder="구역의 추가정보"
								type="text" />
						</td>
					</tr>


					<tr>
						<th></th>
						<td>
							<button type="submit" class="btn btn-primary">추가하기</button>
							<button type="button" class="btn btn-outline btn-success"
								onclick="history.back();">뒤로가기</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</section>



<%@ include file="../common/foot.jspf"%>