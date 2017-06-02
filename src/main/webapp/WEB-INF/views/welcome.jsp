<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <span class="navbar-brand">Welcome, ${pageContext.request.userPrincipal.name}</span>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="#">Current day</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <%--<h2>Welcome, ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>--%>

    </c:if>

    <sec:authorize access="hasRole('ROLE_USER')">
    <h1>
        <script>
            Data = new Date();
            Year = Data.getFullYear();
            Month = Data.getMonth();
            Day = Data.getDate();

            // Преобразуем месяца
            switch (Month)
            {
                case 0: fMonth="january"; break;
                case 1: fMonth="february"; break;
                case 2: fMonth="march"; break;
                case 3: fMonth="april"; break;
                case 4: fMonth="may"; break;
                case 5: fMonth="june"; break;
                case 6: fMonth="july"; break;
                case 7: fMonth="august"; break;
                case 8: fMonth="september"; break;
                case 9: fMonth="october"; break;
                case 10: fMonth="november"; break;
                case 11: fMonth="december"; break;
            }

            // Вывод
            document.write("Today is "+Day+" "+fMonth+" "+Year+" year");
        </script>
    </h1>

        <div class="container">
            <div class="row">
                <div class='col-sm-6'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker1'>
                            <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                    $(function () {
                        $('#datetimepicker').datetimepicker();
                    });
                </script>
            </div>
        </div>

        <div class="form-group">
            <label for="dtp_input1" class="col-md-2 control-label">DateTime Picking</label>
            <div class="input-group date form_datetime col-md-5" data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                <input class="form-control" size="16" type="text" value="" readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input1" value="" /><br/>
        </div>

    <table class="table table-condensed">
        <tr>
            <td>Total fats</td>
            <td>Total proteins</td>
            <td>Total carbohydrates</td>
            <td>
                <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${progressBar}" aria-valuemin="0" aria-valuemax="100" style="width:${progressBar}%">
                        ${progressBar}% Complete
                    </div>
                </div>
            </td>
            <td>Total calories</td>
        </tr>
        <tr>
            <td>${totalFats}</td>
            <td>${totalProteins}</td>
            <td>${totalCarbohydrates}</td>
            <td></td>
            <td>${totalCalories}</td>
        </tr>
    </table>

    <c:if test="${!empty listMeals}">
        <table class="table table-condensed">
            <tr>
                <th width="120">Date</th>
                <th width="120">Ingestion</th>
                <th width="120">Food</th>
                <th width="120">Fats</th>
                <th width="120">Proteins</th>
                <th width="120">Carbohydrates</th>
                <th width="120">Calories</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <tr class="success"><td><h1>Breakfast</h1></td></tr>
            <c:forEach items="${listMeals}" var="meal">
                <tr>
                    <c:if test="${pageContext.request.userPrincipal.name == meal.user.username && meal.ingestion.name == 'breakfast'}">
                        <td>${meal.dateCreated}</td>
                        <td>${meal.ingestion.name}</td>
                        <td>${meal.food.name}</td>
                        <td>${meal.food.fats}</td>
                        <td>${meal.food.proteins}</td>
                        <td>${meal.food.carbohydrates}</td>
                        <td>${meal.food.calories}</td>
                        <td><a href="<c:url value='/editMeal/${meal.id}'/>">Edit</a></td>
                        <td><a href="<c:url value='/removeMeal/${meal.id}'/>">Delete</a></td>
                    </c:if>
                </tr>
            </c:forEach>

            <tr class="success"><td><h1>Lunch</h1></td></tr>
            <c:forEach items="${listMeals}" var="meal">
                <tr>
                    <c:if test="${pageContext.request.userPrincipal.name == meal.user.username && meal.ingestion.name == 'lunch'}">
                        <td>${meal.dateCreated}</td>
                        <td>${meal.ingestion.name}</td>
                        <td>${meal.food.name}</td>
                        <td>${meal.food.fats}</td>
                        <td>${meal.food.proteins}</td>
                        <td>${meal.food.carbohydrates}</td>
                        <td>${meal.food.calories}</td>
                        <td><a href="<c:url value='/editMeal/${meal.id}'/>">Edit</a></td>
                        <td><a href="<c:url value='/removeMeal/${meal.id}'/>">Delete</a></td>
                    </c:if>
                </tr>
            </c:forEach>

            <tr class="success"><td><h1>Dinner</h1></td></tr>
            <c:forEach items="${listMeals}" var="meal">
                <tr>
                    <c:if test="${pageContext.request.userPrincipal.name == meal.user.username && meal.ingestion.name == 'dinner'}">
                        <td>${meal.dateCreated}</td>
                        <td>${meal.ingestion.name}</td>
                        <td>${meal.food.name}</td>
                        <td>${meal.food.fats}</td>
                        <td>${meal.food.proteins}</td>
                        <td>${meal.food.carbohydrates}</td>
                        <td>${meal.food.calories}</td>
                        <td><a href="<c:url value='/editMeal/${meal.id}'/>">Edit</a></td>
                        <td><a href="<c:url value='/removeMeal/${meal.id}'/>">Delete</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <button class="btn-success"><a href="/ingestion">Ingestion list</a></button>
        <button class="btn-success"><a href="/foods">Foods list</a></button>
    </sec:authorize>

</div>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>

<script src="${contextPath}/resources/js/jquery-1.11.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${contextPath}/resources/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${contextPath}/resources/js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>

</body>
</html>