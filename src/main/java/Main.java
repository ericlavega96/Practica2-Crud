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

    public static void main(String[] args) {

        staticFiles.location("/templates");

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        cfg.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(cfg);

        get("/inicio", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            attributes.put("encabezado", "Bienvenido al gestor estudiantil");
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
            attributes.put("encabezado", "Listado de Estudiantes");
            return new ModelAndView(attributes, "listaEstudiantes.ftl");
        }, freeMarkerEngine);

        post("/procesarEstudiante", (request, response) -> {
            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                misEstudiantes.add(new Estudiante(Integer.parseInt(matricula.replaceAll("\\D", "")), nombre, apellido, telefono));
                response.redirect("/agregarEstudiante");
            }catch (Exception e){
                System.out.println("Error al crear el estudiante " + e.toString());
            }
            return new ModelAndView("","listaEstudiantes.ftl");
        }, freeMarkerEngine);

        /**
         * Formulario estudiante
         * http://localhost:4567/agregarEstudiante/
         *
         *
         *
         * post("/agregarEstudiante", (request, response) -> {
         try {
         String matricula = request.queryParams("matricula");
         String nombre = request.queryParams("nombre");
         String apellido = request.queryParams("apellido");
         String telefono = request.queryParams("telefono");
         misEstudiantes.add(new Estudiante(Integer.parseInt(matricula.replaceAll("\\D", "")), nombre, apellido, telefono));
         response.redirect("/agregarEstudiante");
         }catch (Exception e){
         System.out.println("Error al crear estudiante");
         }


         Map<String, Object> attributes = new HashMap<>();
         attributes.put("titulo", "Formulario Agregar Estudiante");
         return new ModelAndView(attributes, "agregarEstudiante.ftl");
         }, freeMarkerEngine);

         }

         public static void ImprimirEstudiantes(){
         System.out.println("Hay " + misEstudiantes.size() + " estudiantes");
         for (Estudiante est: misEstudiantes) {
         System.out.println("Matricula" + est.getMatricula() + "Nombre: " + est.getNombre() + "Apellido: " + est.getApellido() + "Telefono: " + est.getTelefono());
         }
         }
         *
         */
    }
}
