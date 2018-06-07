<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
    </head>
    <body>
        <#include "menuBar.ftl">
        <form action="/salvarEstudianteEditado" method="post">
            <br>
             Matricula:<br>
            <input name="matricula" type="number" value = ${estudiante.matricula?string["0"]}>
            <br>
            <br>
             Nombre:<br>
            <input name="nombre" type="text" value = ${estudiante.nombre}>
            <br>
            <br>
             Apellido:<br>
            <input name="apellido" type="text" value = ${estudiante.apellido}>
            <br>
            <br>
             Telefono:<br>
            <input name="telefono" type="text" value = ${estudiante.telefono}>
            <br>
            <br>
            <button name="salvarCambiosButton" type="submit">Salvar Cambios</button>
        </form>
    </body>
</html>