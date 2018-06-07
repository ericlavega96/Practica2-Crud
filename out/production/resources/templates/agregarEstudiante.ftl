<!DOCTYPE html>
<html>
<head>
    <title>Agregar estudiante</title>
</head>
<body>
    <#include "/menuBar.ftl">
    <form action="/agregarEstudiante" method="post">
        <br>
         Matricula:<br>
        <input name="matricula" type="number"/>
        <br>
        <br>
         Nombre:<br>
        <input name="nombre" type="text"/>
        <br>
        <br>
         Apellido:<br>
        <input name="apellido" type="text"/>
        <br>
        <br>
         Telefono:<br>
        <input name="telefono" type="text"/>
        <br>
        <br>
        <button name="Enviar" type="submit">Enviar</button>
    </form>
</body>
</html>