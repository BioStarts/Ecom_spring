<!DOCTYPE html>

<html>
    <body>
        <h1>Mod Simple Form Example</h1>

        <%-- GET http://localhost:8189/app/mod_form_processing?studentName=Bob --%>

        <form action="mod_form_processing" method="GET">
            <input type="text" name="studentName" placeholder="Enter student name" />
            <input type="submit" />
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/">to Index Page</a>
    </body>
</html>