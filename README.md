<br />
<div align="center">
<h3 align="center">TEST TASK FOR JAVA DEVELOPER</h3>

  <p align="center">
   Dzmitry Betska’s project!

  </p>
</div>

## About The Project

This is a test project for selection into the IT Bootcamp team

The application implements:

- [x] Adding a user to the database
- [x] Getting all users from a database
- [x] Page-by-page display of posts by 10 users (sorted by email)
- [x] Exception handler for validation exceptions
- [x] Written tests for the service layer

## Technologies

The project was developed using:

* Spring Boot
    * Data JPA
    * Validation
    * Test
* MySQL 8
* Java 17+
* Log4j2 as a logging system
* Mapstruct
* Lombok

## Demonstration of some project possibilities

Implemented exception tracking and handling layer

    @Slf4j
    @RestControllerAdvice
    public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        log.warn(EXCEPTION, exception.getMessage());
        return buildErrorResponse(exception);
    }

    private ErrorResponse buildErrorResponse(MethodArgumentNotValidException exception) {
        return ErrorResponse.builder()
                .errorCount(exception.getFieldErrorCount())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .errors(buildValidationErrors(exception))
                .build();
    }

    private List<Error> buildValidationErrors(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors()
                .stream()
                .map(this::getError)
                .toList();
    }

    private Error getError(FieldError fieldError) {
        return new Error(fieldError.getField(), fieldError.getDefaultMessage());
    }
    }

Implemented testing of Services layer methods

    @SpringBootTest
    @ExtendWith(MockitoExtension.class)
    @DisplayName("Testing methods of the UserService")
    public class UserServiceTest {

    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userMapper, userRepository);
    }

    @ParameterizedTest
    @ArgumentsSource(UserCreateArguments.class)
    void createUserTest(UserRequest userRequest, User user, UserResponse userResponse) {
        when(userRepository.save(any(User.class)))
                .thenReturn(user);
        UserResponse actualUserResponse = userService.create(userRequest);
        assertEquals(userResponse, actualUserResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(UsersGetArguments.class)
    void getAllUsersTest(User user, UserResponse userResponse, Pageable pageable) {
        Page<User> page = new PageImpl<>(List.of(user), pageable, 1);
        when(userRepository.findAll(pageable))
                .thenReturn(page);
        List<UserResponse> userResponseList = userService.getAll(pageable);
        assertEquals(Collections.singletonList(userResponse), userResponseList);
    }
    }

## Contact

Dzmitry Betska - d.betska@gmail.com

Project Link: [https://github.com/dzmitrybetska?tab=repositories](https://github.com/dzmitrybetska?tab=repositories)