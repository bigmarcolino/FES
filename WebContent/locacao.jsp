<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Página de Locação</title>
    </head>
    <body>
    	<form action="">    	
	    	Selecione o carro:
		    <select name="sel_carro">
		    	<c:forEach items="${carros}" var="carro">
			    	<option value="${carro.id}">${carro.fabricante} ${carro.modelo}</option>
			    </c:forEach>
			</select>
			<br/>
			<input type="submit" value="Alocar" />
		</form>
    </body>
</html>