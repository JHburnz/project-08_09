<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
	<div class="container mx-auto px-3">

		<c:if test="${!rq.isLogined()}">



			<form class="table-box-type-1" method="POST"
				action="../member/doLogin">
				<div class="section">
					<div class="container">
						<div class="row full-height justify-content-center">
							<div class="col-12 text-center align-self-center py-5">
								<div class="section pb-5 pt-5 pt-sm-2 text-center">
									<h6 class="mb-0 pb-3">
										<span>Log In </span>
										<span>Sign Up</span>
									</h6>
									<input class="checkbox" type="checkbox" id="reg-log"
										name="reg-log" />
									<label for="reg-log"></label>
									<div class="card-3d-wrap mx-auto">
										<div class="card-3d-wrapper">
											<div class="card-front">
												<div class="center-wrap">
													<div class="section text-center">
														<h4 class="mb-4 pb-3">로그인</h4>
														<div class="form-group">
															<input name="loginId" type="text" placeholder="로그인아이디"
																class="form-style" />
															<i class="input-icon uil uil-at"></i>
														</div>
														<div class="form-group mt-2">
															<input name="loginPw" type="password"
																placeholder="로그인비밀번호" class="form-style" />
															<i class="input-icon uil uil-lock-alt"></i>
														</div>
														<button type="submit" class="btn mt-4">로그인</button>

													</div>
												</div>
											</div>
											<div class="card-back">
												<div class="center-wrap">
													<div class="section text-center">
														<h4 class="mb-4 pb-3">Sign Up</h4>
														<div class="form-group">
															<input type="text" name="logname" class="form-style"
																placeholder="Your Full Name" id="logname"
																autocomplete="off">
															<i class="input-icon uil uil-user"></i>
														</div>
														<div class="form-group mt-2">
															<input type="email" name="logemail" class="form-style"
																placeholder="Your Email" id="logemail"
																autocomplete="off">
															<i class="input-icon uil uil-at"></i>
														</div>
														<div class="form-group mt-2">
															<input type="password" name="logpass" class="form-style"
																placeholder="Your Password" id="logpass"
																autocomplete="off">
															<i class="input-icon uil uil-lock-alt"></i>
														</div>
														<a href="#" class="btn mt-4">submit</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>

		</c:if>

		<c:if test="${rq.isLogined()}">

			<form class="table-box-type-1" method="POST"
				action="../usr/aram/list">
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