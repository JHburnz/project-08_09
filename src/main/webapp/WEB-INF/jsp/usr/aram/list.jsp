<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="게시물 리스트" />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3">

    <table>
      <colgroup>
        <col width="50" />
        <col width="150" />
        <col width="150" />
        <col width="150" />
        <col />
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
          <tr>
            <td>${aram.oL}</td>
            <td>${aram.workDate.substring(2, 16)}</td>
            <td>${aram.repairDate.substring(2, 16)}</td>
            <td>${aram.area}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  </div>
</section>

<%@ include file="../common/foot.jspf"%>