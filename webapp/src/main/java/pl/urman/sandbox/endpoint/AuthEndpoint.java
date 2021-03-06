package pl.urman.sandbox.endpoint;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pl.urman.sandbox.auth.AuthService;
import pl.urman.sandbox.auth.UserLoginRequest;

@Path("/auth")
public class AuthEndpoint {

    @Inject
    private AuthService authService;

    @POST
    @Path("login")
    public Response login(UserLoginRequest loginRequest) {

        boolean authenicated = authService.authenticate(loginRequest);

        if (authenicated) {
            return Response.ok().build();
        }
        return Response.status(Status.BAD_REQUEST).build();

    }

    @POST
    @Path("logout")
    public Response logout() {
        authService.logout();
        return Response.ok().build();
    }
}
