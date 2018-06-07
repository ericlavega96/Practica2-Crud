<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
        <style>
            button:hover{
                background-color: lightgray;
            }
        </style>
    </head>
    <body>
        <#include "menuBar.ftl">
        <form action="/procesarEstudiante" method="post">
            <br>
             Matricula:<br>
            <input name="matricula" type="number">
            <br>
            <br>
             Nombre:<br>
            <input name="nombre" type="text">
            <br>
            <br>
             Apellido:<br>
            <input name="apellido" type="text">
            <br>
            <br>
             Teléfono:<br>
            <input name="telefono" type="text">
            <br>
            <br>
            <button name="agregarEstudianteButton" type="submit">Agregar Estudiante</button>
        </form>
    </body>
</html>