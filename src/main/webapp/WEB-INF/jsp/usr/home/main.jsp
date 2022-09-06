<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3">

    <c:if test="${!rq.isLogined()}">

      <form class="table-box-type-1" method="POST" action="../member/doLogin">
        <table>
          <tr>
            <th>로그인아이디</th>
            <td>
              <input name="loginId" type="text" placeholder="로그인아이디" class=" w-96 input input-bordered w-full max-w-xs" />
            </td>
          </tr>
          <tr>
            <th>로그인비밀번호</th>
            <td>
              <input name="loginPw" type="password" placeholder="로그인비밀번호"
                class=" w-96 input input-bordered w-full max-w-xs" />
            </td>
          </tr>
          <tr>
            <th>로그인</th>
            <td>
              <a href="/usr/member/join" class="btn btn-primary">
                <span>회원가입</span>
              </a>
              <button type="submit" class="btn btn-primary">로그인</button>
              <button type="button" class="btn btn-outline btn-success" onclick="history.back();">뒤로가기</button>
            </td>
          </tr>
        </table>
      </form>

    </c:if>

    <c:if test="${rq.isLogined()}">

      <form class="table-box-type-1" method="POST" action="../usr/aram/list">
        <h1>작동상황</h1>
        <table>
          <colgroup>
            <col width="75" />
            <col width="200" />
            <col width="75" />
            <col width="300" />
          </colgroup>
          <thead>
            <tr>
              <th>위치</th>
              <th>작동시간</th>
              <th>구역</th>
              <th>추가정보</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="aram" items="${arams}">
              <c:if test="${rq.loginedMember.location == aram.ol}">
                <c:if test="${aram.stat == 1}">
                  <tr>
                    <td>${aram.ol}</td>
                    <td>${aram.activeDate.substring(2, 16)}</td>
                    <td>${aram.area}</td>
                    <td>${aram.intel}</td>
                  </tr>
                </c:if>
              </c:if>
            </c:forEach>
          </tbody>
        </table>
      </form>

    </c:if>

  </div>
</section>

<%@ include file="../common/foot.jspf"%>