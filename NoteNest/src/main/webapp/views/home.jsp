<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>NoteNest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Include jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Include Toastr.js -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
</head>
<body>

    
    <c:if test="${not empty status}">
        <c:if test="${status}">
            <script>
                toastr.success("Success!!!")
            </script>
        </c:if>
        <c:if test="${not status}">
            <script>
                toastr.error("Failed!!!")
            </script>
        </c:if>
    </c:if>

    <div class="container text-center"><h1>Note Nest</h1></div>
    <div class="container text-center"><a href="/add" ><button type="button" class="btn btn-success">Add Note</button></a></div>

    <div class="container text-center">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Title</th>
                <th scope="col">Body</th>
                <th scope="col">Time</th>
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.title}</td>
                        <td>${item.body}</td>
                        <td>${item.time}</td>
                        <td><a href="/update/${item.id}" ><button type="button" class="btn btn-warning">Update</button></a></td>
                        <td><a href="/delete/${item.id}" ><button type="button" class="btn btn-danger">Delete</button></a></td>
                    </tr>
                </c:forEach>
            
            </tbody>
          </table>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>