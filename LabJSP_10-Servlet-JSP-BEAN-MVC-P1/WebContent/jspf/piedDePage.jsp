<%@page import="java.util.Date, java.text.DateFormat" %>
<%! DateFormat formatDate = DateFormat.getDateInstance(DateFormat.FULL); %>
<br><hr>
<h4 align="right"><%= formatDate.format(new Date()) %></h4>
</body>
</html>