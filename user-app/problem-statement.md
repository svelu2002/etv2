## User App Rest Apis

### Build Apis for the following

- POST: Create new User
- GET: Get all users
- GET: Get user by id
- PUT: Update user
- DELETE: Delete User

**Consider using Map<Integer, User> as our datasource**

```java
import java.time.LocalDate;

class User {
    private int userId;
    private String username;
    private String email;
    private LocalDate dob;
}
```

## Swagger UI URL
http://localhost:8000/swagger-ui.html
