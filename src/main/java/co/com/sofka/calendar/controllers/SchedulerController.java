package co.com.sofka.calendar.controllers;

import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/calendar")
public class SchedulerController {

    @Autowired
    SchedulerService service;

    @GetMapping()
    public Flux<ProgramDate> generateCalendar() {
        var startDate = LocalDate.of(2022, 1, 1);
        return service.generateCalendar("61b3cef8080d7bd8fff0cebb", startDate);
    }
}
