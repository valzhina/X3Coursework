package com.javaunit3.springmvc;
import org.springframework.stereotype.Component;

// @Component is an annotation that allows Spring to automatically detect a custom beans
// it instantiate them and inject any specified dependencies into them
@Component
public class TitanicMovie implements Movie { //implements interface Movie

    @Override
    public String getTitle() {
        return "Titanic";
    }

    @Override
    public String getMaturityRating() {
        return "PG-13";
    }

    @Override
    public String getGenre(){
        return "Romance";
    }
}