package org.geektimes.projects.user.controller;

import org.geektimes.projects.user.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/rest")
public class RestDemoController {

    @POST
    @Path("/testPost")
    public User testPostInvoke(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setName("test-name");
        user.setPhone("16888888888");
        user.setId(1L);
        return user;
    }
}
