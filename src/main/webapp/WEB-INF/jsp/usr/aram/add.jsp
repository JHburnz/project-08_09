<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="구역추가" />
<%@ include file="../common/head.jspf"%>

<script>
	let submitJoinFormDone = false;
	function submitJoinForm(form) {
		if (submitJoinFormDone) {
			alert('처리중입니다.');
			return;
		}

		form.area.value = form.area.value.trim();
		if (form.area.value.length == 0) {
			alert('구역을 입력해주세요');
			form.area.focus();
			return;
		}
		submitJoinFormDone = true;
		form.submit();
	}
</script>

<section class="mt-5">
  <div class="container mx-auto px-3">
    <div class="table-box-type-1">
      <form class="table-box-type-1" method="POST" action="../aram/add" onsubmit="submitJoinForm(this); return false;">
        <input type="hidden" name="afterJoinUri" value="${param.afterJoinUri}" />
        <table>
          <colgroup>
            <col width="200" />
          </colgroup>
          <tbody>
            <tr>
              <th>구역</th>
              <td>
                <input class="input input-bordered" name="area" placeholder="감지기가 추가된구역" type="text" />
              </td>
            </tr>

            <tr>
              <th></th>
              <td>
                <button type="submit" class="btn btn-primary">추가하기</button>
                <button type="button" class="btn btn-outline btn-success" onclick="history.back();">뒤로가기</button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>
</section>



<%@ include file="../common/foot.jspf"%>