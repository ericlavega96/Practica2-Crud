<!DOCTYPE html>
<html>
<head>
    <title>${titulo}</title>
</head>
<body>
    <#include "/menuBar.ftl">
    <p>
        Cantidad de estudiantes: ${listaEstudiantes?size}
    </p>
    <table>
        <tr>
            <th>Matricula</th><th>Nombre</th><th>Apellido</th><th>Telefono</th>
        </tr>
        <tr>
            <#list listaEstudiantes as estudiante>
                <tr>
                    <td>${estudiante.matricula?string["0"]}</td>
                    <td>${estudiante.nombre}</td>
                    <td>${estudiante.apellido}</td>
                    <td>${estudiante.telefono}</td>
                </tr>
            </#list>
        </tr>
    </table>
</body>
</html>