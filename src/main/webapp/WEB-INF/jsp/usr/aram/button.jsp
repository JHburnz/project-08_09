<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko" class="light" data-theme="light">
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle}</title>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- 테일윈드 불러오기 -->
<!-- 노말라이즈, 라이브러리까지 한번에 해결 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.7/tailwind.min.css" />

<!-- 데이지 UI -->
<link href="https://cdn.jsdelivr.net/npm/daisyui@2.19.0/dist/full.css" rel="stylesheet" type="text/css" />

<!-- 폰트어썸 불러오기 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />

<!-- 사이트 공통 CSS -->
<link rel="stylesheet" href="/resource/common.css" />
<!-- 사이트 공통 JS -->
<script src="/resource/common.js" defer="defer"></script>
</head>
<body>
  <header> 버튼페이지 </header>

  <section class="mt-5">
    <div class="container mx-auto px-3">
      <form class="table-box-type-1" method="POST" action="../usr/aram/button">
        <table>
          <colgroup>
            <col width="150" />
            <col width="50" />
          </colgroup>
          <thead>

          </thead>
          <tbody>

            <tr>
              <th>101호 주방 on</th>
              <td>
                <a class="btn-text-link" href="../aram/on?area=주방&ol=101호">on</a>
              </td>
            </tr>
            <tr>
              <th>101호 주방 off</th>
              <td>
                <a class="btn-text-link" href="../aram/off?area=주방&ol=101호">off</a>
              </td>
            </tr>
            <tr>
              <th>102호 주방 on</th>
              <td>
                <a class="btn-text-link" href="../aram/on?area=주방&ol=102호">on</a>
              </td>
            </tr>
            <tr>
              <th>102호 주방 off</th>
              <td>
                <a class="btn-text-link" href="../aram/off?area=주방&ol=102호">off</a>
              </td>
            </tr>


          </tbody>
        </table>
      </form>

    </div>

  </section>

</body>