<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/vue.js"></script>
    <%--<script src="${contextPath}/resources/js/vue-router.min.js"></script>--%>
    <script src="${contextPath}/resources/js/vue-resource.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
        <h4 class="text-center"><a href="${contextPath}/movieview">Show All Movie</a></h4>
    </c:if>

</div>


<%--<div class="container" id="app">
    <router-view></router-view>
</div>

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script type="vue/template" id="tableTemplate">
    <table class="table">
        <thead>
        <tr>
            <th>影片名称</th>
            <th width="50">评分</th>
            <th width="150">导演</th>
            <th width="100">发行年份</th>
        </tr>
        </thead>
        <tbody>
        <template v-for="movie in movies">
            <tr>
                <td><a v-link="'/movie/'+movie.id">{{person.lastName}}</a></td>
                <td>{{person.email}}</td>
                <td>{{person.lastName}}</td>
                <td>{{person.firstName}}</td>
            </tr>
        </template>
        </tbody>
    </table>
</script>
<div id="demo">
    <table>
        <thead>
        <tr>
            <th>username</th>
            <th>lastname</th>
            <th>email</th>
        </tr>
        </thead>
        <tbody v-if="personsList.length > 0">
        <tr v-for="item in personsList" >
            <td>{{ item.firstName }}</td>
            <td>{{ item.lastName }}</td>
            <td>{{ item.email }}</td>
        </tr>
        </tbody>
        <tbody v-else>
        <tr><td colspan="3">No DATA</td></tr>
        </tbody>
    </table>
</div>
<script>

    var appp = new Vue({
        el:"#demo",
        data:{personList:[{'email':'a','firstName':'Guo','lastName':'jason'}]}
    });

    function getPersons() {
        var that = this;
        appp.personList.push({'email':'gggg','lastName':'a'});

//        $.ajax({
//            url:"/spring4/persons",
//            type:'GET',
//            dataType:'json',
//            timeout:30000
//        }).done(function (data) {
//            var app = new Vue({
//                el:'#demo',
//                data:{personsList:[]}
//
//            });
//            data.forEach(function (item) {
//                alert(item.lastName);
//                app.personsList.push(item);
//            });
//        }).fail(function(){
//
//        });
    }
</script>
&lt;%&ndash;<script src="${contextPath}/resources/js/app.js"></script>&ndash;%&gt;
<div id="app1">
    <div id="searchBar">
        Search <input type="text" v-model="searchQuery" />
    </div>
    <simple-grid :data="gridData" :columns="gridColumns" :filter-key="searchQuery">
    </simple-grid>
</div>

<template id="grid-template">
    <table>
        <thead>
        <tr>
            <th v-for="col in columns">
                {{ col | capitalize}}
            </th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="entry in data | filterBy filterKey">
            <td v-for="col in columns">
                {{entry[col]}}
            </td>
        </tr>
        </tbody>
    </table>
</template>--%>

</body>
<script src="js/vue.js"></script>
</body>
</html>
