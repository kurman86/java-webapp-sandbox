package pl.urman.endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pl.urman.model.user.User;
import pl.urman.model.user.UserFinder;

@Path("user")
public class UserEndpoint {

    @Inject
    private UserFinder userFinder;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User fetchOne() {
        return userFinder.fetchOne();
    }
}
