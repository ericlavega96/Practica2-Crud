import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class Main {

    private static ArrayList<Estudiante> misEstudiantes = new ArrayList<Estudiante>();

    private static String idEstudianteActual;

    public static void main(String[] args) {

        staticFiles.location("/templates");

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        cfg.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(cfg);

        get("/inicio", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            attributes.put("encabezado", "Bienvenido al Gestor Estudiantil");
            return new ModelAndView(attributes, "inicio.ftl");
        }, freeMarkerEngine);

        get("/agregarEstudiante", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Agregar Estudiante");
            attributes.put("encabezado", "Agregar Estudiante");
            return new ModelAndView(attributes, "agregarEstudiante.ftl");
        }, freeMarkerEngine);

        get("/listaEstudiantes", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Lista de Estudiantes");
            attributes.put("encabezado", "Lista de Estudiantes");
            attributes.put("listaEstudiantes",misEstudiantes);
            return new ModelAndView(attributes, "listaEstudiantes.ftl");
        }, freeMarkerEngine);

        post("/procesarEstudiante", (request, response) -> {
                    try {
                        String matricula = request.queryParams("matricula");
                        String nombre = request.queryParams("nombre");
                        String apellido = request.queryParams("apellido");
                        String telefono = request.queryParams("telefono");
                        misEstudiantes.add(new Estudiante(Integer.parseInt(matricula.replaceAll("\\D", "")), nombre, apellido, telefono));
                        response.redirect("/listaEstudiantes");
                    } catch (Exception e) {
                        System.out.println("Error al crear el estudiante " + e.toString());
                    }
                    return "";
        });

        get("/visualizarEstudiante/:id", (request, response) -> {

            idEstudianteActual = request.params("id");
            Estudiante estudiante = misEstudiantes.get(Integer.parseInt(idEstudianteActual));

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Visualizar Estudiante");
            attributes.put("encabezado", "Visualizar Estudiante");
            attributes.put("estudiante", estudiante);
            attributes.put("idEstudiante",idEstudianteActual);

            return new ModelAndView(attributes, "visualizarEstudiante.ftl");
        }, freeMarkerEngine);

        get("/editarEstudiante/:id", (request, response) -> {

            idEstudianteActual = request.params("id");
            Estudiante estudiante = misEstudiantes.get(Integer.parseInt(idEstudianteActual));

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Editar Estudiante");
            attributes.put("encabezado", "Editar Estudiante");
            attributes.put("estudiante", estudiante);


            return new ModelAndView(attributes, "editarEstudiante.ftl");
        }, freeMarkerEngine);

        post("/salvarEstudianteEditado", (request, response) -> {
            try {

                Estudiante estudianteEditado = misEstudiantes.get(Integer.parseInt(idEstudianteActual));

                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");

                estudianteEditado.setMatricula(Integer.parseInt(matricula));
                estudianteEditado.setNombre(nombre);
                estudianteEditado.setApellido(apellido);
                estudianteEditado.setTelefono(telefono);

                response.redirect("/listaEstudiantes");
            } catch (Exception e) {
                System.out.println("Error al crear el estudiante " + e.toString());
            }
            return "";
        });

        get("/eliminarEstudiante/:id",(request, response) -> {

            idEstudianteActual = request.params("id");

            misEstudiantes.remove(Integer.parseInt(idEstudianteActual));

            response.redirect("/listaEstudiantes");
            return "";
        });

    }
}
