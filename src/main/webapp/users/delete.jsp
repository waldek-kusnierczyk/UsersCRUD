<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>

    <!-- table list -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuwanie użytkownika</h6>
        </div>
        <div class="card-body">
            <h6 class="m-0 font-weight-bold text-danger">Czyna pewno chcesz usunąć tego użytkownika?</h6>

            <table class="table">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">${userToDelete.id}</th>
                </tr>
                <tr>
                    <th scope="col">Nazwa Użytkownika</th>
                    <th scope="col">${userToDelete.username}</th>
                </tr>
                <tr>
                    <th scope="col">Email</th>
                    <th scope="col">${userToDelete.email}</th>
                </tr>
            </table>
            <form method="post">
                <input type="hidden" class="form-control" name="id" id="id" value="${userToDelete.id}">
                <button type="submit" name="submitType" value="ok" class="btn btn-primary">Usuń</button>
                <button type="submit" name="submitType" value="cancel" class="btn btn-primary">Anuluj</button>
            </form>

        </div>
    </div>



</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>