<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="메인" />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3">
    <form class="table-box-type-1" method="POST" action="../member/doLogin">
      <table>
        <colgroup>
          <col width="200" />
        </colgroup>
        <tbody>

          <c:if test="${!rq.isLogined()}">
            <tr>
              <th>로그인아이디</th>
              <td>
                <input name="loginId" type="text" placeholder="로그인아이디"
                  class=" w-96 input input-bordered w-full max-w-xs" />
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
          </c:if>

          <c:if test="${rq.Logined}">
            <th>로그인아이디</th>


          </c:if>





        </tbody>
      </table>
    </form>
  </div>
</section>


<%@ include file="../common/foot.jspf"%>