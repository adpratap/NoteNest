# NoteNest
Spring Boot : Note taking app !!


// VERSIONS
<version>2.7.18</version>
<java.version>1.8</java.version>

jdbcTemplate.update > for DELETE , INSERT , UPDATE

jdbcTemplate.queryForObject(sql, <ANY>.class , args)
jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(ViewData.class), userId);
jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ViewData.class));
db.queryForObject(q, new RowMapperImpl() , args);
public class RowMapperImpl implements RowMapper<NoteNest> {

	@Override
	public NoteNest mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoteNest note = new NoteNest();
        note.setId(rs.getInt("id"));
        note.setTitle(rs.getString("title"));
        note.setBody(rs.getString("body"));
        note.setTime(rs.getTimestamp("time"));
        return note;
	}

}

// TAGS For JSTL
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

// for Head
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Include jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Include Toastr.js -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

// for body
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.url=jdbc:mysql://<server>:3306/<dbName>

spring.mvc.view.prefix: /views/
spring.mvc.view.suffix: .jsp


 <dependency>
            <groupId>jakarta.servlet.jsp.jstl</groupId>
            <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
</dependency>

<dependency>
            <groupId>org.glassfish.web</groupId>
            <artifactId>jakarta.servlet.jsp.jstl</artifactId>
</dependency>

<dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <scope>provided</scope> <!--default for IntelliJ -->
</dependency>

//form
<form action="/addFeedback" method="post" enctype="multipart/form-data">

<c:forEach var="item" items="list">
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.body}</td>
                <td>${item.time}</td>
                <a href="" ><button type="button" class="btn btn-warning">Update</button></a>
                <a href="" ><button type="button" class="btn btn-danger">Delete</button></a>
            </tr>
</c:forEach>
  
<script>
toastr.success('Action successful!');
toastr.error('Action failed!');
toastr.warning('This is a warning message.');
toastr.info('This is an information message.');
</script>

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
