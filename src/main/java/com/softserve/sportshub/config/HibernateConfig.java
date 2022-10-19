package com.softserve.sportshub.config;

import com.softserve.sportshub.article.domain.Article;
import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.subcategory.model.Subcategory;
import com.softserve.sportshub.user.User;
import com.softserve.sportshub.team.Team;
import com.softserve.sportshub.category.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@AllArgsConstructor
public class HibernateConfig {

  private ApplicationContext context;
 
  @Bean
  public LocalSessionFactoryBean getSessionFactory() {
    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
    factoryBean.setAnnotatedClasses(User.class, Role.class, Team.class, Article.class, Category.class, Subcategory.class);
    return factoryBean;
  }
 
  @Bean
  public HibernateTransactionManager getTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(getSessionFactory().getObject());
    return transactionManager;
  }
}