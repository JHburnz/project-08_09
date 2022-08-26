<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="${board.name} 게시물 리스트" />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3">

    <div class="mt-3">
      <table class="table table-fixed w-full">
        <colgroup>
          <col width="50" />
          <col width="100" />
          <col width="100" />
          <col width="50" />
          <col width="50" />
          <col width="100" />
          <col />
        </colgroup>
        <thead>
          <tr>
            <th>구역</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="aram" items="${arams}">
            <tr class="hover">

              <td>${aram.area}</td>
              <td>
                <a class="btn-text-link block w-full truncate" href=aram.area>${aram.area}</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</section>

<%@ include file="../common/foot.jspf"%>