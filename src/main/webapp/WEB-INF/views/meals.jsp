<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Meals Page</title>

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

<h1>Meals List</h1>

<c:if test="${!empty listMeals}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">User</th>
            <th width="120">Date</th>
            <th width="120">Ingestion</th>
            <th width="120">Food</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listMeals}" var="meal">
            <tr>
                <td>${meal.id}</td>
                <td><%--<a href="/bookdata/${book.id}" target="_blank">--%>${meal.user.username}<%--</a>--%></td>
                <td>${meal.dateCreated}</td>
                <td>${meal.ingestion.name}</td>
                <td>${meal.food.name}</td>
                <td><a href="<c:url value='/editMeal/${meal.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeMeal/${meal.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Meal</h1>

<c:url var="addAction" value="/meals/add"/>

<form:form action="${addAction}" commandName="meal">
    <table>
        <c:if test="${!empty meal.id}">
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
                <form:label path="user.username">
                    <spring:message text="User"/>
                </form:label>
            </td>
            <td>
                <form:input path="user.username"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dateCreated">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateCreated"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ingestion.name">
                    <spring:message text="Ingestion"/>
                </form:label>
            </td>
            <td>
                <form:input path="ingestion.name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="food.name">
                    <spring:message text="Food"/>
                </form:label>
            </td>
            <td>
                <form:input path="food.name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty meal.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Meal"/>"/>
                </c:if>
                <c:if test="${empty meal.id}">
                    <input type="submit"
                           value="<spring:message text="Add Meal"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
