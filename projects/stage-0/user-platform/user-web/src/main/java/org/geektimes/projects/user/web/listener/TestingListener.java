package org.geektimes.projects.user.web.listener;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
<<<<<<< HEAD
=======
import javax.servlet.ServletContext;
>>>>>>> afc3a4cfeb96c33bf1c7f916dd9ef622c8e14d84
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

/**
 * 测试用途
 */
@Deprecated
public class TestingListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ComponentContext context = ComponentContext.getInstance();
        DBConnectionManager dbConnectionManager = context.getComponent("bean/DBConnectionManager");
        dbConnectionManager.getConnection();
<<<<<<< HEAD
=======
        testPropertyFromServletContext(sce.getServletContext());
        testPropertyFromJNDI(context);
>>>>>>> afc3a4cfeb96c33bf1c7f916dd9ef622c8e14d84
        testUser(dbConnectionManager.getEntityManager());
        logger.info("所有的 JNDI 组件名称：[");
        context.getComponentNames().forEach(logger::info);
        logger.info("]");
    }

<<<<<<< HEAD
=======
    private void testPropertyFromServletContext(ServletContext servletContext) {
        String propertyName = "application.name";
        logger.info("ServletContext Property[" + propertyName + "] : "
                + servletContext.getInitParameter(propertyName));
    }

    private void testPropertyFromJNDI(ComponentContext context) {
        String propertyName = "maxValue";
        logger.info("JNDI Property[" + propertyName + "] : "
                + context.lookupComponent(propertyName));
    }

>>>>>>> afc3a4cfeb96c33bf1c7f916dd9ef622c8e14d84
    private void testUser(EntityManager entityManager) {
        User user = new User();
        user.setName("小马哥");
        user.setPassword("******");
        user.setEmail("mercyblitz@gmail.com");
        user.setPhoneNumber("abcdefg");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        System.out.println(entityManager.find(User.class, user.getId()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
