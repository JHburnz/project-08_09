<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>
<section class="mt-5">
  <div class="container mx-auto px-3">
    <form class="table-box-type-1" method="POST" action="../usr/aram/history">
      <table>
        <colgroup>
          <col width="100" />
          <col width="100" />
          <col width="50" />
          <col width="200" />
        </colgroup>
        <thead>
          <tr>
            <th>감지기식별번호</th>
            <th>화재발생시간</th>
            <th>구역</th>
            <th>구역추가정보</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="aram" items="${arams}">
            <c:if test="${rq.loginedMember.location == aram.ol}">
              <tr>
                <td>${history.id}</td>
                <td>${history.activeDate.substring(2, 16)}</td>
                <td>${history.area}</td>
                <td>${history.intel}</td>
              </tr>
            </c:if>
          </c:forEach>
        </tbody>
      </table>
    </form>

  </div>

</section>

<%@ include file="../common/foot.jspf"%>