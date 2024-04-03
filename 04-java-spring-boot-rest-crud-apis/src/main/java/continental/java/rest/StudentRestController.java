package continental.java.rest;

import continental.java.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstructor to load the student data ... only one!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student(1,"fori", "okto"));
        theStudents.add(new Student(2,"eva", "pakp"));
        theStudents.add(new Student(3,"di", "gets"));
    }

    // seperti ini juga bisa berjalan but we want to know what is @PostConstructor
//    public List<Student> loadData(){
//        theStudents = new ArrayList<>();
//        theStudents.add(new Student("fori", "okto"));
//        theStudents.add(new Student("eva", "pakp"));
//        theStudents.add(new Student("di", "gets"));
//        return theStudents;
//    }

    // define endpoint for "/students" return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint for /students/{studentId}
    @GetMapping("/students/{studentsId}")
    public Student getStudent(@PathVariable int studentsId){

        // check the studentId again list size => but the server still down
        if((studentsId >= theStudents.size()) || (studentsId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentsId);
        }
        return theStudents.get(studentsId);
    }

    @ExceptionHandler // exception handler method
    // ResponseEntity<StudentErrorResponse> is the type of the response body
    // StudentNotFoundException exc) is exception type to handle/catch
    // ResponseEntity is the class for response entity
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);// error is a body of the response
        //https.NOT_FOUND is actual status code for this response

    }

    //add another exception handler  ... to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

/*
! why using the Student inside the List<Student> in @GetMapping("/students/{studentsId}")
* because inside using list , because the output direct to "{}" output not like a array so we refers to entity output

* we have to make @ExceptionHandler annotation so the server not down when there are index outbound

! HOMEWORK
* what is this public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) ?
? ResponseEntity is the class from java represent the entire HTTP response. it allow us to control the response status, header, and body that will sand back to client when handling a request
? by using ResponseEntity we have five-grand control over our API response to different situations

? so why we have to return new in this case? so let me break down the code
? when we wanna return value a value from a method, we just use return example:
public int getNumber() {
    return 10;
}
? however in the case of creating and returning an instance of an object, we need to use new
public ResponseEntity<Student> getStudent() {
    Student student = new Student("John", "Doe");
    return new ResponseEntity<>(student, HttpStatus.OK);
}
? here new ResponseEntity<>(student, HttpStatus.OK) creates a new "ResponseEntity" object which is then returned by the method
? so the new keyword is used to instantiate a new object, and return is used to send that object back as the result of the method

* in block if throw new StudentNotFoundException, but why StudentErrorResponseEntity Called? => the question answered
? so what is exactly happened is
?1. if the error comes the block code error will executed to create custom message to the StudentNotFoundException
so now the StudentNotFoundException will have message, because the class inherited from the RuntimeException, so we can use the method from RunTimeException like getMessage or something
?2. @Exception will execute to bring the Response entity to the front like message, status, message, etc, by catch the throw new studentNotFoundException

* what is ResponseEntity<> for?
todo The <> symbol in Java is known as the diamond operator and is used in conjunction with generics. Generics in Java allow you to create classes, interfaces, and methods that operate on a specified type without committing to a specific data type in advance.
? so i will create the example for you
? before java 7, when using generic, we had to spesify the type on both side of the assignment
List<String> list = new ArrayList<String>();
? This redudancy is could be cumbersome, especially dealing with complex data types
? with diamond operator, we can simply write
List<String> list = new ArrayList<>();

? so in our case, we can figure the code with:
ResponseEntity<StudentErrorResponse> handleException = new ResponseEntity<>(error, HttpStatus.NOT_FOUND)


* public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
this is handle exception just for StudentNotFound, so this exception called when thrown a StudentNotFoundException
* public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
this is handle exception for just the generic exception object, to catch all for any exception that's thrown.
* */