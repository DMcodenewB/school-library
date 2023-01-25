package com.example.schoollibrary.services;

import com.example.schoollibrary.entities.Autor;
import com.example.schoollibrary.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAllAuthors(){
        return autorRepository.getAll();
    }

    public Autor getAuthorById(int id){
        return autorRepository.getById(id);
    }

    public List<Autor> getAuthorsByName(String name) {
        return autorRepository.getByName(name);
    }

    public int addAuthors(List<Autor> authors){
        return autorRepository.save(authors);
    }

    public int updateImieNazwisko(int autor_id, Autor updatedAuthor) {
        Autor autor = autorRepository.getById(autor_id);

        if(autor != null){
            autor.setImieNazwiskoAutora(updatedAuthor.getImieNazwiskoAutora());

            autorRepository.update(autor);
            return 1;
        }
        else return -1;
    }

    public int deleteAutor(int autor_id){
        return autorRepository.delete(autor_id);
    }
}
