import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads=Squad.getAll();
            model.put("squads",squads);
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());
        get("/addSquads", (request, response) -> { //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
            return new ModelAndView(model, "addSquads.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine()); //

        post("/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String stringMaxSize = request.queryParams("maxSize");
            String name = request.queryParams("name");
            String fightingCause = request.queryParams("fightingCause");
            int maxSize=parseInt(stringMaxSize);
            Squad newSquad = new Squad(maxSize,name,fightingCause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
