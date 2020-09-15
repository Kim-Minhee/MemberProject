<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="include/header.jsp" %>

<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

	<!-- Main Content -->
	<div id="content">

		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Page Heading -->
			<br />
			<h1 class="h3 mb-2 text-gray-800">회원 목록</h1>
			<p class="mb-4">
				아직 회원이 아니시라면 <a href="register">회원 가입</a>을 해주세요!
			</p>

			<!-- DataTales Example -->
			<div class="card shadow mb-4">

				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
							<thead>
								<tr align="center">
									<th>회원 번호</th>
									<th>이름</th>
									<th>이메일</th>
									<th>가입일</th>
									<th>수정일</th>
									<th>수정 / 삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ members }" var="member">
									<tr align="center">
										<td>
											<c:out value="${ member.mno }" />
										</td>
										<td>
											<c:out value="${ member.mname }" />
										</td>
										<td>
											<c:out value="${ member.email }" />
										</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd" value="${ member.cre_date }" />
										</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd" value="${ member.cre_date }" />
										</td>
										<td>
											<a href="">수정</a> / 
											<a href="">삭제</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- End of Main Content -->

	<!-- Footer -->
	<footer class="sticky-footer bg-white">
		<div class="container my-auto">
			<div class="copyright text-center my-auto">
				<span>Copyright &copy; Your Website 2020</span>
			</div>
		</div>
	</footer>
	<!-- End of Footer -->

</div>
<!-- End of Content Wrapper -->

<%@ include file="include/footer.jsp" %>