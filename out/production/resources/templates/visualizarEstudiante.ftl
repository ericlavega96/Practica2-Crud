<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
        <style>
            table{
                width: auto;
            }
            td,th {
                text-align: left;
            }
        </style>
    </head>
    <body>
        <#include "menuBar.ftl">
        <table>
            <tr>
                <th>Matricula:</th>
                <td>${estudiante.matricula?string["0"]}</td>
            </tr>
            <tr>
                <th>Nombre:</th>
                <td>${estudiante.nombre}</td>
            </tr>
            <tr>
                <th>Apellido:</th>
                <td>${estudiante.apellido}</td>
            </tr>
            <tr>
                <th>Teléfono:</th>
                <td>${estudiante.telefono}</td>
            </tr>
            <tr>
                <td><a href="/editarEstudiante/${idEstudiante}">Editar</td>
                <td><a href="/eliminarEstudiante/${idEstudiante}">Eliminar</td>
            </tr>
        </table>
    </body>
</html>