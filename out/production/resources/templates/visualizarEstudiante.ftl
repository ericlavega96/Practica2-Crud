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
    <table>
        <tr>
            <th>Matricula</th><th>Nombre</th><th>Apellido</th><th>Telefono</th>
        </tr>
        <tr>
                <tr>
                    <td>${estudiante.matricula?string["0"]}</td>
                    <td>${estudiante.nombre}</td>
                    <td>${estudiante.apellido}</td>
                    <td>${estudiante.telefono}</td>
                    <td><a href="/inicio.ftl">Editar</td>
                    <td><a href="/inicio.ftl">Eliminar</td>
                </tr>
        </tr>
    </table>
</body>
</html>