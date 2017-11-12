<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>Insert title here</title>
</head>
<body>
<h3>게시글 목록</h3>
    <button class="btn btn-primary" style="float : right;" onclick="location.href='/board/post'">작성</button>
    <table class="table">
        <tr>
            <th>No</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성날짜</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="board" items="${list}">
        <tr>
            <td>${board.seq}</td>
            <td><a href="/board/${board.seq}">${board.title}</a></td>
            <td><fmt:formatDate value="${board.cnt_time}" pattern="MM/ dd" /></td>
            <td>${board.hit}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>