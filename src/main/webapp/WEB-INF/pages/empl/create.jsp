<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>Add new user</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" >
    <link href="<c:url value="/res/css/main.css" />" rel="stylesheet">
</head>
<body >
<div class="container">
    <div class="col-md-6">
<form method="post" action="/employeeSaveOrUpdate" >
            <div class="row">
                <p>firstName :</p>
                <input type="text" name="firstName" value="<c:out value="${employee.firstName}" />" /> <br/>
                <p class="error"> ${error.get("firstName")}</p>
            </div>
            <div class="row">
                <p>secondName :</p>  <input type="text" name="secondName" value="<c:out value="${employee.secondName}" />" /> <br/>
                <p class="error"> ${error.get("secondName")}</p>
            </div>
            <div class="row">
                <p>Birthday :</p> <input type="date" name="birthday" id="dateInput" required value="${param['birthday'] eq null ? employee.birthday : param['birthday']}"/><br />
                <p class="error"> ${error.get("birthday")}</p>
            </div>
            <div class="row">
                <p>Email :</p>  <input type="text" name="email" placeholder="email..." value="<c:out value="${employee.email}" />" /> <br/>
                <p class="error"> ${error.get("email")}</p>
            </div>
                <input type="hidden" name="depId" value="<c:out value="${depId}" />" >
                <input type="hidden" name="id" value="<c:out value="${employee.id}" />">
                <input type="submit" value="Submit" />

</form>
    </div>
</div>
</body>
</html>