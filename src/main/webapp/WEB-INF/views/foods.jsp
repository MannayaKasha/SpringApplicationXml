<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Foods Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="/">Back to main menu</a>

<br/>
<br/>

<h1>Food List</h1>

<c:if test="${!empty listFoods}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">Name</th>
            <th width="120">Fats</th>
            <th width="120">Proteins</th>
            <th width="120">Carbohydrates</th>
            <th width="120">Calories</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listFoods}" var="food">
            <tr>
                <td>${food.id}</td>
                <td><%--<a href="/bookdata/${book.id}" target="_blank">--%>${food.name}<%--</a>--%></td>
                <td>${food.fats}</td>
                <td>${food.proteins}</td>
                <td>${food.carbohydrates}</td>
                <td>${food.calories}</td>
                <td><a href="<c:url value='/editFood/${food.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeFood/${food.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Food</h1>

<c:url var="addAction" value="/foods/add"/>

<form:form action="${addAction}" commandName="food">
    <table>
        <c:if test="${!empty food.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="fats">
                    <spring:message text="Fats"/>
                </form:label>
            </td>
            <td>
                <form:input path="fats"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="proteins">
                    <spring:message text="Proteins"/>
                </form:label>
            </td>
            <td>
                <form:input path="proteins"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="carbohydrates">
                    <spring:message text="Carbohydrates"/>
                </form:label>
            </td>
            <td>
                <form:input path="carbohydrates"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="calories">
                    <spring:message text="Calories"/>
                </form:label>
            </td>
            <td>
                <form:input path="calories"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty food.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Food"/>"/>
                </c:if>
                <c:if test="${empty food.name}">
                    <input type="submit"
                           value="<spring:message text="Add Food"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
