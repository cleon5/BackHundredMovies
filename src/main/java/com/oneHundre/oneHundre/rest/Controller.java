package com.oneHundre.oneHundre.rest;

import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;
import com.oneHundre.oneHundre.entity.Movie;
import com.oneHundre.oneHundre.entity.Saga;
import com.oneHundre.oneHundre.service.HundredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api")
public class Controller {
    private HundredService hundredService;
    @Autowired
    public Controller(HundredService service){
        hundredService = service;
    }
    @GetMapping("/movies")
    public List<Movie> findAll(){
        return hundredService.findAll();
    }
    @GetMapping("/movie/{id}")
    public Movie movieId(@PathVariable int id){
        return hundredService.movieId(id);
    }

    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie){
        movie.setId(0);
        hundredService.saveMovie(movie);
        return movie;
    }
    @PutMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie){
        hundredService.saveMovie(movie);
        return movie;
    }
    @DeleteMapping("/movie/{Id}")
    public String deleteMovie(@PathVariable int Id) {
        hundredService.movieDelete(Id);
        return "Movie Delete, id - " + Id;
    }

    //Sagas
    @GetMapping("/saga")
    public List<Saga> findSaga(){
        return hundredService.findSagas();
    }
    @GetMapping("/saga/{id}")
    public Saga sagaId(@PathVariable int id){
        return hundredService.sagaId(id);
    }
    @PostMapping("/saga")
    public Saga saveSaga(@RequestBody Saga saga){
        saga.setId(0);
        hundredService.saveSaga(saga);
        return saga;
    }
    @PutMapping("/saga")
    public Saga updateSaga(@RequestBody Saga saga){
        hundredService.saveSaga(saga);
        return saga;
    }
    @DeleteMapping("/saga/{Id}")
    public String deleteSaga(@PathVariable int Id) {
        hundredService.deleteSaga(Id);
        return "Saga Delete, id - " + Id;
    }

    //Actor
    @GetMapping("/actor")
    public List<Actores> actoresAll(){
        return hundredService.actoresAll();
    }
    @GetMapping("/actor/{id}")
    public Actor actorId(@PathVariable int id){
        return hundredService.actorId(id);
    }
    @PostMapping("/actor")
    public Actor saveActor(@RequestBody Actor actor){
        actor.setId(0);
        hundredService.saveActor(actor);
        return actor;
    }
    @PutMapping("/actor")
    public Actor updateSaga(@RequestBody Actor actor){
        hundredService.saveActor(actor);
        return actor;
    }
    @DeleteMapping("/actor/{Id}")
    public String deleteActor(@PathVariable int Id) {
        hundredService.deleteActor(Id);
        return "Saga Delete, id - " + Id;
    }
}