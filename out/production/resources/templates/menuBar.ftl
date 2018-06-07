<!DOCTYPE html>
<head>
	<title>Practica #2: CRUD</title>
    <style>
        ul{
            list-style: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: lightgrey;
        }
        li{
            float:left;
        }
        li a {
            display: block;
            text-align: center;
            text-decoration:none;
            padding: 14px 16px;
            color: black;
        }
        h1{
            text-align: center;
            color: black;
        }
    </style>
</head>
<body>
    <h1>${encabezado}</h1>
	<div>
		<ul text-decoration = none>
			<li><a href = "/inicio">Inicio</a></li>
			<li><a href="/agregarEstudiante">Agregar Estudiante</a></li>
			<li><a href="/listaEstudiantes">Lista de Estudiantes</a></li>
		</ul>
	</div>
</body>
</html>