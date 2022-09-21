<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3">
    <form class="table-box-type-1" method="POST" action="../aram/doModify">
      <input type="hidden" name="id" value="${aram.id}" />
      <table>
        <colgroup>
          <col width="200" />
        </colgroup>
        <tbody>
          <tr>
            <th>번호</th>
            <td>
              <div>${aram.id}</div>
            </td>
          </tr>

          <tr>
            <th>구역</th>
            <td>${aram.area}</td>
          </tr>

          <tr>
            <th>특이사항</th>
            <td>
              <textarea class="w-full textarea textarea-bordered" name="intel" rows="10" placeholder="내용">수정할내용을 입력하세요</textarea>
            </td>
          </tr>
          <tr>
            <th>수정</th>
            <td>
              <input type="submit" class="btn btn-primary" value="수정" />
              <button type="button" class="btn btn-outline btn-success" onclick="history.back();">뒤로가기</button>
            </td>
          </tr>
        </tbody>
      </table>


      </from>
  </div>
</section>

<%@ include file="../common/foot.jspf"%>