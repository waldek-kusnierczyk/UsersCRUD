<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
                    </div>

                    <!-- table list -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Lista użytkowników</h6>
                        </div>
                        <div class="card-body">

                            <table class="table">
                                <!--
                                <caption>List of users</caption> -->
                                <thead class="text-primary">
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Nazwa Użytkownika</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Akcja</th>
                                </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="user" items="${users}">
                                        <tr>
                                            <th scope="row">${user.id}</th>
                                            <td>${user.username}</td>
                                            <td>${user.email}</td>
                                            <td><a href="" >Usuń</a> <a href="" >Edit</a> <a href="" >Pokaż</a></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>

                            </table>
                        </div>
                    </div>



                </div>
                <!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>