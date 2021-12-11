package co.com.sofka.calendar.services;

import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.repositories.ProgramDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProgramDateService {

    @Autowired
    ProgramDateRepository repository;

    public Flux<ProgramDate> getCalendar() {
        return repository.findAll();
    }

    public Flux<ProgramDate> saveCalendar(Flux<ProgramDate> calendar) {
        return repository.saveAll(calendar);
    }
}
