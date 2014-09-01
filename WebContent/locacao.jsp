<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Página de Locação</title>
    </head>
    <body>
    	<form action="salvarAlocacao" method="POST">
    		Nome do locador:
    		<input name="nome" type="text" size="30"/>
    		<br/>    	
	    	Selecione o carro:
		    <select name="sel_carro">
		    	<c:forEach items="${carros}" var="carro">
			    	<option value="${carro}" ${carro.ativo} title="${carro.descricao}">${carro.fabricante} ${carro.modelo}</option>
			    </c:forEach>
			</select>
			<br/>
			Data de início:
			<input name="dia_inicio" type="text" maxlength="2" style="width:20px"/>
			<input name="mes_inicio" type="text" maxlength="2" style="width:20px"/>
			<input name="ano_inicio" type="text" maxlength="4" style="width:40px"/>
			<br/>
			Data de fim:
			<input name="dia_fim" type="text" maxlength="2" style="width:20px"/>
			<input name="mes_fim" type="text" maxlength="2" style="width:20px"/>
			<input name="ano_fim" type="text" maxlength="4" style="width:40px"/>
			<br/>
			Selecione o cliente:
		    <select name="sel_cliente">
		    	<c:forEach items="${clientes}" var="cliente">
			    	<option value="${cliente.id}" ${cliente.ativo} title="${cliente.descricao}"> ${cliente.nome} </option>
			    </c:forEach>
			</select>
			<br/><br/>
			<input type="submit" value="Alocar" />
		</form>
    </body>
</html>