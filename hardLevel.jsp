<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance</title>
</head>
<body>
    <h2>Enter Attendance Details</h2>
    <form action="saveAttendance" method="post">
        <label for="studentId">Student ID: </label>
        <input type="text" id="studentId" name="studentId"><br><br>

        <label for="attendance">Attendance: </label>
        <select name="attendance" id="attendance">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
