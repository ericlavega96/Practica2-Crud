import java.util.ArrayList;

import freemarker.template.Configuration;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

    private static ArrayList<Estudiante> misEstudiantes = new ArrayList<Estudiante>();

    public static void main(String[] args) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        cfg.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(cfg);

        

    }
}
