package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

/**
 *
 */
@Singleton
@Startup
public class StartUpBean {
  private static final Logger log = LoggerFactory.getLogger(StartUpBean.class);

  @Inject UserDao userDao;

  @PostConstruct
  public void init() {
    log.info("PictureShow started.");
    // inital code goes here
  }
}
