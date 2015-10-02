package de.linkvt.bachelor.web;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Redirects to trailing slashes are extracted into this controller.
 */
@RestController
public class TrailingSlashRedirectController {

  @RequestMapping("/ontology")
  public void ontologyRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.sendRedirect(appendQueryString("/ontology/", request));
  }

  @RequestMapping("/ontology/{id}")
  public void ontologyFromIdRedirect(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) throws IOException {
    response.sendRedirect(appendQueryString("/ontology/" + id + "/", request));
  }

  private String appendQueryString(String path, HttpServletRequest request) {
    String queryString = request.getQueryString();

    if (StringUtils.isEmpty(queryString)) {
      return path;
    } else {
      return path + "?" + queryString;
    }
  }

}
