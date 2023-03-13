package com.oneHundre.oneHundre.rest;

import com.oneHundre.oneHundre.entity.*;
import com.oneHundre.oneHundre.service.HundredService;
//import com.sun.tools.javac.util.DiagnosticSource;
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
    public List findAll(){
        return hundredService.findAll();
    }
    @GetMapping("/movie/{id}")
    public Movie movieId(@PathVariable int id){
        return (Movie) hundredService.movieId(id);
    }

    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie){

        //Agregar disponible
        Disponible tmpDisponible = addDisponible(movie.getDisponible());
        movie.setId(0);
        movie.setFk_id_disponible(tmpDisponible.getId());
        movie.setDisponible(tmpDisponible);

        //Agregar Pregunta
        Pregunta tmpPregunta = addPregunta(movie.getPregunta());
        movie.setId(0);
        movie.setFk_id_pregunta(tmpPregunta.getId());
        movie.setPregunta(tmpPregunta);

        //insertar nueva saga
        if(movie.getSaga().getId() == 0 ) {
            Saga tmpSaga = saveSaga(movie.getSaga());
            movie.setFk_id_saga(tmpSaga.getId());
            movie.setSaga(tmpSaga);
        }
        //insertar nueva genero
        if(movie.getDirector().getId() == 0 ) {
            Director tmpDirector = addDirector(movie.getDirector());
            movie.setFk_id_director(tmpDirector.getId());
            movie.setDirector(tmpDirector);
        }

        hundredService.saveMovie(movie);
        return movie;
    }

    @PostMapping("/disponible")
    public Disponible addDisponible(@RequestBody Disponible disponible){
        System.out.println(disponible);
        disponible.setId(0);
        hundredService.saveDisponible(disponible);
        return disponible;
    }
    @PostMapping("/pregunta")
    public Pregunta addPregunta(@RequestBody Pregunta pregunta){
        System.out.println(pregunta);
        pregunta.setId(0);
        hundredService.savePregunta(pregunta);
        return pregunta;
    }
    @PostMapping("/director")
    public Director addDirector(@RequestBody Director director){
        System.out.println(director);
        director.setId(0);
        hundredService.saveDirector(director);
        return director;
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
    public List findSaga(){
        return hundredService.findSagas();
    }
    @GetMapping("/saga/{id}")
    public Saga sagaId(@PathVariable int id){
        return (Saga) hundredService.sagaId(id);
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
    public List actoresAll(){
        return hundredService.actoresAll();
    }
    @GetMapping("/actor/{id}")
    public Actor actorId(@PathVariable int id){
        return (Actor) hundredService.actorId(id);
    }
    @PostMapping("/actor")
    public Actor saveActor(@RequestBody Actor actor){
        actor.setId(0);
        hundredService.saveActor(actor);
        return actor;
    }
    @PutMapping("/actor")
    public Actor updateActor(@RequestBody Actor actor){
        hundredService.saveActor(actor);
        return actor;
    }
    @DeleteMapping("/actor/{Id}")
    public String deleteActor(@PathVariable int Id) {
        hundredService.deleteActor(Id);
        return "Saga Delete, id - " + Id;
    }

    //Rutas director
    @GetMapping("/director")
    public List directorAll(){
        return hundredService.directorAll();
    }
    @GetMapping("/director/{id}")
    public Genero DirectorId(@PathVariable int id){
        return (Director) hundredService.directorId(id);
    }
    @PostMapping("/director")
    public Genero saveDirector(@RequestBody Director director){
        director.setId(0);
        hundredService.saveDirector(director);
        return director;
    }
    @PutMapping("/director")
    public Genero updateGenero(@RequestBody Director director){
        hundredService.saveDirector(director);
        return director;
    }
    @DeleteMapping("/director/{Id}")
    public String deleteDiretor(@PathVariable int Id) {
        hundredService.deleteDirector(Id);
        return "director Delete, id - " + Id;
    }


    //Rutas Genero
    @GetMapping("/genero")
    public List generoAll(){
        return hundredService.generoAll();
    }
    @GetMapping("/genero/{id}")
    public Genero generoId(@PathVariable int id){
        return (Genero) hundredService.generoId(id);
    }
    @PostMapping("/genero")
    public Genero saveGenero(@RequestBody Genero genero){
        genero.setId(0);
        hundredService.saveGenero(genero);
        return genero;
    }
    @PutMapping("/genero")
    public Genero updateGenero(@RequestBody Genero genero){
        hundredService.saveGenero(genero);
        return genero;
    }
    @DeleteMapping("/genero/{Id}")
    public String deleteGenero(@PathVariable int Id) {
        hundredService.deleteGenero(Id);
        return "Saga Delete, id - " + Id;
    }
}