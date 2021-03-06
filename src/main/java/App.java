import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
          return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
      }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        get("/", (request, response) -> { //request for route happens at this location
            Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
            return new ModelAndView(model, "index.hbs"); // assemble individual pieces and render
        }, new HandlebarsTemplateEngine()); //
        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads=Squad.getAll();
            model.put("squads",squads);
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads/new", (request, response) -> { //request for route happens at this location
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

        get("/heros", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros=Hero.getAll();
            ArrayList<Squad> squads=Squad.getAll();
            model.put("heros",heros);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

    get("/heros/new", (request, response) -> { //request for route happens at this location
        Map<String, Object> model = new HashMap<String, Object>(); // new model is made to store information
        ArrayList<Squad> squads=Squad.getAll();
        model.put("squads",squads);
        return new ModelAndView(model, "addHero.hbs"); // assemble individual pieces and render
    }, new HandlebarsTemplateEngine()); //

        post("/newHero", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> squads=Squad.getAll();
            String name = request.queryParams("name");
            String stringAge = request.queryParams("age");
            String weakness = request.queryParams("weakness");
            String specialPowers = request.queryParams("specialPowers");
            int squadId = parseInt(request.queryParams("squadId"));
            Squad newSquad=Squad.findById(squadId);
            int age=parseInt(stringAge);
            Hero newHero = new Hero(name,age,specialPowers,weakness,newSquad);
            return new ModelAndView(model, "successHero.hbs");
        }, new HandlebarsTemplateEngine());

    }


}
