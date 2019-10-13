# Scheduler Based Mail Sending

# Functionality covered:                                                                                                               
This Repository includes following functionality:                                                                                       

`1` : Implemented Quartz Scheduler.                                                                                                    
`2` : Sending Mail based on batch wise using Scheduler timings.                                                                        
`3` : Implemented Spring security.                                                                                                      
`4` : Implemeted dynamic log file creation base on log4j file.                                                                          
`5` : Implemented alert message using bootstrap.                                                                                        

# Steps to Run this repository:                                                                                                         
`step 1`: Dowmload this repository & do maven import.                                                                                   
`step 2`: Fire the Query as listed in db_scripts.sql file to any Data base.                                                             
`step 3`: Add jndi-name in server as defined in data-source.config.xml  
`step 4`: Configure the JNDI in Wildfly For Ref [click](https://wiki.snowflakesoftware.com/display/GPWDOC/JNDI+Data+Source+Configuration+on+WildFly+10)

`step 5`: Configure your Gmail UN & PW in `email-config.xml` for sending email.                                                         
`step 6`: Run the Application, if it successfully deployed means , you will redirected to login page with registration link.            
`step 7`: click on registration link & register the data & mail will go to registered mail account.                                     

# Technology Used:    
  Java 8                                                                                                                                
  Spring MVC                                                                                                                             
  JPA & Hibernate                                                                                                                       
  Spring- security                                                                                                                         Log4j                                                                                                                                 
  Quartz Scheduler                                                                                                                    
  Java Mail                                                                                                                           
  Thymeleaf                                                                                                                           
  
 # Tools Used
 Eclipse - Mrs                                                                                                                        
 Sevrver - Wildfly 10                                                                                                                   


If any issues regarding this repository means, feel free to comment, I will help you guys to run this repository sucessfully.                                                                                                                     
