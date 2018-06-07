<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
        <style>
            table{
                width: 50%;
            }

            th{
                background-color: lightgrey;
            }

            th, td {
                text-align: left;
            }

            a{
                text-align: center;
                display: block;
            }

        </style>
    </head>
    <body>
        <#include "menuBar.ftl">
        <p>
            Cantidad de estudiantes: ${listaEstudiantes?size}
        </p>
        <table>
            <tr>
                <th>Matricula</th><th>Nombre</th><th>Apellido</th><th>Telefono</th>
            </tr>
            <tr>
                <#assign x = 0>
                <#list listaEstudiantes as estudiante>
                    <tr>
                        <td>${estudiante.matricula?string["0"]}</td>
                        <td>${estudiante.nombre}</td>
                        <td>${estudiante.apellido}</td>
                        <td>${estudiante.telefono}</td>
                        <td><a href="/visualizarEstudiante/${x}">Visualizar</td>
                        <td><a href="/editarEstudiante/${x}">Editar</td>
                        <td><a href="/eliminarEstudiante/${x}">Eliminar</td>
                    </tr>
                    <#assign x++>
                </#list>
            </tr>
        </table>
    </body>
</html>